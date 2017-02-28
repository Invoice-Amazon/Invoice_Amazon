package com.service.invoice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class DB_conn {
	public static int add_customer_details(Integer days, String emailid) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/invoice", "root", "arkafoal");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.now();
			System.out.println(dtf.format(localDate)); //2016/11/16
			
			int rs = stmt.executeUpdate("insert into customer_details (emailid, no_of_days, present_date) values ('"+emailid+"', '"+days+"','"+dtf.format(localDate)+"');");
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
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/invoice", "root", "arkafoal");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			
			int rs = stmt.executeUpdate(
					"insert into transaction_details(emailid, transactionID, total_amt,no_of_items,trans_date)	select p1.emailid,	p1.transactionID, p1.total_amt,	p1.no_of_items,	p1.trans_date from input_details  as p1 where p1.emailid = '"+emailid+"';");
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
