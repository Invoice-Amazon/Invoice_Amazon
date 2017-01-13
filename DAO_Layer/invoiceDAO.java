import ADB.ADB;

class invoiceDAO
{
	void store_invoice(Invoice inv)
	{
		int invnum=inv.inv_num;
		int custid=inv.cust_id;
		Date invdate=inv.inv_date;
		int invamt=inv.inv_amt;
		
		ADB adb=new ADB();
		adb.invins(invnum,custid,invdate,invamt);

		
	}
	void get_invoice(Invoice inv)
	{
		invioceDAO invdao=new invoiceDAO();
		invdao.store_invoice(inv);
	}
	
}