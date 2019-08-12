package com.dtsl.swipe_cards_fragment_yuyakaido;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dtsl.swipe_cards_fragment_yuyakaido.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements SwipeFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        getSupportFragmentManager().beginTransaction().add(R.id.conatainer, new SwipeFragment()).commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent item) {

    }
}
