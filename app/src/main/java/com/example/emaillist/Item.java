package com.example.emaillist;

import android.graphics.drawable.Drawable;

public class Item {

    String sender;
    String time;
    String title;
    String preview;
    boolean check;
    Drawable drawable;

    public Item(Drawable drawable, Data data, boolean check) {
        this.drawable = drawable;
        if (data != null) {
            this.sender = data.sender;
            this.time = data.time;
            this.title = data.title.length() > 36 ?
                    data.title.substring(0, 35) + "..." : data.title;
            this.preview = data.preview.length() > 36 ?
                    data.preview.substring(0, 35) + "..." : data.preview;
        }
        this.check = check;
    }
}
