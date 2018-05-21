package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JeonWon on 2018-02-27.
 */

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    public ListViewAdapter(){

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return listViewItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final Context context = viewGroup.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_item, viewGroup, false);
        }

        CheckBox chkBoxView = (CheckBox)view.findViewById(R.id.checkBox);
        TextView courseNameView = (TextView)view.findViewById(R.id.courseName);
        TextView day1View = (TextView)view.findViewById(R.id.day1);
        TextView time1View = (TextView)view.findViewById(R.id.time1);
        TextView day2View = (TextView)view.findViewById(R.id.day2);
        TextView time2View = (TextView)view.findViewById(R.id.time2);

        ListViewItem listViewItem = listViewItemList.get(position);

        chkBoxView.setSelected(listViewItem.getChkBox());
        courseNameView.setText(listViewItem.getCourseName());
        day1View.setText(listViewItem.getDay1());
        time1View.setText(listViewItem.getTime1());
        day2View.setText(listViewItem.getDay2());
        time2View.setText(listViewItem.getTime2());


        return view;
    }

    public void addItem(String courseName, String day1, String time1, String day2, String time2){
        ListViewItem item = new ListViewItem();

        item.setChkBox();
        item.setCourseName(courseName);
        item.setDay1(day1);
        item.setTime1(time1);
        item.setDay2(day2);
        item.setTime2(time2);

        listViewItemList.add(item);
    }
}
