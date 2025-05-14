

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/deleteemployee")
public class deleteemployee extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String id=req.getParameter("id");
		int eid=Integer.parseInt(id);
		try
		{
			Connection con=null;
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("Driver Class Loaded");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhavya","root","root");
   PreparedStatement st=con.prepareStatement("delete from employee where id=?");
   st.setInt(1, eid);
    		//Statement pstmt = con.createStatement();
 
     //       int i=pstmt.executeUpdate("delete from employee where id="+eid+"");
   int i=st.executeUpdate();
		    
		if(i>0)
		{
			RequestDispatcher rd=req.getRequestDispatcher("displayemployees");
			rd.forward(req, res);
		}
		else
		{
			out.println("Unable to Delete Employee Record");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
