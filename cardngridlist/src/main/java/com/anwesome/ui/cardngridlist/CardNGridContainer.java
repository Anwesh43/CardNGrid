package com.anwesome.ui.cardngridlist;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.util.List;

/**
 * Created by anweshmishra on 25/04/17.
 */
public class CardNGridContainer extends RelativeLayout{
    public CardNGridContainer(Context context) {
        super(context);
    }
    public void createAndAddCardList(List<Card> cards,int w) {
        int wParam = w,hParam = ((11*w)/10)*cards.size();
        CardListView cardListView = new CardListView(getContext(),cards);
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.setX(w);
        scrollView.addView(cardListView,new ViewGroup.LayoutParams(wParam,hParam));
        addView(scrollView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void createAndAddGridList(List<Card> cards,int w) {
        int wParam = w,gap = w/7,hParam = ((2*gap)*cards.size()/3)+2*gap;
        GridView gridView = new GridView(getContext(),cards);
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.setX(0);
        scrollView.addView(gridView,new ViewGroup.LayoutParams(wParam,hParam));
        addView(scrollView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
}
