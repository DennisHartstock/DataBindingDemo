package com.example.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.databindingdemo.databinding.ActivityTwoWayBindingBinding;

public class TwoWayBindingActivity extends AppCompatActivity {

    private ActivityTwoWayBindingBinding activityTwoWayBindingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_way_binding);

        activityTwoWayBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_binding);
        activityTwoWayBindingBinding.setGreeting(getCurrentGreeting());
    }

    private Greeting getCurrentGreeting() {
        return new Greeting("Ivan", "Hello");
    }
}