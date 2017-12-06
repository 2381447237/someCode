package com.example.testcustomview2017_4_17;


import android.content.Context;
import android.util.TypedValue;

/**
 * 用于px�?  dp，sp的转换工�?
 * Created by Administrator on 2015/12/16.
 */
public class PxUtils {

    public static int dpToPx(int dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static int spToPx(int sp,Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }


}
