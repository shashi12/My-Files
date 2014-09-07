package com.shashi.android.androidutility;

public class GorceryDetails {
	int to_id;
	String to_unit;
	float to_item;
	float to_price;

	

	public GorceryDetails(int parseInt, String parseFloat, float parseFloat2,
			float parseFloat3) {
		this.to_id=parseInt;
		this.to_unit=parseFloat;
		this.to_item=parseFloat2;
		this.to_price=parseFloat3;
	}

	public GorceryDetails(){
	}

	
	
	public GorceryDetails(String unit,float item,float price){
	
		this.to_unit=unit;
		this.to_item=item;
		this.to_price=price;
			
	}
	
	// getting ID
    	public int getID(){
         return this.to_id;
    	}
     
	// setting id
    	public void setID(int id){
         this.to_id = id;
    	}

	// getting unit
	public String getUnit(){
		return this.to_unit;
	}
	
	// setting Unit
	public void setUnit(String unit){
		this.to_unit = unit;
	}

	// getting Item
	public float getItem(){
		return this.to_item;
	}
	
	// setting Item
	public void setItem(float item){
		this.to_item = item;
	}

	// getting Price
	public float getPrice(){
		return this.to_price;
	}
	
	// setting name
	public void setPrice(float price){
		this.to_price = price;
	}

}
