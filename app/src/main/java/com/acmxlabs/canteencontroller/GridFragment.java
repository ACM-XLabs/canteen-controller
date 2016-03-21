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

    //String[] txt;
    String[] txt = {"AAAA", "BBBB", "CCCC", "DDDDD", "EEEE", "FFFFF", "GGGG"};
    List<String> list = new ArrayList<String>(Arrays.asList(txt));
    GridView grid;
    View v;
    Communicator comm;

    public GridFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        comm=(Communicator)getActivity();
        grid = (GridView) view.findViewById(R.id.gridView);

        adapter adp = new adapter(this.getActivity(), list,comm);

        grid.setAdapter(adp);
        grid.setDrawSelectorOnTop(true);

        return view;

    }


/*    String getText() {
        TextView tv = (TextView) v.findViewById(R.id.info_text);
        Log.v("Sachin", tv.getText().toString());
        return tv.getText().toString();
    }*/
}

    class adapter extends BaseAdapter {

        List<String> list;
        Context c;
        Communicator comm;

        adapter(Context c, List<String> list,Communicator comm) {
            this.list = list;
            this.c = c;
            this.comm=comm;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        class viewHolder implements View.OnClickListener {
            TextView txt_view;


            viewHolder(View v) {

                txt_view = (TextView) v.findViewById(R.id.info_text);
                v.setOnClickListener(this);
                txt_view.setOnClickListener(this);
            }


            @Override
            public void onClick(View v) {


                comm.respond(v);
            }
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            viewHolder holder = null;

            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                row = inflater.inflate(R.layout.grid_detail_view, parent, false);
                holder = new viewHolder(row);
                row.setTag(holder);
            } else {
                holder = (viewHolder) row.getTag();
            }


            holder.txt_view.setText(list.get(position));

            return row;
        }
    }
