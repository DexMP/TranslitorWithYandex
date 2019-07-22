package com.illadium.mikry_13.retrofit_example;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YandexTranslateInterface {
    final String key = "trnsl.1.1.20190504T104105Z.7f02701e95c8d1ce.21b718238438db3489a22d6f0f304794e2841ca4";

    @GET("/api/v1.5/tr.json/translate?key=" + key)
    Call<YaTranslate> translation(@Query("text") String text, @Query("lang") String translate_dir);
}