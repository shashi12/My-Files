package com.shashi.android.androidutility;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import android.widget.TableRow.LayoutParams;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class MainActivityGrocery extends Activity{
	private EditText text1;
	private EditText text2;
	private EditText text3;
	private EditText text4;
	private EditText text5;
	private EditText text6;
	private EditText text7;
	private Spinner spinner01;
	private Spinner spinner02; 
	TableLayout table_layout;
	TableLayout table_layout2;
	Button btnOk;
	ProgressDialog PD;
	Button addBill;
	String selState01, selState02;
	float inputUnit,inputPrice,outputUnit,outputPrice;
	List<GorceryDetails> grocerylist;
	//GorceryDetails grocery;
	DatabaseHandler sqlcon;
	boolean result=false;
	
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
		Button addBill =(Button) findViewById(R.id.button2);
		Button update =(Button) findViewById(R.id.button3);
		table_layout = (TableLayout) findViewById(R.id.tableLayout1);
		DatabaseHandler sqlcon=new DatabaseHandler(this);
	    addItemsOnSpinner();
	    
	    update.setClickable(false);
	    update.setEnabled(false);
	    
	    btnOk.setOnClickListener(new OnClickListener() {

			public void onClick(View view){
				try {
					onclickshashi();
				}catch(Exception e){
					e.printStackTrace();
				}
			}	
		});	
	    setOnClick(addBill, sqlcon);
	    buildTable(sqlcon);    
	}
	
	 private void setOnClick(final Button btn, final DatabaseHandler sqlcon2){
			btn.setOnClickListener(new OnClickListener() {

				public void onClick(View view){
					try {	
						Mysync(sqlcon2);
					}catch(Exception e){
						e.printStackTrace();
					}
				}		
			});	
			
		    }
	 
	private void buildTable(DatabaseHandler sqlcon1) {
		table_layout.removeAllViews();
		 grocerylist=sqlcon1.getAllGrocery();
		 
		 TableRow tr_head1 = new TableRow(this);
			tr_head1.setId(10);
			tr_head1.setBackgroundColor(Color.GRAY);
			tr_head1.setLayoutParams(new LayoutParams(
			LayoutParams.MATCH_PARENT,
			LayoutParams.WRAP_CONTENT));
		 
		 TextView label_d1 = new TextView(this);
	        label_d1.setId(30);
	        label_d1.setText("Id");
	        label_d1.setTextColor(Color.WHITE);
	        label_d1.setPadding(5, 5, 5, 5);
	        tr_head1.addView(label_d1);// add the column to the table row here
			
			TextView label_date1 = new TextView(this);
	        label_date1.setId(31);
	        label_date1.setText("Unit");
	        label_date1.setTextColor(Color.WHITE);
	        label_date1.setPadding(5, 5, 5, 5);
	        tr_head1.addView(label_date1);// add the column to the table row here
			
	        
	        TextView label_weight_kg1 = new TextView(this);
	        label_weight_kg1.setId(32);// define id that must be unique
	        label_weight_kg1.setText("Item"); // set the text for the header 
	        label_weight_kg1.setTextColor(Color.WHITE); // set the color
	        label_weight_kg1.setPadding(5, 5, 5, 5); // set the padding (if required)
	        tr_head1.addView(label_weight_kg1); // add the column to the table row here
	        
	        TextView label_weight1= new TextView(this);
	        label_weight1.setId(33);// define id that must be unique
	        label_weight1.setText("Price"); // set the text for the header 
	        label_weight1.setTextColor(Color.WHITE); // set the color
	        label_weight1.setPadding(5, 5, 5, 5); // set the padding (if required)
	        tr_head1.addView(label_weight1); // add the column to the table row here 
		 
	        table_layout.addView(tr_head1, new TableLayout.LayoutParams(
	                LayoutParams.MATCH_PARENT,
	                LayoutParams.WRAP_CONTENT));
		 
		for(GorceryDetails gn:grocerylist){
			TableRow tr_head = new TableRow(this);
			tr_head.setId(10);
			tr_head.setBackgroundColor(Color.GRAY);
			tr_head.setLayoutParams(new LayoutParams(
			LayoutParams.MATCH_PARENT,
			LayoutParams.WRAP_CONTENT));
			
			
			TextView label_d = new TextView(this);
	        label_d.setId(20);
	        label_d.setText(Integer.toString(gn.getID()));
	        label_d.setTextColor(Color.WHITE);
	        label_d.setPadding(5, 5, 5, 5);
	        tr_head.addView(label_d);// add the column to the table row here
			
			TextView label_date = new TextView(this);
	        label_date.setId(21);
	        label_date.setText(gn.getUnit());
	        label_date.setTextColor(Color.WHITE);
	        label_date.setPadding(5, 5, 5, 5);
	        tr_head.addView(label_date);// add the column to the table row here
			
	        
	        TextView label_weight_kg = new TextView(this);
	        label_weight_kg.setId(22);// define id that must be unique
	        label_weight_kg.setText(Float.toString(gn.getItem())); // set the text for the header 
	        label_weight_kg.setTextColor(Color.WHITE); // set the color
	        label_weight_kg.setPadding(5, 5, 5, 5); // set the padding (if required)
	        tr_head.addView(label_weight_kg); // add the column to the table row here
	        
	        TextView label_weight= new TextView(this);
	        label_weight.setId(23);// define id that must be unique
	        float a=roundTwoDecimals(gn.getPrice());
	        label_weight.setText(Float.toString(a)); // set the text for the header 
	        label_weight.setTextColor(Color.WHITE); // set the color
	        label_weight.setPadding(5, 5, 5, 5); // set the padding (if required)
	        tr_head.addView(label_weight); // add the column to the table row here
	        
	        
	        Button edit_butt= new Button(this);
	        edit_butt.setId(24);
	        edit_butt.setText("Edit"); // set the text for the header 
	        edit_butt.setTextColor(Color.WHITE); // set the color
	        edit_butt.setPadding(5, 5, 5, 5); // set the padding (if required)
	        edit_butt.setLayoutParams(new LayoutParams(10, 50));
	        setedit_button(edit_butt,sqlcon1,gn.getID());
	        tr_head.addView(edit_butt); // add the column to the table row here

	        table_layout.addView(tr_head, new TableLayout.LayoutParams(
	                LayoutParams.MATCH_PARENT,
	                LayoutParams.WRAP_CONTENT));
		}

        
	}

	private void setedit_button(final Button btn,final DatabaseHandler sqlcon3, final int i){
		btn.setOnClickListener(new OnClickListener() {

			public void onClick(View view){
				try {	
					Update_Database(sqlcon3,i);
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}	
		});	
		
	    }

	float roundTwoDecimals(float d) {
		  DecimalFormat twoDForm = new DecimalFormat("#.##");
		  return Float.valueOf(twoDForm.format(d));
		}
	
	private void Update_Database(final DatabaseHandler sqlcon4, int i) {
		
		
		GorceryDetails gor=new GorceryDetails();
		gor=sqlcon4.getGrocery(i);
		text6.setText(String.valueOf(gor.getItem()));
		if(gor.getUnit()=="kgs")
			spinner02.setId(1);
		else
			spinner02.setId(2);
		text7.setText(String.valueOf(gor.getPrice()));
		}	

	  public void btn4Listener(View v) {
				try {	
					float item,price;
					String unit;
					item=Float.valueOf(text6.getText().toString());
					price=Float.valueOf(text7.getText().toString());
					unit=spinner02.getSelectedItem().toString();  
					//GorceryDetails grocery=new GorceryDetails(unit,item,price);
					  int i=sqlcon5.updateGrocery(new GorceryDetails(unit,item,price));
					  buildTable(sqlcon5);   
				}catch(Exception e){
					e.printStackTrace();
				}
			}		
		

	private void addItemsOnSpinner() {
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
	
	
	private void Mysync(DatabaseHandler sqlcon3) {
		float item,price;
		String unit;
		
		  //table_layout.removeAllViews();
		item=Float.valueOf(text6.getText().toString());
		price=Float.valueOf(text7.getText().toString());
		unit=spinner02.getSelectedItem().toString();  
		//GorceryDetails grocery=new GorceryDetails(unit,item,price);
		  
		  
		 
		  sqlcon3.addGrocery(new GorceryDetails(unit,item,price));
		  buildTable(sqlcon3); 
		   
	}
	
	
	/*private class MyAsync extends AsyncTask<Void, Void, Void> {

		  @Override
		  protected void onPreExecute() {

		   super.onPreExecute();

		  table_layout.removeAllViews();

		   PD = new ProgressDialog(MainActivityGrocery.this);
		   PD.setTitle("Please Wait..");
		   PD.setMessage("Loading...");
		   PD.setCancelable(false);
		   PD.show();
		  }
		  @Override
		  protected Void doInBackground(Void... params) {
	      GorceryDetails grocery=new GorceryDetails();
		  grocery.to_item=Float.valueOf(text6.getText().toString());
		  grocery.to_price=Float.valueOf(text7.getText().toString());
		  grocery.to_unit=spinner02.getSelectedItem().toString();
		  
		 
		   sqlcon.addGrocery(grocery);
		   // BuildTable();
		   return null;
		  }

		  @Override
		  protected void onPostExecute(Void result) {
		   super.onPostExecute(result);
		   buildTable();
		 //  PD.dismiss();
		  }
	}*/
	
	
}