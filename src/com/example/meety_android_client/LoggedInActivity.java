package com.example.meety_android_client;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class LoggedInActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_logged_in);

	}

	public void sessionRequest(View view) {
		// TODO Popup window to inform that the status of the request: 'calling'
		// or 'missed'
		System.out.println("Requiring meety session");
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
	            //TODO method call for "about"
	            return true;
	        case R.id.settings:
	        	//TODO method call for "settings"
	            return true;
	        case R.id.friendlist:
	        	//TODO method call for "friendlist"
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}