package com.example.emaillist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Item> items;

    public CustomAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item item = items.get(position);
        CustomViewHolder viewHolder = (CustomViewHolder) holder;
        viewHolder.text_icon.setText(String.format("%s", item.sender.charAt(0)));
        viewHolder.text_icon.setBackground(item.drawable);
        viewHolder.text_sender.setText(item.sender);
        viewHolder.text_time.setText(item.time);
        viewHolder.text_title.setText(item.title);
        viewHolder.text_preview.setText(item.preview);
        viewHolder.box_favourite.setChecked(item.check);
        viewHolder.box_favourite.setOnClickListener(v -> item.check = viewHolder.box_favourite.isChecked());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
