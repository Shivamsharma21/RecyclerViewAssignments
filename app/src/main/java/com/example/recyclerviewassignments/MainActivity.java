package com.example.recyclerviewassignments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewAdapter.CallbackInterface{


    List<PersonInfo>details = new ArrayList<>();
    ViewAdapter viewAdapter = new ViewAdapter(MainActivity.this,details);


    private static final int MY_REQUEST = 1001;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        switch(resultCode){

            case RESULT_OK:

                // ... Check for some data from the intent
                if(requestCode == MY_REQUEST){
                    // .. lets toast again
                    int position = -1;
                    if(data != null){
                        position = data.getIntExtra("Position", 0);
                    }

                    if(position != -1) {
                        String getUser = data.getStringExtra("Username");

                        PersonInfo personInfoupdate = new PersonInfo(getUser,"22-22","1212","flow","location","color");
                            details.remove(position);
                            details.add(position,personInfoupdate);
                            viewAdapter.notifyDataSetChanged();




                        Toast.makeText(this, "Handled the result successfully at position " + position, Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Failed to get data from intent" , Toast.LENGTH_SHORT).show();
                    }
                }

                break;

            case RESULT_CANCELED:

                // ... Handle this situation
                break;
        }

    }

    public void onHandleSelection(int position, String text) {

        Toast.makeText(this, "Selected item in list "+ position + " with text "+ text, Toast.LENGTH_SHORT).show();

        // ... Start a new Activity here and pass the values
        Intent secondActivity = new Intent(MainActivity.this, UserUpdation.class);
        secondActivity.putExtra("Text",text);
        secondActivity.putExtra("Position", position);
        Log.d("Yeh You reach","startActivity");
        startActivityForResult(secondActivity, MY_REQUEST);

    }

    LinearLayout linearLayout;
    EditText newUsername;
    RecyclerView recyclerView;
    ImageView addnew_item,delete_item;
    SwitchCompat switchCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchCompat = findViewById(R.id.switch1);
        linearLayout = findViewById(R.id.rootlayout);
        newUsername = findViewById(R.id.enternew_usernametv);
            Log.i("ONXX","This is On Create");
        addnew_item = findViewById(R.id.adding_new_item);
        delete_item = findViewById(R.id.delete_new_item);


        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(null);


        String status ="off";


        PersonInfo personInfo = new PersonInfo("Shivam Sharma","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York",status);

        PersonInfo personInfo1 = new PersonInfo("Jaden grece","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York",status);

        PersonInfo personInfo2 = new PersonInfo("Michale Vinken","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York",status);

        PersonInfo personInfo3 = new PersonInfo("Mila jade","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York",status);

        PersonInfo personInfo4 = new PersonInfo("Mily Chrish","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York",status);

        PersonInfo personInfo5 = new PersonInfo("Won Shi","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York",status);

        PersonInfo personInfo6 = new PersonInfo("Maden Claf","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York",status);

        PersonInfo personInfo7 = new PersonInfo("Blake Gracy","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York",status);


        details.add(personInfo);
        details.add(personInfo1);
        details.add(personInfo2);
        details.add(personInfo3);
        details.add(personInfo4);
        details.add(personInfo5);
        details.add(personInfo6);
        details.add(personInfo7);


       // recyclerView.setAdapter(new ViewAdapter(details,onClickInterface));
     viewAdapter = new ViewAdapter(MainActivity.this,details);

    recyclerView.setAdapter(viewAdapter);


       viewAdapter.SetOnItemClickListner(new ViewAdapter.OnItemClickListner() {
           @Override
           public void OnItemClick(View view, int position) {
               switchCompat.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       if (switchCompat.isChecked()){
                           linearLayout.setBackgroundColor(Color.GREEN);
                       }else{
                           linearLayout.setBackgroundColor(Color.WHITE);
                       }
                   }
               });
           }
       });



    addnew_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newuser = newUsername.getText().toString();

                PersonInfo personInfo10 = new PersonInfo(newuser,"9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York","off");


                details.add(0,personInfo10);

                viewAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "New User is added", Toast.LENGTH_SHORT).show();

            }
        });

    }

     }