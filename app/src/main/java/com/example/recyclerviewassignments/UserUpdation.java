package com.example.recyclerviewassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserUpdation extends AppCompatActivity {
   EditText usernaemupdate_;
   Button update_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_updation);

            usernaemupdate_ =findViewById(R.id.username_update);
            update_btn = findViewById(R.id.updatebutton);



          update_btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  String Updated_Username = usernaemupdate_.getText().toString();

                  Intent intent = getIntent();

                  int Position = intent.getIntExtra("Position",0);


                  Toast.makeText(UserUpdation.this, ""+Updated_Username+" "+Position, Toast.LENGTH_SHORT).show();
                  //  String Username  = intent.getStringExtra("Text");

                  Intent resultIntent = new Intent();

                  resultIntent.putExtra("Position",Position);
                  resultIntent.putExtra("Username",Updated_Username); //   update name will be pass from here   ///

                  setResult(RESULT_OK,resultIntent);
                  finish();



              }
          });

    /*  //      int position = extras.getInt("Position");
            Intent resultintent = new Intent();
          //  resultintent.putExtra("Position",position);
            setResult(RESULT_OK,resultintent);
            finish();*/
    }
}