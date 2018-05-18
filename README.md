本工程为基于高德地图Android SDK进行封装，配合Kotlin实现展示地图效果。

## 前述 ##
- [高德官网申请Key](http://lbs.amap.com/dev/#/).
- 阅读[参考手册](http://a.amap.com/lbs/static/unzip/Android_Map_Doc/index.html).
- 工程基于Android 3D地图SDK实现

## 功能描述 ##
基于3D地图SDK进行封装，使用Kotlin代码实现了展示地图、添加Marker和绘制Polyline的例子。

## 使用方法 ##
### 配置Kotlin工程

- [Android Studio Kotlin官方文档](https://developer.android.com/kotlin/get-started).
- [Android Studio工程搭建方法](http://lbs.amap.com/api/android-sdk/guide/creat-project/android-studio-creat-project/#add-jars). 
- [通过maven库引入SDK方法](http://lbs.amap.com/api/android-sdk/guide/create-project/android-studio-create-project#gradle_sdk).

### 实现方法

```
 	/**
     * 添加线
     */
    private fun addPolyline() {

        amap!!.addPolyline(PolylineOptions().add(BEIJING,SHANGHAI,CHENGDU).color(Color.GREEN).width(20f).zIndex(1f))
    }

    /**
     * 添加Marker
     */
    private fun addMarker() {
        amap!!.addMarker( MarkerOptions().position(BEIJING).icon(BitmapDescriptorFactory.defaultMarker()))
        amap!!.addMarker( MarkerOptions().position(SHANGHAI).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))
        amap!!.addMarker( MarkerOptions().position(CHENGDU).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)))
    }
```

