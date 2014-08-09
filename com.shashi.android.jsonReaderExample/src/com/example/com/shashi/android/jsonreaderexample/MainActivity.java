package com.example.com.shashi.android.jsonreaderexample;

import com.example.com.shashi.android.jsonreaderexample.R;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	private ProgressDialog pDialog;
	private static String url = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22USD%22%2C%20%22USDINR%22%2C%22GBP%22%2C%22EUR%22)&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";
	
	private static String TAG_Result = "results";
	private static String TAG_ID = "id";
	private static String TAG_NAME = "name";
	
	private static String TAG_To = "to";
	private static String TAG_Rate = "Rate";
	
	JSONArray contacts = null;
	
	ArrayList<HashMap<String, String>> contactList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		contactList = new ArrayList<HashMap<String, String>>();

		ListView lv = getListView();
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting values from selected ListItem
				String name = ((TextView) view.findViewById(R.id.name))
						.getText().toString();
				String cost = ((TextView) view.findViewById(R.id.to))
						.getText().toString();
				String description = ((TextView) view.findViewById(R.id.rate))
						.getText().toString();

				// Starting single contact activity
				Intent in = new Intent(getApplicationContext(),
						SingleContactActivity.class);
				in.putExtra(TAG_NAME, name);
				in.putExtra(TAG_To, cost);
				in.putExtra(TAG_Rate, description);
				startActivity(in);

			}
		});
		
		new GetContacts().execute();
	}
	private class GetContacts extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			pDialog = new ProgressDialog(MainActivity.this);
			pDialog.setMessage("Please wait...");
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// Creating service handler class instance
			ServiceHandler sh = new ServiceHandler();

			// Making a request to url and getting response
			String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

			Log.d("Response: ", "> " + jsonStr);

			if (jsonStr != null) {
				try {
					JSONObject jsonObj = new JSONObject(jsonStr);
					
					contacts = jsonObj.getJSONArray(TAG_Result);
					for (int i = 0; i < contacts.length(); i++) {
						JSONObject c = contacts.getJSONObject(i);
						
						String id = c.getString(TAG_ID);
						String name = c.getString(TAG_NAME);
						String to = c.getString(TAG_To);
						String rate = c.getString(TAG_Rate);
						HashMap<String, String> contact = new HashMap<String, String>();

						// adding each child node to HashMap key => value
						contact.put(TAG_ID, id);
						contact.put(TAG_NAME, name);
						contact.put(TAG_To, to);
						contact.put(TAG_Rate, rate);		
		
						contactList.add(contact);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				Log.e("ServiceHandler", "Couldn't get any data from the url");
			}

			return null;
		}
	

	protected void onPostExecute(Void result) {
		// Dismiss the progress dialog
		if (pDialog.isShowing())
			pDialog.dismiss();
		/**
		 * Updating parsed JSON data into ListView
		 * */
		ListAdapter adapter = new SimpleAdapter(
				MainActivity.this, contactList,
				R.layout.list_item, new String[] { TAG_NAME, TAG_To,
						TAG_Rate }, new int[] { R.id.name,
						R.id.to, R.id.name });

		setListAdapter(adapter);
	}

   }
}