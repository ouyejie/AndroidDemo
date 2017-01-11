package com.ccflamingo.ui.splash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public final class ResUtils
{
  public static int id(Context paramContext, String paramString)
  {
    return a(paramContext, "id", paramString);
  }

  public static int string(Context paramContext, String paramString) {
    return a(paramContext, "string", paramString);
  }

  public static int layout(Context paramContext, String paramString) {
    return a(paramContext, "layout", paramString);
  }

  public static int style(Context paramContext, String paramString) {
    return a(paramContext, "style", paramString);
  }

  public static int drawable(Context paramContext, String paramString) {
    return a(paramContext, "drawable", paramString);
  }

  public static int color(Context paramContext, String paramString) {
    return a(paramContext, "color", paramString);
  }

  public static int anim(Context paramContext, String paramString) {
    return a(paramContext, "anim", paramString);
  }

  public static int array(Context paramContext, String paramString) {
    return a(paramContext, "array", paramString);
  }

  public static int attr(Context paramContext, String paramString) {
    return a(paramContext, "attrs", paramString);
  }

  public static int dimen(Context paramContext, String paramString)
  {
    return a(paramContext, "dimen", paramString);
  }

  public static int xml(Context paramContext, String paramString) {
    return a(paramContext, "xml", paramString);
  }

  public static String getString(Context paramContext, String paramString) {
    return paramContext.getResources().getString(string(paramContext, paramString));
  }

  public static int getColor(Context paramContext, String paramString) {
    Log.d("aaa", "name is " + paramString + "+++ color id is " + color(paramContext, paramString));
    return paramContext.getResources().getColor(color(paramContext, paramString));
  }

  public static Drawable getDrawable(Context paramContext, String paramString) {
    return paramContext.getResources().getDrawable(drawable(paramContext, paramString));
  }

  public static String[] getStringArray(Context paramContext, String paramString) {
    return paramContext.getResources().getStringArray(array(paramContext, paramString));
  }

  public static int[] getIntArrays(Context paramContext, String paramString) {
    return paramContext.getResources().getIntArray(attr(paramContext, paramString));
  }

  public static float getDimension(Context paramContext, String paramString) {
    return paramContext.getResources().getDimension(dimen(paramContext, paramString));
  }

  public static Animation getAnimation(Context paramContext, String paramString) {
    return AnimationUtils.loadAnimation(paramContext, anim(paramContext, paramString));
  }

  private static int a(Context paramContext, String paramString1, String paramString2) {
    if (paramContext == null) {
      throw new NullPointerException("the context is null");
    }
    if ((paramString1 == null) || (paramString1.trim().length() == 0)) {
      throw new NullPointerException("the type is null or empty");
    }
    if ((paramString2 == null) || (paramString2.trim().length() == 0)) {
      throw new NullPointerException("the attrNme is null or empty");
    }
    Resources localResources = paramContext.getResources();

    String str = paramContext.getPackageName();
    return localResources.getIdentifier(paramString2, paramString1, str);
  }
}