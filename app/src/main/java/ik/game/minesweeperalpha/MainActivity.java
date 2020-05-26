package ik.game.minesweeperalpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.example.minesweeperalpha.R;


public class MainActivity extends AppCompatActivity {

    public static final String SETTINGS = "mysettings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        Button startButton = (Button) findViewById(R.id.startButton);

        Button settingsButton = (Button) findViewById(R.id.settings_button);

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSettings();
            }
        });

    }

    //Starts settings activity
    private void goToSettings(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    //maybe
    private void goToHelp(View view){

    }

    //Starts new game
    private void startGame(View view){

    }

    //Toggles normal and quick flagging modes
    private void modeToggle(View view){

    }

    //Loads saved game values
    private void loadValues(){
        SharedPreferences settings = getSharedPreferences(SETTINGS, Context.MODE_PRIVATE);
    }

    //Values that should be saved when screen rotates or any other non-close action occurs
    //Consider checking if screen rotates to determine if time should be saved - probably no need, more harm than good
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

}
