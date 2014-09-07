package com.shashi.android.androidutility;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHandler extends SQLiteOpenHelper {


private static final int DATABASE_VERSION = 1;

// Database Name
private static final String DATABASE_NAME = "grocery_Manager";

// Contacts table name
private static final String TABLE_GROCERY = "grocery_Bill";

// Contacts Table Columns names
private static final String KEY_ID = "id";
private static final String KEY_UNIT = "unit";
private static final String KEY_ITEM = "item";
private static final String KEY_PRICE = "price";


public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_GROCERY_TABLE = "CREATE TABLE " + TABLE_GROCERY + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_UNIT + " TEXT,"+ KEY_ITEM + " TEXT,"
				+ KEY_PRICE + " TEXT" + ")";
		db.execSQL(CREATE_GROCERY_TABLE);
	}

// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROCERY);

		// Create tables again
		onCreate(db);
	}

/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

// Adding new contact
void addGrocery(GorceryDetails grocery) {
	SQLiteDatabase db = this.getWritableDatabase();

	ContentValues values = new ContentValues();
	values.put(KEY_UNIT, grocery.getUnit()); // Unit Name
	values.put(KEY_ITEM, grocery.getItem()); // Unit Name
	values.put(KEY_PRICE, grocery.getPrice()); // Contact Phone

	// Inserting Row
	db.insert(TABLE_GROCERY, null, values);
	db.close(); // Closing database connection
	}

// Getting single contact
   GorceryDetails getGrocery(int id) {
	SQLiteDatabase db = this.getReadableDatabase();

	Cursor cursor = db.query(TABLE_GROCERY, new String[] { KEY_ID,
				KEY_UNIT,KEY_ITEM, KEY_PRICE }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null,null, null);
		if (cursor != null)
			cursor.moveToFirst();

		GorceryDetails grocery = new GorceryDetails(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), Float.parseFloat(cursor.getString(2)),Float.parseFloat(cursor.getString(3)));
		// return grocery
		return grocery;
}



public List<GorceryDetails> getAllGrocery() {
		List<GorceryDetails> groceryList = new ArrayList<GorceryDetails>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_GROCERY;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				GorceryDetails grocery = new GorceryDetails();
				grocery.setID(Integer.parseInt(cursor.getString(0)));
				grocery.setUnit(cursor.getString(1));
				grocery.setItem(Float.parseFloat(cursor.getString(2)));
				grocery.setPrice(Float.parseFloat(cursor.getString(3)));
				// Adding contact to list
				groceryList.add(grocery);
			} while (cursor.moveToNext());
		}

		// return contact list
		return groceryList;
	}

	// Updating single contact
	public int updateGrocery(GorceryDetails grocery) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_UNIT, grocery.getUnit());
		values.put(KEY_ITEM, grocery.getItem());
		values.put(KEY_PRICE, grocery.getPrice());

		// updating row
		return db.update(TABLE_GROCERY, values, KEY_ID + " = ?",
				new String[] { String.valueOf(grocery.getID()) });
	}

	// Deleting single contact
	public void deleteGrocery(GorceryDetails grocery) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_GROCERY, KEY_ID + " = ?",
				new String[] { String.valueOf(grocery.getID()) });
		db.close();
	}


	// Getting contacts Count
	public int getGroceryCount() {
		 int count = 0;
		String countQuery = "SELECT  * FROM " + TABLE_GROCERY;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		
		if(cursor != null && !cursor.isClosed()){
	        count = cursor.getCount();
	        cursor.close();
	    }   
	    return count;

		// return count

	}
}
