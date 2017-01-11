package com.ccflamingo.ui.splash;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.ccflamingo.ui.splash.ResUtils;
import com.ccflamingo.ui.splash.WdSplashListener;

public abstract class WdSplashActivity extends Activity
{
  private RelativeLayout layout;
  private ImageView imageView;
  private int mSplashNum = 0;
  private WdSplashSequence sequence = new WdSplashSequence();

  protected void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);

    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);

    this.layout = new RelativeLayout(this);
    this.layout.setBackgroundColor(getBackgroundColor());
    this.layout.setVisibility(4);

    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -1);

    this.imageView = new ImageView(this);
    this.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    RelativeLayout.LayoutParams imageViewParams = new RelativeLayout.LayoutParams(-1, -1);

    this.layout.addView(this.imageView, imageViewParams);
    
    int id = 0;
    String splash = "";
    
    for(int i = 0; i < mSplashNum; i++){
    	if (getResources().getConfiguration().orientation == 2)
    		splash = "splash_h"+i;
    	else if (getResources().getConfiguration().orientation == 1) {
    		splash = "splash_v"+i;
    	}
        id = ResUtils.drawable(this, splash);
        this.sequence.addSplash(new WdImageSplash(this.layout, this.imageView, id));
    }
    
    setContentView(this.layout, params);
  }
  
  protected void setSplashNum(int num)
  {
	  mSplashNum = num;  
  }

  protected void onResume() {
    super.onResume();
    this.sequence.play(this, new WdSplashListener() {
      public void onFinish() {
        WdSplashActivity.this.onSplashStop();
      }
    });
  }

  public abstract int getBackgroundColor();

  public abstract void onSplashStop();
}