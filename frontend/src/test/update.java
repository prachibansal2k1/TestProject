package test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class update extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		try{
            String u=req.getParameter("username");
            String e=req.getParameter("email");
            String a=req.getParameter("address");
			String p=req.getParameter("password");
            String q="update tb_info set username=?,address=?,password=? where email=?";
            details obj=new details();
            PreparedStatement pst=obj.db.prepareStatement(q);
            pst.setString(1,u);
            pst.setString(2,a);
            pst.setString(3,p);
            pst.setString(4,e);
            pst.executeUpdate();
        }
        catch(Exception e){
            System.out.print(e.getMessage());}
	}
}
