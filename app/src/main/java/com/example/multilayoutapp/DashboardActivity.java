package com.example.multilayoutapp; // change if different

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        EditText etSearch = findViewById(R.id.etSearch);
        Button btnViewProfile = findViewById(R.id.btnViewProfile);
        Button btnSettings = findViewById(R.id.btnSettings);

        btnViewProfile.setOnClickListener(v ->
                Toast.makeText(this, "View Profile Clicked!", Toast.LENGTH_SHORT).show()
        );

        btnSettings.setOnClickListener(v ->
                Toast.makeText(this, "Settings Clicked!", Toast.LENGTH_SHORT).show()
        );
    }
}
