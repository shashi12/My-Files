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


public class MainActivityArea extends Activity implements OnItemSelectedListener{
	private Spinner spinner01;
	private EditText text;
	private EditText text1;
	private EditText text2;
	private EditText text3;
	private EditText text4;
	private EditText text5;
	private EditText text6;
	private EditText text7;
		
	public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_area);
		 
			text = (EditText) findViewById(R.id.editText1);
		    text1 = (EditText) findViewById(R.id.editText2);
		    text2= (EditText) findViewById(R.id.editText3);
		    text3= (EditText) findViewById(R.id.editText4);	
		    text4= (EditText) findViewById(R.id.editText5);	
		    text5= (EditText) findViewById(R.id.editText6);	
		    text6= (EditText) findViewById(R.id.editText7);	
		    text7= (EditText) findViewById(R.id.editText8);	
		    

		    spinner01 = (Spinner) findViewById(R.id.spinner1);
		    spinner01.setOnItemSelectedListener(this);
		    addItemsOnSpinner1();
	  }
	
	 public void addItemsOnSpinner1() {
		  
			List<String> list = new ArrayList<String>();
			list.add("Choose");
			list.add("Square_KM");
			list.add("Hectare");
			list.add("Square_Meter");
			list.add("Square_Mile");
			list.add("Acre");
			list.add("Square_Yard");
			list.add("Square_Foot");
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
			
		 case "Square_KM":
			 text1.setText(String.valueOf(inputValue));
			 text2.setText(String.valueOf(ConverterUtil.convertSquare_KMToHectare(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertSquare_KMToSquare_Meter(inputValue))); 	 
			 text4.setText(String.valueOf(ConverterUtil.convertSquare_KMToSquare_Mile(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertSquare_KMToAcre(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertSquare_KMToSquare_Yard(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertSquare_KMToSquare_foot(inputValue)));
			 break;
		 case "Hectare":
			 text1.setText(String.valueOf(ConverterUtil.convertHectareToSquareKM(inputValue)));
			 text2.setText(String.valueOf(inputValue));
			 text3.setText(String.valueOf(ConverterUtil.convertHectareToSquare_Meter(inputValue))); 	 
			 text4.setText(String.valueOf(ConverterUtil.convertHectareToSquare_Mile(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertHectareToAcre(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertHectareToSquare_Yard(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertHectareToSquare_Foot(inputValue)));
			 break;
		 case "Square_Meter":
			 text1.setText(String.valueOf(ConverterUtil.convertSquare_MeterToSquareKM(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertSquare_MeterToHectare(inputValue)));
			 text3.setText(String.valueOf(inputValue));	 
			 text4.setText(String.valueOf(ConverterUtil.convertSquare_MeterToSquare_Mile(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertSquare_MeterToAcre(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertSquare_MeterToSquare_Yard(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertSquare_MeterToSquare_Foot(inputValue)));
			 break;
		 case "Square_Mile":
			 text1.setText(String.valueOf(ConverterUtil.convertSquare_MileToSquareKM(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertSquare_MileToHectare(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertSquare_MileToSquare_Meter(inputValue))); 	 
			 text4.setText(String.valueOf(inputValue));
			 text5.setText(String.valueOf(ConverterUtil.convertSquare_MileToAcre(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertSquare_MileToSquare_Yard(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertSquare_MileToSquare_Foot(inputValue)));
			 break;
		 case "Acre":
			 text1.setText(String.valueOf(ConverterUtil.convertAcreToSquareKM(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertAcreToHectare(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertAcreToSquare_Meter(inputValue)));
			 text4.setText(String.valueOf(ConverterUtil.convertAcreToSquare_Mile(inputValue)));
			 text5.setText(String.valueOf(inputValue));
			 text6.setText(String.valueOf(ConverterUtil.convertAcreToSquare_Yard(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertAcreToSquare_Foot(inputValue)));
			 break;
		 case "Square_Yard":
			 text1.setText(String.valueOf(ConverterUtil.convertSquare_YardToSquareKM(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertSquare_YardToHectare(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertSquare_YardToSquare_Meter(inputValue)));
			 text4.setText(String.valueOf(ConverterUtil.convertSquare_YardToSquare_Mile(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertSquare_YardToAcre(inputValue)));
			 text6.setText(String.valueOf(inputValue));
			 text7.setText(String.valueOf(ConverterUtil.convertSquare_YardToSquare_Foot(inputValue)));
			 break;
		 case "Square_Foot":
			 text1.setText(String.valueOf(ConverterUtil.convertSquare_FootToSquareKM(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertSquare_FootToHectare(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertSquare_FootToSquare_Meter(inputValue)));
			 text4.setText(String.valueOf(ConverterUtil.convertSquare_FootToSquare_Mile(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertSquare_FootToAcre(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertSquare_FootToSquare_Yard(inputValue)));
			 text7.setText(String.valueOf(inputValue));
			 break;
		 }
		
      } 
		 
	 }

	    public void onNothingSelected(AdapterView<?> parent) {
	        // Another interface callback
	    }

	 
}
