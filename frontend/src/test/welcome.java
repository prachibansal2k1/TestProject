package test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
            
            String e="",a="";
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                e=rs.getString("email");
                a=rs.getString("address");
               
            }
    		req.setAttribute("user",u);
    		req.setAttribute("email",e);
    		req.setAttribute("add",a);
    		req.setAttribute("pass",p);
    		RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
    		rd.include(req,res);
        }
        catch(Exception e){
            System.out.print(e.getMessage());}
		
	}
}