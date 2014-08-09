package com.shashi.android.xmlreaderexample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserFactory;

import com.shashi.android.xmlreaderexample.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivityCurrency extends Activity implements
OnItemSelectedListener {
	private Spinner spinner01;
	private Spinner spinner02;
	String selState01, selState02;
	XmlPullParserFactory factory = null;
	List<Student> students = null;
	String network = "Not connected to Internet";
	private EditText text;
	private EditText text1;
	final String urlString = "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
	int inter;
	List<Student> Students = null;
	float rate1, rate2, rate3, inputValue01;
	private RadioGroup radiocheckGroup;
    

	XMLPullParserHandler parser = new XMLPullParserHandler();
     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_convert_currency);
		Button btnOk =(Button) findViewById(R.id.button1);
		
		spinner01 = (Spinner) findViewById(R.id.spinner1);
		spinner02 = (Spinner) findViewById(R.id.spinner2);
		addItemsOnSpinner1();
		addItemsOnSpinner2();
		text = (EditText) findViewById(R.id.editText1);
		text1 = (EditText) findViewById(R.id.editText2);
		
		btnOk.setOnClickListener(new OnClickListener() {
		
		 
			public void onClick(View view){
				try {
					onclickshashi();
				}catch(NullPointerException e){
					e.printStackTrace();
				}
		}
		 });	
				// spinner02.onItemSelected_spinner2(this);
				// spinner01.setOnItemSelectedListener(this);
				// spinner02.setOnItemSelectedListener(this);


			}

			public void addItemsOnSpinner1() {

				List<String> list = new ArrayList<String>();
				list.add("Choose");
				list.add("USD");
				list.add("JPY");
				list.add("GBP");
				list.add("CHF");
				list.add("RUB");
				list.add("AUD");
				list.add("BRL");
				list.add("CAD");
				list.add("CNY");
				list.add("HKD");
				list.add("INR");
				list.add("MXN");
				list.add("MYR");
				list.add("NZD");
				list.add("SGD");
				ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, list);
				dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner01.setAdapter(dataAdapter);
			}

			public void addItemsOnSpinner2() {

				List<String> list = new ArrayList<String>();
				list.add("Choose");
				list.add("USD");
				list.add("JPY");
				list.add("GBP");
				list.add("CHF");
				list.add("RUB");
				list.add("AUD");
				list.add("BRL");
				list.add("CAD");
				list.add("CNY");
				list.add("HKD");
				list.add("INR");
				list.add("MXN");
				list.add("MYR");
				list.add("NZD");
				list.add("SGD");
				ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, list);
				dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner02.setAdapter(dataAdapter);
			}


			public void onclickshashi(){
			//	spinner01 = (Spinner) findViewById(R.id.spinner1);
			//	spinner02 = (Spinner) findViewById(R.id.spinner2);
				//addItemsOnSpinner1();
				
			//	text = (EditText) findViewById(R.id.editText1);
			//	text1 = (EditText) findViewById(R.id.editText2);

				radiocheckGroup = (RadioGroup) findViewById(R.id.radioGroup1);

				

				//btnOk.setOnClickListener(new OnClickListener() {

				//	public void onClick(View view){
						int selectedId = radiocheckGroup.getCheckedRadioButtonId();
						inputValue01 = Float.parseFloat(text.getText().toString());
						selState01 = (String) spinner01.getSelectedItem();
						selState02 = (String) spinner02.getSelectedItem();
						RadioButton temperatureButton = (RadioButton) findViewById(selectedId);
						network = NetworkUtil.getConnectivityStatusString(getApplicationContext());


						if( temperatureButton.getText().equals("Internet")){
							if (network != "Not connected to Internet") {
								try{
									Toast.makeText(this, temperatureButton.getText(),Toast.LENGTH_LONG).show();
									//Toast.makeText(this, network, Toast.LENGTH_LONG).show();
									Students = parser.fetchXML(urlString);
									//Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();

								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();}

							}else if (network == "Not connected to Internet") { 
								//Toast.makeText(this, "Not Connected To Internet",Toast.LENGTH_LONG).show();						

							}

						}else if( temperatureButton.getText().equals("Local") ){
							if (network == "Not connected to Internet") {
								try {
									//	Toast.makeText(this, "Not Connected To Internet",
									//			Toast.LENGTH_LONG).show();
									students = new ArrayList<Student>();
									Students = parser.parse(
											getAssets().open("eurofxref-daily.xml"), students);
									//		Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (RuntimeException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						} else {
						}

					//}
				//});		

				calculate(inputValue01,selState01,selState02);
			}


			public void calculate(float inputValue,String selState,String selState1){

				try {// USD
					if (selState.equals("USD") && selState1.equals("USD")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("USD") && selState1.equals("JPY")) {
						rate1 = Float.parseFloat(Students.get(0).getRate());
						rate2 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("USD") && selState1.equals("GBP")) {
						rate1 = Float.parseFloat(Students.get(0).getRate());
						rate2 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("USD") && selState1.equals("CHF")) {
						rate1 = Float.parseFloat(Students.get(0).getRate());
						rate2 = Float.parseFloat(Students.get(11).getRate());
					} else if (selState.equals("USD") && selState1.equals("RUB")) {
						rate1 = Float.parseFloat(Students.get(0).getRate());
						rate2 = Float.parseFloat(Students.get(14).getRate());
					} else if (selState.equals("USD") && selState1.equals("AUD")) {
						rate1 = Float.parseFloat(Students.get(0).getRate());
						rate2 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("USD") && selState1.equals("BRL")) {
						rate1 = Float.parseFloat(Students.get(0).getRate());
						rate2 = Float.parseFloat(Students.get(17).getRate());
					} else if (selState.equals("USD") && selState1.equals("CAD")) {
						rate1 = Float.parseFloat(Students.get(0).getRate());
						rate2 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("USD") && selState1.equals("CNY")) {
						rate1 = Float.parseFloat(Students.get(0).getRate());
						rate2 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("USD") && selState1.equals("HKD")) {
						rate1 = Float.parseFloat(Students.get(0).getRate());
						rate2 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("USD") && selState1.equals("INR")) {
						rate1 = Float.parseFloat(Students.get(0).getRate());
						rate2 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("USD") && selState1.equals("MXN")) {
						rate1 = Float.parseFloat(Students.get(0).getRate());
						rate2 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("USD") && selState1.equals("MYR")) {
						rate1 = Float.parseFloat(Students.get(0).getRate());
						rate2 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("USD") && selState1.equals("NZD")) {
						rate1 = Float.parseFloat(Students.get(0).getRate());
						rate2 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("USD") && selState1.equals("SGD")) {
						rate1 = Float.parseFloat(Students.get(0).getRate());
						rate2 = Float.parseFloat(Students.get(29).getRate());
					} else if (selState.equals("USD") && selState1.equals("EUR")) {
						rate1 = Float.parseFloat(Students.get(0).getRate());
						rate2 = (float) 1.0;
					}

					// EUR
					else if (selState.equals("EUR") && selState1.equals("EUR")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("EUR") && selState1.equals("USD")) {
						rate1 = (float) 1.0;
						rate2 = Float.parseFloat(Students.get(0).getRate());
					} else if (selState.equals("EUR") && selState1.equals("JPY")) {
						rate1 = (float) 1.0;
						rate2 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("EUR") && selState1.equals("GBP")) {
						rate1 = (float) 1.0;
						rate2 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("EUR") && selState1.equals("CHF")) {
						rate1 = (float) 1.0;
						rate2 = Float.parseFloat(Students.get(11).getRate());
					} else if (selState.equals("EUR") && selState1.equals("RUB")) {
						rate1 = (float) 1.0;
						rate2 = Float.parseFloat(Students.get(14).getRate());
					} else if (selState.equals("EUR") && selState1.equals("AUD")) {
						rate1 = (float) 1.0;
						rate2 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("EUR") && selState1.equals("BRL")) {
						rate1 = (float) 1.0;
						rate2 = Float.parseFloat(Students.get(17).getRate());
					} else if (selState.equals("EUR") && selState1.equals("CAD")) {
						rate1 = (float) 1.0;
						rate2 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("EUR") && selState1.equals("CNY")) {
						rate1 = (float) 1.0;
						rate2 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("EUR") && selState1.equals("HKD")) {
						rate1 = (float) 1.0;
						rate2 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("EUR") && selState1.equals("INR")) {
						rate1 = (float) 1.0;
						rate2 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("EUR") && selState1.equals("MXN")) {
						rate1 = (float) 1.0;
						rate2 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("EUR") && selState1.equals("MYR")) {
						rate1 = (float) 1.0;
						rate2 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("EUR") && selState1.equals("NZD")) {
						rate1 = (float) 1.0;
						rate2 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("EUR") && selState1.equals("SGD")) {
						rate1 = (float) 1.0;
						rate2 = Float.parseFloat(Students.get(29).getRate());
					}

					// JPY
					else if (selState.equals("JPY") && selState1.equals("EUR")) {
						rate2 = (float) 1.0;
						rate1 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("JPY") && selState1.equals("JPY")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("JPY") && selState1.equals("GBP")) {
						rate2 = Float.parseFloat(Students.get(5).getRate());
						rate1 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("JPY") && selState1.equals("CHF")) {
						rate2 = Float.parseFloat(Students.get(11).getRate());
						rate1 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("JPY") && selState1.equals("RUB")) {
						rate2 = Float.parseFloat(Students.get(14).getRate());
						rate1 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("JPY") && selState1.equals("AUD")) {
						rate2 = Float.parseFloat(Students.get(16).getRate());
						rate1 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("JPY") && selState1.equals("BRL")) {
						rate2 = Float.parseFloat(Students.get(17).getRate());
						rate1 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("JPY") && selState1.equals("CAD")) {
						rate2 = Float.parseFloat(Students.get(18).getRate());
						rate1 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("JPY") && selState1.equals("CNY")) {
						rate2 = Float.parseFloat(Students.get(19).getRate());
						rate1 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("JPY") && selState1.equals("HKD")) {
						rate2 = Float.parseFloat(Students.get(20).getRate());
						rate1 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("JPY") && selState1.equals("INR")) {
						rate2 = Float.parseFloat(Students.get(23).getRate());
						rate1 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("JPY") && selState1.equals("MXN")) {
						rate2 = Float.parseFloat(Students.get(25).getRate());
						rate1 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("JPY") && selState1.equals("MYR")) {
						rate2 = Float.parseFloat(Students.get(26).getRate());
						rate1 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("JPY") && selState1.equals("NZD")) {
						rate2 = Float.parseFloat(Students.get(27).getRate());
						rate1 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("JPY") && selState1.equals("SGD")) {
						rate2 = Float.parseFloat(Students.get(29).getRate());
						rate1 = Float.parseFloat(Students.get(1).getRate());
					} else if (selState.equals("JPY") && selState1.equals("USD")) {
						rate2 = Float.parseFloat(Students.get(0).getRate());
						rate1 = Float.parseFloat(Students.get(1).getRate());
					}

					// GBP
					else if (selState.equals("GBP") && selState1.equals("GBP")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("GBP") && selState1.equals("JPY")) {
						rate2 = Float.parseFloat(Students.get(1).getRate());
						rate1 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("GBP") && selState1.equals("USD")) {
						rate2 = Float.parseFloat(Students.get(0).getRate());
						rate1 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("GBP") && selState1.equals("EUR")) {
						rate2 = (float) 1.0;
						rate1 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("GBP") && selState1.equals("CHF")) {
						rate2 = Float.parseFloat(Students.get(11).getRate());
						rate1 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("GBP") && selState1.equals("RUB")) {
						rate2 = Float.parseFloat(Students.get(14).getRate());
						rate1 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("GBP") && selState1.equals("AUD")) {
						rate2 = Float.parseFloat(Students.get(16).getRate());
						rate1 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("GBP") && selState1.equals("BRL")) {
						rate2 = Float.parseFloat(Students.get(17).getRate());
						rate1 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("GBP") && selState1.equals("CAD")) {
						rate2 = Float.parseFloat(Students.get(18).getRate());
						rate1 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("GBP") && selState1.equals("CNY")) {
						rate2 = Float.parseFloat(Students.get(19).getRate());
						rate1 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("GBP") && selState1.equals("HKD")) {
						rate2 = Float.parseFloat(Students.get(20).getRate());
						rate1 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("GBP") && selState1.equals("INR")) {
						rate2 = Float.parseFloat(Students.get(23).getRate());
						rate1 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("GBP") && selState1.equals("MXN")) {
						rate2 = Float.parseFloat(Students.get(25).getRate());
						rate1 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("GBP") && selState1.equals("MYR")) {
						rate2 = Float.parseFloat(Students.get(26).getRate());
						rate1 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("GBP") && selState1.equals("NZD")) {
						rate2 = Float.parseFloat(Students.get(27).getRate());
						rate1 = Float.parseFloat(Students.get(5).getRate());
					} else if (selState.equals("GBP") && selState1.equals("SGD")) {
						rate2 = Float.parseFloat(Students.get(29).getRate());
						rate1 = Float.parseFloat(Students.get(5).getRate());
					}
					// CHF
					else if (selState.equals("CHF") && selState1.equals("JPY")) {
						rate2 = Float.parseFloat(Students.get(1).getRate());
						rate1 = Float.parseFloat(Students.get(11).getRate());
					} else if (selState.equals("CHF") && selState1.equals("CHF")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("CHF") && selState1.equals("USD")) {
						rate2 = Float.parseFloat(Students.get(0).getRate());
						rate1 = Float.parseFloat(Students.get(11).getRate());
					} else if (selState.equals("CHF") && selState1.equals("EUR")) {
						rate2 = (float) 1.0;
						rate1 = Float.parseFloat(Students.get(11).getRate());
					} else if (selState.equals("CHF") && selState1.equals("RUB")) {
						rate2 = Float.parseFloat(Students.get(14).getRate());
						rate1 = Float.parseFloat(Students.get(11).getRate());
					} else if (selState.equals("CHF") && selState1.equals("AUD")) {
						rate2 = Float.parseFloat(Students.get(16).getRate());
						rate1 = Float.parseFloat(Students.get(11).getRate());
					} else if (selState.equals("CHF") && selState1.equals("BRL")) {
						rate2 = Float.parseFloat(Students.get(17).getRate());
						rate1 = Float.parseFloat(Students.get(11).getRate());
					} else if (selState.equals("CHF") && selState1.equals("CAD")) {
						rate2 = Float.parseFloat(Students.get(18).getRate());
						rate1 = Float.parseFloat(Students.get(11).getRate());
					} else if (selState.equals("CHF") && selState1.equals("CNY")) {
						rate2 = Float.parseFloat(Students.get(19).getRate());
						rate1 = Float.parseFloat(Students.get(11).getRate());
					} else if (selState.equals("CHF") && selState1.equals("HKD")) {
						rate2 = Float.parseFloat(Students.get(20).getRate());
						rate1 = Float.parseFloat(Students.get(11).getRate());
					} else if (selState.equals("CHF") && selState1.equals("INR")) {
						rate2 = Float.parseFloat(Students.get(23).getRate());
						rate1 = Float.parseFloat(Students.get(11).getRate());
					} else if (selState.equals("CHF") && selState1.equals("MXN")) {
						rate2 = Float.parseFloat(Students.get(25).getRate());
						rate1 = Float.parseFloat(Students.get(11).getRate());
					} else if (selState.equals("CHF") && selState1.equals("MYR")) {
						rate2 = Float.parseFloat(Students.get(26).getRate());
						rate1 = Float.parseFloat(Students.get(11).getRate());
					} else if (selState.equals("CHF") && selState1.equals("NZD")) {
						rate2 = Float.parseFloat(Students.get(27).getRate());
						rate1 = Float.parseFloat(Students.get(11).getRate());
					} else if (selState.equals("CHF") && selState1.equals("SGD")) {
						rate2 = Float.parseFloat(Students.get(29).getRate());
						rate1 = Float.parseFloat(Students.get(11).getRate());
					}

					// RUB
					else if (selState.equals("RUB") && selState1.equals("JPY")) {
						rate2 = Float.parseFloat(Students.get(1).getRate());
						rate1 = Float.parseFloat(Students.get(14).getRate());
					} else if (selState.equals("RUB") && selState1.equals("USD")) {
						rate2 = Float.parseFloat(Students.get(0).getRate());
						rate1 = Float.parseFloat(Students.get(14).getRate());
					} else if (selState.equals("RUB") && selState1.equals("GBP")) {
						rate2 = Float.parseFloat(Students.get(5).getRate());
						rate1 = Float.parseFloat(Students.get(14).getRate());
					} else if (selState.equals("RUB") && selState1.equals("EUR")) {
						rate2 = (float) 1.0;
						rate1 = Float.parseFloat(Students.get(14).getRate());
					} else if (selState.equals("RUB") && selState1.equals("RUB")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("RUB") && selState1.equals("AUD")) {
						rate2 = Float.parseFloat(Students.get(16).getRate());
						rate1 = Float.parseFloat(Students.get(14).getRate());
					} else if (selState.equals("RUB") && selState1.equals("BRL")) {
						rate2 = Float.parseFloat(Students.get(17).getRate());
						rate1 = Float.parseFloat(Students.get(14).getRate());
					} else if (selState.equals("RUB") && selState1.equals("CAD")) {
						rate2 = Float.parseFloat(Students.get(18).getRate());
						rate1 = Float.parseFloat(Students.get(14).getRate());
					} else if (selState.equals("RUB") && selState1.equals("CNY")) {
						rate2 = Float.parseFloat(Students.get(19).getRate());
						rate1 = Float.parseFloat(Students.get(14).getRate());
					} else if (selState.equals("RUB") && selState1.equals("HKD")) {
						rate2 = Float.parseFloat(Students.get(20).getRate());
						rate1 = Float.parseFloat(Students.get(14).getRate());
					} else if (selState.equals("RUB") && selState1.equals("INR")) {
						rate2 = Float.parseFloat(Students.get(23).getRate());
						rate1 = Float.parseFloat(Students.get(14).getRate());
					} else if (selState.equals("RUB") && selState1.equals("MXN")) {
						rate2 = Float.parseFloat(Students.get(25).getRate());
						rate1 = Float.parseFloat(Students.get(14).getRate());
					} else if (selState.equals("RUB") && selState1.equals("MYR")) {
						rate2 = Float.parseFloat(Students.get(26).getRate());
						rate1 = Float.parseFloat(Students.get(14).getRate());
					} else if (selState.equals("RUB") && selState1.equals("NZD")) {
						rate2 = Float.parseFloat(Students.get(27).getRate());
						rate1 = Float.parseFloat(Students.get(14).getRate());
					} else if (selState.equals("RUB") && selState1.equals("SGD")) {
						rate2 = Float.parseFloat(Students.get(29).getRate());
						rate1 = Float.parseFloat(Students.get(14).getRate());
					}

					// AUD
					else if (selState.equals("AUD") && selState1.equals("JPY")) {
						rate2 = Float.parseFloat(Students.get(1).getRate());
						rate1 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("AUD") && selState1.equals("AUD")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("AUD") && selState1.equals("USD")) {
						rate2 = Float.parseFloat(Students.get(0).getRate());
						rate1 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("AUD") && selState1.equals("EUR")) {
						rate2 = (float) 1.0;
						rate1 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("AUD") && selState1.equals("GBP")) {
						rate2 = Float.parseFloat(Students.get(5).getRate());
						rate1 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("AUD") && selState1.equals("CHF")) {
						rate2 = Float.parseFloat(Students.get(11).getRate());
						rate1 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("AUD") && selState1.equals("RUB")) {
						rate2 = Float.parseFloat(Students.get(14).getRate());
						rate1 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("AUD") && selState1.equals("BRL")) {
						rate2 = Float.parseFloat(Students.get(17).getRate());
						rate1 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("AUD") && selState1.equals("CAD")) {
						rate2 = Float.parseFloat(Students.get(18).getRate());
						rate1 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("AUD") && selState1.equals("CNY")) {
						rate2 = Float.parseFloat(Students.get(19).getRate());
						rate1 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("AUD") && selState1.equals("HKD")) {
						rate2 = Float.parseFloat(Students.get(20).getRate());
						rate1 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("AUD") && selState1.equals("INR")) {
						rate2 = Float.parseFloat(Students.get(23).getRate());
						rate1 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("AUD") && selState1.equals("MXN")) {
						rate2 = Float.parseFloat(Students.get(25).getRate());
						rate1 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("AUD") && selState1.equals("MYR")) {
						rate2 = Float.parseFloat(Students.get(26).getRate());
						rate1 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("AUD") && selState1.equals("NZD")) {
						rate2 = Float.parseFloat(Students.get(27).getRate());
						rate1 = Float.parseFloat(Students.get(16).getRate());
					} else if (selState.equals("AUD") && selState1.equals("SGD")) {
						rate2 = Float.parseFloat(Students.get(29).getRate());
						rate1 = Float.parseFloat(Students.get(16).getRate());
					}

					// BRL
					else if (selState.equals("BRL") && selState1.equals("JPY")) {
						rate2 = Float.parseFloat(Students.get(1).getRate());
						rate1 = Float.parseFloat(Students.get(17).getRate());
					} else if (selState.equals("BRL") && selState1.equals("BRL")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("BRL") && selState1.equals("USD")) {
						rate2 = Float.parseFloat(Students.get(0).getRate());
						rate1 = Float.parseFloat(Students.get(17).getRate());
					} else if (selState.equals("BRL") && selState1.equals("EUR")) {
						rate2 = (float) 1.0;
						rate1 = Float.parseFloat(Students.get(17).getRate());
					} else if (selState.equals("BRL") && selState1.equals("GBP")) {
						rate2 = Float.parseFloat(Students.get(5).getRate());
						rate1 = Float.parseFloat(Students.get(17).getRate());
					} else if (selState.equals("BRL") && selState1.equals("CHF")) {
						rate2 = Float.parseFloat(Students.get(11).getRate());
						rate1 = Float.parseFloat(Students.get(17).getRate());
					} else if (selState.equals("BRL") && selState1.equals("AUD")) {
						rate2 = Float.parseFloat(Students.get(16).getRate());
						rate1 = Float.parseFloat(Students.get(17).getRate());
					} else if (selState.equals("BRL") && selState1.equals("CAD")) {
						rate2 = Float.parseFloat(Students.get(18).getRate());
						rate1 = Float.parseFloat(Students.get(17).getRate());
					} else if (selState.equals("BRL") && selState1.equals("CNY")) {
						rate2 = Float.parseFloat(Students.get(19).getRate());
						rate1 = Float.parseFloat(Students.get(17).getRate());
					} else if (selState.equals("BRL") && selState1.equals("HKD")) {
						rate2 = Float.parseFloat(Students.get(20).getRate());
						rate1 = Float.parseFloat(Students.get(17).getRate());
					} else if (selState.equals("BRL") && selState1.equals("INR")) {
						rate2 = Float.parseFloat(Students.get(23).getRate());
						rate1 = Float.parseFloat(Students.get(17).getRate());
					} else if (selState.equals("BRL") && selState1.equals("MXN")) {
						rate2 = Float.parseFloat(Students.get(25).getRate());
						rate1 = Float.parseFloat(Students.get(17).getRate());
					} else if (selState.equals("BRL") && selState1.equals("MYR")) {
						rate2 = Float.parseFloat(Students.get(26).getRate());
						rate1 = Float.parseFloat(Students.get(17).getRate());
					} else if (selState.equals("BRL") && selState1.equals("NZD")) {
						rate2 = Float.parseFloat(Students.get(27).getRate());
						rate1 = Float.parseFloat(Students.get(17).getRate());
					} else if (selState.equals("BRL") && selState1.equals("SGD")) {
						rate2 = Float.parseFloat(Students.get(29).getRate());
						rate1 = Float.parseFloat(Students.get(17).getRate());
					}

					// CAD
					else if (selState.equals("CAD") && selState1.equals("JPY")) {
						rate2 = Float.parseFloat(Students.get(1).getRate());
						rate1 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("CAD") && selState1.equals("CAD")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("CAD") && selState1.equals("USD")) {
						rate2 = Float.parseFloat(Students.get(18).getRate());
						rate1 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("CAD") && selState1.equals("EUR")) {
						rate2 = (float) 1.0;
						rate1 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("CAD") && selState1.equals("GBP")) {
						rate2 = Float.parseFloat(Students.get(18).getRate());
						rate1 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("CAD") && selState1.equals("CHF")) {
						rate2 = Float.parseFloat(Students.get(11).getRate());
						rate1 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("CAD") && selState1.equals("RUB")) {
						rate2 = Float.parseFloat(Students.get(14).getRate());
						rate1 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("CAD") && selState1.equals("AUD")) {
						rate2 = Float.parseFloat(Students.get(16).getRate());
						rate1 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("CAD") && selState1.equals("BRL")) {
						rate2 = Float.parseFloat(Students.get(17).getRate());
						rate1 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("CAD") && selState1.equals("CNY")) {
						rate2 = Float.parseFloat(Students.get(19).getRate());
						rate1 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("CAD") && selState1.equals("HKD")) {
						rate2 = Float.parseFloat(Students.get(20).getRate());
						rate1 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("CAD") && selState1.equals("INR")) {
						rate2 = Float.parseFloat(Students.get(23).getRate());
						rate1 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("CAD") && selState1.equals("MXN")) {
						rate2 = Float.parseFloat(Students.get(25).getRate());
						rate1 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("CAD") && selState1.equals("MYR")) {
						rate2 = Float.parseFloat(Students.get(26).getRate());
						rate1 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("CAD") && selState1.equals("NZD")) {
						rate2 = Float.parseFloat(Students.get(27).getRate());
						rate1 = Float.parseFloat(Students.get(18).getRate());
					} else if (selState.equals("CAD") && selState1.equals("SGD")) {
						rate2 = Float.parseFloat(Students.get(29).getRate());
						rate1 = Float.parseFloat(Students.get(18).getRate());
					}

					// CNY
					else if (selState.equals("CNY") && selState1.equals("JPY")) {
						rate2 = Float.parseFloat(Students.get(1).getRate());
						rate1 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("CNY") && selState1.equals("CNY")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("CNY") && selState1.equals("USD")) {
						rate2 = Float.parseFloat(Students.get(0).getRate());
						rate1 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("CNY") && selState1.equals("EUR")) {
						rate2 = (float) 1.0;
						rate1 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("CNY") && selState1.equals("GBP")) {
						rate2 = Float.parseFloat(Students.get(5).getRate());
						rate1 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("CNY") && selState1.equals("CHF")) {
						rate2 = Float.parseFloat(Students.get(11).getRate());
						rate1 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("CNY") && selState1.equals("RUB")) {
						rate2 = Float.parseFloat(Students.get(14).getRate());
						rate1 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("CNY") && selState1.equals("AUD")) {
						rate2 = Float.parseFloat(Students.get(16).getRate());
						rate1 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("CNY") && selState1.equals("BRL")) {
						rate2 = Float.parseFloat(Students.get(17).getRate());
						rate1 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("CNY") && selState1.equals("CAD")) {
						rate2 = Float.parseFloat(Students.get(18).getRate());
						rate1 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("CNY") && selState1.equals("HKD")) {
						rate2 = Float.parseFloat(Students.get(20).getRate());
						rate1 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("CNY") && selState1.equals("INR")) {
						rate2 = Float.parseFloat(Students.get(23).getRate());
						rate1 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("CNY") && selState1.equals("MXN")) {
						rate2 = Float.parseFloat(Students.get(25).getRate());
						rate1 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("CNY") && selState1.equals("MYR")) {
						rate2 = Float.parseFloat(Students.get(26).getRate());
						rate1 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("CNY") && selState1.equals("NZD")) {
						rate2 = Float.parseFloat(Students.get(27).getRate());
						rate1 = Float.parseFloat(Students.get(19).getRate());
					} else if (selState.equals("CNY") && selState1.equals("SGD")) {
						rate2 = Float.parseFloat(Students.get(29).getRate());
						rate1 = Float.parseFloat(Students.get(19).getRate());
					}

					// HKD
					else if (selState.equals("HKD") && selState1.equals("JPY")) {
						rate2 = Float.parseFloat(Students.get(1).getRate());
						rate1 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("HKD") && selState1.equals("HKD")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("HKD") && selState1.equals("USD")) {
						rate2 = Float.parseFloat(Students.get(0).getRate());
						rate1 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("HKD") && selState1.equals("EUR")) {
						rate2 = (float) 1.0;
						rate1 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("HKD") && selState1.equals("GBP")) {
						rate2 = Float.parseFloat(Students.get(5).getRate());
						rate1 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("HKD") && selState1.equals("CHF")) {
						rate2 = Float.parseFloat(Students.get(11).getRate());
						rate1 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("HKD") && selState1.equals("RUB")) {
						rate2 = Float.parseFloat(Students.get(14).getRate());
						rate1 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("HKD") && selState1.equals("AUD")) {
						rate2 = Float.parseFloat(Students.get(16).getRate());
						rate1 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("HKD") && selState1.equals("BRL")) {
						rate2 = Float.parseFloat(Students.get(17).getRate());
						rate1 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("HKD") && selState1.equals("CAD")) {
						rate2 = Float.parseFloat(Students.get(18).getRate());
						rate1 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("HKD") && selState1.equals("CNY")) {
						rate2 = Float.parseFloat(Students.get(19).getRate());
						rate1 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("HKD") && selState1.equals("INR")) {
						rate2 = Float.parseFloat(Students.get(23).getRate());
						rate1 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("HKD") && selState1.equals("MXN")) {
						rate2 = Float.parseFloat(Students.get(25).getRate());
						rate1 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("HKD") && selState1.equals("MYR")) {
						rate2 = Float.parseFloat(Students.get(26).getRate());
						rate1 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("HKD") && selState1.equals("NZD")) {
						rate2 = Float.parseFloat(Students.get(27).getRate());
						rate1 = Float.parseFloat(Students.get(20).getRate());
					} else if (selState.equals("HKD") && selState1.equals("SGD")) {
						rate2 = Float.parseFloat(Students.get(29).getRate());
						rate1 = Float.parseFloat(Students.get(20).getRate());
					}

					// INR

					else if (selState.equals("INR") && selState1.equals("JPY")) {
						rate2 = Float.parseFloat(Students.get(1).getRate());
						rate1 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("INR") && selState1.equals("INR")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("INR") && selState1.equals("USD")) {
						rate2 = Float.parseFloat(Students.get(0).getRate());
						rate1 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("INR") && selState1.equals("EUR")) {
						rate2 = (float) 1.0;
						rate1 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("INR") && selState1.equals("GBP")) {
						rate2 = Float.parseFloat(Students.get(5).getRate());
						rate1 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("INR") && selState1.equals("CHF")) {
						rate2 = Float.parseFloat(Students.get(11).getRate());
						rate1 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("INR") && selState1.equals("RUB")) {
						rate2 = Float.parseFloat(Students.get(14).getRate());
						rate1 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("INR") && selState1.equals("AUD")) {
						rate2 = Float.parseFloat(Students.get(16).getRate());
						rate1 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("INR") && selState1.equals("BRL")) {
						rate2 = Float.parseFloat(Students.get(17).getRate());
						rate1 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("INR") && selState1.equals("CAD")) {
						rate2 = Float.parseFloat(Students.get(18).getRate());
						rate1 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("INR") && selState1.equals("CNY")) {
						rate2 = Float.parseFloat(Students.get(19).getRate());
						rate1 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("INR") && selState1.equals("HKD")) {
						rate2 = Float.parseFloat(Students.get(20).getRate());
						rate1 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("INR") && selState1.equals("MXN")) {
						rate2 = Float.parseFloat(Students.get(25).getRate());
						rate1 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("INR") && selState1.equals("MYR")) {
						rate2 = Float.parseFloat(Students.get(26).getRate());
						rate1 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("INR") && selState1.equals("NZD")) {
						rate2 = Float.parseFloat(Students.get(27).getRate());
						rate1 = Float.parseFloat(Students.get(23).getRate());
					} else if (selState.equals("INR") && selState1.equals("SGD")) {
						rate2 = Float.parseFloat(Students.get(29).getRate());
						rate1 = Float.parseFloat(Students.get(23).getRate());
					}

					// MXN
					else if (selState.equals("MXN") && selState1.equals("JPY")) {
						rate2 = Float.parseFloat(Students.get(1).getRate());
						rate1 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("MXN") && selState1.equals("MXN")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("MXN") && selState1.equals("USD")) {
						rate2 = Float.parseFloat(Students.get(0).getRate());
						rate1 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("MXN") && selState1.equals("EUR")) {
						rate2 = (float) 1.0;
						rate1 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("MXN") && selState1.equals("GBP")) {
						rate2 = Float.parseFloat(Students.get(5).getRate());
						rate1 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("MXN") && selState1.equals("CHF")) {
						rate2 = Float.parseFloat(Students.get(11).getRate());
						rate1 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("MXN") && selState1.equals("RUB")) {
						rate2 = Float.parseFloat(Students.get(14).getRate());
						rate1 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("MXN") && selState1.equals("AUD")) {
						rate2 = Float.parseFloat(Students.get(16).getRate());
						rate1 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("MXN") && selState1.equals("BRL")) {
						rate2 = Float.parseFloat(Students.get(17).getRate());
						rate1 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("MXN") && selState1.equals("CAD")) {
						rate2 = Float.parseFloat(Students.get(18).getRate());
						rate1 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("MXN") && selState1.equals("CNY")) {
						rate2 = Float.parseFloat(Students.get(19).getRate());
						rate1 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("MXN") && selState1.equals("HKD")) {
						rate2 = Float.parseFloat(Students.get(20).getRate());
						rate1 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("MXN") && selState1.equals("INR")) {
						rate2 = Float.parseFloat(Students.get(23).getRate());
						rate1 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("MXN") && selState1.equals("MYR")) {
						rate2 = Float.parseFloat(Students.get(26).getRate());
						rate1 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("MXN") && selState1.equals("NZD")) {
						rate2 = Float.parseFloat(Students.get(27).getRate());
						rate1 = Float.parseFloat(Students.get(25).getRate());
					} else if (selState.equals("MXN") && selState1.equals("SGD")) {
						rate2 = Float.parseFloat(Students.get(27).getRate());
						rate1 = Float.parseFloat(Students.get(25).getRate());
					}

					// MYR

					else if (selState.equals("MYR") && selState1.equals("JPY")) {
						rate2 = Float.parseFloat(Students.get(26).getRate());
						rate1 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("MYR") && selState1.equals("MYR")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("MYR") && selState1.equals("USD")) {
						rate2 = Float.parseFloat(Students.get(0).getRate());
						rate1 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("MYR") && selState1.equals("EUR")) {
						rate2 = (float) 1.0;
						rate1 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("MYR") && selState1.equals("GBP")) {
						rate2 = Float.parseFloat(Students.get(5).getRate());
						rate1 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("MYR") && selState1.equals("CHF")) {
						rate2 = Float.parseFloat(Students.get(11).getRate());
						rate1 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("MYR") && selState1.equals("RUB")) {
						rate2 = Float.parseFloat(Students.get(14).getRate());
						rate1 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("MYR") && selState1.equals("AUD")) {
						rate2 = Float.parseFloat(Students.get(16).getRate());
						rate1 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("MYR") && selState1.equals("BRL")) {
						rate2 = Float.parseFloat(Students.get(17).getRate());
						rate1 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("MYR") && selState1.equals("CAD")) {
						rate2 = Float.parseFloat(Students.get(18).getRate());
						rate1 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("MYR") && selState1.equals("CNY")) {
						rate2 = Float.parseFloat(Students.get(19).getRate());
						rate1 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("MYR") && selState1.equals("HKD")) {
						rate2 = Float.parseFloat(Students.get(20).getRate());
						rate1 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("MYR") && selState1.equals("MXN")) {
						rate2 = Float.parseFloat(Students.get(25).getRate());
						rate1 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("MYR") && selState1.equals("INR")) {
						rate2 = Float.parseFloat(Students.get(23).getRate());
						rate1 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("MYR") && selState1.equals("NZD")) {
						rate2 = Float.parseFloat(Students.get(27).getRate());
						rate1 = Float.parseFloat(Students.get(26).getRate());
					} else if (selState.equals("MYR") && selState1.equals("SGD")) {
						rate2 = Float.parseFloat(Students.get(29).getRate());
						rate1 = Float.parseFloat(Students.get(26).getRate());
					}

					// NZD
					else if (selState.equals("NZD") && selState1.equals("JPY")) {
						rate2 = Float.parseFloat(Students.get(1).getRate());
						rate1 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("NZD") && selState1.equals("USD")) {
						rate2 = Float.parseFloat(Students.get(0).getRate());
						rate1 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("NZD") && selState1.equals("EUR")) {
						rate2 = (float) 1.0;
						rate1 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("NZD") && selState1.equals("GBP")) {
						rate2 = Float.parseFloat(Students.get(5).getRate());
						rate1 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("NZD") && selState1.equals("CHF")) {
						rate2 = Float.parseFloat(Students.get(11).getRate());
						rate1 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("NZD") && selState1.equals("RUB")) {
						rate2 = Float.parseFloat(Students.get(14).getRate());
						rate1 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("NZD") && selState1.equals("AUD")) {
						rate2 = Float.parseFloat(Students.get(16).getRate());
						rate1 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("NZD") && selState1.equals("BRL")) {
						rate2 = Float.parseFloat(Students.get(17).getRate());
						rate1 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("NZD") && selState1.equals("CAD")) {
						rate2 = Float.parseFloat(Students.get(18).getRate());
						rate1 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("NZD") && selState1.equals("CNY")) {
						rate2 = Float.parseFloat(Students.get(19).getRate());
						rate1 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("NZD") && selState1.equals("HKD")) {
						rate2 = Float.parseFloat(Students.get(20).getRate());
						rate1 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("NZD") && selState1.equals("INR")) {
						rate2 = Float.parseFloat(Students.get(23).getRate());
						rate1 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("NZD") && selState1.equals("MXN")) {
						rate2 = Float.parseFloat(Students.get(25).getRate());
						rate1 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("NZD") && selState1.equals("MYR")) {
						rate2 = Float.parseFloat(Students.get(26).getRate());
						rate1 = Float.parseFloat(Students.get(27).getRate());
					} else if (selState.equals("NZD") && selState1.equals("NZD")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("NZD") && selState1.equals("SGD")) {
						rate2 = Float.parseFloat(Students.get(29).getRate());
						rate1 = Float.parseFloat(Students.get(27).getRate());
					}

					// SGD
					else if (selState.equals("SGD") && selState1.equals("JPY")) {
						rate2 = Float.parseFloat(Students.get(1).getRate());
						rate1 = Float.parseFloat(Students.get(29).getRate());
					} else if (selState.equals("SGD") && selState1.equals("USD")) {
						rate2 = Float.parseFloat(Students.get(0).getRate());
						rate1 = Float.parseFloat(Students.get(29).getRate());
					} else if (selState.equals("SGD") && selState1.equals("EUR")) {
						rate2 = (float) 1.0;
						rate1 = Float.parseFloat(Students.get(29).getRate());
					} else if (selState.equals("SGD") && selState1.equals("GBP")) {
						rate2 = Float.parseFloat(Students.get(5).getRate());
						rate1 = Float.parseFloat(Students.get(29).getRate());
					} else if (selState.equals("SGD") && selState1.equals("CHF")) {
						rate2 = Float.parseFloat(Students.get(11).getRate());
						rate1 = Float.parseFloat(Students.get(29).getRate());
					} else if (selState.equals("SGD") && selState1.equals("RUB")) {
						rate2 = Float.parseFloat(Students.get(14).getRate());
						rate1 = Float.parseFloat(Students.get(29).getRate());
					} else if (selState.equals("SGD") && selState1.equals("AUD")) {
						rate2 = Float.parseFloat(Students.get(16).getRate());
						rate1 = Float.parseFloat(Students.get(29).getRate());
					} else if (selState.equals("SGD") && selState1.equals("BRL")) {
						rate2 = Float.parseFloat(Students.get(17).getRate());
						rate1 = Float.parseFloat(Students.get(29).getRate());
					} else if (selState.equals("SGD") && selState1.equals("CAD")) {
						rate2 = Float.parseFloat(Students.get(18).getRate());
						rate1 = Float.parseFloat(Students.get(29).getRate());
					} else if (selState.equals("SGD") && selState1.equals("CNY")) {
						rate2 = Float.parseFloat(Students.get(19).getRate());
						rate1 = Float.parseFloat(Students.get(29).getRate());
					} else if (selState.equals("SGD") && selState1.equals("HKD")) {
						rate2 = Float.parseFloat(Students.get(20).getRate());
						rate1 = Float.parseFloat(Students.get(29).getRate());
					} else if (selState.equals("SGD") && selState1.equals("INR")) {
						rate2 = Float.parseFloat(Students.get(23).getRate());
						rate1 = Float.parseFloat(Students.get(29).getRate());
					} else if (selState.equals("SGD") && selState1.equals("MXN")) {
						rate2 = Float.parseFloat(Students.get(25).getRate());
						rate1 = Float.parseFloat(Students.get(29).getRate());
					} else if (selState.equals("SGD") && selState1.equals("NZD")) {
						rate2 = Float.parseFloat(Students.get(27).getRate());
						rate1 = Float.parseFloat(Students.get(29).getRate());
					} else if (selState.equals("SGD") && selState1.equals("SGD")) {
						rate1 = (float) 1.0;
						rate2 = (float) 1.0;
					} else if (selState.equals("SGD") && selState1.equals("MYR")) {
						rate2 = Float.parseFloat(Students.get(29).getRate());
						rate1 = Float.parseFloat(Students.get(29).getRate());
					}
					rate3 = (rate2 / rate1) * inputValue;
					text1.setText(String.valueOf(rate3));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub

			}

		}
