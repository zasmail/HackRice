package com.hackrice.betapp;



//import android.R;

import com.hackrice.betapp.R;

import android.app.Activity; 
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class Exchange  extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exchange_layout);

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

        		//Toast.makeText(NavBarActivity.this, "People", Toast.LENGTH_SHORT).show();            	
               	if(new String("Home").equals(buttonView.getText())){
            		Intent intent = new Intent(getBaseContext(), NavBarActivity.class);
                	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            		startActivity(intent);
            	}
            	
            	if(new String("People").equals(buttonView.getText())){
            		Intent intent = new Intent(getBaseContext(), People.class);
                	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            		startActivity(intent);
            	}
            	
            	if(new String("Ante").equals(buttonView.getText())){
            		Intent intent = new Intent(getBaseContext(), Ante.class);
                	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            		startActivity(intent);
            	}
            	if(new String("Exchange").equals(buttonView.getText())){
            		Intent intent = new Intent(getBaseContext(), Exchange.class);
                	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            		startActivity(intent);
            	}
            	if(new String("Settings").equals(buttonView.getText())){
            		Intent intent = new Intent(getBaseContext(), Settings.class);
                	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            		startActivity(intent);
            	}  
            }
        }
    };

    
    
    
}