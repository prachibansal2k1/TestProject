package test;

import java.sql.*;

public class details {
    public Connection db;
    public details(){
    try{
    	Class.forName("com.mysql.jdbc.Driver");
        db=DriverManager.getConnection("jdbc:mysql://localhost/jsp","root","");
    }
    catch(Exception e){
        System.out.print(e.getMessage());
    }
}
}