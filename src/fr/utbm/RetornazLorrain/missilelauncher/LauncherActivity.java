package fr.utbm.RetornazLorrain.missilelauncher;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class LauncherActivity extends Activity {

	/*-----------------*/
	ImageButton toRightBtn, toLeftBtn, toTopBtn, toBottomBtn, fireBtn;
	/*-----------------*/

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		toRightBtn = (ImageButton) findViewById(R.id.toRightBtn);
		toLeftBtn = (ImageButton) findViewById(R.id.toLeftBtn);
		toTopBtn = (ImageButton) findViewById(R.id.toTopBtn);
		toBottomBtn = (ImageButton) findViewById(R.id.toBottomBtn);
		fireBtn = (ImageButton) findViewById(R.id.FireBtn);
		initListener();
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.launcher, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/*-------------------------*/
	private void initListener() {
		toBottomBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				// TODO JR - Clic sur bas (descendre la tourelle)
				// XXX Jeremy supprimer ce print
				Toast.makeText(getApplicationContext(),
						"Ordre : descendre la tourelle", Toast.LENGTH_SHORT).show();
			}
		});

		toTopBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				// TODO JR - Clic sur haut (monter la tourelle)
				// XXX Jeremy supprimer ce print
				Toast.makeText(getApplicationContext(),
						"Ordre : monter la tourelle", Toast.LENGTH_SHORT).show();
			}
		});

		toLeftBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				// TODO JR - Clic sur gauche (tourner la tourelle à gauche)
				// XXX Jeremy supprimer ce print
				Toast.makeText(getApplicationContext(),
						"Ordre : tourner la tourelle à gauche",
						Toast.LENGTH_SHORT).show();
			}
		});

		toRightBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				// TODO JR - Clic sur droite (tourner la tourelle à droite)
				// XXX Jeremy supprimer ce print
				Toast.makeText(getApplicationContext(),
						"Ordre : tourner la tourelle à droite",
						Toast.LENGTH_SHORT).show();
			}
		});

		fireBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				// TODO JR - Clic sur droite (tourner la tourelle à droite)
				// XXX Jeremy supprimer ce print
				Toast.makeText(getApplicationContext(), "Ordre : FIRE !!",
						Toast.LENGTH_SHORT).show();
			}
		});
	}

}
