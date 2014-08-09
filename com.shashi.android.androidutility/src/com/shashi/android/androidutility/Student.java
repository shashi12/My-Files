package com.shashi.android.androidutility;

public class Student {
     
	    private String currency="currency";
		//private String Cube="Cube";
		private String rate="rate";
		
		public String getCurrency(){
			return currency;
		}
		
		public String getRate(){
			return rate;
		}
		
		public void setCurrency(String currency)
		{
			this.currency=currency;
		}
		
		public void setRate(String rate){
			this.rate=rate;
		}
		
	    @Override
	    public String toString() 
	    {
	        return "Currency : " + currency +
	                " Rate : " + rate ;
	                
	    }
	
}
