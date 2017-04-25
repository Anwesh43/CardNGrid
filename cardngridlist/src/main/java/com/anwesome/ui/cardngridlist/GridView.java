package com.anwesome.ui.cardngridlist;

import android.content.Context;

import java.util.List;

/**
 * Created by anweshmishra on 25/04/17.
 */
public class GridView extends CardView {
    public GridView(Context context,List<Card> cards) {
        super(context,cards);
    }
    public void initLayout(int w,List<Card> cards) {
        LayoutUtil.arrangeInGrid(cards,w);
    }
}
