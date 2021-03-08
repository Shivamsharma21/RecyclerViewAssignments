package com.example.recyclerviewassignments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolderX> {


    public OnItemClickListner onItemClickListner;

    public interface OnItemClickListner {

        void OnItemClick(View view,int position);

    }

    public void SetOnItemClickListner(OnItemClickListner clickListner){
        onItemClickListner = clickListner;
    }
   public Context mcontext;

    CallbackInterface callbackInterface;
    List<PersonInfo>itemList;

   public interface CallbackInterface{

        /**
         * Callback invoked when clicked
         * @param position - the position
         * @param text - the text to pass back
         */
        void onHandleSelection(int position, String text);
    }

    public ViewAdapter(Context context,List<PersonInfo>list) {

        mcontext = context;
         itemList =list;
        callbackInterface = (CallbackInterface) context;
    }

    @NonNull
    @Override
    public ViewHolderX onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.listitem,parent,false);
        return new ViewHolderX(view,onItemClickListner) ;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderX holder, int position) {

        final ViewHolderX viewHolderX = (ViewHolderX)holder;

        PersonInfo personInfo = itemList.get(position);
         holder.usernametv.setText(personInfo.getUsername());
         holder.Flowtv.setText(personInfo.getFlow());
         holder.locationtv.setText(personInfo.getLocation());
         holder.timetv.setText(personInfo.getTime());

        String passname =  holder.usernametv.getText().toString();

         String status = personInfo.getColor();

         int pos = position;

             personInfo.setColor(status);

             if (personInfo.getColor()=="off"){
                 holder.linearLayout.setBackgroundColor(Color.WHITE);
             }


        holder.delete_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemList.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.usernametv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callbackInterface.onHandleSelection(position,"This is text");
                   notifyDataSetChanged();

            }
        });

   
   }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    static class ViewHolderX extends RecyclerView.ViewHolder{


        SwitchCompat switchCompat;
        LinearLayout linearLayout;
        TextView datetv,Flowtv,usernametv,timetv,locationtv;
        Button Decline_btn,Accept_btn;
        ImageView user_img,clock_img,locationimg,delete_item,addnew_item;

        public ViewHolderX(@NonNull View itemView,OnItemClickListner listner) {
            super(itemView);


            switchCompat = itemView.findViewById(R.id.switch1);

            linearLayout =itemView.findViewById(R.id.rootlayout);
            // textview
            datetv = itemView.findViewById(R.id.date_textview);
            Flowtv = itemView.findViewById(R.id.flow_textview);
            usernametv = itemView.findViewById(R.id.username_textview);
            timetv = itemView.findViewById(R.id.textviewTime);
            locationtv =itemView.findViewById(R.id.location_textview);

            ///   button
            Decline_btn = itemView.findViewById(R.id.Declinebtn);
            Accept_btn = itemView.findViewById(R.id.acceptbtn);

           // image view

            delete_item =itemView.findViewById(R.id.delete_new_item);

            user_img = itemView.findViewById(R.id.user_imageView);
            clock_img = itemView.findViewById(R.id.imagetime);
            locationimg = itemView.findViewById(R.id.locationimage);

//            switchCompat.setOnClickListener(this);

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
            Accept_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     int c =getAdapterPosition();
                     Toast.makeText(v.getContext(),"Clicked Action button",Toast.LENGTH_SHORT).show();
                    Log.d("This Is Lister block","Yeppp it is");
                    Log.d("This Is Position",String.valueOf(c));
                }
            });

       /*     itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listner != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listner.OnItemClick(v,position);
                        }
                    }
                }
            });*/

        }

      /*  @Override
        public void onClick(View v) {
        int position = getAdapterPosition();
           if (position != 0){
               switchCompat.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       if (switchCompat.isChecked()){
                       linearLayout.setBackgroundColor(Color.GREEN);}
                       else{
                           linearLayout.setBackgroundColor(Color.WHITE);
                       }
                   }
               });*/
           }
        }



            /*
           if (switchCompat.isChecked()){
               linearLayout.setBackgroundColor(Color.GREEN);
           }else{
               linearLayout.setBackgroundColor(Color.WHITE);
           }*/




