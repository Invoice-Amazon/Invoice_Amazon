import ADB.ADB;

class inputDAO
{
	void insert_inp(Transaction t)
	{
			
		int tid=t.t_id;
		Date tdate=t.t_date;
		int tamt=t.t_amt;
		String tcurr=t.t_curr;
		
		
		ADB adb=new ADB();
		adb.iins(tid,tdate,tamt,tcurr);
	}
	void get_inp(Transaction t)
	{
		inputDAO idao=new inputDAO();
		idao.insert_inp(t);	
	} 
}