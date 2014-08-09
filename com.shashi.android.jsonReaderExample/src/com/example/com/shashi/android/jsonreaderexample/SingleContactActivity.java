package com.example.com.shashi.android.jsonreaderexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.com.shashi.android.jsonreaderexample.R;

public class SingleContactActivity extends Activity{
	// JSON node keys
		private static final String TAG_NAME = "name";
		private static final String TAG_To = "to";
		private static final String TAG_Rate = "rate";
		@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_single_contact);
	        
	        // getting intent data
	        Intent in = getIntent();
	        
	        // Get JSON values from previous intent
	        String name = in.getStringExtra(TAG_NAME);
	        String to = in.getStringExtra(TAG_To);
	        String rate = in.getStringExtra(TAG_Rate);
	        
	        // Displaying all values on the screen
	        TextView lblName = (TextView) findViewById(R.id.name_label);
	        TextView lblEmail = (TextView) findViewById(R.id.email_label);
	        TextView lblMobile = (TextView) findViewById(R.id.mobile_label);
	        
	        lblName.setText(name);
	        lblEmail.setText(to);
	        lblMobile.setText(rate);
	    }
	
	
}
