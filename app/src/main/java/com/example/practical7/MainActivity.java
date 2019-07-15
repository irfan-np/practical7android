package com.example.practical7;

import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = findViewById(R.id.newUserTouch);

        txt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Intent intent = new Intent(v.getContext(), Create.class);
                    startActivity(intent);

                    return true;
                }
                return false;
            }
        });
    }
    public void Login(View v) {

        EditText enteruser = findViewById(R.id.enterUsername);
        String username = enteruser.getText().toString();

        EditText enterpass = findViewById(R.id.enterPassword);
        String password = enterpass.getText().toString();

        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String getUsername = pref.getString("USER_NAME", null);
        String getPassword = pref.getString("PASSWORD", null);


        if(username.equals(getUsername) && password.equals(getPassword)) {
            Toast tt= Toast.makeText(MainActivity.this, "Valid", Toast.LENGTH_SHORT);
            tt.show();
        }
        else {
            Toast tt= Toast.makeText(MainActivity.this, "Invalid!", Toast.LENGTH_SHORT);
            tt.show();
        }
    }
        }