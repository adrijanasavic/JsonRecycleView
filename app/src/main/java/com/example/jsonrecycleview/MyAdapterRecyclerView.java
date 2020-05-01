package com.example.jsonrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapterRecycleView extends RecyclerView.Adapter<MyAdapterRecycleView.MyViewHolder> {
    private List<Detail> details;
    Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView age;

        public MyViewHolder(@NonNull View itemView) {
            super( itemView );

            this.name = itemView.findViewById( R.id.name );
            this.age = itemView.findViewById( R.id.age );
        }
    }


    public MyAdapterRecycleView(List<Detail> details, Context context) {
        this.details = details;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.details_row, parent, false );

        MyViewHolder myViewHolder = new MyViewHolder( view );
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText( details.get( position ).getName() );
        holder.age.setText( String.valueOf( details.get( position ).getAge() ) );

    }

    @Override
    public int getItemCount() {
        return details.size();
    }

}
