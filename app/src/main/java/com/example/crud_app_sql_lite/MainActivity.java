package com.example.crud_app_sql_lite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button createbtn,updatebtn,deletebtn;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        db.AddBlog(new UserData("FAHAD","LOVE TO CODE"));

        List<UserData> users =db.getAllBlogs();
        for(UserData us: users){

        }
        linearLayout = findViewById(R.id.mainlinearlayout);
        createbtn = findViewById(R.id.createBtn);
        updatebtn = findViewById(R.id.updateBtn);
        deletebtn = findViewById(R.id.deleteBtn);

      createbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(getApplicationContext(),Create.class);
              startActivity(intent);
          }
      });
      updatebtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(getApplicationContext(), Update.class);
              startActivity(intent);
          }
      });
    }
}