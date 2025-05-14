

import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class initContextParamsDemo
 */

public class initContextParamsDemo extends HttpServlet {
public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
{res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("Init Parameters Demo<br>");
ServletConfig sconfig=getServletConfig();
out.println(sconfig.getInitParameter("id")+"<br");
out.println(sconfig.getInitParameter("name")+"<br");
out.println(sconfig.getInitParameter("gender")+"<br");
out.println(sconfig.getInitParameter("designation")+"<br");

out.println("Context Parameters Demo using Enumeration<br>");
ServletContext sc=getServletContext();
Enumeration<String> contextparams=sc.getInitParameterNames();
while(contextparams.hasMoreElements())
{
	out.println(sc.getInitParameter(contextparams.nextElement())+"<br>");
}

}
       
 

}
