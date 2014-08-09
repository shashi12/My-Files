package com.shashi.android.androidutility;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
//import android.view.View.OnClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
//import android.widget.AdapterView.OnItemSelectedListener;


public class MainActivityTemperature extends Activity implements OnItemSelectedListener{
	private Spinner spinner01;
	private EditText text;
	private EditText text1;
	private EditText text2;
	private EditText text3;
	
	public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_temperature);
		 
			text = (EditText) findViewById(R.id.editText1);
		    text1 = (EditText) findViewById(R.id.editText2);
		    text2= (EditText) findViewById(R.id.editText3);
		    text3= (EditText) findViewById(R.id.editText4);	
		    spinner01 = (Spinner) findViewById(R.id.spinner1);
		    addItemsOnSpinner1();
		    spinner01.setOnItemSelectedListener(this);
		    
	  }
	
	 public void addItemsOnSpinner1() {
		// String[] spinnerValues = { "Choose", "Celsius", "Fahrenheit","Kelvin"}; 
			List<String> list = new ArrayList<String>();
			list.add("Choose");
			list.add("Celsius");
			list.add("Fahrenheit");
			list.add("Kelvin");
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				R.layout.simple_spinner, list);
			dataAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
			spinner01.setAdapter(dataAdapter);
		  }
	 
	
	 public void onItemSelected(AdapterView<?> parent, View view, 
	            int pos, long id) {
	        // An item was selected. You can retrieve the selected item using
	        // parent.getItemAtPosition(pos)
		 spinner01.setSelection(pos);
		 String selState = (String) spinner01.getSelectedItem();
		 
		 if (text.getText().length() == 0) {
		        Toast.makeText(this, "Please enter a valid number",
		            Toast.LENGTH_LONG).show();
		        return;
		   }else {
		float inputValue = Float.parseFloat(text.getText().toString());
		 if(selState == "Celsius"){
			 text1.setText(String.valueOf(inputValue));
			 text2.setText(String
	    	            .valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
			  text3.setText(String
	    	            .valueOf(ConverterUtil.convertCelsiusToKelvin(inputValue)));
		 }
		 
		 if(selState == "Fahrenheit"){
			 text1.setText(String
	    	            .valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
			 text2.setText(String.valueOf(inputValue));
			 text3.setText(String
	    	            .valueOf(ConverterUtil.convertFahrenheitToKelvin(inputValue)));
		 }
		 
		 if(selState == "Kelvin"){
			 
			 text1.setText(String
	    	            .valueOf(ConverterUtil.convertKelvinToCelsius(inputValue)));
			  text2.setText(String
	    	            .valueOf(ConverterUtil.convertKelvinToFahrenheit(inputValue)));
			  text3.setText(String.valueOf(inputValue));
		 }
	 } 
		 
	    }

	    public void onNothingSelected(AdapterView<?> parent) {
	        // Another interface callback
	    }

	 
}
