/*
According to apache license

This is fork of christocracy cordova-plugin-background-geolocation plugin
https://github.com/christocracy/cordova-plugin-background-geolocation

This is a new class
*/

package com.marianhello.cordova.bgloc;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Config class
 */
public class Config implements Parcelable
{
    private float stationaryRadius = 50;
    private Integer distanceFilter = 500;
    private Integer desiredAccuracy = 100;
    private Boolean debugging = false;
    private String notificationTitle = "Background tracking";
    private String notificationText = "ENABLED";
    private String notificationIconLarge;
    private String notificationIconSmall;
    private String notificationIconColor;
    private ServiceProviderEnum serviceProvider = ServiceProviderEnum.ANDROID_DISTANCE_FILTER;
    private Integer interval = 600000; //milliseconds
    private Integer fastestInterval = 120000; //milliseconds
    private Integer activitiesInterval = 1000; //milliseconds
    private Boolean stopOnTerminate = false;
    private Boolean startOnBoot = false;
    private Boolean startForeground = true;
    private String url = null;
    private String method = null;
    private HashMap<String, String> headers = null;
    private HashMap<String, String> params = null;

    public int describeContents() {
        return 0;
    }

    // write your object's data to the passed-in Parcel
    public void writeToParcel(Parcel out, int flags) {
        out.writeFloat(getStationaryRadius());
        out.writeInt(getDistanceFilter());
        out.writeInt(getDesiredAccuracy());
        out.writeValue(isDebugging());
        out.writeString(getNotificationTitle());
        out.writeString(getNotificationText());
        out.writeString(getLargeNotificationIcon());
        out.writeString(getSmallNotificationIcon());
        out.writeString(getNotificationIconColor());
        out.writeValue(getStopOnTerminate());
        out.writeValue(getStartOnBoot());
        out.writeValue(getStartForeground());
        out.writeInt(getServiceProvider().asInt());
        out.writeInt(getInterval());
        out.writeInt(getFastestInterval());
        out.writeInt(getActivitiesInterval());
        out.writeString(getUrl());
        out.writeString(getMethod());
        out.writeSerializable(getHeaders());
        out.writeSerializable(getParams());
    }

    public static final Parcelable.Creator<Config> CREATOR
            = new Parcelable.Creator<Config>() {
        public Config createFromParcel(Parcel in) {
            return new Config(in);
        }

        public Config[] newArray(int size) {
            return new Config[size];
        }
    };

    public Config () {

    }

    private Config(Parcel in) {
        setStationaryRadius(in.readFloat());
        setDistanceFilter(in.readInt());
        setDesiredAccuracy(in.readInt());
        setDebugging((Boolean) in.readValue(null));
        setNotificationTitle(in.readString());
        setNotificationText(in.readString());
        setLargeNotificationIcon(in.readString());
        setSmallNotificationIcon(in.readString());
        setNotificationIconColor(in.readString());
        setStopOnTerminate((Boolean) in.readValue(null));
        setStartOnBoot((Boolean) in.readValue(null));
        setStartForeground((Boolean) in.readValue(null));
        setServiceProvider(in.readInt());
        setInterval(in.readInt());
        setFastestInterval(in.readInt());
        setActivitiesInterval(in.readInt());
        setUrl(in.readString());
        setMethod(in.readString());
        setHeaders((HashMap<String, String>) in.readSerializable());
        setParams((HashMap<String, String>)in.readSerializable());
    }

    public float getStationaryRadius() {
        return stationaryRadius;
    }

    public void setStationaryRadius(float stationaryRadius) {
        this.stationaryRadius = stationaryRadius;
    }

    public Integer getDesiredAccuracy() {
        return desiredAccuracy;
    }

    public void setDesiredAccuracy(Integer desiredAccuracy) {
        this.desiredAccuracy = desiredAccuracy;
    }

    public Integer getDistanceFilter() {
        return distanceFilter;
    }

    public void setDistanceFilter(Integer distanceFilter) {
        this.distanceFilter = distanceFilter;
    }

    public Boolean isDebugging() {
        return debugging;
    }

    public void setDebugging(Boolean debugging) {
        this.debugging = debugging;
    }

    public String getNotificationIconColor() {
        return notificationIconColor;
    }

    public void setNotificationIconColor(String notificationIconColor) {
        if (!"null".equals(notificationIconColor)) {
            this.notificationIconColor = notificationIconColor;
        }
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public String getLargeNotificationIcon () {
        return notificationIconLarge;
    }

    public void setLargeNotificationIcon (String icon) {
        this.notificationIconLarge = icon;
    }

    public String getSmallNotificationIcon () {
        return notificationIconSmall;
    }

    public void setSmallNotificationIcon (String icon) {
        this.notificationIconSmall = icon;
    }

    public Boolean getStopOnTerminate() {
        return stopOnTerminate;
    }

    public void setStopOnTerminate(Boolean stopOnTerminate) {
        this.stopOnTerminate = stopOnTerminate;
    }

    public Boolean getStartOnBoot() {
        return startOnBoot;
    }

    public void setStartOnBoot(Boolean startOnBoot) {
        this.startOnBoot = startOnBoot;
    }

    public Boolean getStartForeground() {
        return this.startForeground;
    }

    public void setStartForeground(Boolean startForeground) {
        this.startForeground = startForeground;
    }

    public ServiceProviderEnum getServiceProvider() {
        return this.serviceProvider;
    }

    public void setServiceProvider(Integer providerId) {
        this.serviceProvider = ServiceProviderEnum.forInt(providerId);
    }

    public void setServiceProvider(ServiceProviderEnum provider) {
        this.serviceProvider = provider;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getFastestInterval() {
        return fastestInterval;
    }

    public void setFastestInterval(Integer fastestInterval) {
        this.fastestInterval = fastestInterval;
    }

    public Integer getActivitiesInterval() {
        return activitiesInterval;
    }

    public void setActivitiesInterval(Integer activitiesInterval) {
        this.activitiesInterval = activitiesInterval;
    }

    public String getUrl(){
        return url;
    }
    public String getMethod(){
        return method;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public void setMethod(String method){
        this.method = method;
    }
    public void setHeaders(String jsonString){
        try {
            JSONObject obj = new JSONObject(jsonString);
            setHeaders(obj);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void setHeaders(HashMap<String, String> headers){
        this.headers = headers;
    }
    public void setParams(String jsonString){
        try {
            JSONObject obj = new JSONObject(jsonString);
            setParams(obj);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void setParams(HashMap<String, String> params){
        this.params = params;
    }
    public void setHeaders(JSONObject headersObj){
        Iterator<String> iterator = headersObj.keys();
        headers = new HashMap<String, String>();
        while(iterator.hasNext()){
            try {
                String key = iterator.next();
                String val = headersObj.getString(key);
                headers.put(key, val);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public String getHeadersJsonString(){
        JSONObject jsonObj = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                jsonObj.put(entry.getKey(), entry.getValue());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return jsonObj.toString();
    }
    public HashMap<String, String> getHeaders(){
        return headers;
    }
    public void setParams(JSONObject headersObj){
        Iterator<String> iterator = headersObj.keys();
        params = new HashMap<String, String>();
        while(iterator.hasNext()){
            try {
                String key = iterator.next();
                String val = headersObj.getString(key);
                params.put(key, val);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public HashMap<String, String> getParams(){
        return params;
    }
    public String getParamsJsonString(){
        JSONObject jsonObj = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                jsonObj.put(entry.getKey(), entry.getValue());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return jsonObj.toString();
    }
    @Override
    public String toString () {
        return new StringBuffer()
                .append("stationaryRadius: "       + getStationaryRadius())
                .append(" desiredAccuracy: " + getDesiredAccuracy())
                .append(" distanceFilter: "        + getDistanceFilter())
                .append(" debugging: "             + isDebugging())
                .append(" notificationTitle: "     + getNotificationTitle())
                .append(" notificationText: "      + getNotificationText())
                .append(" notificationIconLarge: " + getLargeNotificationIcon())
                .append(" notificationIconSmall: " + getSmallNotificationIcon())
                .append(" notificationIconColor: " + getNotificationIconColor())
                .append(" stopOnTerminate: "       + getStopOnTerminate())
                .append(" startOnBoot: "           + getStartOnBoot())
                .append(" startForeground: "       + getStartForeground())
                .append(" serviceProvider: "       + getServiceProvider())
                .append(" interval: "              + getInterval())
                .append(" fastestInterval: "       + getFastestInterval())
                .append(" activitiesInterval: "    + getActivitiesInterval())
                .append(" url: " + getUrl())
                .append(" method: " + getMethod())
                .append(" headers: " + getHeaders())
                .append(" params: " + getParams())
                .toString();
    }

    public Parcel toParcel () {
        Parcel parcel = Parcel.obtain();
        this.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        return parcel;
    }

    public static Config fromByteArray (byte[] byteArray) {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(byteArray, 0, byteArray.length);
        parcel.setDataPosition(0);
        return Config.CREATOR.createFromParcel(parcel);
    }

    public static Config fromJSONArray (JSONArray data) throws JSONException {
        JSONObject jObject = data.getJSONObject(0);
        Config config = new Config();
        config.setStationaryRadius((float) jObject.optDouble("stationaryRadius", config.getStationaryRadius()));
        config.setDistanceFilter(jObject.optInt("distanceFilter", config.getDistanceFilter()));
        config.setDesiredAccuracy(jObject.optInt("desiredAccuracy", config.getDesiredAccuracy()));
        config.setDebugging(jObject.optBoolean("debug", config.isDebugging()));
        config.setNotificationTitle(jObject.optString("notificationTitle", config.getNotificationTitle()));
        config.setNotificationText(jObject.optString("notificationText", config.getNotificationText()));
        config.setStopOnTerminate(jObject.optBoolean("stopOnTerminate", config.getStopOnTerminate()));
        config.setStartOnBoot(jObject.optBoolean("startOnBoot", config.getStartOnBoot()));
        config.setServiceProvider(jObject.optInt("locationService", config.getServiceProvider().asInt()));
        config.setInterval(jObject.optInt("interval", config.getInterval()));
        config.setFastestInterval(jObject.optInt("fastestInterval", config.getFastestInterval()));
        config.setActivitiesInterval(jObject.optInt("activitiesInterval", config.getActivitiesInterval()));
        config.setNotificationIconColor(jObject.optString("notificationIconColor", config.getNotificationIconColor()));
        config.setLargeNotificationIcon(jObject.optString("notificationIconLarge", config.getLargeNotificationIcon()));
        config.setSmallNotificationIcon(jObject.optString("notificationIconSmall", config.getSmallNotificationIcon()));
        config.setStartForeground(jObject.optBoolean("startForeground", config.getStartForeground()));
        config.setUrl(jObject.optString("url", config.getUrl()));
        config.setMethod(jObject.optString("method", config.getMethod()));
        config.setHeaders(jObject.optJSONObject("headers"));
        config.setParams(jObject.optJSONObject("params"));
        return config;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("stationaryRadius", getStationaryRadius());
        json.put("distanceFilter", getDistanceFilter());
        json.put("desiredAccuracy", getDesiredAccuracy());
        json.put("debugging", isDebugging());
        json.put("notificationTitle", getNotificationTitle());
        json.put("notificationText", getNotificationText());
        json.put("notificationIconLarge", getLargeNotificationIcon());
        json.put("notificationIconSmall", getSmallNotificationIcon());
        json.put("notificationIconColor", getNotificationIconColor());
        json.put("stopOnTerminate", getStopOnTerminate());
        json.put("startOnBoot", getStartOnBoot());
        json.put("startForeground", getStartForeground());
        json.put("serviceProvider", getServiceProvider());
        json.put("interval", getInterval());
        json.put("fastestInterval", getFastestInterval());
        json.put("activitiesInterval", getActivitiesInterval());
        json.put("url", getUrl());
        json.put("method", getMethod());
        json.put("headers", getHeaders());
        json.put("params", getParams());
        return json;
  	}
}
