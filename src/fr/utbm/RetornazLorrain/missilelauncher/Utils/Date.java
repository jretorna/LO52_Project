package fr.utbm.RetornazLorrain.missilelauncher.Utils;

import java.util.Calendar;

/**
 * @version 01.00.00
 *
 * @author Jeremy - V01.00.00
 * @date 7 nov. 2015<br>
 *
 */
public class Date {
	public String setDate() {
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
}
