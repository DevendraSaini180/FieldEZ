package com.example.devendra.fieldez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_toolbar_item, menu);
        return super.onCreateOptionsMenu(menu);

    }

    private void initializeViews() {
        Log.d(TAG, "initializeViews: ");
        mListView = findViewById(R.id.listView);
        String[] names = { "Ankitha", "Isaac", "Mathew", "Sachin Mathew", "Tracey", "Rebecca Olivia"};
        HomeContentAdapter adapter = new HomeContentAdapter(this,  names);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String message = names[position];
                Toast.makeText(getBaseContext(), "Your customer name is " + message, Toast.LENGTH_SHORT).show();
            }
        });

    }

}