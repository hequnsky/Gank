
--

#闲暇一款休闲视听的App

## 目录
1. [简介](#简介)
1. [截图](#截图)
1. [知识](#可以学到)
1. [依赖](#使用到的库)
1. [关于](#关于作者)

---

##简介
Gank是一个[MaterialDesign](http://www.google.com/design/spec/material-design/)风格和[MVP]模式的项目。你可以方便地阅读暴走日报，还可以浏览妹子图以及一起看LOL开黑视频。如果你在学习中遇到任何bug、疑问，请[提交一个issue](https://github.com/hequnsky/Gank/issues/new)）

##截图
![](/screenshot/screenshot_2016-08-06-16-45-24.png)
![](/screenshot/Screenshot_2016-08-06-16-44-12.png)
![](/screenshot/Screenshot_2016-08-06-16-44-56.png)
![](/screenshot/Screenshot_2016-08-06-16-45-40.png)
![](/screenshot/Screenshot_2016-08-06-16-47-09.png)
![](/screenshot/Screenshot_2016-08-06-16-47-33.png)
![](/screenshot/Screenshot_2016-08-06-16-47-41.png)

项目下载地址：http://fir.im/bqse

##可以学到：

- Android Design库的使用
- 自定义你的基类Activity
- 应用MVP模式到项目中
- Retrofit 的使用
- 自定义View基础
- 缓存管理控制
- 状态栏的显示和隐藏
- RxJava 的使用，包括配合 Retrofit、RxBus 的使用等
- RecycleView 的使用，下拉刷新，上拉到底自动加载等；
- vitamio播放视频和自定义控制器
- Activity滑动返回的实现
- Android 抓包及逆向分析

## 使用到的库

dependencies {

    compile project(':vitamio')
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile 'com.android.support:cardview-v7:23.4.0'
    compile 'com.android.support:appcompat-v7:24.0.0-beta1'
    compile 'com.jakewharton:butterknife:7.0.1'
    compile 'com.squareup.retrofit2:retrofit:2.0.2'
    compile 'com.squareup.okhttp3:logging-interceptor:3.1.2'
    compile 'com.squareup.retrofit2:converter-gson:2.0.2'
    compile 'com.squareup.retrofit2:adapter-rxjava:2.0.2'
    compile 'io.reactivex:rxandroid:1.1.0'
    compile 'io.reactivex:rxjava:1.1.0'
    compile 'com.android.support:design:23.4.0'
    compile 'com.github.bumptech.glide:glide:3.6.0'
    compile 'com.github.CymChad:BaseRecyclerViewAdapterHelper:v1.9.3'
    compile 'com.android.support.constraint:constraint-layout:1.0.0-alpha4'
    compile 'com.bm.photoview:library:1.4.0'
    testCompile 'junit:junit:4.12'
}

## TODO
- [ ] 日夜间模式切换
- [ ] 热修复

## 关于作者

QQ ：1363790125
邮箱：hequnsky@gmail.com




