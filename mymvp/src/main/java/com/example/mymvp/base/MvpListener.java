package com.example.mymvp.base;

public interface MvpListener<T> {
    void onSuccess(T result);
    void onError(String errorMsg);
}