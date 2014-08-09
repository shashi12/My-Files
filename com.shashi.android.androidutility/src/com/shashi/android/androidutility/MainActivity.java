package com.shashi.android.androidutility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
 
  
public class MainActivity extends Activity{
	// private AdView mAdView;
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        	
      //  mAdView = (AdView) findViewById(R.id.adView);
      // AdRequest adRequest = new AdRequest();
    		   //.Builder()
      // adRequest.addTestDevice("FF6E7E12F5BCB7838DAC43CB4C099358");
       //.build();
       //mAdView.setAdListener(new ToastAdListener(this)); 
      // mAdView.loadAd(adRequest);
        }

    public void onClick(View view) {
    	//final Context context = this;
        //switch (view.getId()) {
        //case R.id.button1:
        	 RadioButton temperatureButton = (RadioButton) findViewById(R.id.radio0);
             RadioButton lengthButton = (RadioButton) findViewById(R.id.radio1);
             RadioButton storageButton = (RadioButton) findViewById(R.id.radio2);
             RadioButton areaButton = (RadioButton) findViewById(R.id.radio3);
             RadioButton speedButton = (RadioButton) findViewById(R.id.radio4);
             RadioButton massButton = (RadioButton) findViewById(R.id.radio5);
             RadioButton currencyButton = (RadioButton) findViewById(R.id.radio6);
             
             if (temperatureButton.isChecked()) { 
            	 Intent intent = new Intent(this, MainActivityTemperature.class);
                 startActivity(intent);  
             }else if(lengthButton.isChecked()){
            	 Intent intent1 = new Intent(this, MainActivityLength.class);
                 startActivity(intent1);
             }else if(storageButton.isChecked()){
            	 Intent intent2 = new Intent(this, MainActivityStorage.class);
                 startActivity(intent2);
             }else if(areaButton.isChecked()){
            	 Intent intent3 = new Intent(this, MainActivityArea.class);
                 startActivity(intent3);
             }else if(speedButton.isChecked()){
            	 Intent intent4 = new Intent(this, MainActivitySpeed.class);
                 startActivity(intent4);
             }else if(massButton.isChecked()){
            	 Intent intent5 = new Intent(this, MainActivityMass.class);
                 startActivity(intent5);
             }else if(currencyButton.isChecked()){
            	 Intent intent6 = new Intent(this, MainActivityCurrency.class);
                 startActivity(intent6);
             }else{
            	 
             }
             //break;
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
 // @Override
 // protected void onDestroy() {
   //  if (mAdView != null) {
    //	  mAdView.destroy();
    //   }
    //  super.onDestroy(); 
  // }
}