
import java.sql.*;
public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class Loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhavya","root","root");
			System.out.println("Connection Established");
			Statement st=con.createStatement();
			String qry="create table employee2(empid integer primary key,ename varchar(30) not null,salary decimal(10,4) not null,gender varchar(10))";
			st.executeUpdate(qry);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}