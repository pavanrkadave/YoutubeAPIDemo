package com.example.android.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] videoNames = {
            "Google Pixel Promo",
            "Everything Apple Pro",
            "SuperSaf Tv ",
            "Notifications On Oreo",
            "Intro to Android THings",
    };

    private String[] VIDEO_ID = {
            "Rykmwn0SMWU",
            "BT4ig34Olo4",
            "P8OopBgony4",
            "zGIw4MIJn5o",
            "HxRv_w5DcxM",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.list_row,videoNames);

        ListView listView = (ListView) findViewById(R.id.video_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String tempVidId = "";
        tempVidId = VIDEO_ID[position];
        Intent intent = new Intent(MainActivity.this, YoutubeActivity.class);
        intent.putExtra(EXTRA_MESSAGE,tempVidId);
        startActivity(intent);
    }
}
