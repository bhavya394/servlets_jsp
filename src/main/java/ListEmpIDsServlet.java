
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ListEmpIDsServlet")
public class ListEmpIDsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection con = null;
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhavya", "root", "Bhavya@08");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id FROM employee");

            out.println("<html><body>");
            out.println("<form action='displayEmpValues' method='get'>");
            out.println("<label>Select Employee ID:</label>");
            out.println("<select name='id'>");

            while (rs.next()) {
                int id = rs.getInt("id");
                out.println("<option value='" + id + "'>" + id + "</option>");
            }

            out.println("</select>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
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
