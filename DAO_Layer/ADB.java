package ADB;
import java.sql.*;

public class ADB
{

		Connection con=null;
		Statement cst=null,tst=null,invst=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");

            cst=con.createStatement
			           (ResultSet.TYPE_SCROLL_SENSITIVE,
			             ResultSet.CONCUR_UPDATABLE);
		    ResultSet crs=cst.executeQuery("SELECT custid,emailid,invoicegenday FROM custdetails");	

		    tst=con.createStatement
			           (ResultSet.TYPE_SCROLL_SENSITIVE,
			             ResultSet.CONCUR_UPDATABLE);
	     	ResultSet trs=tst.executeQuery("SELECT tid,tdate,tamt,tcurr FROM transaction");	 
		  
		    invst=con.createStatement
			           (ResultSet.TYPE_SCROLL_SENSITIVE,
			             ResultSet.CONCUR_UPDATABLE);
	     	ResultSet invrs=invst.executeQuery("SELECT invnum,custid,invdate,invamt FROM invoice");	 
		}
		catch (SQLException s)
		{
			System.out.println(s);
		}
		catch(ClassNotFoundException c)
		{
			System.out.println(c);
		}

		
        public void cins(int cust_id,String email_id,Date invoice_gen_day)
		{
			crs.moveToInsertRow();
			crs.updateInt(1,cust_id);
			crs.updateString(2,email_id);
			crs.updateDate(3,invoice_gen_day);
		        crs.insertRow();
		 }
	    public void cupdate(int cust_id,String email_id,Date invoice_gen_day)
		{
			while(crs.next())
			{
				if(Integer.parseInt(rs.getString(1))==cust_id)
				{
					if(email_id!=NULL&&invoice_gen_day==NULL)
						crs.updateString(2,email_id);
                                        else if(email_id==NULL&&invoice_gen_day!=NULL)
                                                crs.updateDate(3,invoice_gen_day);
                                        else if(email_id!=NULL&&invoice_gen_day!=NULL)
                                        {    
                                                crs.updateString(2,email_id);
                                                crs.updateDate(3,invoice_gen_day);
                                        }
                                        crs.updateRow();
				}
			}                        
		}
		
 	     public void tins(int t_id,Date t_date,int t_amt,String t_curr);
		{
			trs.moveToInsertRow();
			trs.updateInt(1,t_id);
			trs.updateDate(2,t_date);
			trs.updateInt(3,t_amt);
            trs.updateString(4,t_curr);
		    trs.insertRow();
		 }
       
        public void invins(int inv_num,int cust_id,Date inv_date,inv_amt)
	    {
			invrs.moveToInsertRow();
			invrs.updateInt(1,inv_num);
			invrs.updateDate(2,cust_id);
			invrs.updateInt(3,inv_date);
            invrs.updateString(4,inv_amt);
		    invrs.insertRow();
		}	
}
