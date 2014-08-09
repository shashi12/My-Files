package com.shashi.android.androidutility;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ListMobileActivity extends ListActivity {
	 
	static final String[] Convert_Util = 
               new String[] { "Temperature", "Storage", "Speed", "Mass","Length","Area","Currency","Grocery"};
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		setListAdapter(new MobileArrayAdapter(this, Convert_Util));
 
	}
 
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
 
		//get selected items
		String selectedValue = (String) getListAdapter().getItem(position);
		Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
		
		if(selectedValue=="Temperature"){
			Intent intent = new Intent(this, MainActivityTemperature.class);
            startActivity(intent);  
		}else if(selectedValue=="Length"){
       	 	Intent intent1 = new Intent(this, MainActivityLength.class);
       	 	startActivity(intent1);
		}else if(selectedValue=="Storage"){
			Intent intent2 = new Intent(this, MainActivityStorage.class);
			startActivity(intent2);
		}else if(selectedValue=="Area"){
    	 	Intent intent3 = new Intent(this, MainActivityArea.class);
    	 	startActivity(intent3);
		}else if(selectedValue=="Speed"){
			Intent intent4 = new Intent(this, MainActivitySpeed.class);
			startActivity(intent4);
		}else if(selectedValue=="Mass"){
			Intent intent5 = new Intent(this, MainActivityMass.class);
			startActivity(intent5);
		}else if(selectedValue=="Currency"){
			Intent intent6 = new Intent(this, MainActivityCurrency.class);
			startActivity(intent6);
		}else if(selectedValue=="Grocery"){
			Intent intent7 = new Intent(this, MainActivityGrocery.class);
			startActivity(intent7);
		}else{
    	 
		}
 
	}
	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.activity_main_actions, menu);
	 
	        return super.onCreateOptionsMenu(menu);
	    }
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Take appropriate action for each action item click
	        switch (item.getItemId()) {
	        case R.id.action_about:
	        	Intent intent = new Intent(this, About.class);
	            startActivity(intent); 
	            // search action
	            return true;
	        case R.id.action_language_setting:
	            // location found
	            //LocationFound();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }

}