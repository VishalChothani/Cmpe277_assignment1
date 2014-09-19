package com.vishal.danceacademy;

import java.io.Console;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormFilling extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form_filling);
		
		Button exit = (Button) findViewById(R.id.exitButton);
		exit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FormFilling.this.finish();
			}
		});
		
		Button save = (Button) findViewById(R.id.saveButton);
		save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(FormFilling.this);

				EditText firstnameEditText;
				EditText lastnameEditText;
				EditText emailEditText;
				EditText phoneNumberEditText;
				
				firstnameEditText = (EditText) findViewById(R.id.firstnameEditText);
				lastnameEditText = (EditText) findViewById(R.id.lastnameEditText);
        		emailEditText = (EditText) findViewById(R.id.emailEditText);
        		phoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);
        		
        		String firstname = firstnameEditText.getText().toString();
        		if(firstname.length() == 0 )
        		{
        			firstnameEditText.setError( "First name is required!" );
        			return;
        		}
        		else
        		{
        			firstnameEditText.setError(null);
        		}
        		
        		String lastname = lastnameEditText.getText().toString();
        		if(lastname.length() == 0 )
        		{
        			lastnameEditText.setError( "Last name is required!" );
        			return;
        		}
        		else
        		{
        			lastnameEditText.setError(null);
        		}
        		
        		String email = emailEditText.getText().toString();
        		if( !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        		{
        			emailEditText.setError( "Wrong email entered!" );
        			return;
        		}
        		else
        		{
        			emailEditText.setError(null);
        		}
        		
        		String phoneNumber = phoneNumberEditText.getText().toString();
        		if(phoneNumber.length() != 10 )
        		{
        			phoneNumberEditText.setError( "Phone Number has 10 digits!" );
        			return;
        		}
        		else
        		{
        			phoneNumberEditText.setError(null);
        		}
        		
		        alertDialog.setMessage("Thank you for registration");
		        alertDialog.setNeutralButton("Ok",new DialogInterface.OnClickListener() {
		        	public void onClick(DialogInterface dialog,int id) {		        				        		
		        		FormFilling.this.finish();
		        	}
		        });

		        alertDialog.show();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.form_filling, menu);
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
