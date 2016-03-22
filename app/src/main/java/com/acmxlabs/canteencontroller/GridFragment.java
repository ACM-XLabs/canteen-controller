package com.acmxlabs.canteencontroller;


<<<<<<< HEAD
import android.content.Context;
=======
>>>>>>> 350c5fd594300ee97f47843e0bcd94a054e01f45
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
=======
>>>>>>> 350c5fd594300ee97f47843e0bcd94a054e01f45


/**
 * A simple {@link Fragment} subclass.
 */
public class GridFragment extends Fragment {

<<<<<<< HEAD
    //String[] txt;
    String[] txt= {"AAAA", "BBBB", "CCCC", "DDDDD", "EEEE", "FFFFF", "GGGG"};
    GridView grid;
=======

>>>>>>> 350c5fd594300ee97f47843e0bcd94a054e01f45
    public GridFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
<<<<<<< HEAD
        View view=inflater.inflate(R.layout.fragment_grid, container, false);

         grid = (GridView) view.findViewById(R.id.gridView);
        adapter adp=new adapter(this.getActivity(),txt);
        grid.setAdapter(adp);
        return view;

    }

}

class adapter extends BaseAdapter{

    String[] text;
    Context c;

    adapter(Context c,String[] text)
    {
        this.text=text;
        this.c=c;
    }

    @Override
    public int getCount() {
        return text.length;
    }

    @Override
    public Object getItem(int position) {
        return text[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class viewHolder{
        TextView txt_view;
        viewHolder(View v)
        {
            txt_view= (TextView) v.findViewById(R.id.info_text);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        viewHolder holder=null;

        if(row==null)
        {
            LayoutInflater inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row=inflater.inflate(R.layout.grid_detail_view,parent,false);
            holder=new viewHolder(row);
            row.setTag(holder);
        }
        else
        {
            holder= (viewHolder) row.getTag();
        }


        holder.txt_view.setText(text[position]);

        return row;
    }
=======
        return inflater.inflate(R.layout.fragment_grid, container, false);
    }

>>>>>>> 350c5fd594300ee97f47843e0bcd94a054e01f45
}
