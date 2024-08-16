package com.example.crud_app_sql_lite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Create extends AppCompatActivity {
    EditText usernameInput, descriptionInput;
    Button saveBtn;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        db = new DatabaseHandler(this);

        usernameInput = findViewById(R.id.usernameInput);
        descriptionInput = findViewById(R.id.descriptionInput);
        saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String description = descriptionInput.getText().toString();

                if (!username.isEmpty() && !description.isEmpty()) {
                    db.AddBlog(new UserData(username, description));
                    Toast.makeText(Create.this, "User added successfully", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(Create.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
