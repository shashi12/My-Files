package com.shashi.android.androidutility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivityFuelUsage extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
 
	}
	
	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.activity_main_fuel_add_new, menu);
	 
	        return super.onCreateOptionsMenu(menu);
	    }
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Take appropriate action for each action item click
	        switch (item.getItemId()) {
	        case R.id.action_add:
	        	Intent intent = new Intent(this, //About.class
	        			);
	            startActivity(intent); 
	            // search action
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }
	
	
}
