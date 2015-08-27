package db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import mode.County;
import mode.Province;
import mode.city;

public class WeatherDB {
	/*
	 * 数据库名
	 * */
public  static final String DB_NAME="weather_database";
public  static final int VERSION=1;
private static WeatherDB weatherDB;
private SQLiteDatabase db;
private WeatherDB(Context context){
	WeatherOpenHelper dbhelper=new WeatherOpenHelper(context,DB_NAME,null,VERSION) ;
	db=dbhelper.getWritableDatabase();
}

/*
 * get WeatherDB 实例
 * 
 * */
public synchronized WeatherDB getInstance(Context context){
	if(weatherDB ==null){
		weatherDB=new WeatherDB( context);
	}
	return weatherDB;
}
/*
 * 将province实例储存到数据库
 * */

public void saveProvince(Province province){
	if(province !=null){
		ContentValues contentValues=new ContentValues();
		contentValues.put("provinceName",province.getProvinceName());
		contentValues.put("provinceCode",province.getProvinceCode());
		db.insert("provice", null, contentValues);
	}
}

public List<Province> loadProvince(){
	List<Province> list =new ArrayList<Province>();
	Cursor cursor=db.query("provice", null, null, null, null, null, null);
	if(cursor.moveToFirst()){
		do {
			Province province=new Province();
			province.setId(cursor.getInt(cursor.getColumnIndex("id")));
			province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
			province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
			list.add(province);
		} while (cursor.moveToNext());
	}
		return list;
}

public void savecity(city city){
	if(city !=null){
		ContentValues contentValues=new ContentValues();
		contentValues.put("cityName",city.getCityName());
		contentValues.put("cityCode",city.getCityCode());
		contentValues.put("provinceId",city.getCityCode());
		db.insert("city", null, contentValues);
	}
}

public List<city> loadCity(){
	List<city> list =new ArrayList<city>();
	Cursor cursor=db.query("city", null, null, null, null, null, null);
	if(cursor.moveToFirst()){
		do {
			city city=new city();
			city.setId(cursor.getInt(cursor.getColumnIndex("id")));
			city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
			city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
			city.setProvinceId(cursor.getInt(cursor.getColumnIndex("province_id")));
			list.add(city);
		} while (cursor.moveToNext());
	}
		return list;
}


public void saveCounty(County county){
	if(county !=null){
		ContentValues contentValues=new ContentValues();
		contentValues.put("countyName",county.getCountyName());
		contentValues.put("countCode",county.getCountyCode());
		contentValues.put("cityId",county.getCityId());
		db.insert("county", null, contentValues);
	}
}

public List<County> loadCounty(){
	List<County> list =new ArrayList<County>();
	Cursor cursor=db.query("county", null, null, null, null, null, null);
	if(cursor.moveToFirst()){
		do {
			County county=new County();
			county.setId(cursor.getInt(cursor.getColumnIndex("id")));
			county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
			county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
			county.setCityId(cursor.getInt(cursor.getColumnIndex("city_id")));
			list.add(county);
		} while (cursor.moveToNext());
	}
		return list;
}
}
