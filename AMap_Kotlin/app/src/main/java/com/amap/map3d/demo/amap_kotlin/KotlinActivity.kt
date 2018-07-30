package com.amap.map3d.demo.amap_kotlin

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import com.amap.api.maps.AMap
import com.amap.api.maps.CameraUpdateFactory
import com.amap.api.maps.MapView
import com.amap.api.maps.model.*

class KotlinActivity : Activity() , AMap.OnMapLoadedListener {

    internal var BEIJING = LatLng(39.90403, 116.407525)
    internal var SHANGHAI = LatLng(31.238068, 121.501654)// 上海市经纬度
    internal var CHENGDU = LatLng(30.679879, 104.064855)// 成都市经纬度

    internal var CENTER_LAT = 39.90403
    internal var CENTER_LON = 116.407525
    internal var OFFSET_LAT = 0.1
    internal var OFFSET_LON = 0.105


    internal var latlng0 = LatLng(CENTER_LAT + OFFSET_LAT, CENTER_LON - OFFSET_LON)
    internal var latlng1 = LatLng(CENTER_LAT, CENTER_LON - OFFSET_LON)
    internal var latlng2 = LatLng(CENTER_LAT + OFFSET_LAT, CENTER_LON)
    internal var latlng3 = LatLng(CENTER_LAT - OFFSET_LAT, CENTER_LON - OFFSET_LON)
    internal var latlng4 = LatLng(CENTER_LAT + OFFSET_LAT, CENTER_LON + OFFSET_LON)
    internal var latlng5 = LatLng(CENTER_LAT, CENTER_LON)
    internal var latlng6 = LatLng(CENTER_LAT - OFFSET_LAT, CENTER_LON + OFFSET_LON)


    private var mapview: MapView? = null;
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


//        addMarker();
//        addPolyline();
//

        addPolygon();
    }

    /**
     * 添加面
     */
    private fun addPolygon() {


        amap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng5, 9.5f))

        amap!!.addPolygon(PolygonOptions().add(latlng0, latlng1, latlng2).fillColor(Color.rgb(0, 150, 210)).strokeWidth(0.0f).zIndex(1.0f))
        amap!!.addPolygon(PolygonOptions().add(latlng1, latlng2, latlng4, latlng3).fillColor(Color.rgb(243, 122, 68)).strokeWidth(0.0f).zIndex(1.0f))
        amap!!.addPolygon(PolygonOptions().add(latlng3, latlng5, latlng6).fillColor(Color.rgb(75, 125, 218)).strokeWidth(0.0f).zIndex(1.0f))
    }

    /**
     * 添加线
     */
    private fun addPolyline() {

        amap!!.addPolyline(PolylineOptions().add(BEIJING, SHANGHAI, CHENGDU).color(Color.GREEN).width(20f).zIndex(1f))
    }

    /**
     * 添加Marker
     */
    private fun addMarker() {
        amap!!.addMarker(MarkerOptions().position(BEIJING).icon(BitmapDescriptorFactory.defaultMarker()))
        amap!!.addMarker(MarkerOptions().position(SHANGHAI).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))
        amap!!.addMarker(MarkerOptions().position(CHENGDU).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)))
    }
}