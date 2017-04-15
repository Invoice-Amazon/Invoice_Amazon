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

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Invoice", "root", "arkafoal");
			Statement st = con.createStatement();
			int u1 = st.executeUpdate("UPDATE cutomer_details SET time_counter=time_counter+1;commit;");
			ResultSet rs = st.executeQuery("select input_details.emaiid, sum(total_amt) as aggregate_cost,sum(no_of_items) as total_no_of_items from input_details,customer_details where input_details.emailid = customer_details.emailid && input_details.created_time >= customer_details.start_time && input_details.created_time <= customer_details.end_time && time_counter==time_interval group by input_details.emailid;commit;"); 
			int u2 = st.executeUpdate("UPDATE cutomer_details SET time_counter=0, start_time=end_time, end_time=start_time+time_interval where time_counter==time_interval;"); 
			ResultSet rs1 = st.executeQuery("select input_details.emailid,sum(total_amt) as aggregate_cost,sum(no_of_items) as total_no_of_items from input_details,customer_details where input_details.emailid = customer_details.emailid group by input_details.emailid;commit;");
			File file = new File("Invoice.txt");
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
