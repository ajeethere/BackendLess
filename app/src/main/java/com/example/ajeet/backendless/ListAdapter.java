package com.example.ajeet.backendless;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by AJEET on 03-04-2018.
 */

public class ListAdapter extends BaseAdapter
{
    private static LayoutInflater inflater=null;
    private Context context;
    ListActivity ListAct;
    private List<profileTable> profileList=new ArrayList<profileTable>();

    public ListAdapter(ListActivity ListAct, List<profileTable> profileData) {
        context = ListAct;
        this.ListAct=ListAct;
        profileList=profileData;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return profileList.size();

    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class Holder{
        ImageView image;
        TextView name;
        TextView mobile;
    }

    @Override
    public View getView(final int position, View convertView,final ViewGroup parent) {
        Holder holder;
        View rowView = convertView;
        if (rowView == null) {
            holder = new Holder();
            rowView = inflater.inflate(R.layout.lsitview, null);
            holder.name = (TextView) rowView.findViewById(R.id.name);
            holder.mobile = (TextView) rowView.findViewById(R.id.mobile);
            holder.image = (ImageView) rowView.findViewById(R.id.img);
            rowView.setTag(holder);
        } else {
            holder = (Holder) rowView.getTag();
        }


        holder.name.setText(position + 1 + ":" + profileList.get(position).getName());
        holder.mobile.setText(profileList.get(position).getMobileNo());
        Picasso.get().load(profileList.get(position).getImageUrl()).into(holder.image);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "this is " + (position + 1) + "data", Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }
}
