package com.example.meety_android_client;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

public class AttemptingLogIn extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("***CRIOU***");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attempting_log_in);

		System.out.println("***vai começar a esperar***");
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				Intent intent = new Intent(getThis(), LoggedInActivity.class);
				startActivity(intent);
			}
		}, 5000);

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
