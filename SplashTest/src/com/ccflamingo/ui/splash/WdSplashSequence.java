package com.ccflamingo.ui.splash;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

public class WdSplashSequence
{
  private List<WdImageSplash> list = new ArrayList();

  public void addSplash(WdImageSplash splash) {
    this.list.add(splash);
  }

  public void play(Activity context, WdSplashListener listener) {
    play(context, listener, 0);
  }

  private void play(final Activity context, final WdSplashListener listener, final int index) {
    if (index >= this.list.size())
      listener.onFinish();
    else
      ((WdImageSplash)this.list.get(index)).play(context, new WdSplashListener() {
        public void onFinish() {
          WdSplashSequence.this.play(context, listener, index + 1);
        }
      });
  }
}