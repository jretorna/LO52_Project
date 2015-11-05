package fr.utbm.RetornazLorrain.missilelauncher;

public class CommandeLaunchedMessage {
	/*-------------------*/
	private String date;
	private String cmd;
	/*-------------------*/

	public CommandeLaunchedMessage() {
		// TODO Auto-generated constructor stub
	}

	public CommandeLaunchedMessage(final String date, final String cmd) {
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
