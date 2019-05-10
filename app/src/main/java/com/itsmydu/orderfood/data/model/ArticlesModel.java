package com.itsmydu.orderfood.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class ArticlesModel {

    @SerializedName("source")
    @Expose
    private SourceModel sourceModel;

    @SerializedName("content")
    @Expose
    private String content;

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;


    public class SourceModel {
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("inamed")
        @Expose
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
