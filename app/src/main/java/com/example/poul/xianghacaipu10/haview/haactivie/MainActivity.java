package com.example.poul.xianghacaipu10.haview.haactivie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.poul.xianghacaipu10.R;
import com.example.poul.xianghacaipu10.ext.MyApp;
import com.example.poul.xianghacaipu10.haview.hafragment.HaBBS;
import com.example.poul.xianghacaipu10.haview.hafragment.LearnCook;
import com.example.poul.xianghacaipu10.haview.hafragment.HaMarket;
import com.example.poul.xianghacaipu10.haview.hafragment.HaMessage;
import com.example.poul.xianghacaipu10.haview.hafragment.HaMine;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyApp.context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_id, new LearnCook()).commit();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.learn_cook:
                fragment = new LearnCook();
                break;
            case R.id.market:
                fragment = new HaMarket();
                break;
            case R.id.bbs:
                fragment = new HaBBS();
                break;
            case R.id.message:
                fragment = new HaMessage();
                break;
            case R.id.mine:
                fragment = new HaMine();
                break;
        }
        change(fragment);
    }

    public void change(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_id, fragment).commit();
    }
}
