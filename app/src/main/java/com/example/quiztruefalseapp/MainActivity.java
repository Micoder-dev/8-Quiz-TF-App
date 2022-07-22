package com.example.quiztruefalseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.quiztruefalseapp.controller.CardStackAdapter;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mRequestQueue;
    private String url;
    private CardStackView mCardStackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCardStackView = findViewById(R.id.myCardStackView);
        mCardStackView.setLayoutManager(new CardStackLayoutManager(this));

        ArrayList<String> testFilms = new ArrayList<>();
        testFilms.add("On The Floor");
        testFilms.add("Right Round");
        testFilms.add("Believer");
        testFilms.add("Shape Of You");
        testFilms.add("Beat It");

        mCardStackView.setAdapter(new CardStackAdapter(this, testFilms));

        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();
        url = "https://opentdb.com/api.php?amount=10&category=11&type=boolean";

        JsonObjectRequest filmsJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("FILMS", response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(filmsJsonObjectRequest);

    }
}