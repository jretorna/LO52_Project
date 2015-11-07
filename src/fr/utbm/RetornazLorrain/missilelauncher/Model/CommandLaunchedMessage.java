package fr.utbm.RetornazLorrain.missilelauncher.Model;

/**
 * @version 01.00.00
 *
 * @author Jeremy - V01.00.00
 * @date 7 nov. 2015<br>
 *
 */
public class CommandLaunchedMessage {
	/*-------------------*/
	private String date;
	private String cmd;
	/*-------------------*/

	public CommandLaunchedMessage() {
		// TODO Auto-generated constructor stub
	}

	public CommandLaunchedMessage(final String date, final String cmd) {
		super();
		this.date = date;
		this.cmd = cmd;
	}

	/*-------- GETTERS & SETTERS ---------*/

	public String getDate() {
		return date;
	}

	public void setDate(final String date) {
		this.date = date;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(final String cmd) {
		this.cmd = cmd;
	}
}