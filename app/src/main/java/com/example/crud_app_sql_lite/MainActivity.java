package com.example.crud_app_sql_lite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button createbtn, updatebtn, deletebtn;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.mainlinearlayout);
        createbtn = findViewById(R.id.createBtn);

        DatabaseHandler db = new DatabaseHandler(this);
        db.AddBlog(new UserData("FAHAD", "LOVE TO CODE"));


        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Create.class);
                startActivity(intent);
            }
        });

        displayUsers();
    }

    @Override
    protected void onResume() {
        super.onResume();

        displayUsers();
    }

    private void displayUsers() {

        linearLayout.removeAllViews();

        DatabaseHandler db = new DatabaseHandler(this);


        List<UserData> users = db.getAllBlogs();


        for ( UserData user : users) {

            View userView = getLayoutInflater().inflate(R.layout.user_item_layout, null);


            TextView usernameView = userView.findViewById(R.id.username);
            TextView descriptionView = userView.findViewById(R.id.description);
            Button updateButton = userView.findViewById(R.id.updateBtn);
            Button deleteButton = userView.findViewById(R.id.deleteBtn);


            usernameView.setText(user.getName());
            descriptionView.setText(user.get_description());


            updateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Update.class);
                    intent.putExtra("user_id", user.getID());
                    startActivity(intent);
                }
            });


            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.deleteBlog(user);
                    displayUsers();
                }
            });


            linearLayout.addView(userView);
        }
    }
}
