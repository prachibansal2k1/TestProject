package test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class welcome extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		
		
		try{
			String u=(String) req.getAttribute("user");
			String p=(String) req.getAttribute("pass");
            String q="select * from tb_info where username=? and password=?";
            details obj=new details();
            PreparedStatement pst=obj.db.prepareStatement(q);
            pst.setString(1,u);
            pst.setString(2,p);
           // pst.executeUpdate();
           // ResultSet rs=pst.executeQuery();
          // String e=rs.getString("email");
           //String a=rs.getString("address");
            
       String e="",a="";
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                e=rs.getString("email");
                a=rs.getString("address");
               
            }
          //  t1.set
            PrintWriter out=res.getWriter();
    		out.print("Username="+u+" Password="+p+a+e);
    		out.print("WELCOME");
        }
        catch(Exception e){
            System.out.print(e.getMessage());}
		
	}
}