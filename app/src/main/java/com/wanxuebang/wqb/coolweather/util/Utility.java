package com.wanxuebang.wqb.coolweather.util;

import android.text.TextUtils;

import com.wanxuebang.wqb.coolweather.model.City;
import com.wanxuebang.wqb.coolweather.model.CoolWeatherDB;
import com.wanxuebang.wqb.coolweather.model.Country;
import com.wanxuebang.wqb.coolweather.model.Province;

/**
 * Created by wanxuebang-ai-03 on 2018/1/9.
 */

public class Utility {

    public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB,String response){

        if (!TextUtils.isEmpty(response)){
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0){
                for (String p : allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceName(array[1]);
                    province.setProvinceCode(array[0]);
                    coolWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    public synchronized static boolean handleCitiesResponse (CoolWeatherDB coolWeatherDB,String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0){
                for (String p : allCities) {
                    String[] array = p.split("\\|");
                    City city = new City();
                    city.setProvinceId(provinceId);
                    city.setCityName(array[1]);
                    city.setCityCode(array[0]);
                    coolWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    public synchronized static boolean handleCountriesResponse (CoolWeatherDB coolWeatherDB,String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            String[] allCountries = response.split(",");
            if (allCountries != null && allCountries.length > 0){
                for (String p : allCountries) {
                    String[] array = p.split("\\|");
                    Country country = new Country();
                    country.setCityId(cityId);
                    country.setCountryName(array[1]);
                    country.setCountryCode(array[0]);
                    coolWeatherDB.saveCountry(country);
                }
                return true;
            }
        }
        return false;
    }
}


