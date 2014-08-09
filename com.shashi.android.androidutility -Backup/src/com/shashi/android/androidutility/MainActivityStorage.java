package com.shashi.android.androidutility;

import java.util.ArrayList;

import com.shashi.android.androidutility.R;

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


public class MainActivityStorage extends Activity implements OnItemSelectedListener{
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
			setContentView(R.layout.activity_main_storage);
		 
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
			list.add("Bit");
			list.add("Byte");
			list.add("KiloByte");
			list.add("MegaByte");
			list.add("GigaByte");
			list.add("TeraByte");
			list.add("PetaByte");
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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
			
		 case "Bit":
			 text1.setText(String.valueOf(inputValue));
			 text2.setText(String.valueOf(ConverterUtil.convertBitToByte(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertBitToKiloByte(inputValue))); 	 
			 text4.setText(String.valueOf(ConverterUtil.convertBitToMegaByte(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertBitToGigaByte(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertBitToTeraByte(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertBitToPetaByte(inputValue)));
			 break;
		 case "Byte":
			 text1.setText(String.valueOf(ConverterUtil.convertBYteToBit(inputValue)));
			 text2.setText(String.valueOf(inputValue));
			 text3.setText(String.valueOf(ConverterUtil.convertBYteToKiloByte(inputValue))); 	 
			 text4.setText(String.valueOf(ConverterUtil.convertBYteToMegaByte(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertBYteToGigaByte(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertBYteToTeraByte(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertBYteToPetaByte(inputValue)));
			 break;
		 case "KiloByte":
			 text1.setText(String.valueOf(ConverterUtil.convertKiloByteToBit(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertKiloByteToByte(inputValue)));
			 text3.setText(String.valueOf(inputValue));	 
			 text4.setText(String.valueOf(ConverterUtil.convertKiloByteToMegaByte(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertKiloByteToGigaByte(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertKiloByteToTeraByte(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertKiloByteToPetaByte(inputValue)));
			 break;
		 case "MegaByte":
			 text1.setText(String.valueOf(ConverterUtil.convertMegaByteToBit(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertMegaByteToByte(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertMegaByteToKiloByte(inputValue))); 	 
			 text4.setText(String.valueOf(inputValue));
			 text5.setText(String.valueOf(ConverterUtil.convertMegaByteToGigaByte(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertMegaByteToTeraByte(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertMegaByteToPetaByte(inputValue)));
			 break;
		 case "GigaByte":
			 text1.setText(String.valueOf(ConverterUtil.convertGigaByteToBit(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertGigaByteToKiloByte(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertGigaByteToMegaByte(inputValue)));
			 text4.setText(String.valueOf(ConverterUtil.convertGigaByteToByte(inputValue)));
			 text5.setText(String.valueOf(inputValue));
			 text6.setText(String.valueOf(ConverterUtil.convertGigaByteToTeraByte(inputValue)));
			 text7.setText(String.valueOf(ConverterUtil.convertGigaByteToPetaByte(inputValue)));
			 break;
		 case "TeraByte":
			 text1.setText(String.valueOf(ConverterUtil.convertTeraByteToBit(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertTeraByteToByte(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertTeraByteToKiloByte(inputValue)));
			 text4.setText(String.valueOf(ConverterUtil.convertTeraByteToMegaByte(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertTeraByteToGigaByte(inputValue)));
			 text6.setText(String.valueOf(inputValue));
			 text7.setText(String.valueOf(ConverterUtil.convertTeraByteToPetaByte(inputValue)));
			 break;
		 case "PetaByte":
			 text1.setText(String.valueOf(ConverterUtil.convertPetaByteToPetaByte(inputValue)));
			 text2.setText(String.valueOf(ConverterUtil.convertPetaByteToByte(inputValue)));
			 text3.setText(String.valueOf(ConverterUtil.convertPetaByteToKiloByte(inputValue)));
			 text4.setText(String.valueOf(ConverterUtil.convertPetaByteToMegaByte(inputValue)));
			 text5.setText(String.valueOf(ConverterUtil.convertPetaByteToGigaByte(inputValue)));
			 text6.setText(String.valueOf(ConverterUtil.convertPetaByteToTeraByte(inputValue)));
			 text7.setText(String.valueOf(inputValue));
			 break;
		 }
		
      } 
		 
	 }

	    public void onNothingSelected(AdapterView<?> parent) {
	        // Another interface callback
	    }

	 
}
