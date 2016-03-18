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


/**
 * A simple {@link Fragment} subclass.
 */
public class TokenFragment extends Fragment {

    String[] txt= {"AAAA", "BBBB", "CCCC", "DDDDD", "EEEE", "FFFFF", "GGGG"};
    ListView grid;
    public TokenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_token, container, false);

        grid = (ListView) view.findViewById(R.id.mobile_list);
        adapter adp=new adapter(this.getActivity(),txt);
        grid.setAdapter(adp);
        return view;

    }

}

class adapter2 extends BaseAdapter{

   String[] txt2;
    Context c;

    @Override
    public int getCount() {
        return txt2.length;
    }

    @Override
    public Object getItem(int position) {
        return txt2[position];
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


        holder.txt_view.setText(txt2[position]);

        return row;
    }
}