package fr.utbm.RetornazLorrain.missilelauncher.Model;

import java.util.ArrayList;
import java.util.List;

import fr.utbm.RetornazLorrain.missilelauncher.Librairies.EventListenerList;
import fr.utbm.RetornazLorrain.missilelauncher.Utils.Constantes;
import fr.utbm.RetornazLorrain.missilelauncher.Utils.Date;

public class CommandManager {
	/*---------------------*/
	EventListenerList eventListener = null;
	private Date date;
	private final int nbMaxIteration = 9;
	private List<CommandLaunchedMessage> cmdList;
	/*-------- JNI ---------*/
	private static native void sendRightCommand();
	private static native void sendLeftCommand();
	private static native void sendFireCommand();
	private static native void sendTopCommand();
	private static native void sendBottomCommand();
	private static native void sendStopCommand();

	public CommandManager() {
		if (this.eventListener != null) {
			this.eventListener = null;
		}
		this.eventListener = new EventListenerList();

		date = new Date();
		cmdList = new ArrayList<CommandLaunchedMessage>();
	}

	/*-------------------------------------------------*/

	public void bottomBtnClick() {
		writeOnList(date.setDate(), Constantes.LOWER_TURRET);
	}
	public void topBtnClick() {
		writeOnList(date.setDate(), Constantes.UPPER_TURRET);
	}
	public void rightBtnClick() {
		writeOnList(date.setDate(), Constantes.RIGHT_TURRET);
	}
	public void leftBtnClick() {
		writeOnList(date.setDate(), Constantes.LEFT_TURRET);
	}
	public void fireBtnClick() {
		writeOnList(date.setDate(), Constantes.FIRE);
	}
	public void stopRight() {
		writeOnList(date.setDate(), Constantes.STOP_RIGHT_TURRET);
	}
	public void stopLeft() {
		writeOnList(date.setDate(), Constantes.STOP_LEFT_TURRET);
	}
	public void stopTop() {
		writeOnList(date.setDate(), Constantes.STOP_UPPER_TURRET);
	}
	public void stopBottom() {
		writeOnList(date.setDate(), Constantes.STOP_LOWER_TURRET);
	}
	public void settingBtnClick() {
		// TODO JR - Setting clic
	}

	private void writeOnList(final String _date, final String _msg) {
		if (cmdList.size() > nbMaxIteration) {
			cmdList.remove(0);
			cmdList.add(nbMaxIteration,
					new CommandLaunchedMessage(_date, _msg));
		} else {
			cmdList.add(new CommandLaunchedMessage(_date, _msg));
		}
		fireUpdateCommandList(cmdList);
	}

	/*----- JNI ------*/

	static {
		System.loadLibrary("usb");
	}

	/*-------- Listeners --------*/

	/**
	 * @param listener
	 * 
	 */
	public void addCommandManagerListener(final CommandManagerListener listener) {
		this.eventListener.add(CommandManagerListener.class, listener);
	}
	/**
	 * @param listener
	 * 
	 */
	public void removeCommandManagerListener(final CommandManagerListener listener) {
		this.eventListener.remove(CommandManagerListener.class, listener);
	}

	/*------ Fire -----*/

	private void fireUpdateCommandList(final List<CommandLaunchedMessage> _cmdList) {
		CommandManagerListener[] listenerList = this.eventListener.getListeners(
				CommandManagerListener.class);
		for (CommandManagerListener listener : listenerList) {
			listener.updateCommandList(_cmdList);
		}
	}
}
