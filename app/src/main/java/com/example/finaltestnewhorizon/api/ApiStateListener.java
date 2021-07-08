package com.example.finaltestnewhorizon.api;

public interface ApiStateListener {

    void onSuccess(Object... params);

    void onFailure(Object... params);
}
