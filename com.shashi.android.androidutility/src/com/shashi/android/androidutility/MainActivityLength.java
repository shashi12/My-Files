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


public class MainActivityLength extends Activity implements OnItemSelectedListener{
	private Spinner spinner01;
	private EditText text;
	private EditText text1;
	private EditText text2;
	private EditText text3;
	private EditText text4;
	private EditText text5;
	private EditText text6;
	private EditText text7;
	private EditText text8;
	private EditText text9;
	
	public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_length);
		 
			text = (EditText) findViewById(R.id.editText1);
		    text1 = (EditText) findViewById(R.id.editText2);
		    text2= (EditText) findViewById(R.id.editText3);
		    text3= (EditText) findViewById(R.id.editText4);	
		    text4= (EditText) findViewById(R.id.editText5);	
		    text5= (EditText) findViewById(R.id.editText6);	
		    text6= (EditText) findViewById(R.id.editText7);	
		    text7= (EditText) findViewById(R.id.editText8);	
		    text8= (EditText) findViewById(R.id.editText9);	
		    text9= (EditText) findViewById(R.id.editText10);	

		    spinner01 = (Spinner) findViewById(R.id.spinner1);
		    spinner01.setOnItemSelectedListener(this);
		    addItemsOnSpinner1();
	  }
	
	 public void addItemsOnSpinner1() {
		  
			List<String> list = new ArrayList<String>();
			list.add("Choose");
			list.add("Kilometer");
			list.add("Meter");
			list.add("Centimeter");
			list.add("Millimeter");
			list.add("Mile");
			list.add("Yard");
			list.add("Foot");
			list.add("Inch");
			list.add("Nautical Mile");
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
			
		 case "Kilometer":
			 text1.setText(String.valueOf(inputValue));
			 text2.setText(String.valueOf(ConverterUtil.convertKilometerToMeter(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertKilometerTocentiMeter(inputValue))); 	 
			 text4.setText(String.valueOf(ConverterUtil.convertKilometerTomilliMeter(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertKilometerToMile(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertKilometerToYard(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertKilometerToFoot(inputValue)));
			 text8.setText(String.valueOf(ConverterUtil.convertKilometerToInch(inputValue)));
			 text9.setText(String.valueOf(ConverterUtil.convertKilometerToNauticleMile(inputValue)));
		     break;
		 case "Meter":
			 text1.setText(String.valueOf(ConverterUtil.convertMeterToKilometer(inputValue)));
			 text2.setText(String.valueOf(inputValue));
			 text3.setText(String.valueOf(ConverterUtil.convertMeterTocentiMeter(inputValue))); 	 
			 text4.setText(String.valueOf(ConverterUtil.convertMeterTomilliMeter(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertMeterToMile(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertMeterToYard(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertMeterToFoot(inputValue)));
			 text8.setText(String.valueOf(ConverterUtil.convertMeterToInch(inputValue)));
			 text9.setText(String.valueOf(ConverterUtil.convertMeterToNauticleMile(inputValue)));
			 break;
		 case "Centimeter":
			 text1.setText(String.valueOf(ConverterUtil.convertCentimeterToKilometer(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertCentimeterTometer(inputValue)));
			 text3.setText(String.valueOf(inputValue));	 
			 text4.setText(String.valueOf(ConverterUtil.convertCentimeterTomilliMeter(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertCentimeterToMile(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertCentimeterToYard(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertCentimeterToFoot(inputValue)));
			 text8.setText(String.valueOf(ConverterUtil.convertCentimeteroInch(inputValue)));
			 text9.setText(String.valueOf(ConverterUtil.convertCentimeterToNauticleMile(inputValue)));
			 break;
		 case "Millimeter":
			 text1.setText(String.valueOf(ConverterUtil.convertMillimeterToKilometer(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertMillimeterTometer(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertMillimeterTocentiMeter(inputValue))); 	 
			 text4.setText(String.valueOf(inputValue));
			 text5.setText(String.valueOf(ConverterUtil.convertMillimeterToMile(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertMillimeterToYard(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertMillimeterToFoot(inputValue)));
			 text8.setText(String.valueOf(ConverterUtil.convertMillimeterToInch(inputValue)));
			 text9.setText(String.valueOf(ConverterUtil.convertMillimeterToNauticleMile(inputValue)));
			 break;
		 case "Mile":
			 text1.setText(String.valueOf(ConverterUtil.convertMileToKilometer(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertMileTometer(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertMilemeterTocentiMeter(inputValue)));
			 text4.setText(String.valueOf(ConverterUtil.convertMileToMillimeter(inputValue)));
			 text5.setText(String.valueOf(inputValue));
			 text6.setText(String.valueOf(ConverterUtil.convertMileToYard(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertMileToFoot(inputValue)));
			 text8.setText(String.valueOf(ConverterUtil.convertMileToInch(inputValue)));
			 text9.setText(String.valueOf(ConverterUtil.convertMileToNauticleMile(inputValue)));
			 break;
		 case "Yard":
			 text1.setText(String.valueOf(ConverterUtil.convertYardToKilometer(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertYardTometer(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertYardTocentiMeter(inputValue)));
			 text4.setText(String.valueOf(ConverterUtil.convertYardToMillimeter(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertYardToMile(inputValue)));
			 text6.setText(String.valueOf(inputValue));
			 text7.setText(String.valueOf(ConverterUtil.convertYardToFoot(inputValue)));
			 text8.setText(String.valueOf(ConverterUtil.convertYardToInch(inputValue)));
			 text9.setText(String.valueOf(ConverterUtil.convertYardToNauticleMile(inputValue)));
			 break;
		 case "Foot":
			 text1.setText(String.valueOf(ConverterUtil.convertFootToKilometer(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertFootTometer(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertFootTocentiMeter(inputValue)));
			 text4.setText(String.valueOf(ConverterUtil.convertFootToMillimeter(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertFootToMile(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertFootToYard(inputValue)));
			 text7.setText(String.valueOf(inputValue));
			 text8.setText(String.valueOf(ConverterUtil.convertFootToInch(inputValue)));
			 text9.setText(String.valueOf(ConverterUtil.convertFootToNauticleMile(inputValue)));
			 break;
		 case "Inch":
			 text1.setText(String.valueOf(ConverterUtil.convertInchToKilometer(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertInchTometer(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertInchTocentiMeter(inputValue)));
			 text4.setText(String.valueOf(ConverterUtil.convertInchToMillimeter(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertInchToMile(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertInchToYard(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertInchTofoot(inputValue)));
			 text8.setText(String.valueOf(inputValue));
			 text9.setText(String.valueOf(ConverterUtil.convertInchToNauticleMile(inputValue)));
			 break;
		 case "Nauticle Mile":
			 text1.setText(String.valueOf(ConverterUtil.convertNauticleMileToKilometer(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertNauticleMileTometer(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertNauticleMileTocentiMeter(inputValue)));
			 text4.setText(String.valueOf(ConverterUtil.convertNauticleMileToMillimeter(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertNauticleMileToMile(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertNauticleMileToYard(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertNauticleMileTofoot(inputValue)));
			 text8.setText(String.valueOf(ConverterUtil.convertNauticleMileToInch(inputValue)));
			 text9.setText(String.valueOf(inputValue));	
		     break;
		 }
		
      } 
		 
	 }

	    public void onNothingSelected(AdapterView<?> parent) {
	        // Another interface callback
	    }

	 
}
