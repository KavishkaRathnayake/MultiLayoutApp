package com.example.multilayoutapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone;
    Button btnSubmit, btnClear;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnClear = findViewById(R.id.btnClear);

        dbHelper = new DBHelper(this);

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();
            String phone = etPhone.getText().toString();

            boolean inserted = dbHelper.insertStudent(name, email, phone);
            if (inserted) {
                Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error Saving Data", Toast.LENGTH_SHORT).show();
            }

            // Read data back
            Cursor cursor = dbHelper.getAllStudents();
            if (cursor.getCount() > 0) {
                StringBuilder sb = new StringBuilder();
                while (cursor.moveToNext()) {
                    sb.append("ID: ").append(cursor.getInt(0))
                            .append(" Name: ").append(cursor.getString(1))
                            .append(" Email: ").append(cursor.getString(2))
                            .append(" Phone: ").append(cursor.getString(3))
                            .append("\n");
                }
                Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
            }
        });

        btnClear.setOnClickListener(v -> {
            dbHelper.deleteAll();
            Toast.makeText(this, "All Data Deleted!", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etEmail.setText("");
            etPhone.setText("");
        });
    }
}
