package fr.utbm.RetornazLorrain.missilelauncher.View;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.TextView;
import fr.utbm.RetornazLorrain.missilelauncher.Model.CommandLaunchedMessage;
import fr.utbm.RetornazLorrain.missilelauncher.Model.CommandManager;
import fr.utbm.RetornazLorrain.missilelauncher.Model.CommandManagerListener;
import fr.utbm.RetornazLorrain.missilelauncher.Utils.Constantes;

public class LauncherActivity extends Activity implements OnTouchListener {

	/*-----------------*/
	private ImageButton toRightBtn, toLeftBtn, toTopBtn, toBottomBtn, fireBtn,
			settingBtn;
	private TextView cmdLaunched;
	String line_separator = System.getProperty("line.separator");
	CommandManager commandManager;
	CommandManagerListener commandManagerListener;
	/*-----------------*/

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		fireBtn = (ImageButton) findViewById(R.id.fireBtn);
		toRightBtn = (ImageButton) findViewById(R.id.toRightBtn);
		toLeftBtn = (ImageButton) findViewById(R.id.toLeftBtn);
		toTopBtn = (ImageButton) findViewById(R.id.toTopBtn);
		toBottomBtn = (ImageButton) findViewById(R.id.toBottomBtn);
		cmdLaunched = (TextView) findViewById(R.id.listCmd);
		settingBtn = (ImageButton) findViewById(R.id.settingBtn);
		commandManager = new CommandManager();
		initListener();
	}

	@Override
	protected void onDestroy() {
		this.commandManager.removeCommandManagerListener(this.commandManagerListener);
	};

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

	/*--------- LISTERNERS PART ----------------*/

	private void initListener() {
		fireBtn.setOnTouchListener(this);
		toRightBtn.setOnTouchListener(this);
		toLeftBtn.setOnTouchListener(this);
		toTopBtn.setOnTouchListener(this);
		toBottomBtn.setOnTouchListener(this);
		settingBtn.setOnTouchListener(this);
		this.commandManagerListener = new CommandManagerListener() {
			@Override
			public void updateCommandList(final List<CommandLaunchedMessage> _cmdList) {
				refreshList(_cmdList);
			}
		};
		this.commandManager.addCommandManagerListener(this.commandManagerListener);
	}

	/*-----------------------------------*/

	private void refreshList(final List<CommandLaunchedMessage> _cmdList) {
		cmdLaunched.setText("");
		for (CommandLaunchedMessage cl : _cmdList) {
			cmdLaunched.setText(cmdLaunched.getText() + cl.getDate() + " : "
					+ cl.getCmd() + line_separator);
		}
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouch(final View v, final MotionEvent event) {
		/*--- Relachement ---*/
		if (event.getAction() == MotionEvent.ACTION_UP
				|| event.getAction() == MotionEvent.ACTION_CANCEL) {
			switch (v.getId()) {
				case Constantes.toRightCommand :
					commandManager.stopRight();
					break;
				case Constantes.toLeftCommand :
					commandManager.stopLeft();
					break;
				case Constantes.toTopCommand :
					commandManager.stopTop();
					break;
				case Constantes.toBottomCommand :
					commandManager.stopBottom();
					break;
			}
		} else if (event.getAction() == MotionEvent.ACTION_DOWN) {
			/*--- Lors d'un clic ---*/
			switch (v.getId()) {
				case Constantes.toRightCommand :
					commandManager.rightBtnClick();
					break;
				case Constantes.toLeftCommand :
					commandManager.leftBtnClick();
					break;
				case Constantes.toTopCommand :
					commandManager.topBtnClick();
					break;
				case Constantes.toBottomCommand :
					commandManager.bottomBtnClick();
					break;
				case Constantes.fireCommand :
					commandManager.fireBtnClick();
					break;
				case Constantes.settingCommand :
					commandManager.settingBtnClick();
					break;
			}
		}
		return false;
	}
}
