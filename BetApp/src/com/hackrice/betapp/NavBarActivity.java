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

public class NavBarActivity  extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_layout);
      
    }
    
    public void transitionSignUp(View view) {
		Intent intent = new Intent(NavBarActivity.this, SignUp.class);
	    NavBarActivity.this.startActivity(intent);
	}
    public void transitionSignIn(View view) {
 		Intent intent = new Intent(NavBarActivity.this, SignIn.class);
 	    NavBarActivity.this.startActivity(intent);
 	}
    	
    	
   
   
 

    
    
    
}