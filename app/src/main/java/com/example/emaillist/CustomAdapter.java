package com.example.emaillist;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Item[] items;
    int size;
    Drawable star1, star2;

    public CustomAdapter(Item[] items, Drawable star1, Drawable star2) {
        this.items = items;
        size = items == null ? 0 : items.length;
        this.star1 = star1;
        this.star2 = star2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup root, int viewType) {
        View view = LayoutInflater.from(root.getContext()).inflate(R.layout.item, root, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        CustomViewHolder viewHolder = (CustomViewHolder)holder;
        viewHolder.setText(items[i]);
        viewHolder.box_favourite.setChecked(items[i].check);
        viewHolder.box_favourite.setButtonDrawable(items[i].check ? star1 : star2);
        viewHolder.box_favourite.setOnClickListener(v -> {
            items[i].check = viewHolder.box_favourite.isChecked();
            viewHolder.box_favourite.setButtonDrawable(items[i].check ? star1 : star2);
        });
    }

    @Override
    public long getItemId(int index) {
        return index;
    }

    @Override
    public int getItemCount() {
        return size;
    }
}
