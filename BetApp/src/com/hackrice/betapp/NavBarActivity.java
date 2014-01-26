package com.hackrice.betapp;



//import android.R;

import com.hackrice.betapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class NavBarActivity  extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actnavbar);

        RadioButton radioButton;
        radioButton = (RadioButton) findViewById(R.id.btnAll);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);
        radioButton = (RadioButton) findViewById(R.id.btnPicture);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);
        radioButton = (RadioButton) findViewById(R.id.btnVideo);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);
        radioButton = (RadioButton) findViewById(R.id.btnFile);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);
        radioButton = (RadioButton) findViewById(R.id.btnMore);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);
    }

    private CompoundButton.OnCheckedChangeListener btnNavBarOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
            	
            	if(new String("People").equals(buttonView.getText())){
            		Toast.makeText(NavBarActivity.this, "People", Toast.LENGTH_SHORT).show();
            		
            		change();
            		//startActivity(new Intent(this, People.class));
            		
            	}
            	
               
            	//Intent intent = new Intent(NavBarActivity.this, People.class);
	    	    //NavBarActivity.this.startActivity(intent);
            	/*
            	if ( a == "People"){
            		//Toast.makeText(NavBarActivity.this, "awesome", Toast.LENGTH_SHORT).show();
            		Toast.makeText(NavBarActivity.this, buttonView.getText(), Toast.LENGTH_SHORT).show();
                	*/
            		
            	//}
            }
        }
    };
    
    public void change() 
    {
    	Intent intent = new Intent(getBaseContext(), People.class);
    	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
		startActivity(intent);
    	
    }
    
    
    
}