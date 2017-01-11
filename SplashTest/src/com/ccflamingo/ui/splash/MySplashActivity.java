package com.ccflamingo.ui.splash;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.ccflamingo.ui.splash.WdSplashActivity;

/**
 * Created by Employee on 2015/12/22.
 */
public class MySplashActivity extends WdSplashActivity {
	@Override
	protected void onCreate(Bundle savedInstance) {
		super.setSplashNum(1);
		super.onCreate(savedInstance);
	}
	
    @Override
    public int getBackgroundColor() {
        //当闪屏PNG图片无法铺满部分机型的屏幕时，设置与闪屏颜色配合的背景色会给用户更好的体验
        return Color.WHITE;
    }

    @Override
    public void onSplashStop() {
        //闪屏结束后，启动游戏的Activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}

