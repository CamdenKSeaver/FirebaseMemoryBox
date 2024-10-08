package com.example.firebasememorybox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddMemoryActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    Spinner spinner;
    EditText memoryName, memoryDesc;
    String spinnerSelectedText = "none";
        // How to implement a Spinner
        // https://www.tutorialspoint.com/how-to-get-spinner-value-in-android

        // How to style the spinner
        // https://www.youtube.com/watch?v=7tnlh1nVkuE


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_memory);

            memoryName = findViewById(R.id.memoryNameEditText);
            memoryDesc = findViewById(R.id.memoryDescEditText);

            // this attaches my spinner design (spinner_list.xml) and my array of spinner choices(R.array.memoryRating)
            spinner = findViewById(R.id.memorySpinner);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_list,
                    getResources().getStringArray(R.array.memoryRating));

            // this attaches my custom row design (how I want each row to look)
            adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_row);

            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
        }
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             spinnerSelectedText = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), spinnerSelectedText, Toast.LENGTH_SHORT).show();
        }
        // This method is required, even if empty, for the OnItemSelectedListener to work
        @Override
        public void onNothingSelected(AdapterView<?> parent) { }

    public void addmemoryButtonClicked(View view) {
        String memName = memoryName.getText().toString();
        String memDesc = memoryDesc.getText().toString();

        int memoryRatingNum = Integer.parseInt(spinnerSelectedText);

        Memory m = new Memory(memoryRatingNum, memName, memDesc);
        Log.d("Denna", m.toString());
        SignInActivity.firebaseHelper.addData(m);

        memoryName.setText("");
        memoryDesc.setText("");
    }
}






    

