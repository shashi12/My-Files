package com.shashi.android.xmlreaderexample;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserFactory;
import com.shashi.android.xmlreaderexample.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.widget.AdapterView.OnItemSelectedListener;
import android.util.Log;
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

public class MainActivityCurrency extends Activity implements OnItemSelectedListener {
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
	List<Student> Students1 = null;
	List<Student> Student_Local=null;
	float rate1, rate2, rate3, inputValue01;
	private RadioGroup radiocheckGroup;
	Boolean isInternetPresent = false;
	ProgressDialog mProgressDialog;
	Button button_download;
	
	// Connection detector class
	Detectinternetconnection cd;

	XMLPullParserHandler parser = new XMLPullParserHandler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_convert_currency);
		Button btnOk =(Button) findViewById(R.id.button1);
		button_download = (Button) findViewById(R.id.button2);
		button_download.setOnClickListener(new OnClickListener() {
			 
	            public void onClick(View arg0) {
	                // Execute DownloadFile AsyncTask
	                new DownloadFile().execute(urlString);
	            }
	        });
		int size = 0;
		byte[] savedData = null;

		try
		{
			String FILENAME = "eurofxref-daily.xml";
			File file = new File(getFilesDir(), FILENAME);
			if (file.exists())
			   size = (int)file.length();
			
			if (size != 0)
			{
				FileInputStream inputStream = openFileInput(FILENAME);
				//savedState = new byte[size];
				//inputStream.read(savedState, 0, size);
			
		
		try{
			Students1 = parser.fetchXML(urlString);
			students = new ArrayList<Student>();
			Student_Local = parser.parse(inputStream, students);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		inputStream.close();
			}
		}
		catch (final Exception ex) { Log.e("JAVA_DEBUGGING", "Exception while reading in saved data"); ex.printStackTrace(); }
	}
	private class DownloadFile extends AsyncTask<String, Integer, String> {
		 
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create progress dialog
            mProgressDialog = new ProgressDialog(MainActivityCurrency.this);
            // Set your progress dialog Title
            mProgressDialog.setTitle("Progress Bar Tutorial");
            // Set your progress dialog Message
            mProgressDialog.setMessage("Downloading, Please Wait!");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setMax(100);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            // Show progress dialog
            mProgressDialog.show();
        }
 
        @Override
        protected String doInBackground(String... Url) {
            try {
                URL url = new URL(Url[0]);
                URLConnection connection = url.openConnection();
                connection.connect();
                int fileLength = connection.getContentLength();
                
                InputStream is = connection.getInputStream();
                BufferedInputStream inStream = new BufferedInputStream(is, 1024 * 5);
                ContextWrapper context = new ContextWrapper(getApplicationContext());
                
                File file= new File(context.getDir("filesdir", Context.MODE_PRIVATE) + "/eurofxref-daily.xml");
                if (file.exists())
                {
                    file.delete();
                }
                file.createNewFile();
                
                FileOutputStream outStream = new FileOutputStream(file);
                byte[] buff = new byte[5 * 1024];
                int len;
                long total = 0;
                while ((len = inStream.read(buff)) != -1)
                {
                	total += len;
                    publishProgress((int) (total * 100 / fileLength));
                    outStream.write(buff, 0, len);

                }

                outStream.flush();
                outStream.close();
                inStream.close();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
			return null;

                
        }
 
        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
            // Update the progress dialog
            mProgressDialog.setProgress(progress[0]);
            // Dismiss the progress dialog
            //mProgressDialog.dismiss();
        }
    }

	public void onclickshashi(){
		

		radiocheckGroup = (RadioGroup) findViewById(R.id.radioGroup1);

		int selectedId = radiocheckGroup.getCheckedRadioButtonId();
		inputValue01 = Float.parseFloat(text.getText().toString());
		selState01 = (String) spinner01.getSelectedItem();
		selState02 = (String) spinner02.getSelectedItem();
		RadioButton temperatureButton = (RadioButton) findViewById(selectedId);
		network = NetworkUtil.getConnectivityStatusString(getApplicationContext());
		cd = new Detectinternetconnection(getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet();
		//Student_Local=null;
		//Students=null;

		if( temperatureButton.getText().equals("Local") ){
			//if (!isInternetPresent) {
			Toast.makeText(this, temperatureButton.getText(),Toast.LENGTH_LONG).show();		
			//rate3=
			calculate(Student_Local,inputValue01,selState01,selState02);
		}else if( temperatureButton.getText().equals("Internet")){
			if (isInternetPresent) {
				Toast.makeText(this, temperatureButton.getText(),Toast.LENGTH_LONG).show();
					//rate3=
					calculate(Students1,inputValue01,selState01,selState02);
				} 
			else if (!isInternetPresent) { 
				Toast.makeText(this, "Not Connected To Internet, Please connect to Internet or Use Local",Toast.LENGTH_LONG).show();
				}}
		else {
		}

	}


	public void calculate(List<Student> Students,float inputValue,String selState,String selState1){

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
		//return rate3;	
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

	
	
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub

	}

	/*@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}*/

}
