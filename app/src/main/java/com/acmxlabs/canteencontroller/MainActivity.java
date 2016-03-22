package com.acmxlabs.canteencontroller;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
import android.util.Log;
=======
>>>>>>> 23d438086ee520cc3c78e5082288817c5354be52
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements Communicator {

    GridFragment gridFragment;
    TokenFragment tokenFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        //Create all three fragment objects
         gridFragment = new GridFragment();
        SearchFragment searchFragment = new SearchFragment();
         tokenFragment = new TokenFragment();

        //create an instance of fragment manager
        FragmentManager manager=getSupportFragmentManager();

        //create an instance of Fragment-transaction
        FragmentTransaction transaction=manager.beginTransaction();

        transaction.add(R.id.My_Container_1_ID, gridFragment, "Frag_Grid_tag");
        transaction.add(R.id.My_Container_2_ID, searchFragment, "Frag_Search_tag");
        transaction.add(R.id.My_Container_3_ID, tokenFragment, "Frag_Token_tag");


        transaction.commit();


    }

    @Override
    public void respond(View v) {
<<<<<<< HEAD
        Log.v("buck", "entered respond fun");
        TextView txt_view= (TextView) v.findViewById(R.id.info_text);
        String txt=  txt_view.getText().toString();
        Log.v("buck", txt);

=======
        //extracting text from the view attribute
        TextView txt_view= (TextView) v.findViewById(R.id.grid_card_text);
        String txt=  txt_view.getText().toString();

        //calling 'change function' in token fragment with text as argument
>>>>>>> 23d438086ee520cc3c78e5082288817c5354be52
        tokenFragment.change(txt);
    }
}
