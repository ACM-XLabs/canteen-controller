package com.acmxlabs.canteencontroller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements View.OnClickListener{

    String search_str;
    View view;
    Communicator comm_for_search;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        comm_for_search= (Communicator) getActivity();
         view=inflater.inflate(R.layout.fragment_search, container, false);

        //create references for all the buttons
        Button b1= (Button) view.findViewById(R.id.button1);
        Button b2= (Button) view.findViewById(R.id.button2);
        Button b3= (Button) view.findViewById(R.id.button3);
        Button b4= (Button) view.findViewById(R.id.button4);
        Button b5= (Button) view.findViewById(R.id.button5);
        Button b6= (Button) view.findViewById(R.id.button6);

        //set on click listeners for all the butttons
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        //get refernce of text view and extract text from it for searching
        TextView search_txt=(TextView) view.findViewById(R.id.search_number);
        search_str=(search_txt).getText().toString();

        //use switch case according to the view id of the button clicked
        switch (v.getId()) {
            case R.id.button1:

                //append '1' to search_str when button1 is clicked
                search_str=search_str+'1';

                //set the textView to the updated search_str
                search_txt.setText(search_str);
                break;
            case R.id.button2:
                search_str=search_str+'2';
                search_txt.setText(search_str);
                break;
            case R.id.button3:
                search_str=search_str+'3';
                search_txt.setText(search_str);
                break;
            case R.id.button4:
                search_str=search_str+'4';
                search_txt.setText(search_str);
                break;
            case R.id.button5:
                search_str=search_str+'5';
                search_txt.setText(search_str);
                break;
            case R.id.button6:

                //when the search string has only one char then replace it by null
                // or else decrease the length by one
                if(search_str.length()>1)
                    search_str = search_str.substring(0, search_str.length() - 1);
                else
                    search_str = "";

                search_txt.setText(search_str);
                break;
        }

        //trigger the search funtion of communicator with the search string obtained
        comm_for_search.search_fun(search_str);

    }
}

