package com.amap.map3d.demo.amap_kotlin

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import com.amap.api.maps.AMap
import com.amap.api.maps.CameraUpdateFactory
import com.amap.api.maps.MapView
import com.amap.api.maps.model.*

class KotlinActivity : Activity() , AMap.OnMapLoadedListener{

    internal var BEIJING = LatLng(39.90403, 116.407525)
    internal var SHANGHAI = LatLng(31.238068, 121.501654)// 上海市经纬度
    internal var CHENGDU = LatLng(30.679879, 104.064855)// 成都市经纬度

    private var mapview:MapView? = null;
    private var amap: AMap? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mapview = MapView(this);
        mapview?.onCreate(savedInstanceState);
        setContentView(mapview);


        amap = mapview!!.getMap();
        amap!!.setOnMapLoadedListener(this);
    }


    override fun onResume() {
        super.onResume()
        mapview?.onResume();
    }


    override fun onPause() {
        super.onPause()
        mapview?.onResume();
    }


    override fun onDestroy() {
        super.onDestroy()
        mapview?.onDestroy();


    }


    /**
     * 地图加载完成时会回调
     */
    override fun onMapLoaded() {

        amap!!.moveCamera(CameraUpdateFactory.zoomTo(4f))

        addMarker();
        addPolyline();
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
}