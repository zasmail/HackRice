package com.hackrice.betapp;

import com.hackrice.betapp.R;


//import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class People extends Activity { @Override
    public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.people_layout);
	
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
	        	
	           Toast.makeText(People.this, buttonView.getText(), Toast.LENGTH_SHORT).show();
	        	
	        }
	    }
	};
	
	
}

