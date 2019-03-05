package user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateCompany {

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
