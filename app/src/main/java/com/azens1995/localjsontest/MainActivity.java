package com.azens1995.localjsontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;

import android.os.Bundle;
import android.util.Log;

import com.azens1995.localjsontest.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        Data studentData = new Gson().fromJson(readJSONFromAsset(), Data.class);
        mainBinding.recyclerview.setAdapter(new PersonAdapter(studentData.getPersonList()));
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(mainBinding.recyclerview);
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
