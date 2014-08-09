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
import android.widget.Spinner;
import android.widget.Toast;
//import android.widget.AdapterView.OnItemSelectedListener;


public class MainActivityMass extends Activity implements OnItemSelectedListener{
	private Spinner spinner01;
	private EditText text;
	private EditText text1;
	private EditText text2;
	private EditText text3;
	private EditText text4;
		
	public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_mass);
		 
			text = (EditText) findViewById(R.id.editText1);
		    text1 = (EditText) findViewById(R.id.editText2);
		    text2= (EditText) findViewById(R.id.editText3);
		    text3= (EditText) findViewById(R.id.editText4);	
		    text4= (EditText) findViewById(R.id.editText5);	
		    

		    spinner01 = (Spinner) findViewById(R.id.spinner1);
		    spinner01.setOnItemSelectedListener(this);
		    addItemsOnSpinner1();
	  }
	
	 public void addItemsOnSpinner1() {
		  
			List<String> list = new ArrayList<String>();
			list.add("Choose");
			list.add("MetricTon");
			list.add("Kilogram");
			list.add("Pound");
			list.add("Ounce");
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
		 
		 switch(selState){
			
		 case "MetricTon":
			 text1.setText(String.valueOf(inputValue));
			 text2.setText(String.valueOf(ConverterUtil.convertMetricTonToKilogram(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertMetricTonToPound(inputValue))); 	 
			 text4.setText(String.valueOf(ConverterUtil.convertMetricTonToOunce(inputValue)));
			 break;
		 case "Kilogram":
			 text1.setText(String.valueOf(ConverterUtil.convertKilogramToMetricTon(inputValue)));
			 text2.setText(String.valueOf(inputValue));
			 text3.setText(String.valueOf(ConverterUtil.convertKilogramToPound(inputValue))); 	 
			 text4.setText(String.valueOf(ConverterUtil.convertKilogramToOunce(inputValue)));
			 break;
		 case "Pound":
			 text1.setText(String.valueOf(ConverterUtil.convertPoundToMetricTon(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertPoundToKilogram(inputValue)));
			 text3.setText(String.valueOf(inputValue));	 
			 text4.setText(String.valueOf(ConverterUtil.convertPoundToOunce(inputValue)));
			 break;
		 case "Ounce":
			 text1.setText(String.valueOf(ConverterUtil.convertOunceToMetricTon(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertOunceToKilogram(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertOunceToPound(inputValue))); 	 
			 text4.setText(String.valueOf(inputValue));
			 break;
		 }
		
      } 
		 
	 }

	    public void onNothingSelected(AdapterView<?> parent) {
	        // Another interface callback
	    }

	 
}
