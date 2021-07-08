package com.example.finaltestnewhorizon.model.home.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageResponse {
    @SerializedName("medium")
    @Expose
    private String medium;
    @SerializedName("original")
    @Expose
    private String original;

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
}
