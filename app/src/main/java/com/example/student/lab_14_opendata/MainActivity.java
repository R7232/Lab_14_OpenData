package com.example.student.lab_14_opendata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.student.lab_14_opendata.utl.TaipeiOpenDataUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TaipeiOpenDataUtil.loadTapipeiAttractions();
    }
}
