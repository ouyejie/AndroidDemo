package com.ccflamingo.ui.splash;

import android.app.Activity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.ccflamingo.ui.splash.L;
import com.ccflamingo.ui.splash.WdSplashListener;

public class WdImageSplash
{
  private View layout;
  private ImageView imageView;
  private int resourceId;
  private long mStartOffset = 1500L;
  private long mDuration 	= 1000L;

  public WdImageSplash(View layout, ImageView imageView, int id)
  {
    this.layout = layout;
    this.imageView = imageView;
    this.resourceId = id;
  }

  public void loadImage(Activity paramActivity, ImageView paramImageView, LoadSplashCallback paramLoadSplashCallback)
  {
    paramImageView.setImageResource(this.resourceId);
    paramLoadSplashCallback.onLoadSuccess();
  }

  public void play(final Activity context, final WdSplashListener listener) {
    loadImage(context, this.imageView, new LoadSplashCallback() {
      public void onLoadSuccess() {
        WdImageSplash.this.playSplash(context, listener);
      }

      public void onLoadFailed() {
        listener.onFinish();
      }
    });
  }

  public void playSplash(Activity context, final WdSplashListener listener) {
    Animation animation = getAnimation();
    animation.setAnimationListener(new Animation.AnimationListener() {
      public void onAnimationStart(Animation paramAnimation) {
        L.d("animation start");
      }

      public void onAnimationRepeat(Animation paramAnimation) {
        L.d("animation repeat");
      }

      public void onAnimationEnd(Animation paramAnimation) {
        L.d("animation end");
        WdImageSplash.this.layout.setVisibility(4);
        listener.onFinish();
      }
    });
    L.d("start animat ion");
    this.layout.startAnimation(animation);
    this.layout.setVisibility(0);
  }

  private Animation getAnimation() {
    Animation fadeIn = new AlphaAnimation(0.0F, 1.0F);
    fadeIn.setInterpolator(new DecelerateInterpolator());
    fadeIn.setDuration(1000L);

    Animation fadeOut = new AlphaAnimation(1.0F, 0.0F);
    fadeOut.setInterpolator(new AccelerateInterpolator());
    fadeOut.setStartOffset(mStartOffset);
    fadeOut.setDuration(mDuration);

    AnimationSet animation = new AnimationSet(false);
    animation.addAnimation(fadeIn);
    animation.addAnimation(fadeOut);

    return animation;
  }

  public static abstract interface LoadSplashCallback
  {
    public abstract void onLoadSuccess();

    public abstract void onLoadFailed();
  }
}