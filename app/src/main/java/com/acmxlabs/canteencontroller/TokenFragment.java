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
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TokenFragment extends Fragment {

    //create an empty arraylist
    List<String> list = new ArrayList<String>();

    GridView token_frg_view;

    public TokenFragment() {
        // Required empty public constructor
    }

    adapter_token_frg adp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_token, container, false);

        //create a new adapter object
         adp=new adapter_token_frg(this.getActivity(),list);

        //get reference to the grid view of token_frg
        token_frg_view= (GridView) view.findViewById(R.id.mobile_list);

        //set adapter to the gridview of token_frg
        token_frg_view.setAdapter(adp);

        return view;

    }


    //called by mainactivity to add elements dynamically
    void change(String text)
    {
        //add text to the list
        list.add(text);

        //create a new adapter with the updated list and set the adapter
        adp=new adapter_token_frg(this.getActivity(),list);
        token_frg_view.setAdapter(adp);

    }

    void view_cards_starting_with(String search_substr)
    {
        //create a new array list for elements starting with the given sub-str
        List<String> search_list = new ArrayList<String>();

        //iterate over the list of elements for searching strings starting with given sub-str
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).startsWith(search_substr))
                search_list.add(list.get(i));
        }

        //create and set the adapter by the new arraylist
        adp=new adapter_token_frg(this.getActivity(),search_list);
        token_frg_view.setAdapter(adp);
    }

}

class adapter_token_frg extends BaseAdapter{


    Context c;
    List<String> list;

    //constructor for adapter_token_frg class
    adapter_token_frg(Context c, List<String> list) {

        this.list=list;
        this.c = c;

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

    class viewHolder{
        TextView txt_view;
        viewHolder(View v)
        {
            txt_view= (TextView) v.findViewById(R.id.token_card_text);
        }
    }

    //returns a view that should be displayed
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        viewHolder holder=null;

        if(row==null)
        {
            //enters if row is being created for the first time

            LayoutInflater inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //convert layout xml file to a java object
            row=inflater.inflate(R.layout.linear_view,parent,false);

            //create a new viewholder
            holder=new viewHolder(row);
            row.setTag(holder);
        }
        else
        {
            //enters if view is already created
            holder= (viewHolder) row.getTag();
        }

        //set text from arraylist to viewholder
        holder.txt_view.setText(list.get(position));

        return row;
    }
}