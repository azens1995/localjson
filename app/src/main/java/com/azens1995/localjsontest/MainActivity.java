package com.azens1995.localjsontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.azens1995.localjsontest.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String PERSON_DETAIL = "person_details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));


        Data studentData = new Gson().fromJson(readJSONFromAsset(), Data.class);
        mainBinding.recyclerview.setAdapter(new PersonAdapter(studentData.getPersonList(), (view, personModel) -> {
            Intent detailIntent = new Intent(getApplicationContext(), DetailActivity.class);
            detailIntent.putExtra(PERSON_DETAIL, personModel);
            View imageView = view.findViewById(R.id.imageView);
            View nameView = view.findViewById(R.id.textName);
            View emailView = view.findViewById(R.id.textEmail);
            Pair<View, String> pair = Pair.create(imageView, ViewCompat.getTransitionName(imageView));
            Pair<View, String> pair2 = Pair.create(nameView, ViewCompat.getTransitionName(nameView));
            Pair<View, String> pair3 = Pair.create(emailView, ViewCompat.getTransitionName(emailView));
            /*ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,
                    imageView,
                    ViewCompat.getTransitionName(imageView));*/
            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,pair, pair2, pair3);
            startActivity(detailIntent, activityOptionsCompat.toBundle());
        }));
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        //pagerSnapHelper.attachToRecyclerView(mainBinding.recyclerview);
        Log.d(TAG, "onCreate: " + studentData.toString());

    }


    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = null;
            try {
                is = getAssets().open("persondata.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
