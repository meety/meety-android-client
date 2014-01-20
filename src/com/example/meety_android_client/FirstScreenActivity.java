package com.example.meety_android_client;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class FirstScreenActivity extends Activity {

	//Future plans: these texts will be set depending on the user language
	private String userName;
	private final String passwordDefault = "meety";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_first_screen);
		
		setTextByLanguage();
		final EditText userNameText = (EditText) findViewById(R.id.text_username);
		final EditText passwordText = (EditText) findViewById(R.id.text_password);
		userNameText.setText(userName);
		passwordText.setText(passwordDefault);
		
		final Button logInButton = (Button) findViewById(R.id.button_log_in);
		
		System.out.println("Log In Button created");
		logInButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Log In Button click");
                System.out.println("Username: " + userNameText.getText());
                System.out.println("Password: " + passwordText.getText());
                System.out.println("========================================");
            }
        });
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

	}
	
	//dummy method to set user language for texts
	private void setTextByLanguage(){
		userName = "username";
	}

}