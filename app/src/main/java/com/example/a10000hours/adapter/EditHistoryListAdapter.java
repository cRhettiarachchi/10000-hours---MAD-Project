package com.example.a10000hours.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10000hours.R;

import java.util.ArrayList;

public class EditHistoryListAdapter extends RecyclerView.Adapter<EditHistoryListAdapter.ViewHolder>{

    private ArrayList<String> mHistory_dates = new ArrayList<>();
    private ArrayList<String> mHistory_titles = new ArrayList<>();
    private ArrayList<String> mHistory_time = new ArrayList<>();
    private Context context;

    public EditHistoryListAdapter(Context context, ArrayList<String> mHistory_dates, ArrayList<String> mHistory_titles, ArrayList<String> mHistory_time) {
        this.mHistory_dates = mHistory_dates;
        this.mHistory_titles = mHistory_titles;
        this.mHistory_time = mHistory_time;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_history_list_items, parent, false);
        EditHistoryListAdapter.ViewHolder holder = new EditHistoryListAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(" ","onBindViewHolder: called");

        holder.edit_history_date.setText(mHistory_dates.get(position));
        holder.edit_history_title.setText(mHistory_titles.get(position));
        holder.edit_history_time.setText(mHistory_time.get(position));
    }

    @Override
    public int getItemCount() {
        return mHistory_titles.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView edit_history_date, edit_history_title, edit_history_hours;
        EditText edit_history_time;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            edit_history_date = itemView.findViewById(R.id.edit_history_date);
            edit_history_title = itemView.findViewById(R.id.edit_history_title);
            edit_history_time = itemView.findViewById(R.id.edit_history_time);
            edit_history_hours = itemView.findViewById(R.id.edit_history_hrs);
        }
    }
}
