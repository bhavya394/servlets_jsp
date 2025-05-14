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

@WebServlet("/viewemployeebyid")
public class viewemployeebyid extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	String eid=req.getParameter("eid");
	int id=Integer.parseInt(eid);
	try
	{
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Class Loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhavya","root","root");
		PreparedStatement st=con.prepareStatement("select * from employee where id=?");
		st.setInt(1, id);
		ResultSet rs=st.executeQuery();
		out.println("<h2 align=center>View Employee Records</h2><br>");
		out.println("<table align=center border='2'>");
		out.println("<tr bgcolor='lightblue'>");
		out.println("<th>ID</th>");
		out.println("<th>NAME</th>");
		out.println("<th>EMAIL</th>");
		out.println("<th>PASSWORD</th>");
		out.println("<th>MOBILE NO</th>");
		out.println("<th>DEPARTMENT</th>");
		out.println("<th>LOCATION</th>");
		out.println("<th>GENDER</th>");
		out.println("</tr>");
		if(rs.next())
		{
			out.println("<tr>");
			out.println("<td>"+rs.getInt(1)+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("<td>"+rs.getString(4)+"</td>");
			out.println("<td>"+rs.getString(5)+"</td>");
			out.println("<td>"+rs.getString(6)+"</td>");
			out.println("<td>"+rs.getString(7)+"</td>");
			out.println("<td>"+rs.getString(8)+"</td>");
		}
		out.println("</table");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}