package com.amazon.acms.invoice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;
import java.util.TimerTask;

/**
 * 
 */

/**
 * @author ramya
 *
 */

public class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/invoice", "root", "arkafoal");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select input_details.emailid,sum(total_amt) as aggregate_cost,sum(no_of_items) as total_no_of_items from input_details,customer_details where input_details.emailid = customer_details.emailid group by input_details.emailid;");
			File file = new File("abx.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			ResultSetMetaData rsmd = rs.getMetaData();
			int n = rsmd.getColumnCount();
			String content = null;
			String contents = null;

			while (rs.next()) {
				for (int i = 1; i <= n; i++) {

					System.out.println(rs.getString(i));
					content = rs.getString(i);
					bw.write(content);
					// bw.newLine();
					bw.write("\t");
				}
				bw.newLine();
			}

/**			ResultSet rt = st.executeQuery("select sum(total_amt) from input_details");
			while (rt.next()) {
				System.out.println("total cost ");
				System.out.println(rt.getString(1));
				contents = rt.getString(1);
				bw.write("total cost");

				bw.write(contents);
				bw.newLine();

			}**/
			bw.newLine();
			bw.newLine();
			bw.close();
			// TODO code application logic here

			System.out.println(
					"Executing timer task on " + TimerMain.convertTimeToDateFormat(System.currentTimeMillis()));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
