package com.example.a10000hours.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10000hours.R;

import java.util.ArrayList;

public class DeleteHistoryAdapter extends RecyclerView.Adapter<DeleteHistoryAdapter.ViewHolder>{

    private ArrayList<String> mHistory_dates = new ArrayList<>();
    private ArrayList<String> mHistory_titles = new ArrayList<>();
    private ArrayList<String> mHistory_time = new ArrayList<>();
    private Context context;

    public DeleteHistoryAdapter(Context context, ArrayList<String> mHistory_dates, ArrayList<String> mHistory_titles, ArrayList<String> mHistory_time) {
        this.mHistory_dates = mHistory_dates;
        this.mHistory_titles = mHistory_titles;
        this.mHistory_time = mHistory_time;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_hisotry_list, parent, false);
        DeleteHistoryAdapter.ViewHolder holder = new DeleteHistoryAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.delete_history_date.setText(mHistory_dates.get(position));
        holder.delete_history_title.setText(mHistory_titles.get(position));
        holder.delete_history_time.setText(mHistory_time.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d("titles_count", " " + mHistory_titles.size());
        return mHistory_titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView delete_history_time, delete_history_date, delete_history_title;
        ImageView delete_history_rmImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            delete_history_date = itemView.findViewById(R.id.delete_history_date);
            delete_history_title = itemView.findViewById(R.id.delete_history_title);
            delete_history_time = itemView.findViewById(R.id.delete_history_time);
            delete_history_rmImage = itemView.findViewById(R.id.delete_history_button);
        }
    }

}
