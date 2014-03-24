package meety.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	}
	
	public void attemptLogin(View view){
		
		final EditText usernameText = (EditText) findViewById(R.id.text_username);
		final EditText passwordText = (EditText) findViewById(R.id.text_password);
		
		if(TextUtils.isEmpty(usernameText.getText().toString()) && TextUtils.isEmpty(passwordText.getText().toString())) {
			usernameText.setText("username");
			passwordText.setText("password");
		}

        Intent intent = new Intent(this, AttemptingLoginActivity.class);
        intent.putExtra("username", usernameText.getText().toString());
        intent.putExtra("password", passwordText.getText().toString());
        startActivity(intent);
	}
	
	public void signUpScreen(View view){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
	}

}