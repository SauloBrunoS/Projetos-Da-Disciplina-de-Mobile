package com.example.gamesnews.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

import com.example.gamesnews.model.NewsResult;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class NewsResponse {

    @SerializedName("news_results")
    @Expose
    private List<NewsResult> newsResults = new ArrayList<NewsResult>();

    public NewsResponse() {
    }

    public NewsResponse(List<NewsResult> newsResults) {
        super();
        this.newsResults = newsResults;
    }

    public List<NewsResult> getNewsResults() {
        return newsResults;
    }

    public void setNewsResults(List<NewsResult> newsResults) {
        this.newsResults = newsResults;
    }

}