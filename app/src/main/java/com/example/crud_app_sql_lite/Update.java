package com.example.crud_app_sql_lite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Update extends AppCompatActivity {
    EditText usernameUpdateInput, descriptionUpdateInput;
    Button updateBtn;
    DatabaseHandler db;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        db = new DatabaseHandler(this);

        usernameUpdateInput = findViewById(R.id.usernameUpdateInput);
        descriptionUpdateInput = findViewById(R.id.descriptionUpdateInput);
        updateBtn = findViewById(R.id.updateBtn);


        Intent intent = getIntent();
        userId = intent.getIntExtra("user_id", -1);

        if (userId != -1) {
            UserData user = db.getBlog(userId);
            if (user != null) {
                usernameUpdateInput.setText(user.getName());
                descriptionUpdateInput.setText(user.get_description());
            }
        }

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatedUsername = usernameUpdateInput.getText().toString();
                String updatedDescription = descriptionUpdateInput.getText().toString();

                if (!updatedUsername.isEmpty() && !updatedDescription.isEmpty()) {
                    db.getBlog(userId);
                    Toast.makeText(Update.this, "User updated successfully", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(Update.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
