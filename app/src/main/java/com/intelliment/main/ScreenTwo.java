package com.intelliment.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ScreenTwo extends AppCompatActivity {
    private final static String TAG = ScreenTwo.class.getSimpleName();
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_two);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        getdata();
    }


    private void init(){

    }

    private void getdata(){
        String url = "http://express-it.optusnet.com.au/sample.json";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
//                            JSONArray jsonArray = response.toJSONArray();
                            response.toString();
                            setData(response);

                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG,"Request Error"+error.getStackTrace());

                    }
                }
        );


        queue.add(jsonObjectRequest);
    }

    private void setData(JSONObject response){

    }

    @Override
    protected void onStop() {
                            super.onStop();
        queue.cancelAll(this);
    }
}
