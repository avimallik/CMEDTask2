package com.cmed.task2;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    TextView detailActorName, detailArtistName, detailGender;
    ImageView detailimg;
    String imgUrlIntentToken = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Image URL Intent Token
        imgUrlIntentToken = getIntent().getExtras().getString("intent_artistImage");

        detailActorName = (TextView) findViewById(R.id.detailActorName);
        detailArtistName = (TextView) findViewById(R.id.detailArtistName);
        detailimg = (ImageView) findViewById(R.id.detailimg);
        detailGender = (TextView) findViewById(R.id.detailGender);

        detailArtistName.setText(getIntent().getExtras().getString("intent_artistName"));
        detailActorName.setText(getIntent().getExtras().getString("intent_name"));
        detailGender.setText(getIntent().getExtras().getString("intent_artistGender"));

        Glide.with(detailimg.getContext()).load(imgUrlIntentToken).apply(RequestOptions.circleCropTransform()
                .placeholder(R.drawable.error)
                .error(R.drawable.error)
                .override(400, 200)).into(detailimg);

    }
}