package be.webelite.iconviewexample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.animation.AnimationUtils;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.loading).setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_loading));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
