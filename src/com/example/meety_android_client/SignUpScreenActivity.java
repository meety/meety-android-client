package com.example.meety_android_client;

import android.app.Activity;
import android.os.Bundle;

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
		
		System.out.println("¿?¿?¿?¿?¿?¿?¿?¿?¿?¿ Sign Up Screen ?¿?¿?¿?¿?¿?¿?¿?¿?¿?");
	}



//	private Activity getThis(){
//		return this;
//	}
	

}