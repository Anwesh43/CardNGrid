package com.anwesome.ui.cardngridlist;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 25/04/17.
 */
public class CardNGrid {
    private Activity activity;
    private CardToGridButton cardToGridButton;
    private boolean isShown = false;
    private int w,h;
    private AnimationHandler animationHandler;
    private CardNGridContainer cardNGridContainer;
    private List<Card> gridCards = new ArrayList<>(),listCards = new ArrayList<>();
    public CardNGrid(Activity activity) {
        this.activity = activity;
        cardToGridButton = new CardToGridButton(activity);
        animationHandler = new AnimationHandler(cardToGridButton);
        cardNGridContainer = new CardNGridContainer(activity);
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
    public void addCard(Bitmap bitmap,String title) {
        if(!isShown) {
            Card card = new Card(bitmap,title);
            listCards.add(card);
            gridCards.add(card);
        }
    }
    public void show() {
        if(!isShown) {
            RelativeLayout relativeLayout = new RelativeLayout(activity);
            relativeLayout.addView(cardToGridButton,new ViewGroup.LayoutParams(w/10,w/10));
            cardToGridButton.setX(w/2-w/20);
            cardToGridButton.setY((Math.max(w,h)-Math.min(w,h))/20);
            cardNGridContainer.createAndAddCardList(listCards,w);
            cardNGridContainer.createAndAddGridList(gridCards,w);
            relativeLayout.addView(cardNGridContainer,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            cardNGridContainer.setX(0);
            cardNGridContainer.setY(cardToGridButton.getY()+w/9);
            activity.setContentView(relativeLayout);
            isShown = true;
        }
    }
}
