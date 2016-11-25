package com.example.thread_3_handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ThreadHandler extends Activity {
	private Handler handler;
	  private ProgressBar progress;
	  private TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		progress = (ProgressBar) findViewById(R.id.progressBar1);
	    text = (TextView) findViewById(R.id.textView1);
	}

	 public void startProgress(View view) {

		     Runnable runnable = new Runnable() {
		      @Override
		      public void run() {

		          for (int i = 0; i <= 10; i++) {

		          final int value = i;
		            try {
		            Thread.sleep(1000);
		          } catch (InterruptedException e) {
		            e.printStackTrace();
		          }

		          progress.post(new Runnable() {
		            @Override
		            public void run() {
		              text.setText("Updating"+value);
		              progress.setProgress(value);}
		          });

		        }



		      }
		    };
		    new Thread(runnable).start();
		  }


}
