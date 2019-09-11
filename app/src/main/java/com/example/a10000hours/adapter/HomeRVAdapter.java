package com.example.a10000hours.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10000hours.R;

import java.util.ArrayList;

public class HomeRVAdapter extends RecyclerView.Adapter<HomeRVAdapter.HomeViewHolder>{

    private static final String TAG = "HomeRVAdapter";

    private ArrayList<String> projectNames = new ArrayList<>();
    private Context nContext;


    public HomeRVAdapter(Context context,ArrayList<String> projectNames) {
        this.projectNames = projectNames;
        this.nContext = context;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_homepage,parent,false);
        HomeViewHolder holder = new HomeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder called!!");

        holder.projectName.setText(projectNames.get(position));

    }

    @Override
    public int getItemCount() {
        return projectNames.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView projectName;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            projectName = itemView.findViewById(R.id.projectName);
            cardView = itemView.findViewById(R.id.projectHomeCard);
        }

    }

}