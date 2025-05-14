

import java.io.*;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Serv
 */

public class Serv extends GenericServlet {
	
	
	public void service(ServletRequest request,ServletResponse response) throws ServletException, IOException 
		// TODO Auto-generated method stub
		{
			System.out.println("Service Method");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String name="hi";
			out.println("<h1>Hello "+name+"</h1><br>");
			out.println("HttpServlet Demo");
			
		}

	
}