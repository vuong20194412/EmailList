package com.example.emaillist;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView text_icon;
    TextView text_sender;
    TextView text_time;
    TextView text_title;
    TextView text_preview;
    CheckBox box_favourite;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        text_icon = itemView.findViewById(R.id.text_icon);
        text_sender= itemView.findViewById(R.id.text_sender);
        text_time = itemView.findViewById(R.id.text_time);
        text_title = itemView.findViewById(R.id.text_title);
        text_preview = itemView.findViewById(R.id.text_preview);
        box_favourite = itemView.findViewById(R.id.box_favourite);
    }

    public void setText(@NonNull Item item) {
        text_icon.setText(String.valueOf(item.sender.charAt(0)));
        text_icon.setBackground(item.drawable);
        text_sender.setText(item.sender);
        text_time.setText(item.time);
        text_title.setText(item.title);
        text_preview.setText(item.preview);
    }
}
