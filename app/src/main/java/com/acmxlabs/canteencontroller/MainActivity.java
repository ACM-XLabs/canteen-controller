package com.acmxlabs.canteencontroller;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        //Create all three fragment objects
        GridFragment gridFragment = new GridFragment();
        SearchFragment searchFragment = new SearchFragment();
        TokenFragment tokenFragment = new TokenFragment();

        //create an instance of fragment manager
        FragmentManager manager=getSupportFragmentManager();

        //create an instance of Fragment-transaction
        FragmentTransaction transaction=manager.beginTransaction();

        transaction.add(R.id.My_Container_1_ID, gridFragment, "Frag_Grid_tag");
        transaction.add(R.id.My_Container_2_ID, searchFragment, "Frag_Search_tag");
        transaction.add(R.id.My_Container_3_ID, tokenFragment, "Frag_Token_tag");


        transaction.commit();
    }
}
