package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		try{
			String u=req.getParameter("username");
			String p=req.getParameter("password");
            String q="select * from tb_info where username=? and password=?";
            details obj=new details();
            PreparedStatement pst=obj.db.prepareStatement(q);
            pst.setString(1,u);
            pst.setString(2,p);
            ResultSet rs=pst.executeQuery();
            if(rs.next()) {
            	req.setAttribute("user",u);
        		req.setAttribute("pass",p);
        		RequestDispatcher rd=req.getRequestDispatcher("url");
        		rd.forward(req,res);
            }
            else {
            	PrintWriter out=res.getWriter();
    			out.print("INVALID");
    			RequestDispatcher rd=req.getRequestDispatcher("log.html");
    			rd.include(req,res);
            }
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
	}
}
