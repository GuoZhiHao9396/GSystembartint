# GSystembartint
# 沉浸式状态栏

![image](https://github.com/GuoZhiHao9396/GSystembartint/blob/master/app/src/main/res/raw/test.png)

AndroidStudio使用Gradle构建添加依赖（推荐）

Add it in your root build.gradle at the end of repositories:
```java
    repositories {
        flatDir {
            dirs 'libs'
        }
    }

    dependencies {
         compile (name:'gsystembartintlibrary-v1.0.0',ext:'aar')
    }
```

# 属性介绍

```text
      setStatusBarTintEnabled：是否启动状态栏
      setNavigationBarTintEnabled：是否启用导航栏

      setTintColor：设置状态栏和导航栏的颜色
      setTintAlpha：设置状态栏和导航栏的透明度（范围：0-1f）
      setTintDrawable：设置状态栏和导航栏的Drawable
      setTintResource：设置状态栏和导航栏的Resource

      setStatusBarTintColor：设置状态栏的颜色
      setStatusBarAlpha：设置状态栏的透明度（范围：0-1f）
      setStatusBarTintDrawable：设置状态栏的Drawable
      setStatusBarTintResource：设置状态栏的Resource

      setNavigationBarTintColor：设置导航栏的颜色
      setNavigationBarAlpha：设置导航栏的透明度（范围：0-1f）
      setNavigationBarTintDrawable：设置导航栏的Drawable
      setNavigationBarTintResource：设置导航栏的Resource

```

# 使用介绍

1.使用方法
```java
      //只有大于等于4.4版本支持这个半透明状态栏的效果
      protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_main);
             //判断当前手机的系统版本是否大于19
             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                 setTranslucentStatus(true);
             }
             //实例化对象
             mTintManager = new SystemBarTintManager(this);
             //是否启用状态栏设置
             mTintManager.setStatusBarTintEnabled(true);
             //设置状态栏颜色
             mTintManager.setStatusBarTintColor(Color.parseColor("#FF00FF"));
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
```
2.配置布局

xml
```text
   1、在根布局中设置如下，防止布局上移

   android:fitsSystemWindows="true" 设置状态栏的高度自适应

   2、在res文件下新建values-v14和values-v19文件夹，然后添加stayles.xml设置属性

   v14：
      <style name="FullBleedTheme" parent="android:Theme.Holo.Light.NoActionBar">
           <!-- API 14 theme customizations can go here. -->
       </style>
   v19：
      <style name="FullBleedTheme" parent="android:Theme.Holo.Light.NoActionBar.TranslucentDecor">
           <!-- API 19 theme customizations can go here. -->
       </style>
```


# License
```text
Copyright 2017 ZhiHao Guo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
