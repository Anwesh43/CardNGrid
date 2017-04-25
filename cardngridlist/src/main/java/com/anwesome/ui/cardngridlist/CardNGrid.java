package com.anwesome.ui.cardngridlist;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
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
        cardToGridButton.setOnTapListener(new CardToGridButton.OnTapListener() {
            @Override
            public void onTap() {
                animationHandler.start();
            }
        });
        initDimension(activity);
        cardNGridContainer = new CardNGridContainer(activity,w,h);
        animationHandler = new AnimationHandler(cardToGridButton,cardNGridContainer);
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
            listCards.add(new Card(bitmap,title));
            gridCards.add(new Card(bitmap,title));
        }
    }
    public void show() {
        if(!isShown) {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            RelativeLayout relativeLayout = new RelativeLayout(activity);
            relativeLayout.addView(cardToGridButton,new ViewGroup.LayoutParams(w/10,w/10));
            cardToGridButton.setX(w/2-w/20);
            cardToGridButton.setY((Math.max(w,h)-Math.min(w,h))/20);
            cardNGridContainer.createAndAddCardList(listCards);
            cardNGridContainer.createAndAddGridList(gridCards);
            relativeLayout.addView(cardNGridContainer,new ViewGroup.LayoutParams(2*w,h));
            cardNGridContainer.setX(0);
            cardNGridContainer.setY(cardToGridButton.getY()+w/9);
            activity.setContentView(relativeLayout);
            isShown = true;
        }
    }
}
