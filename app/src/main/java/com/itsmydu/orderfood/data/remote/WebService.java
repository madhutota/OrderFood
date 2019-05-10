package com.itsmydu.orderfood.data.remote;


import com.google.gson.JsonElement;
import com.itsmydu.orderfood.data.model.Meals;
import com.itsmydu.orderfood.data.model.TopHeadLinesModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {

    @GET("latest.php")
    Observable<JsonElement> getMeal();

    @GET("categories.php")
    Observable<JsonElement> getCategories();

    @GET("filter.php")
    Observable<Meals>getMealsByCategory(@Query("c")String category);




    @GET(ApiEndPoint.TOP_HEAD_LINES)
    Observable<JsonElement> getTopHeadLines(@Query("country") String country, @Query("apiKey") String apiKey);

    @GET("top-headlines?country=in&apiKey=b1422282ee3f4716ba138edcf5523d68")
    Call<TopHeadLinesModel> getTopRatedHeadLinesNews();


}
