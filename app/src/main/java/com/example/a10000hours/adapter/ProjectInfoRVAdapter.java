package com.example.a10000hours.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10000hours.R;

import java.util.ArrayList;

public class ProjectInfoRVAdapter extends RecyclerView.Adapter<ProjectInfoRVAdapter.PInfoViewHolder>{

    private static final String TAG = "ProjectInfoRVAdapter";

    private Context mContext;
    private ArrayList<String> projectNames = new ArrayList<>();
    private ArrayList<String> totalHours = new ArrayList<>();

    public ProjectInfoRVAdapter(Context mContext, ArrayList<String> proNames, ArrayList<String> hours) {
        this.mContext = mContext;
        this.projectNames = proNames;
        this.totalHours = hours;
        Log.d(TAG,"ProjectInfoAdapter constructor called!!");

    }

    @NonNull
    @Override
    public PInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG,"test1 called!!");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_info,parent,false);
        PInfoViewHolder holder = new PInfoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PInfoViewHolder holder, final int position) {
        Log.d(TAG,"2nd onBindViewHolder called!!");

        holder.projectName.setText(projectNames.get(position));
        holder.totHours.setText(totalHours.get(position));

    /*    holder.infoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,projectNames.get(position),Toast.LENGTH_SHORT).show();
            }
        }); */

    }

    @Override
    public int getItemCount() {
        return projectNames.size();
    }

    public class PInfoViewHolder extends RecyclerView.ViewHolder{

        CardView infoCard;
        ImageView projectImg;
        TextView projectName;
        TextView totHours;

        public PInfoViewHolder(@NonNull View itemView) {
            super(itemView);

            infoCard = itemView.findViewById(R.id.projectInfoCard);
            projectName = itemView.findViewById(R.id.projectNameInfo);
            totHours = itemView.findViewById(R.id.totalHours);
            projectImg = itemView.findViewById(R.id.tIcon4);

        }
    }

}
