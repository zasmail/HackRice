package com.hackrice.betapp;



//import android.R;

import com.hackrice.betapp.R;

import android.app.Activity; 
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignIn  extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_layout);
      
    }
    
    public void transitionHome(View view) {
		Intent intent = new Intent(SignIn.this, Home.class);
	    SignIn.this.startActivity(intent);
	}

   
 

    
    
    
}