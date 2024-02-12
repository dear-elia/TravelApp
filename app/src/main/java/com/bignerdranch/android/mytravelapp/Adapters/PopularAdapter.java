package com.bignerdranch.android.mytravelapp.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bignerdranch.android.mytravelapp.Domains.PopularDomain;
import com.bignerdranch.android.mytravelapp.R;
import com.bignerdranch.android.mytravelapp.activities.DetailActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import java.text.DecimalFormat;
import java.util.ArrayList;

//define an adapter for a RecyclerView that displays a list of PopularDomain objects
public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    ArrayList<PopularDomain> items;


    public PopularAdapter(ArrayList<PopularDomain> items) {
        this.items = items;

    }

    //onCreateViewHolder() creates a new ViewHolder instance and inflates the viewholder_popular layout.
    @NonNull
    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }


    //onBindViewHolder() sets the data for each item in the RecyclerView.
    //It gets the item at the current position from the items ArrayList and sets the titleTxt, locationTxt, and scoreTxt
    //TextView objects with the item's data.
    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.locationTxt.setText(items.get(position).getLocation());
        holder.scoreTxt.setText(""+items.get(position).getScore());

        int drawableResId = holder.itemView.getResources().getIdentifier(items.get(position).getPic(),
                "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResId)
                .transform(new CenterCrop(), new GranularRoundedCorners(40, 40, 40, 40))
                .into(holder.pic);


        //we create 'onClickListener' for each item in RecyclerView
        //when you click on an item in the RecyclerView,
        //this code creates an Intent to start the DetailActivity

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("object",items.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleTxt, locationTxt, scoreTxt;
        ImageView pic;
        public ViewHolder(@NonNull View itemView){
            super(itemView);

            titleTxt = itemView.findViewById(R.id.titleTxt);
            locationTxt = itemView.findViewById(R.id.locationTxt);
            scoreTxt = itemView.findViewById(R.id.scoretxt);
            pic = itemView.findViewById(R.id.picImg);
        }
    }
}
