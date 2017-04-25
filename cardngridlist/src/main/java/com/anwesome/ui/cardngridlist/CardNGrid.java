package com.anwesome.ui.cardngridlist;

import android.app.Activity;

/**
 * Created by anweshmishra on 25/04/17.
 */
public class CardNGrid {
    private Activity activity;
    private CardToGridButton cardToGridButton;
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
    }
}
