//MainActivity.java
package com.example.targetheartratecalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private double age = 0.0;
	private int maxHeartRate = 0;
	private TextView ageDisplayTextView;
	private TextView maxHeartDisplayTextView;
	private TextView minHeartDisplayTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//call superclass's version
		setContentView(R.layout.activity_main); //inflate gui
		ageDisplayTextView = (TextView)findViewById(R.id.ageDisplayTextView);
		maxHeartDisplayTextView = (TextView)findViewById(R.id.maxHeartDisplayTextView);
		minHeartDisplayTextView = (TextView)findViewById(R.id.minHeartDisplayTextView);
				
		//String age = String.valueOf(ageDisplayTextView);
		//ageDisplayTextView.setText(age);
		
		//String max = String.valueOf(maxHeartDisplayTextView);
		//maxHeartDisplayTextView.setText(max);
		
		//String min = String.valueOf(minHeartDisplayTextView);
		//minHeartDisplayTextView.setText(min);
		
		//updateMax();
		//updateMin();
		
		EditText ageEditText = (EditText)findViewById(R.id.ageEditText);
		ageEditText.addTextChangedListener(ageEditTextWatcher);
		
	}
	
	//update Max
	private void updateMax()
	{
		//convert ageDisplayTextView to an int
		//int ageNum = Integer.valueOf(String.valueOf(ageDisplayTextView));
		
		//do math for max heart rate
		double maxHeart = 220 - age;
		
		//make it a string
		String newMax = String.valueOf(maxHeart);
		
		//set display
		maxHeartDisplayTextView.setText(newMax);
		
	}

	private void updateMin()
	{
		//convert ageDisplayTextView to an int
		//int ageNum = Integer.valueOf(String.valueOf(ageDisplayTextView));
		
		//do math for max heart rate
		double maxHeart = 220 - age;

		//do math for min heart rate and max range heart rate
		double minHeart = maxHeart *.5 ;
		double maxRange = maxHeart *.85;
		
		//create string to display
		String rangeMin = String.valueOf(minHeart);
		String rangeMax = String.valueOf(maxRange);
		
		String range = rangeMin + " to " + rangeMax;
		
		//set display
		minHeartDisplayTextView.setText(range);
		
	}
	
	//event handling entered age
	private TextWatcher ageEditTextWatcher = new TextWatcher()
	{
		//called when user enters a number
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count)
		{
			//convert age text to double
			try {
				age = Integer.valueOf(String.valueOf(s.toString()));
			} //end try
			catch (NumberFormatException e)
			{
				age = 0.0;
			}
			//display info by displaying the original input
			ageDisplayTextView.setText(s);
			//update and display the min and max
			updateMax();
			updateMin();
			
		}//end onTextChanged
		
		@Override
		public void afterTextChanged(Editable s)
		{
			
		}//end afterTextChanged
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after)
		{
			
		}//end before text changed
		
		
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
