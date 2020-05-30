package ik.game.minesweeperalpha;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


import com.example.minesweeperalpha.R;

import java.util.Set;

public class SettingsActivity extends AppCompatActivity {

    public static final String SETTINGS = "mysettings";
    //In squares, of the playing field
    private int height;
    private int width;

    private int minesTotal;
    private int squaresTotal;

    //default values/options
    //Beginner 9x9, 10 mines
    protected static class BeginnerSettings {
        public static final int HEIGHT = 9;
        public static final int WIDTH = 9;
        public static final int MINES = 10;
    }

    //Intermediate 16x16, 40 mines
    protected static class IntermediateSettings {
        public static final int HEIGHT = 16;
        public static final int WIDTH = 16;
        public static final int MINES = 40;
    }

    //Advanced 30x16, 99 mines
    protected static class AdvancedSettings {
        public static final int HEIGHT = 30;
        public static final int WIDTH = 16;
        public static final int MINES = 99;
    }

    private Spinner difficultySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        validateDifficultyValues();

        initializeToolbar();
        initializeDifficultySpinner();
        initializeCustomEditTexts();

        /*Button saveButton = (Button) findViewById();
        Button cancelButton = (Button) findViewById();

         */
        //Button restoreToDefaultButton = (Button) findViewById();


        /*
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSettings();
            }
        });

         */
    }

    private void initializeToolbar() {
        Toolbar settingsToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(settingsToolbar);
        ActionBar settingsActionBar = getSupportActionBar();

        settingsActionBar.setDisplayShowTitleEnabled(false);
        settingsActionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void initializeDifficultySpinner() {
        difficultySpinner = (Spinner) findViewById(R.id.difficulty_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.difficulties_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);
    }

    private void initializeCustomEditTexts() {
        EditText etWidth = (EditText) findViewById(R.id.etWidth);
        EditText etHeight = (EditText) findViewById(R.id.etHeight);
        EditText etMines = (EditText) findViewById(R.id.etMines);

        String selection = difficultySpinner.getSelectedItem().toString();
        String[] choices = getResources().getStringArray(R.array.difficulties_array);
        if (!selection.equals(choices[3])) {
            etWidth.setEnabled(false);
            etHeight.setEnabled(false);
            etMines.setEnabled(false);
            if(selection.equals(choices[0])){

            }else if(selection.equals(choices[1])){

            }else if(selection.equals(choices[2])){

            }else{
                throw new InvalidSpinnerSelectionException("Invalid/nonexistent spinner choice selected");
            }
        } else {
            etWidth.setEnabled(true);
            etHeight.setEnabled(true);
            etMines.setEnabled(true);
        }

    }

    private void validateDifficultyValues() {
        int[] internal = {BeginnerSettings.WIDTH, BeginnerSettings.HEIGHT,
                BeginnerSettings.MINES, IntermediateSettings.WIDTH,
                IntermediateSettings.HEIGHT, IntermediateSettings.MINES,
                AdvancedSettings.WIDTH, AdvancedSettings.HEIGHT,
                AdvancedSettings.MINES};
        int[] external = {getResources().getInteger(R.integer.beginner_width),
                getResources().getInteger(R.integer.beginner_height),
                getResources().getInteger(R.integer.beginner_mines),
                getResources().getInteger(R.integer.intermediate_width),
                getResources().getInteger(R.integer.intermediate_height),
                getResources().getInteger(R.integer.intermediate_mines),
                getResources().getInteger(R.integer.advanced_width),
                getResources().getInteger(R.integer.advanced_height),
                getResources().getInteger(R.integer.advanced_mines)};
        if(!internal.equals(external)){
            throw new ValueMismatchException("Default game settings have values that don't match with those in @values/integers");
        }
    }

    protected void saveSettings() {
        SharedPreferences settings = getSharedPreferences(SETTINGS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

    }

}
