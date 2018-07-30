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

### 覆盖物实现方法

```
	/**
     * 添加面
     */
    private fun addPolygon() {


        amap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng5,9.5f))

        amap!!.addPolygon(PolygonOptions().add(latlng0,latlng1,latlng2).fillColor(Color.rgb(0,150,210)).strokeWidth(0.0f).zIndex(1.0f))
        amap!!.addPolygon(PolygonOptions().add(latlng1,latlng2,latlng4,latlng3).fillColor(Color.rgb(243,122,68)).strokeWidth(0.0f).zIndex(1.0f))
        amap!!.addPolygon(PolygonOptions().add(latlng3,latlng5,latlng6).fillColor(Color.rgb(75,125,218)).strokeWidth(0.0f).zIndex(1.0f))
    }
    
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


----

### Android Studio 使用 Kotlin 注意事项

#### Kotlin工程配置
1. 使用Android Studio打开工程
2. 选择Tools-Kotlin-Config Kotlin in Porject
3. build.gradle里会出现 apply plugin: 'kotlin-android' 和 compile "org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version"
4. 配置完成后便可正常使用


#### Java转Kotlin
1. 使用Android Studio打开工程
2. 选择对应.java 文件
3. 选择 Code-Convert Java File to Kotlin File

#### Kotlin工程引入地图SDK
1. Java工程引入SDK方式还可以继续使用
2. 在gradle中  implementation 'com.amap.api:3dmap:latest.integration' 或者放到libs目录下
3. JAVA引入包方式也可以直接使用 如引入MapView import com.amap.api.maps.MapView
	

<font color='red'>注：如有问题、请通过lbs.amap.com找到我们</font>
