package com.example.emaillist;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Data[] arrayData = ArrayData.dataArray;
    int[] colors = ArrayData.colorArray;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("  Inbox");
            getSupportActionBar().setIcon(R.drawable.ic_baseline_menu_24);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
        }

        RecyclerView recyclerView = findViewById(R.id.list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Item> items = new ArrayList<>();

        int len = colors.length;
        int size = arrayData.length;
        int index;
        Drawable drawable;
        for (int i = 0; i < size; i++) {
            drawable = getDrawable(R.drawable.text_icon);
            index = (int) (Math.random() * 1000000) % len;
            drawable.setColorFilter(colors[index], PorterDuff.Mode.ADD);
            items.add(new Item(drawable, arrayData[i], i % 2 == 0));
        }

        CustomAdapter adapter = new CustomAdapter(this, items);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}