package com.acmxlabs.canteencontroller;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GridFragment extends Fragment {


    //initialise a dummy string array
    String[] txt = {"AAAA", "BBBB", "CCCC", "DDDDD", "EEEE", "FFFFF", "GGGG"};

    //convert string array to arraylist
    List<String> list = new ArrayList<String>(Arrays.asList(txt));
    GridView grid;

    //define a communicator object for communication between fragments
    Communicator comm;

    public GridFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid, container, false);


        //initialising the comm object
        comm = (Communicator) getActivity();

        //get the grid view
        grid = (GridView) view.findViewById(R.id.gridView);

        //create a new adapter_grid_fragment
        adapter_grid_fragment adp = new adapter_grid_fragment(this.getActivity(), list, comm);

        //set adapter_grid_fragment to the grid layout
        grid.setAdapter(adp);
        grid.setDrawSelectorOnTop(true);

        return view;

    }
}

    class adapter_grid_fragment extends BaseAdapter {

        List<String> list;
        Context c;
        Communicator comm;


        //define a constructor for adapter_grid_fragment class
        adapter_grid_fragment(Context c, List<String> list, Communicator comm) {
            this.list = list;
            this.c = c;
            this.comm=comm;
        }

        //returns number of items in the list to display
        @Override
        public int getCount() {
            return list.size();
        }

        //returns the object at a given position
        @Override
        public Object getItem(int position) {
            return list.get(position);
        }


        //returns a id for every object which is index of arraylist in our case
        @Override
        public long getItemId(int position) {
            return position;
        }


        //extracts Textview for given view and sets onClick function
        class viewHolder implements View.OnClickListener {
            TextView txt_view;


            viewHolder(View v) {


                txt_view = (TextView) v.findViewById(R.id.grid_card_text);

                //set onclick listener for the view v
                v.setOnClickListener(this);
                txt_view.setOnClickListener(this);
            }


            //
            @Override
            public void onClick(View v) {
                //triggers respond function when clicked
                comm.respond(v);
            }
        }

        //returns a view that should be displayed
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            viewHolder holder = null;

            if (row == null) {

                //enters if row is being created for the first time

                LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                //convert layout xml file to a java object
                row = inflater.inflate(R.layout.grid_detail_view, parent, false);

                //create a viewholder object
                holder = new viewHolder(row);
                row.setTag(holder);
            } else {
                //enters if view is already created

                holder = (viewHolder) row.getTag();
            }

            //set text from arraylist to viewholder
            holder.txt_view.setText(list.get(position));

            return row;
        }
    }
