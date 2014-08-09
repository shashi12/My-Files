package com.shashi.android.xmlreader;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;




public class MainActivity extends Activity {
	private static String URL="http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
	private EditText currency,rate;
	private HandleXML obj;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		currency=(EditText) findViewById(R.id.editText1);
		rate=(EditText) findViewById(R.id.editText2);
	
	}

		@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

		
		public void open(View view){
		      obj = new HandleXML(URL);
		      obj.fetchXML();
		      while(obj.parsingComplete){
		    	  currency.setText(obj.getCurrency());
		    	  rate.setText(obj.getRate());
		      }
		}
}
