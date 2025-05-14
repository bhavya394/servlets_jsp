
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 * Servlet implementation class updateEmpByID
 */
@WebServlet("/updateEmpByID")
public class updateEmpByID extends HttpServlet {

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        Connection con = null;
	        try {
	            String id = request.getParameter("id");
	            String name = request.getParameter("name");
	            String designation = request.getParameter("designation");
	            String salary = request.getParameter("salary");

	            // Load the database driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhavya", "root", "root");

	            PreparedStatement pstmt = con.prepareStatement("UPDATE employee SET name = ?, designation = ?, salary = ? WHERE id = ?");
	            pstmt.setString(1, name);
	            pstmt.setString(2, designation);
	            pstmt.setInt(3, Integer.parseInt(salary));
	            pstmt.setInt(4, Integer.parseInt(id));

	            int i = pstmt.executeUpdate();

	            out.println("<html><body>");
	            if (i > 0) {
	                out.println("<p>Employee record updated successfully!</p>");
	                out.println("<a href='listEmpIDs'>Go Back to Employee List</a>");
	            } else {
	                out.println("<p>Failed to update the employee record.</p>");
	            }
	            out.println("</body></html>");

	        } catch (Exception e) {
	            e.printStackTrace(out);
	        } finally {
	            try {
	                if (con != null) con.close();
	            } catch (Exception e) {
	                e.printStackTrace(out);
	            }
	        }
	    }
	}
