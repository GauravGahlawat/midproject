package user;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	public GetConnection() {
		// TODO Auto-generated constructor stub
		
	}
	Connection con;
	
		Connection createConnection()
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); // cj is a latest driver //loading and registering the driver
				con = DriverManager.getConnection("jdbc:mysql://localhost:3307/jobportal", "root", "gaurav1997TISHA");

				/*Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3307/classicmodels","root","gaurav1997TISHA");*/
			}

			catch (Exception e) {
				System.out.println(e);
				//e.printStackTrace();
			}
			return con;
		}
	}

