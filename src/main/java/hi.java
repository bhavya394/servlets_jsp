

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/hi")
public class hi extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		if(uname.equals("klu")&&pwd.equals("klu"))
		{
			//out.println("Hi");
			HttpSession session=request.getSession();
			session.setAttribute("uname", uname);
			session.setAttribute("pwd", pwd);
			session.setMaxInactiveInterval(10);
			response.sendRedirect("userhome");
		}
		else
		{
			out.println("Invalid");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
