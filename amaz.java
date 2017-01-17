import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;



public class Ch extends HttpServlet{


    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
try
{
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","nishitha");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from custdetails where id="+request.getParameter("id"));
File file = new File("C:\\New folder\\abx.txt");
FileWriter fw = new FileWriter(file.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);

        ResultSetMetaData rsmd=rs.getMetaData();
        int n=rsmd.getColumnCount();
   String content=null;
          String contents=null;

        while(rs.next())
        {
            for(int i=1;i<=n;i++)
            {
                System.out.print(rs.getString(i));
                 content = rs.getString(i);
                          bw.write(content);
                          bw.newLine();


            }

            }
      ResultSet rt=st.executeQuery("select sum(cost) from custdetails where id="+request.getParameter("id"));
     while(rt.next())
     {
         System.out.println(rt.getString(1));
         contents = rt.getString(1);
         bw.write("total cost");

                          bw.write(contents);
                          bw.newLine();


     }
     bw.close();

}
catch(Exception e)
{
Sytem.out.println(e);
}

    }

}
