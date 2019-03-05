package user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*
		Connection con;
		PreparedStatement pstmt;*/
		ResultSet rs;
		int cnt = 0;
		String sqlUpdate;
		
		try
		{
			
			sqlUpdate = "UPDATE user SET user_name=?,company_name=?,salary=?,contact_no=?,post=?,location=? WHERE user_id = ?";
			
			//pstmt = con.prepareStatement(sqlUpdate);
			

			  GetConnection getConnection=new GetConnection();
			  Connection con= getConnection.createConnection();
		      PreparedStatement pstmt = con.prepareStatement(sqlUpdate);
			
			// prepared data for Update
			
			Scanner s = new Scanner(System.in);
			
			System.out.println("Enter User Id :");
			
			int user_id = s.nextInt(); // used to enter the company id
			s.nextLine();

			System.out.println("Enter User Name :");
			
			String user_name = s.nextLine(); // update user name for respective id we have given

			System.out.println("Enter Company Name :");
			
			String company_name = s.nextLine(); // update company name for respective id we have given

			System.out.println("Enter Salary :");
			
			String salary = s.nextLine(); // update salary for respective id we have given

			System.out.println("Enter Contact Number :");
			
			String contact_no = s.nextLine(); // update contact number for respective id we have given
			
			System.out.println("Enter Post  :");
			
			String post = s.nextLine(); // update post for respective id we have given

			System.out.println("Enter New Location :");
			
			String location = s.nextLine(); // update location for respective id we have given
			pstmt.setString(1,user_name);
			pstmt.setString(2,company_name);
			pstmt.setString(3,salary);
			pstmt.setString(4,contact_no);
			pstmt.setString(5,post);
			pstmt.setString(6,location);
			pstmt.setInt(7,user_id);
			
			int rowAffected = pstmt.executeUpdate();
			System.out.println("Row Affected :" + rowAffected);
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}

}
