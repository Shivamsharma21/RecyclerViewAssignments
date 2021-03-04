package com.example.recyclerviewassignments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private onClickInterface onclickInterface;
    ImageView addnew_item,delete_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Log.i("ONXX","This is On Create");
        addnew_item = findViewById(R.id.adding_new_item);
        delete_item = findViewById(R.id.delete_new_item);



        onclickInterface = new onClickInterface() {
            @Override
            public void setClick(int abc) {
                //list.remove(abc);
                Toast.makeText(MainActivity.this,"Position is"+abc, Toast.LENGTH_LONG).show();
                //  recyclerView.notifyDataSetChanged();
            }
        };
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        List<PersonInfo>details = new ArrayList<>();

        PersonInfo personInfo = new PersonInfo("Shivam Sharma","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York");

        PersonInfo personInfo1 = new PersonInfo("Jaden grece","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York");

        PersonInfo personInfo2 = new PersonInfo("Michale Vinken","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York");

        PersonInfo personInfo3 = new PersonInfo("Mila jade","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York");

        PersonInfo personInfo4 = new PersonInfo("Mily Chrish","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York");

        PersonInfo personInfo5 = new PersonInfo("Won Shi","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York");

        PersonInfo personInfo6 = new PersonInfo("Maden Claf","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York");

        PersonInfo personInfo7 = new PersonInfo("Blake Gracy","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York");


        details.add(personInfo);
        details.add(personInfo1);
        details.add(personInfo2);
        details.add(personInfo3);
        details.add(personInfo4);
        details.add(personInfo5);
        details.add(personInfo6);
        details.add(personInfo7);


       // recyclerView.setAdapter(new ViewAdapter(details,onClickInterface));
    ViewAdapter viewAdapter = new ViewAdapter(details,onclickInterface);
    recyclerView.setAdapter(viewAdapter);
        addnew_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonInfo personInfo10 = new PersonInfo("Wiz Khalifa","9:00 AM - 10 AM (1hr)","12-01-2021","Flow","New York");
                details.add(personInfo10);
                viewAdapter.notifyItemInserted(details.size() - 1);
                Toast.makeText(MainActivity.this, "New User is added", Toast.LENGTH_SHORT).show();

            }
        });

    delete_item.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (viewAdapter.getItemCount() >0){

            Toast.makeText(MainActivity.this, "User is deleted", Toast.LENGTH_SHORT).show();
            details.remove(details.size()-1);
             viewAdapter.notifyItemChanged(details.size());

            }else{
                Toast.makeText(MainActivity.this, "List Is Empty", Toast.LENGTH_SHORT).show();
            }
        }
    });


    }
     }