package com.shashi.android.androidutility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MobileArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
 
	public MobileArrayAdapter(Context context, String[] values) {
		super(context, R.layout.single_list_item_view, values);
		this.context = context;
		this.values = values;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.single_list_item_view, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
		textView.setText(values[position]);
 
		// Change icon based on name
		String s = values[position];
 
		System.out.println(s);
 
		if (s.equals("Temperature")) {
			imageView.setImageResource(R.drawable.image1);
		} else if (s.equals("Storage")) {
			imageView.setImageResource(R.drawable.storage);
		} else if (s.equals("Speed")) {
			imageView.setImageResource(R.drawable.speed1);
		} else if (s.equals("Mass")) {
			imageView.setImageResource(R.drawable.mass);
		} else if (s.equals("Length")) {
			imageView.setImageResource(R.drawable.length);
		} else if (s.equals("Area")) {
			imageView.setImageResource(R.drawable.area);
		} else if (s.equals("Currency")) {
			imageView.setImageResource(R.drawable.money);
		} 
 
		return rowView;
	}
}

