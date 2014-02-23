package com.example.meety_android_client;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class AttemptingLogIn extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attempting_log_in);
		
		setUpActivity();
		
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				
				Intent intentFromPreviousActivity = getIntent();
				attemptLogIn(intentFromPreviousActivity);
			}

		}, 2000);
		
		//attemptLogIn(intentFromPreviousActivity);
		

	}

	private void setUpActivity() {
		TextView text_login_fail = (TextView) findViewById(R.id.text_login_fail);
		text_login_fail.setVisibility(View.GONE);
	}

	private void attemptLogIn(Intent intentFromPreviousActivity) {
		String username = intentFromPreviousActivity.getStringExtra("username");
		String password = intentFromPreviousActivity.getStringExtra("password");
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.println("USERNAME " + username);
		System.out.println("PASSWORD " + password);
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		
		//TODO send username and password to attempt login
		
		boolean authenticated = (username.equals("username") && password.equals("meety"));
		System.out.println("authenticated-----------------------" + authenticated);
		if(authenticated){
			callLoggedInActivity();
		}else{
			
			denyLogIn();	
		}	
	}

	
	private void denyLogIn() {
		TextView logo_meety = (TextView) findViewById(R.id.logo_meety);
		logo_meety.setTextColor(this.getResources().getColor(R.color.red_deny_login));
		TextView text_login_fail = (TextView) findViewById(R.id.text_login_fail);
		text_login_fail.setVisibility(View.VISIBLE);
		
		ProgressBar progressBarView = (ProgressBar) findViewById(R.id.progressBarView);
		progressBarView.setVisibility(View.GONE);
		
	}

	private void callLoggedInActivity() {
		Intent intent = new Intent(getThis(), LoggedInActivity.class);
		startActivity(intent);
		
	}

	/**
	 * Method necessary to get this class object from an inner scope like
	 * OnClickListener
	 * 
	 * @return
	 */
	private Activity getThis() {
		return this;
	}

}
