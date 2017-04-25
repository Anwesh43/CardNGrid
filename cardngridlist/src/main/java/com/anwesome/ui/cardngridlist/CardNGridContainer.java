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
    private int w;
    public CardNGridContainer(Context context,int w) {
        super(context);
        this.w = w;
    }
    public void createAndAddCardList(List<Card> cards) {
        int wParam = w,hParam = ((11*w)/10)*cards.size();
        CardListView cardListView = new CardListView(getContext(),cards);
        cardListView.setX(w);
        addView(cardListView,new ViewGroup.LayoutParams(wParam,hParam));
        //addView(scrollView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void createAndAddGridList(List<Card> cards) {
        int wParam = w,gap = w/7,hParam = ((2*gap)*cards.size()/3)+2*gap;
        GridView gridView = new GridView(getContext(),cards);
        //ScrollView scrollView = new ScrollView(getContext());
        gridView.setX(0);
        addView(gridView,new ViewGroup.LayoutParams(wParam,hParam));
        //addView(scrollView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
    public void updateX(float factor) {
        setX(-w*factor);
    }
}
