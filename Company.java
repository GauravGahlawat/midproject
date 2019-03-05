package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Company {
	/*public static void main(String args[])*/
	public void insertCompany()
	{
		try
		{
			int company_id,user_id;
			String company_name,date,time,location;
			System.out.println("insert company data :");
			Scanner s1= new Scanner(System.in);
			company_id = s1.nextInt();
			company_name = s1.next();
			date = s1.next();
			time=s1.next();
			location = s1.next();
			user_id = s1.nextInt();
			String query = " insert into company (company_id,company_name, date, time, location,user_id)"
			        + " values (?, ?, ?, ?, ?, ?)";
			 
			// create the mysql insert preparedstatement
			
			  GetConnection getConnection=new GetConnection();
			  Connection con= getConnection.createConnection();
		      PreparedStatement pstm = con.prepareStatement(query);

		      pstm.setInt(1, company_id);
		      pstm.setString (2, company_name);
		      pstm.setString (3, date);
		      pstm.setString(4,time);
		      pstm.setString(5, location);
		      pstm.setInt(6, user_id);
		     

		      // execute the preparedstatement
		      pstm.executeUpdate();
		      
		      //con.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void updateCompany()
	{
		
	ResultSet rs;
	int cnt = 0;
	String sqlUpdate;
	
	try
	{

		System.out.println("update company data :");
		
		sqlUpdate = "UPDATE company SET company_name=?,date=?,time=?,location=? WHERE company_id = ?";
		
		//pstmt = con.prepareStatement(sqlUpdate);
		

		  GetConnection getConnection=new GetConnection();
		  Connection con= getConnection.createConnection();
	      PreparedStatement pstmt = con.prepareStatement(sqlUpdate);
		
		// prepared data for Update
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Company Id :");
		
		int company_id = s.nextInt(); // used to enter the company id
		 s.nextLine();

		System.out.println("Enter Company Name :");
		
		String company_name = s.nextLine(); // update company name for respective id we have given

		System.out.println("Enter New Date :");
		
		String date = s.nextLine(); // update date for respective id we have given

		System.out.println("Enter New Time :");
		
		String time = s.nextLine(); // update time for respective id we have given

		System.out.println("Enter New Location :");
		
		String location = s.nextLine(); // update location for respective id we have given
		pstmt.setString(1,company_name);
		pstmt.setString(2,date);
		pstmt.setString(3,time);
		pstmt.setString(4,location);
		pstmt.setInt(5,company_id);
		
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
