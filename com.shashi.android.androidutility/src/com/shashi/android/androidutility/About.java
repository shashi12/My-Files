package com.shashi.android.androidutility;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class About extends Activity{

	// private AdView mAdView;
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        	
        EditText about_text = (EditText) findViewById(R.id.editText1);
        }

}