package com.anwesome.ui.cardngridlist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 25/04/17.
 */
public class CardToGridButton extends View {
    private int w;
    private CardToGridShape cardToGridShape = new CardToGridShape();
    private OnTapListener onTapListener;
    public void setOnTapListener(OnTapListener onTapListener) {
        this.onTapListener = onTapListener;
    }
    public CardToGridButton(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {
        Paint paint = Constants.paint;
        w = canvas.getWidth();
        cardToGridShape.draw(canvas,paint);
    }
    public void update(float factor) {
        cardToGridShape.update(factor);
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN && onTapListener != null) {
            onTapListener.onTap();
        }
        return true;
    }
    private class CardToGridShape {
        private float l = 0,deg = 0;
        public void draw(Canvas canvas,Paint paint) {
            canvas.drawColor(Color.parseColor("#BDBDBD"));
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(w/15);
            canvas.save();
            canvas.translate(w/2,w/2);
            canvas.rotate(deg);
            for(int i =0;i<3;i++) {
                canvas.save();
                canvas.translate(0,(i-1)*w/2);
                Path path = new Path();
                for(int k=0;k<3;k++) {
                    int x = (i-1)*w/2, y = 0;
                    canvas.save();
                    canvas.translate(x,y);
                    canvas.drawRect(new RectF(-w/30,-w/30,w/30,w/30),paint);
                    canvas.restore();
                }
                canvas.drawLine(0,0,-l,0,paint);
                canvas.drawLine(0,0,l,0,paint);
                canvas.restore();
            }
            canvas.restore();
        }
        public void update(float factor) {
            deg = 90*factor;
            l = ((w/2-w/15))*factor;
        }
    }
    public interface OnTapListener {
        void onTap();
    }
}
