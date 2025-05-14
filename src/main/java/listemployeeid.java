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

@WebServlet("/listemployeeid")
public class listemployeeid extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	try
	{
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Class Loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhavya","root","Bhavya@08");
		PreparedStatement st=con.prepareStatement("select * from employee");
		ResultSet rs=st.executeQuery();
		out.println("<form method=post action='viewemployeebyid'>");
		out.println("Select Employee ID");
		out.println("<select name='eid' required>");
		out.println("<option value=''>--Select--</option>");
		while(rs.next())
		{
			out.println("<option value="+rs.getInt("id")+">"+rs.getInt("id")+"</option>");
		}
		out.println("</select><br><br>");
		out.println("<input type='submit' value='View'>");
		out.println("</form>");
	}
	catch(Exception e) 
	{
		System.out.println(e);
	}
	}
}
		