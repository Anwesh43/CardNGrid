package com.anwesome.ui.cardngridlist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 25/04/17.
 */
public class CardView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public CardView(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {

    }
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
