package com.azens1995.localjsontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.transition.Explode;

import com.azens1995.localjsontest.databinding.ActivityDetailBinding;

import static com.azens1995.localjsontest.MainActivity.PERSON_DETAIL;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding detailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        PersonModel person = (PersonModel) getIntent().getSerializableExtra(PERSON_DETAIL);
        detailBinding.setPerson(person);

        /*getWindow().setSharedElementExitTransition(new Explode());*/

    }
}
