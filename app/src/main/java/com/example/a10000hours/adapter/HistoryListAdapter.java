package com.example.a10000hours.adapter;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10000hours.DescriptionDialog;
import com.example.a10000hours.R;

import java.util.ArrayList;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ViewHolder> {

    private ArrayList<String> mHistory_dates = new ArrayList<>();
    private ArrayList<String> mHistory_titles = new ArrayList<>();
    private ArrayList<String> mHistory_time = new ArrayList<>();
    private ArrayList<String> mHistory_description = new ArrayList<>();
    private ArrayList<Integer> mHisotry_id = new ArrayList<>();
    DescriptionDialog descriptionDialog;
    private Context context;

    public HistoryListAdapter(Context context, ArrayList<String> mHistory_dates, ArrayList<String> mHistory_titles, ArrayList<String> mHistory_time, ArrayList<Integer> mHistory_id,
                              ArrayList<String> mHistory_description) {
        this.mHistory_dates = mHistory_dates;
        this.mHistory_titles = mHistory_titles;
        this.mHistory_time = mHistory_time;
        this.mHisotry_id = mHistory_id;
        this.mHistory_description = mHistory_description;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_list_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(" ","onBindViewHolder: called");

        holder.history_date.setText(mHistory_dates.get(position));
        holder.history_title.setText(mHistory_titles.get(position));
        holder.history_time.setText(mHistory_time.get(position));
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descriptionDialog = new DescriptionDialog();
                if(!mHistory_description.get(position).isEmpty()){
                    descriptionDialog.setDescription(mHistory_description.get(position));
                }else{
                    descriptionDialog.setDescription("No Description");
                }
                descriptionDialog.show(((AppCompatActivity)context).getSupportFragmentManager(), "dialog");
            }
        });
        Log.d("id", "" + mHisotry_id.get(position));
    }

    @Override
    public int getItemCount() {
        return mHistory_titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView history_date, history_title, history_time;
        RelativeLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            history_date = itemView.findViewById(R.id.history_date);
            history_title = itemView.findViewById(R.id.history_title);
            history_time = itemView.findViewById(R.id.history_time);
            layout = itemView.findViewById(R.id.history_child_layout);
        }
    }

}
