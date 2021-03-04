package com.example.recyclerviewassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserUpdation extends AppCompatActivity {
   EditText usernaemupdate_;
   Button update_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_updation);

    usernaemupdate_ =findViewById(R.id.username_update);
    update_btn = findViewById(R.id.updatebutton);

  String passname = usernaemupdate_.getText().toString();

        Intent intent = new Intent(UserUpdation.this,MainActivity.class);
          intent.putExtra("username",passname);
    }
}