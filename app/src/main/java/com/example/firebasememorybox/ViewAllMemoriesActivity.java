package com.example.firebasememorybox;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewAllMemoriesActivity extends AppCompatActivity {

    private ListView myMemoryListView;
    public static final String CHOSEN_MEMORY = "chosen memory";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_memories);

        // find listView in xml
        myMemoryListView = findViewById(R.id.allMemoriesListView);
        // get ArrayList of data from firebase
        ArrayList<Memory> myList = SignInActivity.firebaseHelper.getMemoryArrayList();
        // bind data to the ArrayAdapter (this is a default adapter
        // The text shown is based on the Memory class toString
        ArrayAdapter<Memory> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, myList);
        // attaches the listAdapter to my listView
        myMemoryListView.setAdapter(listAdapter);
        // if did custom array set up, use this one

        // Create listener to listen for when a Food from the specific Category list is clicked on
        myMemoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Creates an intent to go from the Specific Category to the specific Detail
                Intent intent = new Intent(ViewAllMemoriesActivity.this, EditMemoryActivity.class);
                // Sends the specific object at index i to the Detail activity
                // In this case, it is sending the particular Food object
                intent.putExtra(CHOSEN_MEMORY, myList.get(position));
                startActivity(intent);
            }
        });

    }

    public void goToSelectOptions(View view) {
        Intent intent = new Intent(ViewAllMemoriesActivity.this, SelectActionActivity.class);
        startActivity(intent);
    }
}
