package user;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


public class UserDetails {

	Connection con;
	Statement stmt;
	ResultSet rs;
	
	 UserDetails()
	{
		
	}

	
	 
	public void readUserDetails(int E_Id)
	{
		try
		{
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("Select * from user e inner join company d where e.company_name=d.company_name");
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+ " " +rs.getString(2)+ " " + rs.getInt(3) + " " + rs.getInt(4) + " "+ rs.getString(5) + " "+rs.getString(6)+ " " +rs.getString(7)+ " "+ rs.getString(8)+ " "+rs.getString(9)+ " "+rs.getString(10));   
				
			}
			con.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		String query = "{ call User(?) }";

		try {
			CallableStatement stmt = con.prepareCall(query);
			
			stmt.setString(1, "company_name");
			rs = stmt.executeQuery();
			while (rs.next()) {

				System.out.println(String.format("%s - %s",
						rs.getString("user_name")+ " " + rs.getString("company_name") + " " + rs.getDate("salary") + " "+ rs.getString("contact_no") + " "+rs.getString("post")+ " " +rs.getString("location")+ " "+ rs.getString("date")+ " "+rs.getInt("time")+ " "+rs.getBlob("location")));
			}
		}

		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
	
