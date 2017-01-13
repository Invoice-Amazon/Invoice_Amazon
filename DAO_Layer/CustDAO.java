import ADB.ADB;

class CustDAO
{
	void insertCustReq(CustDetails cd)
	{
		int cust_id=cd.cust_id;
		String email_id=cd.email_id;
		Date invoice_gen_day=cd.invoice_gen_day;

		ADB adb=new ADB();
		adb.cins(cust_id,email_id,invoice_gen_day);
	}
    void updateCustReq(CustDetails cd) 
	{
		int cust_id=cd.cust_id;
		String email_id=cd.email_id;
		Date invoice_gen_day=cd.invoice_gen_day;

		ADB adb=new ADB();
		adb.cupdate(cust_id,email_id,invoice_gen_day);

	}
    void getCustReq(CustDetails cd)
	{
               custDAO cdao=new custDAO();
               cdao.insertCustReq(cd);
	}
}