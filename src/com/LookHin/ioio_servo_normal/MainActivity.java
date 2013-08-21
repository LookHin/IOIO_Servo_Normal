package com.LookHin.ioio_servo_normal;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.PwmOutput;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.BaseIOIOLooper;
import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;


/*
 * Servo 1 = PIN 3
 * Servo 2 = PIN 4
 * Servo 3 = PIN 5
 * Servo 4 = PIN 6
 * Servo 5 = PIN 7
 * Servo 6 = PIN 10
 */





public class MainActivity extends IOIOActivity {
	
	private ToggleButton toggleButton1;
	private Button button1;
	
	private SeekBar seekBar1;
	private SeekBar seekBar2;
	private SeekBar seekBar3;
	private SeekBar seekBar4;
	private SeekBar seekBar5;
	private SeekBar seekBar6;
	
	private int seek_bar_value_1;
	private int seek_bar_value_2;
	private int seek_bar_value_3;
	private int seek_bar_value_4;
	private int seek_bar_value_5;
	private int seek_bar_value_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
        button1 = (Button) findViewById(R.id.button1);
        
        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar4 = (SeekBar) findViewById(R.id.seekBar4);
        seekBar5 = (SeekBar) findViewById(R.id.seekBar5);
        seekBar6 = (SeekBar) findViewById(R.id.seekBar6);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
        case R.id.action_about:
        	//Toast.makeText(getApplicationContext(), "Show About", Toast.LENGTH_SHORT).show();
        	
        	Intent about = new Intent(this, AboutActivity.class);
    		startActivity(about);
    		
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    } 
    
    
    class Looper extends BaseIOIOLooper {
		
    	private DigitalOutput digital_led1;
    	
		private PwmOutput servoPwmOutput1;
		private PwmOutput servoPwmOutput2;
		private PwmOutput servoPwmOutput3;
		private PwmOutput servoPwmOutput4;
		private PwmOutput servoPwmOutput5;
		private PwmOutput servoPwmOutput6;
		

		@Override
		protected void setup() throws ConnectionLostException {

			digital_led1 = ioio_.openDigitalOutput(0,true);
			
			servoPwmOutput1 = ioio_.openPwmOutput(3, 100);
			servoPwmOutput2 = ioio_.openPwmOutput(4, 100);
			servoPwmOutput3 = ioio_.openPwmOutput(5, 100);
			servoPwmOutput4 = ioio_.openPwmOutput(6, 100);
			servoPwmOutput5 = ioio_.openPwmOutput(7, 100);
			servoPwmOutput6 = ioio_.openPwmOutput(10, 100);
			
			runOnUiThread(new Runnable() {
				public void run() {
					Toast.makeText(getApplicationContext(), "IOIO Connect", Toast.LENGTH_SHORT).show();
				}
			});
			
			
			// Set To Center
			button1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					seekBar1.setProgress(50);
					seekBar2.setProgress(50);
					seekBar3.setProgress(50);
					seekBar4.setProgress(50);
					seekBar5.setProgress(50);
					seekBar6.setProgress(50);
					
					seek_bar_value_1 = 50;
					seek_bar_value_2 = 50;
					seek_bar_value_3 = 50;
					seek_bar_value_4 = 50;
					seek_bar_value_5 = 50;
					seek_bar_value_6 = 50;
					
				}
			});
			
			// SeekBar1
			seekBar1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				
				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					// TODO Auto-generated method stub
					
					seek_bar_value_1 = progress;
					
					Log.d("Servo1 ", " = "+ seek_bar_value_1);
				}
			});
			
			// SeekBar2
			seekBar2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				
				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					// TODO Auto-generated method stub
					
					seek_bar_value_2 = progress;
					
					Log.d("Servo2 ", " = "+ seek_bar_value_2);
				}
			});
			
			// SeekBar3
			seekBar3.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				
				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					// TODO Auto-generated method stub
					
					seek_bar_value_3 = progress;
					
					Log.d("Servo3 ", " = "+ seek_bar_value_3);
				}
			});
			
			// SeekBar4
			seekBar4.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				
				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					// TODO Auto-generated method stub
					
					seek_bar_value_4 = progress;
					
					Log.d("Servo4 ", " = "+ seek_bar_value_4);
				}
			});
			
			
			// SeekBar5
			seekBar5.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				
				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					// TODO Auto-generated method stub
					
					seek_bar_value_5 = progress;
					
					Log.d("Servo5 ", " = "+ seek_bar_value_5);
				}
			});
			
			// SeekBar6
			seekBar6.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				
				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					// TODO Auto-generated method stub
					
					seek_bar_value_6 = progress;
					
					Log.d("Servo6 ", " = "+ seek_bar_value_6);
				}
			});
			
		}

		@Override
		public void loop() throws ConnectionLostException {
			
			digital_led1.write(!toggleButton1.isChecked());
			
			servoPwmOutput1.setPulseWidth((int)((seek_bar_value_1 * 10)+1000));
			servoPwmOutput2.setPulseWidth((int)((seek_bar_value_2 * 10)+1000));
			servoPwmOutput3.setPulseWidth((int)((seek_bar_value_3 * 10)+1000));
			servoPwmOutput4.setPulseWidth((int)((seek_bar_value_4 * 10)+1000));
			servoPwmOutput5.setPulseWidth((int)((seek_bar_value_5 * 10)+1000));
			servoPwmOutput6.setPulseWidth((int)((seek_bar_value_6 * 10)+1000));
						
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				
			}
			
		}
	}

	@Override
	protected IOIOLooper createIOIOLooper() {
		return new Looper();
	}
    
}
