package com.anwesome.ui.cardngridlist;

import android.app.Activity;

/**
 * Created by anweshmishra on 25/04/17.
 */
public class CardNGrid {
    private Activity activity;
    private CardToGridButton cardToGridButton;
    public CardNGrid(Activity activity) {
        this.activity = activity;
        cardToGridButton = new CardToGridButton(activity);
    }
}
