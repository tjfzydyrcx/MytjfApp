package com.example.mymvp.network;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.mymvp.app.MyApp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019-01-06 0006.
 */

public class RequestManager {

    private RequestQueue queue;

    private static volatile RequestManager instance;

    private RequestManager() {
        queue = Volley.newRequestQueue(MyApp.getInstance());

    }

    public static RequestManager getInstance() {
        if (instance == null) {
            synchronized (RequestManager.class) {
                if (instance == null) {
                    instance = new RequestManager();
                }
            }
        }

        return instance;
    }

    public RequestQueue getRequestQueue() {
        return queue;
    }

    public <T> void sendGet(String url, Class<T> clazz, final MyListener myListener) {
        MyRequest<T> request = new MyRequest<T>(url, clazz, new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                myListener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myListener.onError(error.getMessage());
            }
        });
        addToRequestQueue(request);

    }

    public <T> void sendPost(String url, Class<T> clazz, final HashMap<String, String> map, final MyListener myListener) {
        MyRequest<T> request = new MyRequest<T>(url, clazz, new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                myListener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myListener.onError(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };

        addToRequestQueue(request);

    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
