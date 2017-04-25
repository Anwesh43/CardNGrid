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
    private int w,h;
    public CardNGridContainer(Context context,int w,int h) {
        super(context);
        this.w = w;
        this.h = h;
    }
    public void onMeasure(int wspec,int hspec) {
        super.onMeasure(wspec,hspec);
        setMeasuredDimension(2*w,h);
    }
    public void createAndAddCardList(List<Card> cards) {
        int wParam = w,hParam = ((11*w)/20)*cards.size();
        //ScrollView scrollView = new ScrollView(getContext());
        CardListView cardListView = new CardListView(getContext(),cards);
        addView(cardListView,new ViewGroup.LayoutParams(wParam,hParam));
        setX(0);
        cardListView.setMaxH(hParam);
        //addView(scrollView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void createAndAddGridList(List<Card> cards) {
        int wParam = w,gap = w/7,hParam = ((2*gap)*cards.size()/3)+2*gap;
        GridView gridView = new GridView(getContext(),cards);
        //ScrollView scrollView = new ScrollView(getContext());
        gridView.setX(w);
        addView(gridView,new ViewGroup.LayoutParams(wParam,hParam));
        gridView.setMaxH(hParam);
        //addView(scrollView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
    public void updateX(float factor) {
        setX(-w*factor);
    }
}
