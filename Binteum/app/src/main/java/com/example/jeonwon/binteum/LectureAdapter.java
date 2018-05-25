package com.example.jeonwon.binteum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LectureAdapter extends BaseAdapter {
    private ArrayList<Lecture> LecutureList = new ArrayList<Lecture>();

    @Override
    public int getCount() {
        return LecutureList.size();
    }

    @Override
    public Object getItem(int i) {
        return LecutureList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i;
        final Context context = viewGroup.getContext();

        if(view==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.listviewlecture, viewGroup, false);
        }

        TextView textViewFullInfo = (TextView)view.findViewById(R.id.textViewFullInfo);
        TextView textViewLNum = (TextView)view.findViewById(R.id.textViewLNum);
        TextView textViewTitle = (TextView)view.findViewById(R.id.textViewTitle);
        TextView textViewLID= (TextView)view.findViewById(R.id.textViewLID);

        Lecture lecture = LecutureList.get(i);

        textViewFullInfo.setText(lecture.getFullInfo());
        textViewLNum.setText(lecture.getL_Num());
        textViewTitle.setText(lecture.getTitle());
        textViewLID.setText(String.valueOf(lecture.getLID()));

        return view;
    }

    public void addLecture(Lecture lecture){
        Lecture item=lecture;

        LecutureList.add(item);
        notifyDataSetChanged();
    }

    public void remove(Lecture lecture){
        LecutureList.remove(lecture);
        notifyDataSetChanged();
    }

    public void deleteList(){
        LecutureList.removeAll(LecutureList);
        notifyDataSetChanged();
    }


}
