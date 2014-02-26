package com.example.meety_android_client;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * This activity requires first name, last name, desired username and password,
 * e-mail, sexual gender, birthdate and choosen language from the user.
 * Then, all those informations are sent to the server and await 
 * for sign up confirmation
 * @author Rafael
 *
 */
public class SignUpScreenActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		
		addItemsOnSpinnerSex();
		addItemsOnSpinnerCountry();
		
		System.out.println("¿?¿?¿?¿?¿?¿?¿?¿?¿?¿ Sign Up Screen ?¿?¿?¿?¿?¿?¿?¿?¿?¿?");
	}


	private void addItemsOnSpinnerSex() {
		Spinner sp = (Spinner)findViewById(R.id.spinner_sex);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.sex_arrays, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);
	}
	
	private void addItemsOnSpinnerCountry() {
		Spinner sp = (Spinner) findViewById(R.id.spinner_country);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countries_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);
	}
	



//	private Activity getThis(){
//		return this;
//	}
	

}