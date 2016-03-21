package com.acmxlabs.canteencontroller;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TokenFragment extends Fragment {



    List<String> list = new ArrayList<String>();
    ListView grid;
    public TokenFragment() {
        // Required empty public constructor
    }

    adapter2 adp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_token, container, false);
         adp=new adapter2(this.getActivity(),list);

        grid = (ListView) view.findViewById(R.id.mobile_list);
        grid.setAdapter(adp);
        return view;

    }

    void change(String text)
    {

        list.add(text);
        adp=new adapter2(this.getActivity(),list);
        grid.setAdapter(adp);

    }

}

class adapter2 extends BaseAdapter{


    Context c;
    List<String> list;

    adapter2(Context c, List<String> list) {
        //this.txt2 = text;
        this.list=list;
        this.c = c;

    }

    @Override
    public int getCount() {
        //return txt2.length;
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        //return txt2[position];
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class viewHolder{
        TextView txt_view;
        viewHolder(View v)
        {
            txt_view= (TextView) v.findViewById(R.id.info_text2);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        viewHolder holder=null;

        if(row==null)
        {
            LayoutInflater inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row=inflater.inflate(R.layout.linear_view,parent,false);
            holder=new viewHolder(row);
            row.setTag(holder);
        }
        else
        {
            holder= (viewHolder) row.getTag();
        }


        holder.txt_view.setText(list.get(position));

        return row;
    }
}