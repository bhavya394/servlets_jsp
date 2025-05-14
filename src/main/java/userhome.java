

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userhome
 */
@WebServlet("/userhome")
public class userhome extends HttpServlet {
public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	HttpSession session=req.getSession(false);
	if(session!=null)
	{
		String uname=(String)session.getAttribute("uname");
		out.println("<h2 align=center>User Home Page</h2><br>");
		out.println("<b>Welcome</b>"+uname+"<br><br>");
		out.println(session.getId()+"<br>");
		out.println(session.getMaxInactiveInterval()+"<br>");
		RequestDispatcher rd=req.getRequestDispatcher("userhome.html");
		rd.include(req, res);
	}
}
}
