package com.anwesome.ui.cardngridlist;

import android.content.Context;

import java.util.List;

/**
 * Created by anweshmishra on 25/04/17.
 */
public class CardListView extends CardView {
    public CardListView(Context context, List<Card> cards) {
        super(context,cards);
    }
    public void initLayout(int w,List<Card> cards) {
        LayoutUtil.arrangeInCardList(cards,w);
    }
}
