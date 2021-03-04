package com.example.recyclerviewassignments;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolderX> {

    List<PersonInfo>itemList;
   onClickInterface onClickInterface;

    public ViewAdapter(List<PersonInfo>list,onClickInterface onClickInterface) {
         itemList =list;
        this.onClickInterface = onClickInterface;
    }

    @NonNull
    @Override
    public ViewHolderX onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.listitem,parent,false);
        return new ViewHolderX(view) ;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderX holder, int position) {
        PersonInfo personInfo = itemList.get(position);
         holder.usernametv.setText(personInfo.getUsername());
         holder.Flowtv.setText(personInfo.getFlow());
         holder.locationtv.setText(personInfo.getLocation());
         holder.timetv.setText(personInfo.getTime());
         holder.delete_item.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 itemList.remove(position);
                 //or use this for better perfomance.
                 notifyItemChanged(position);

             }
         });
         holder.Accept_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 onClickInterface.setClick(position);

             }
         });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolderX extends RecyclerView.ViewHolder{

        TextView datetv,Flowtv,usernametv,timetv,locationtv;
        Button Decline_btn,Accept_btn;
        ImageView user_img,clock_img,locationimg,delete_item;

        public ViewHolderX(@NonNull View itemView) {
            super(itemView);

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
            Accept_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     int c =getAdapterPosition();
                    Log.d("This Is Lister block","Yeppp it is");
                    Log.d("This Is Position",String.valueOf(c));
                }
            });
        }
    }
}
