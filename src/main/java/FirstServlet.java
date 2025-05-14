

import java.io.*;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/First")
public class FirstServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	out.println("I am first servlet");
	//RequestDispatcher rd=req.getRequestDispatcher("SecondServlet");
	//rd.forward(req,res);
	res.sendRedirect("https://uta.instructure.com/login?needs_cookies=1");
	}
}