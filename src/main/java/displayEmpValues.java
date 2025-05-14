
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/displayEmpValues")
public class displayEmpValues extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection con = null;
        try {
            String id = request.getParameter("id");
            
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhavya", "root", "Bhavya@08");

            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM employee WHERE id = ?");
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();

            out.println("<html><body>");
            if (rs.next()) {
                out.println("<form action='updateEmpByID' method='post'>");
                out.println("<input type='hidden' name='id' value='" + id + "'>");
                out.println("<label>Name:</label><input type='text' name='name' value='" + rs.getString("name") + "'><br>");
               // out.println("<label>Designation:</label><input type='text' name='designation' value='" + rs.getString("designation") + "'><br>");
                //out.println("<label>Salary:</label><input type='text' name='salary' value='" + rs.getInt("salary") + "'><br>");
                out.println("<input type='submit' value='Update'>");
                out.println("</form>");
            } else {
                out.println("<p>No employee found with ID " + id + "</p>");
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
