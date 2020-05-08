package com.myapplicationdev.android.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GradeAdapter extends ArrayAdapter<Grade> {
    private ArrayList<Grade> al;
    private Context context;
    private TextView tvDay, tvGrade;
    private ImageView ivImage;

    public GradeAdapter(Context context, int resource, ArrayList<Grade> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        al = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
// "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);
        Grade s = al.get(position);
        tvDay = (TextView) rowView.findViewById(R.id.textViewWeek);
        tvDay.setText("Week" + s.getWeek());

        tvGrade = (TextView) rowView.findViewById(R.id.textViewGrade);
        tvGrade.setText(s.getGrade());

        ivImage = (ImageView) rowView.findViewById(R.id.imageView);
        ivImage.setImageResource(R.drawable.dg);

        return rowView;
    }
}
