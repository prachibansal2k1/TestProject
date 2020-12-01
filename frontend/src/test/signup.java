/*package test;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signup extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		try{
			String u=req.getParameter("username");
			String e=req.getParameter("email");
			String a=req.getParameter("address");
			String p=req.getParameter("password");
            String q="insert into tb_info (username,email,address,password) values (?,?,?,?)";
            details obj=new details();
            PreparedStatement pst=obj.db.prepareStatement(q);
            pst.setString(1,u);
            pst.setString(2,e);
            pst.setString(3,a);
            pst.setString(4,p);
            pst.executeUpdate();
            req.setAttribute("user",u);
    		req.setAttribute("pass",p);
    		RequestDispatcher rd=req.getRequestDispatcher("next.html");
			rd.include(req,res);
           
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
	}
}*/

package test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class signup extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		try{
			String u=req.getParameter("username");
			String e=req.getParameter("email");
			String a=req.getParameter("address");
			String p=req.getParameter("password");
            String q="insert into tb_info (username,email,address,password) values (?,?,?,?)";
            details obj=new details();
            PreparedStatement pst=obj.db.prepareStatement(q);
            pst.setString(1,u);
            pst.setString(2,e);
            pst.setString(3,a);
            pst.setString(4,p);
            pst.executeUpdate();
            req.setAttribute("user",u);
    		req.setAttribute("pass",p);
            RequestDispatcher rd=req.getRequestDispatcher("log.html");
    		rd.include(req,res);
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
	}
}
