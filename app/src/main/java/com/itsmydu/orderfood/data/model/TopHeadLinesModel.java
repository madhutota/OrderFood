package com.itsmydu.orderfood.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TopHeadLinesModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("totalResults")
    @Expose
    private String totalResults;
    @SerializedName("articles")
    @Expose
    private ArrayList<ArticlesModel> articlesModels;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<ArticlesModel> getArticlesModels() {
        return articlesModels;
    }

    public void setArticlesModels(ArrayList<ArticlesModel> articlesModels) {
        this.articlesModels = articlesModels;
    }
}
