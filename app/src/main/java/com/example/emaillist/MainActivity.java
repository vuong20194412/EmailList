package com.example.emaillist;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private static CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("  Inbox");
            getSupportActionBar().setIcon(R.drawable.menu);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
        }

        if (savedInstanceState == null) {
            init();
        }

        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void init() {
        ArrayData dataArray = new ArrayData();
        Data[] arrayData = dataArray.getDataArray();
        int[] arrayColor = dataArray.getColorArray();
        int len = arrayColor.length;
        Item[] items = new Item[arrayData.length];
        int i = 0;
        for (Data data : arrayData) {
            Drawable drawable = getDrawable(R.drawable.text_icon);
            int index = (int) (Math.random() * 1024) % len;
            drawable.setColorFilter(arrayColor[index], PorterDuff.Mode.ADD);
            items[i] = new Item(drawable, data, index % 2 == 0);
            i++;
        }

        adapter = new CustomAdapter(items, getDrawable(R.drawable.star),
                getDrawable(R.drawable.star_border));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}