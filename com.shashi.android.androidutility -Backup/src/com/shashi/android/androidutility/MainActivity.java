package com.shashi.android.androidutility;

//import com.google.ads.AdRequest;
//import com.google.ads.AdView;
import com.shashi.android.androidutility.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
             
             if (temperatureButton.isChecked()) { 
            	 Intent intent = new Intent(this, MainActivity3.class);
                 startActivity(intent);  
             }else if(lengthButton.isChecked()){
            	 Intent intent1 = new Intent(this, MainActivityLength.class);
                 startActivity(intent1);
             }else if(storageButton.isChecked()){
            	 Intent intent2 = new Intent(this, MainActivityStorage.class);
                 startActivity(intent2);
             }else{
            	 
             }
             //break;
        }

 
 // @Override
 // protected void onDestroy() {
   //  if (mAdView != null) {
    //	  mAdView.destroy();
    //   }
    //  super.onDestroy(); 
  // }
}