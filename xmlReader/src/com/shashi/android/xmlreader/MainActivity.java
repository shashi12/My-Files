package com.shashi.android.xmlreader;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class MainActivity extends ListActivity {

	static final String URL = "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
	static final String KEY_CUBE = "Cube"; // parent node
	static final String KEY_GME = "gesmes:Envelope";
	static final String KEY_SEND="gesmes:Sender";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();
		XMLParser parser = new XMLParser();
		String xml = parser.getXmlFromUrl(URL); // getting XML
		Document doc = parser.getDomElement(xml); // getting DOM element
	
	/*	
		NodeList nl = doc.getElementsByTagName(KEY_GME);
		for (int i = 0; i < nl.getLength(); i++) {
			if(nl.item(i)==doc.getElementsByTagName(KEY_CUBE)){
			HashMap<String, String> map = new HashMap<String, String>();
			Element e = (Element) nl.item(i);
			
			map.put(KEY_CUBE, parser.getValue(e, KEY_CUBE));
			menuItems.add(map);
		}}
	
	/*	ListAdapter adapter = new SimpleAdapter(this, menuItems,R.layout.list_item,
				new String[] { KEY_CUBE }, new int[] {R.id.name});

		setListAdapter(adapter);

		// selecting single ListView item
		ListView lv = getListView();
	
	lv.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view,
				int position, long id) {
			// getting values from selected ListItem
			String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
					
			// Starting new intent
			Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
			in.putExtra(KEY_CUBE, name);
			startActivity(in);

		}
	});*/
	

	}
}
