package com.gzh.gsystembartint;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.gzh.systembartintlibrary.SystemBarTintManager;

public class MainActivity extends Activity {

    private SystemBarTintManager mTintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //判断当前手机的系统版本是否大于19
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        mTintManager = new SystemBarTintManager(this);//实例化对象
        mTintManager.setStatusBarTintEnabled(true);//是否启用状态栏设置
        mTintManager.setNavigationBarTintEnabled(true);//是否启用导航栏设置
        mTintManager.setTintColor(Color.parseColor("#FF0000"));//设置颜色
    }

    /**
     * 状态栏
     *
     * @param view
     */
    public void statusBarOnClick(View view) {
        mTintManager.setStatusBarTintColor(Color.parseColor("#FF00FF"));//设置颜色
    }

    /**
     * 导航栏
     *
     * @param view
     */
    public void navigationBarOnClick(View view) {
        mTintManager.setNavigationBarTintColor(Color.parseColor("#FF00FF"));//设置颜色
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
