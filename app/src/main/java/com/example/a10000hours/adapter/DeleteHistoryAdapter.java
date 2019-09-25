package com.example.a10000hours.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10000hours.DeleteHistory;
import com.example.a10000hours.R;

import java.util.ArrayList;

import Database.DBHelper;

public class DeleteHistoryAdapter extends RecyclerView.Adapter<DeleteHistoryAdapter.ViewHolder>{

    private ArrayList<String> mHistory_dates = new ArrayList<>();
    private ArrayList<String> mHistory_titles = new ArrayList<>();
    private ArrayList<String> mHistory_time = new ArrayList<>();
    private ArrayList<Integer>  mHistory_id = new ArrayList<>();
    private Context context;
    DBHelper db;

    public DeleteHistoryAdapter(Context context, ArrayList<String> mHistory_dates, ArrayList<String> mHistory_titles, ArrayList<String> mHistory_time, ArrayList<Integer>  mHistory_id) {
        this.mHistory_dates = mHistory_dates;
        this.mHistory_titles = mHistory_titles;
        this.mHistory_time = mHistory_time;
        this.mHistory_id = mHistory_id;
        this.context = context;
        db = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_hisotry_list, parent, false);
        DeleteHistoryAdapter.ViewHolder holder = new DeleteHistoryAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.delete_history_date.setText(mHistory_dates.get(position));
        holder.delete_history_title.setText(mHistory_titles.get(position));
        holder.delete_history_time.setText(mHistory_time.get(position));
        holder.delete_history_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean deleted = db.deleteRecord(mHistory_id.get(position));
                if(deleted){
                    Toast.makeText(context, "Data deleted successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(context, DeleteHistory.class);
                    context.startActivity(intent);
                }else{
                    Toast.makeText(context, "Record could not be deleted", Toast.LENGTH_LONG).show();
                }

            }
        });
        if(position % 2 == 0){
            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.white));
        }else{
            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.background_off_white));
        }
    }

    @Override
    public int getItemCount() {
        Log.d("titles_count", " " + mHistory_titles.size());
        return mHistory_titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView delete_history_time, delete_history_date, delete_history_title;
        ImageView delete_history_button;
        RelativeLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            delete_history_date = itemView.findViewById(R.id.delete_history_date);
            delete_history_title = itemView.findViewById(R.id.delete_history_title);
            delete_history_time = itemView.findViewById(R.id.delete_history_time);
            delete_history_button = itemView.findViewById(R.id.delete_history_button);
            layout = itemView.findViewById(R.id.delete_history_layout);
        }
    }

}
