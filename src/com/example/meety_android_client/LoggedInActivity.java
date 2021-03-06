package com.example.meety_android_client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * 
 * This activity is responsible to provide all the logged in functions such as
 * general menu and asking a friend to join in a Meety Session
 * 
 * @author Tales Tenorio de Souza Pimentel - tales.tsp@gmail.com
 * 
 */
public class LoggedInActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logged_in);
		System.out.println("LoggedInActivity");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.meety_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		System.out.println("item menu >>> " + item.getItemId());
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.about:
			// TODO method call for "about"
			return true;
		case R.id.settings:
			// TODO method call for "settings"
			return true;
		case R.id.friendlist:
			// TODO method call for "friendlist"
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/**
	 * Send Meety Session Request
	 * 
	 * @param view
	 */
	public void sessionRequest(View view) {
		// TODO Popup window to inform that the status of the request: 'calling'
		// or 'missed'

		boolean startSession = true;

		if (startSession) {
			attemptMeetySession();
		}
	}

	private void attemptMeetySession() {
		Intent intentAttMS = new Intent(this, AttemptingMeetySession.class);
		startActivity(intentAttMS);
	}

}