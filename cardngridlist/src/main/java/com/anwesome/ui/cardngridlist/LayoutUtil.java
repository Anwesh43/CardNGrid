package com.anwesome.ui.cardngridlist;

import java.util.List;

/**
 * Created by anweshmishra on 25/04/17.
 */
public class LayoutUtil {
    public static void arrangeInGrid(List<Card> cards,float w) {
        float gap = w/7,x =3*gap/2,y = 3*gap/2,i = 0;
        for(Card card:cards) {
            card.setDimension(x,y,gap);
            x += 3*gap/2;
            i++;
            if(i == 3) {
                i = 0;
                x = 3*gap/2;
                y += 2*gap;
            }
        }
    }
    public static void arrangeInCardList(List<Card> cards,float w) {
        float x = 0,y = w/20;
        for(Card card:cards) {
            card.setDimension(x,y,w);
            y += w/20 +w;
        }
    }
}
