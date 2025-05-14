import java.io.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addemployee")
public class addemployee extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	String name=req.getParameter("name");
	String gender=req.getParameter("gender");
	String email=req.getParameter("email");
	String pwd=req.getParameter("pwd");
	String mob=req.getParameter("mob");
	String dept=req.getParameter("dept");
	String loc=req.getParameter("Loc");
	int id=(int)(Math.random()*99999)+1;
	try
	{
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Class Loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhavya","root","Bhavay@2002");
		System.out.println("Connection Established");
		PreparedStatement st=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?)");
		st.setInt(1, id);
		st.setString(2, name);
		st.setString(8, gender);
		st.setString(3, email);
		st.setString(4, pwd);
		st.setString(5, mob);
		st.setString(6, dept);
		st.setString(7, loc);
		int n=st.executeUpdate();
	
	if(n>0)
	{
		out.println("Inserted");
	}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}