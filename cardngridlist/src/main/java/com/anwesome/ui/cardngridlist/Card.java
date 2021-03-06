package com.anwesome.ui.cardngridlist;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by anweshmishra on 25/04/17.
 */
public class Card {
    private Bitmap bitmap;
    private String title;
    private float x,y,size;
    private OnClickListener onClickListener;
    public Card(Bitmap bitmap,String title) {
        this.bitmap = bitmap;
        this.title = title;
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(x,y);
        paint.setColor(Color.WHITE);
        canvas.drawRect(new RectF(0,0,size,size),paint);
        canvas.drawBitmap(bitmap,size/10,size/10,paint);
        paint.setTextSize(size/10);
        canvas.save();
        canvas.translate(size/10,4*size/5+size/10);
        String adjustedTitle = getAdjustedTitle(paint);
        paint.setColor(Color.BLACK);
        canvas.drawText(adjustedTitle,0,paint.getTextSize()/10,paint);
        canvas.restore();
        canvas.restore();
    }
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    private String getAdjustedTitle(Paint paint) {
        String msg = "";
        for(int i=0;i<title.length();i++) {
            char letter = title.charAt(i);
            if(paint.measureText(msg+letter) < (7*size)/10) {
                msg += letter;
            }
            else {
                msg += "...";
                break;
            }
        }
        return msg;
    }
    public void setDimension(float x,float y,float size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.bitmap = Bitmap.createScaledBitmap(bitmap,(int)(4*size/5),(int)(3*size/5),true);
    }
    public boolean handleTap(float x,float y) {
        boolean condition = x>=this.x && x<=this.x+size && y>=this.y && y<=this.y+size;
        if(condition && onClickListener!=null) {
            onClickListener.onClick();
        }
        return condition;
    }
    public int hashCode() {
        return bitmap.hashCode()+title.hashCode();
    }
}
