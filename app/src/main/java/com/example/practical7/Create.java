package com.example.practical7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Create extends AppCompatActivity {
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
    }


    public void CreateUser(View v) {

        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        EditText enteruser = findViewById(R.id.enterUsername);
        String username = enteruser.getText().toString();
        Pattern pattern = Pattern.compile("^[A-Za-z0-9],{5,12}$");
        Matcher matcher = pattern.matcher(username);

        EditText enterpass = findViewById(R.id.enterPassword);
        String password = enterpass.getText().toString();
        Pattern patternPass = Pattern.compile("^(?=,*[!@#])(?=,*[A-Z])(?=,*[0-9]).*$");
        Matcher matcherPass = pattern.matcher(password);

        if (matcher.matches() == true && matcherPass.matches() == true) {
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("USER_ NAME", username);
            editor.putString("PASSWORD", password);
            editor.commit();
            Toast tt = Toast.makeText(Create.this, "New User Created Successfully", Toast.LENGTH_SHORT);
            tt.show();
        }
        else{
            Toast tt = Toast.makeText(Create.this, "User cannot be created. Please try again.", Toast.LENGTH_SHORT);
            tt.show();

        }
    }
    public void cancel(View v) {
        Intent intent = new Intent(v.getContext(), MainActivity.class);
        startActivity(intent);
    }
}
