package com.anwesome.ui.cardngridlist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 25/04/17.
 */
public class CardView extends View {
    private float maxH = 0;
    private Screen screen = new Screen();
    private List<Card> cards = new ArrayList<>();
    private int time = 0;
    public CardView(Context context,List<Card> cardList) {
        super(context);
        this.cards = cardList;
    }
    public void onDraw(Canvas canvas) {
        Paint paint = Constants.paint;
        canvas.drawColor(Color.parseColor("#E0E0E0"));
        if(time == 0) {
            initLayout(canvas.getWidth(),cards);
        }
        canvas.save();
        canvas.translate(0,screen.y);
        for(Card card:cards) {
            card.draw(canvas,paint);
        }
        canvas.restore();
        time++;
    }
    public void initLayout(int w,List<Card> cards) {

    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            handleTap(event.getX(),event.getY());
        }
        return true;
    }
    protected void handleTap(float x,float y) {

    }
    public void setMaxH(float maxH) {
        this.maxH = maxH;
    }
    private class Screen {
        float y = 0;
    }
}
