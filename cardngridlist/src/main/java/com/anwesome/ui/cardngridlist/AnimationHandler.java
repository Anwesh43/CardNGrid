package com.anwesome.ui.cardngridlist;

import android.animation.Animator;
import android.animation.ValueAnimator;

/**
 * Created by anweshmishra on 25/04/17.
 */
public class AnimationHandler implements Animator.AnimatorListener,ValueAnimator.AnimatorUpdateListener {
    private CardToGridButton cardToGridButton;
    private ValueAnimator upAnim = ValueAnimator.ofFloat(0,1),downAnim = ValueAnimator.ofFloat(1,0);
    private int dir = 0;
    private CardNGridContainer cardNGridContainer;
    public AnimationHandler(CardToGridButton cardToGridButton,CardNGridContainer cardNGridContainer) {
        this.cardToGridButton = cardToGridButton;
        this.cardNGridContainer = cardNGridContainer;
        upAnim.setDuration(500);
        downAnim.setDuration(500);
        upAnim.addUpdateListener(this);
        upAnim.addListener(this);
        downAnim.addUpdateListener(this);
        downAnim.addListener(this);

    }
    public void start() {
        dir = dir == 1?-1:1;
        if(dir == -1) {
            downAnim.start();
        }
        if(dir == 1) {
            upAnim.start();
        }
    }
    public void onAnimationEnd(Animator animator) {

    }
    public void onAnimationRepeat(Animator animator) {

    }
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float factor = (float)valueAnimator.getAnimatedValue();
        cardToGridButton.update(factor);
        cardNGridContainer.updateX(factor);
    }
    public void onAnimationCancel(Animator animator) {

    }
    public void onAnimationStart(Animator animator) {

    }
}
