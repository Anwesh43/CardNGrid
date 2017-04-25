package com.anwesome.ui.cardngridlist;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.ViewGroup;

/**
 * Created by anweshmishra on 25/04/17.
 */
public class CardNGrid {
    private Activity activity;
    private CardToGridButton cardToGridButton;
    private boolean isShown = false;
    private int w,h;
    private AnimationHandler animationHandler;
    public CardNGrid(Activity activity) {
        this.activity = activity;
        cardToGridButton = new CardToGridButton(activity);
        animationHandler = new AnimationHandler(cardToGridButton);
        cardToGridButton.setOnTapListener(new CardToGridButton.OnTapListener() {
            @Override
            public void onTap() {
                animationHandler.start();
            }
        });
        initDimension(activity);
    }
    public void initDimension(Activity activity) {
        DisplayManager displayManager = (DisplayManager)activity.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        if(display != null) {
            Point dimension = new Point();
            display.getRealSize(dimension);
            w = dimension.x;
            h = dimension.y;
        }
    }
    public void show() {
        if(!isShown) {
            activity.addContentView(cardToGridButton,new ViewGroup.LayoutParams(w/10,w/10));
            cardToGridButton.setX(w/2-w/20);
            cardToGridButton.setY(h/30+w/2-w/20);
            isShown = true;
        }
    }
}
