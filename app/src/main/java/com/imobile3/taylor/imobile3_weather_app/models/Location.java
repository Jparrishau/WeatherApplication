package com.imobile3.taylor.imobile3_weather_app.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * An object model containing relevant location data used to search for weather data.
 *
 * @author Taylor Parrish
 * @since 8/27/2016
 */
public class Location implements Parcelable {
    private String mLatitude;
    private String mLongitude;
    private String mCoordinates;
    private String mCity;
    private String mState;
    private String mFormatted_address;

    //Convert this to hash table where keys are the dates?
    private ArrayList<Day> mDays = new ArrayList<>();

    private CurrentWeatherForecast mCurrentWeatherForecast;

    public Location(String latitude, String longitude,
                    String formatted_address) {
        setLatitude(latitude);
        setLatitude(longitude);
        setFormatted_address(formatted_address);
        setCoordinates(latitude + "," + longitude);
    }

    public Location(String latitude, String longitude,
                    String city, String state,
                    String formatted_address) {
        setLatitude(latitude);
        setLongitude(longitude);
        setFormatted_address(formatted_address);
        setCoordinates(latitude + "," + longitude);
        setCity(city);
        setState(state);
    }

    public CurrentWeatherForecast getCurrentWeatherForecast() {
        return mCurrentWeatherForecast;
    }

    public void setCurrentWeatherForecast(CurrentWeatherForecast currentWeatherForecast) {
        this.mCurrentWeatherForecast = currentWeatherForecast;
    }

    public String getCoordinates() {
        return mCoordinates;
    }

    public void setCoordinates(String coordinates) {
        this.mCoordinates = coordinates;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String mLatitude) {
        this.mLatitude = mLatitude;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public void setLongitude(String longitude) {
        this.mLongitude = longitude;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        this.mCity = city;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        this.mState = state;
    }

    public String getFormatted_address() {
        return mFormatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.mFormatted_address = formatted_address;
    }
    public void setDays(ArrayList<Day> days){
        mDays = days;
    }

    public Day getDay(int index){
        return mDays.get(index);
    }

    public ArrayList<Day> getDays(){
        return mDays;
    }

    /*
       End Make Parcelable
    */

    @Override
    public String toString() {
        return "Location{" +
                ", Latitude='" + getLatitude() + '\'' +
                ", Longitude='" + getLongitude() + '\'' +
                ", Coordinates='" + getCoordinates() + '\'' +
                 ", Address='" + getFormatted_address() + '\'' +
                ", City=" + getCity() + '\'' +
                ", State='" + getState() +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mLatitude);
        dest.writeString(this.mLongitude);
        dest.writeString(this.mCoordinates);
        dest.writeString(this.mCity);
        dest.writeString(this.mState);
        dest.writeString(this.mFormatted_address);
        dest.writeTypedList(this.mDays);
        dest.writeParcelable(this.mCurrentWeatherForecast, flags);
    }

    protected Location(Parcel in) {
        this.mLatitude = in.readString();
        this.mLongitude = in.readString();
        this.mCoordinates = in.readString();
        this.mCity = in.readString();
        this.mState = in.readString();
        this.mFormatted_address = in.readString();
        this.mDays = in.createTypedArrayList(Day.CREATOR);
        this.mCurrentWeatherForecast = in.readParcelable(CurrentWeatherForecast.class.getClassLoader());
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
}
