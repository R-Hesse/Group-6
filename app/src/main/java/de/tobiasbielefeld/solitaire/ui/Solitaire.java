package de.tobiasbielefeld.solitaire.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import de.tobiasbielefeld.solitaire.R;

public class Solitaire extends AppCompatActivity {

    EditText name;
    String PREF_FILE_NAME = "shared_prefs";
    SharedPreferences namePrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        // place to enter your name

        name = findViewById(R.id.userInput);
        Button nextButton = findViewById(R.id.button_name);

        // Sending Sharedpreff to remember it.

        namePrefs = getSharedPreferences(PREF_FILE_NAME, MODE_PRIVATE);
        if (namePrefs.contains("typed")){
            name.setText(namePrefs.getString("typed", ""));
        }

        nextButton.setOnClickListener(click -> {

            // Linking the button to intent to pass the information around

            Intent nextPage = new Intent (Solitaire.this, GameSelector.class);
            nextPage.putExtra("typed", name.getText().toString() );
            startActivityForResult(nextPage, 1);
            SharedPreferences.Editor prefsEditor = namePrefs.edit();
            prefsEditor.putString("typed", name.getText().toString());
            prefsEditor.apply();

        });

    }
}