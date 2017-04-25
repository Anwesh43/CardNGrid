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
    public CardView(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {
        Paint paint = Constants.paint;
    }
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
