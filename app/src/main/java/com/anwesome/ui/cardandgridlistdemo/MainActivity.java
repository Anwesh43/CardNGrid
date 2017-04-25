package com.anwesome.ui.cardandgridlistdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.anwesome.ui.cardngridlist.CardNGrid;
import com.anwesome.ui.cardngridlist.OnClickListener;

public class MainActivity extends AppCompatActivity {
    private int resources[] = {R.drawable.back,R.drawable.back1,R.drawable.back2,R.drawable.back3,R.drawable.back4};
    private Bitmap bitmaps[] = new Bitmap[resources.length];
    private String titles[] = {"background image","background image 1","background image 2","background image 3","background image 4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<resources.length;i++) {
            bitmaps[i] = BitmapFactory.decodeResource(getResources(),resources[i]);
        }
        CardNGrid cardNGrid = new CardNGrid(this);
        for(int i=0;i<bitmaps.length;i++) {
            final String title = titles[i];
            cardNGrid.addCard(bitmaps[i], titles[i], new OnClickListener() {
                @Override
                public void onClick() {
                    Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
                }
            });
        }
        cardNGrid.show();
    }
}
