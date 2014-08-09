package com.shashi.android.androidutility;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivityGrocery extends Activity{
	private EditText text;
	private EditText text1;
	private EditText text2;
	private EditText text3;
	private EditText text4;
	private EditText text5;
	private EditText text6;
	private EditText text7;
	private Spinner spinner01;
	private Spinner spinner02; 
	Button btnOk;
	String selState01, selState02;
	float inputUnit,inputPrice,outputUnit,outputPrice;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_grocery);
	 
		spinner01 = (Spinner) findViewById(R.id.spinner1);
		spinner02 = (Spinner) findViewById(R.id.spinner2);
		
		text1 = (EditText) findViewById(R.id.editText1);
		text1.setKeyListener(null);
		text2 = (EditText) findViewById(R.id.editText2);
		text3 = (EditText) findViewById(R.id.editText3);
		text3.setKeyListener(null);
		text4 = (EditText) findViewById(R.id.editText4);
		text5 = (EditText) findViewById(R.id.editText5);
		text5.setKeyListener(null);
		text6 = (EditText) findViewById(R.id.editText6);
		text7 = (EditText) findViewById(R.id.editText7);
		Button btnOk =(Button) findViewById(R.id.button1);
		
	    addItemsOnSpinner();
	    
		
		
		btnOk.setOnClickListener(new OnClickListener() {

			public void onClick(View view){
				try {
					onclickshashi();
				}catch(Exception e){
					e.printStackTrace();
				}
			}

			
		});	
  }

	private void addItemsOnSpinner() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("Kgs");
		list.add("gms");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				R.layout.simple_spinner, list);
		dataAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
		spinner01.setAdapter(dataAdapter);
		spinner02.setAdapter(dataAdapter);
	}

	private void onclickshashi() {
		// TODO Auto-generated method stub
		selState01 = (String) spinner01.getSelectedItem();
		selState02 = (String) spinner02.getSelectedItem();
		inputUnit = Float.parseFloat(text2.getText().toString());
		inputPrice= Float.parseFloat(text4.getText().toString());
		outputUnit= Float.parseFloat(text6.getText().toString());
		//outputPrice= Float.parseFloat(text7.getText().toString());
		
		if(selState01=="Kgs" && selState02=="Kgs"){
			text7.setText(String.valueOf(ConverterUtil.convertkgToKg(inputUnit,outputUnit,inputPrice)));
		}else if(selState01=="gms" && selState02=="gms"){
			text7.setText(String.valueOf(ConverterUtil.convertgmTogm(inputUnit,outputUnit,inputPrice)));
		}else if(selState01=="gms" && selState02=="Kgs"){
			text7.setText(String.valueOf(ConverterUtil.convertgmTokg(inputUnit,outputUnit,inputPrice)));
		}else if(selState01=="Kgs" && selState02=="gms"){
			text7.setText(String.valueOf(ConverterUtil.convertkgTogm(inputUnit,outputUnit,inputPrice)));
		}else{
			
		}
		
		
		
	}

}
