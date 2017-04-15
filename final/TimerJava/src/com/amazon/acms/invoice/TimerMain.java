/**
 * 
 */
package com.amazon.acms.invoice;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Timer;

/**
 * @author ramya
 *
 */

public class TimerMain {
	public static void main(String[] args) throws SQLException, IOException {

		System.out.println("Timer tasks started on " + convertTimeToDateFormat(System.currentTimeMillis()));
		System.out.println("**************************");
		// It will create new thread
		Timer timer = new Timer();

		timer.schedule(new MyTimerTask(), 0, 1);

		// Stopping the timer thread after some time for example :12 secs.
		
		try {
			Thread.sleep(120000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("Timer tasks finished on " + convertTimeToDateFormat(System.currentTimeMillis()));

		System.exit(0);
	}

	public static String convertTimeToDateFormat(long milliseconds) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
		Date resultdate = new Date(milliseconds);
		return sdf.format(resultdate);
	}

}


