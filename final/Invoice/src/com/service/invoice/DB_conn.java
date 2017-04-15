package com.service.invoice;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class DB_conn {
	public static int add_customer_details(Integer secs, String emailid) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/invoice", "root", "arkafoal");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			
	//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	//		LocalDate localDate = LocalDate.now();
	//		System.out.println(dtf.format(localDate)); //2016/11/16
	        Calendar cal = Calendar.getInstance();
	        Calendar cal1 = Calendar.getInstance();
	        cal.add(Calendar.SECOND, secs);
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	        System.out.println( sdf.format(cal.getTime()) );
	       
	        int t=0;
			
	       	int rs = stmt.executeUpdate("insert into customer_details (emailid, time_interval, created_time, start_time, end_time, time_counter) values ('"+emailid+"','"+secs+"','"+sdf.format(cal.getTime())+"','"+sdf.format(cal.getTime())+"', '"+sdf.format(cal1.getTime())+"','"+t+"');commit;");
			//while (rs.next())
				System.out.println(rs);//.getString(1) + "  " + rs.getInt(2));
				
				
			con.close();
			return rs;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	public static int add_transaction_details(String emailid) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Invoice", "root", "arkafoal");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			
			int rs = stmt.executeUpdate(
					"insert into transaction_details(emailid, transactionID, total_amt,no_of_items,created_time)	select p1.emailid,	p1.transactionID, p1.total_amt,	p1.no_of_items,	p1.created_time from input_details  as p1 where p1.emailid = '"+emailid+"';commit;");
			//while (rs.next())
				System.out.println(rs);//.getString(1) + "  " + rs.getInt(2));
				
				
			con.close();
			return rs;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	
	
}
