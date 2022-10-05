package com.example.firebasememorybox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    Button logInB, signUpB;
    EditText userNameET, passwordET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        logInB = findViewById(R.id.loginButton);
        signUpB = findViewById(R.id.signupButton);
        userNameET = findViewById(R.id.userNameEditText);
        passwordET = findViewById(R.id.passwordEditText);
    }








    public void logInClicked(View view) {
        Log.i("Denna", "Log in clicked");
        if (getValues()) {        // get username and password
            // check if valid with Firebase auth
            // if valid, log in user and then switch to next activity

            Intent intent = new Intent(SignInActivity.this, SelectActionActivity.class);
            startActivity(intent);

            // if invalid - prompt message that says why signin won't go through
        }
    }

    public void signUpClicked(View view) {
        Log.i("Denna", "Sign up clicked");
        if (getValues()) {      // get username and password
            // Try to create an account using auth
            // if successful, switch to next activity

        }
    }

    /**
     * Helper method to get userName and password whenever one of these buttons is clicked
     * The method makes sure both EditText boxes are filled in and also ensures the password
     * is at least 6 characters long.  If those tests pass, then it will send the values on
     * to be checked by Firebase auth
     *
     * @return true if values pass these tests, false otherwise
     */
    private boolean getValues() {
        String userName = userNameET.getText().toString();
        String password = passwordET.getText().toString();

        // verify all user data is entered
        if (userName.length() == 0 || password.length() == 0) {
            Toast.makeText(getApplicationContext(), "Enter all fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        // verify password is at least 6 char long (otherwise firebase will deny)
        else if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password must be at least 6 char long", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Log.i("Denna", userName + " " + password + " is set after getValues(), return true");
            return true;
        }
    }








}
