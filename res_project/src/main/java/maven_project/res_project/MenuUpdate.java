package maven_project.res_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.lang3.math.NumberUtils;

public class MenuUpdate {
	
	public static void modifyTodayMenu() throws Exception{
		 System.out.println("\n1.To create new \n2.To modify in existing");
		 System.out.print("Enter: ");
		 int N=scclass.sc.nextInt();
		 boolean str1=false;
		 if(N==1) {
			 truncaterecords();
			 str1=true;
		 }
		 else if(N==2) {
			 str1=true;
		 }
		 System.out.println("\nEnter dish ID to add \nEnter 'exit' to Terminate process");
		 while(str1){
			 System.out.print("\nEnter: ");
			 String n = scclass.sc.next();  
			 if(NumberUtils.isDigits(n)) {
				 todaysMenu(n);	
				 
				 str1=true;
			 }
			 else {
				 str1=false;
				 System.out.println(" Succesfully dishes updated ");
			 }
       } 
	}
	
	//-----------------------------------Menu Add--------------------------------------------
	public static void todaysMenu(String a) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resproject?autoReconnect=true&useSSL=false","root","root");	
		String query="INSERT INTO menu SELECT * FROM dish_details WHERE dish_id="+a+"";
		PreparedStatement ps=con.prepareStatement(query);
		int count=ps.executeUpdate();
		if(count>0)
		{
			System.out.println("Data updated successfully");
		}
		else
		{
			System.out.println("Please enter correct id to update sdata");
		}
		ps.close();
		con.close();
	}
	//----------------------------------Truncate Menu Table----------------------------------------------
	public static void truncaterecords() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resproject","root","root");
		String query="TRUNCATE TABLE menu";
		PreparedStatement ps=con.prepareStatement(query);
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	//----------------------------------------------Menu Retrieve----------------------------------------------
	public static void menuRetrieve() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resproject","root","root");
		Statement stmt=con.createStatement();
		String query="select * from menu"; 
		ResultSet rs=stmt.executeQuery(query);
		System.out.println("---------------------------------------------------------------------");
		while(rs.next())
		{
			System.out.print("Id : "+rs.getInt(1)+"\t Name : "+rs.getString("dish_name"));
			System.out.println("\t\t Price : "+rs.getInt("dish_price")+"\t Quantity : "+rs.getInt(4));
		}
		System.out.println("---------------------------------------------------------------------");
		rs.close();
		stmt.close();
		con.close();
	}


}
