package com.example.firebasememorybox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }
    public void changeLayout(View view){
        Intent intent = new Intent(SignInActivity.this, SelectActionActivity.class);
        startActivity(intent);
    }
}
