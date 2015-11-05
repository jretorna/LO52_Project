package fr.utbm.RetornazLorrain.missilelauncher;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import fr.utbm.RetornazLorrain.missilelauncher.Utils.Constantes;

public class LauncherActivity extends Activity implements OnClickListener {

	/*-----------------*/
	private ImageButton toRightBtn, toLeftBtn, toTopBtn, toBottomBtn, fireBtn,
			settingBtn;
	private TextView cmdLaunched;
	String line_separator = System.getProperty("line.separator");
	private List<CommandeLaunchedMessage> cmdList = new ArrayList<CommandeLaunchedMessage>();
	private final int nbMaxIteration = 9;
	/*-----------------*/

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		toRightBtn = (ImageButton) findViewById(R.id.toRightBtn);
		toRightBtn.setId(Constantes.toRightCommandID);
		toLeftBtn = (ImageButton) findViewById(R.id.toLeftBtn);
		toLeftBtn.setId(Constantes.toLeftCommandID);
		toTopBtn = (ImageButton) findViewById(R.id.toTopBtn);
		toTopBtn.setId(Constantes.toTopCommandID);
		toBottomBtn = (ImageButton) findViewById(R.id.toBottomBtn);
		toBottomBtn.setId(Constantes.toBottomCommandID);
		fireBtn = (ImageButton) findViewById(R.id.FireBtn);
		fireBtn.setId(Constantes.fireCommandID);
		settingBtn = (ImageButton) findViewById(R.id.settingBtn);
		settingBtn.setId(Constantes.settingCommandID);
		cmdLaunched = (TextView) findViewById(R.id.listCmd);
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
	private String setDate() {
		String date = "";
		Calendar c = Calendar.getInstance();
		if (c.get(Calendar.HOUR_OF_DAY) < 9)
			date = "0" + Integer.toString(c.get(Calendar.HOUR_OF_DAY));
		else
			date = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
		if (c.get(Calendar.MINUTE) < 9)
			date = date + ":0" + c.get(Calendar.MINUTE);
		else
			date = date + ":" + Integer.toString(c.get(Calendar.MINUTE));
		if (c.get(Calendar.SECOND) < 9)
			date = date + ":0" + Integer.toString(c.get(Calendar.SECOND));
		else
			date = date + ":" + Integer.toString(c.get(Calendar.SECOND));
		return date;
	}

	private void refreshList() {
		int j = 0;
		// XXX Jeremy supprimer ce print
		Log.d("refreshList", "Je refresh la liste");
		cmdLaunched.setText("");
		for (CommandeLaunchedMessage cl : cmdList) {
			cmdLaunched.setText(cmdLaunched.getText() + cl.getDate() + " : "
					+ cl.getCmd() + line_separator);
			j++;
		}
		// XXX Jeremy supprimer ce print
		Log.e("total refresh", "list refresh : " + j);

	}

	@Override
	public void onClick(final View v) {
		switch (v.getId()) {
			case Constantes.toRightCommandID :
				rightBtnClick();
				break;
			case Constantes.toLeftCommandID :
				leftBtnClick();
				break;
			case Constantes.toTopCommandID :
				topBtnClick();
				break;
			case Constantes.toBottomCommandID :
				bottomBtnClick();
				break;
			case Constantes.fireCommandID :
				fireBtnClick();
				break;
			case Constantes.settingCommandID :
				settingBtnClick();
				break;
		}
	}

	private void bottomBtnClick() {
		if (cmdList.size() > nbMaxIteration) {
			Log.d("raz", "raz");
			cmdList.remove(nbMaxIteration);
			cmdList.add(0, new CommandeLaunchedMessage(setDate(),
					"Descendre la tourelle"));
		} else {
			Log.d("no raz", "no raz");
			cmdList.add(new CommandeLaunchedMessage(setDate(),
					"Descendre la tourelle"));
		}
		refreshList();
	}
	private void topBtnClick() {
		if (cmdList.size() > nbMaxIteration) {
			Log.d("raz", "raz");
			cmdList.remove(nbMaxIteration);
			cmdList.add(0, new CommandeLaunchedMessage(setDate(),
					"Monter la tourelle"));
		} else {
			Log.d("no raz", "no raz");
			cmdList.add(new CommandeLaunchedMessage(setDate(),
					"Monter la tourelle"));
		}
		refreshList();
	}
	private void rightBtnClick() {
		if (cmdList.size() > nbMaxIteration) {
			Log.d("raz", "raz");
			cmdList.remove(nbMaxIteration);
			cmdList.add(0, new CommandeLaunchedMessage(setDate(),
					"Tourner la tourelle à droite"));
		} else {
			cmdList.add(new CommandeLaunchedMessage(setDate(),
					"Tourner la tourelle à droite"));
		}
		refreshList();
	}
	private void leftBtnClick() {
		if (cmdList.size() > nbMaxIteration) {
			Log.d("raz", "raz");
			cmdList.remove(nbMaxIteration);
			cmdList.add(0, new CommandeLaunchedMessage(setDate(),
					"Tourner la tourelle à gauche"));
		} else {
			Log.d("no raz", "no raz");
			cmdList.add(new CommandeLaunchedMessage(setDate(),
					"Tourner la tourelle à gauche"));
		}
		refreshList();
	}
	private void fireBtnClick() {
		if (cmdList.size() > nbMaxIteration) {
			Log.d("raz", "raz");
			cmdList.remove(nbMaxIteration);
			cmdList.add(0, new CommandeLaunchedMessage(setDate(), "FIRE !!!"));
		} else {
			cmdList.add(new CommandeLaunchedMessage(setDate(), "FIRE !!!"));
		}
		refreshList();
	}

	private void settingBtnClick() {
		// XXX Jeremy supprimer ce print
		Toast.makeText(getApplicationContext(), "Ordre : Setting item ask",
				Toast.LENGTH_SHORT).show();
	}
}
