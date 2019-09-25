package com.example.a10000hours.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10000hours.History;
import com.example.a10000hours.R;
import Database.DBHelper;

import java.util.ArrayList;

public class EditHistoryListAdapter extends RecyclerView.Adapter<EditHistoryListAdapter.ViewHolder>{

    private ArrayList<String> mHistory_dates = new ArrayList<>();
    private ArrayList<String> mHistory_titles = new ArrayList<>();
    private ArrayList<String> mHistory_time = new ArrayList<>();
    private ArrayList<Integer> mHistory_id = new ArrayList<>();
    private Context context;

    //String variable to read edited value
    double editedTime;
    DBHelper db;

    public EditHistoryListAdapter(Context context, ArrayList<String> mHistory_dates, ArrayList<String> mHistory_titles, ArrayList<String> mHistory_time, ArrayList<Integer>  mHistory_id) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_history_list_items, parent, false);
        EditHistoryListAdapter.ViewHolder holder = new EditHistoryListAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(" ","onBindViewHolder: called");

        holder.edit_history_date.setText(mHistory_dates.get(position));
        holder.edit_history_title.setText(mHistory_titles.get(position));
        holder.edit_history_time.setText(mHistory_time.get(position));
        holder.doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editedTime = Double.parseDouble(holder.edit_history_time.getText().toString());
                boolean updated = db.updateTimeRecord(mHistory_id.get(position), editedTime);
                if(updated){
                    Toast.makeText(context, "The record has been updated", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context, "Update failed", Toast.LENGTH_LONG).show();
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
        return mHistory_titles.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView edit_history_date, edit_history_title, edit_history_hours;
        EditText edit_history_time;
        RelativeLayout layout;
        ImageView doneBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            edit_history_date = itemView.findViewById(R.id.edit_history_date);
            edit_history_title = itemView.findViewById(R.id.edit_history_title);
            edit_history_time = itemView.findViewById(R.id.edit_history_time);
            doneBtn = itemView.findViewById(R.id.edit_history_edit_done_btn);
            layout = itemView.findViewById(R.id.edit_history_layout);
        }
    }
}
