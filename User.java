package user;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Scanner;


public class User 
{
	
	//public void insertion()  throws Exception
	/*public static void main(String args[])*/
	public void insertUser()
	{
		try
		{
			String user_name,company_name,salary,contact_no,post,location;
			System.out.println("insert user data :");
			Scanner s1= new Scanner(System.in);
			user_name = s1.nextLine();
			company_name = s1.nextLine();
			salary = s1.nextLine();
			contact_no = s1.nextLine();
			post = s1.nextLine();
			location = s1.nextLine();
			
			String query = " insert into user (user_name, company_name,salary,contact_no, post, location)"
			        + " values (?, ?, ?, ?, ?, ?)";
			 
			// create the mysql insert preparedstatement
			
			  GetConnection getConnection=new GetConnection();
			  Connection con= getConnection.createConnection();
		      PreparedStatement pstm = con.prepareStatement(query);

		      pstm.setString (1, user_name);
		      pstm.setString (2, company_name);
		    
		      pstm.setString(3,salary);
		      pstm.setString(4, contact_no);
		      pstm.setString (5, post);
		      pstm.setString (6, location); 

		      // execute the preparedstatement
		      pstm.executeUpdate();
		      
		      //con.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void updateUser()
	{
		ResultSet rs;
		int cnt = 0;
		String sqlUpdate;
		
		try
		{

			System.out.println("update user data :");
			
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
