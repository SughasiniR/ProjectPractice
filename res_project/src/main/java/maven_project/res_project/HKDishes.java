package maven_project.res_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.commons.lang3.math.NumberUtils;

public class HKDishes {
	
	public static void modifyHKDishes() throws Exception{
		System.out.println();
	    System.out.println(" ---- Heaven's Kitchen Dish List ---- ");
		boolean ass=true;
		while(ass) {
		System.out.println("\n1.Create new dish record \n2.Retrieve all dishes details \n3.Update dish \n4.Delete dish \nEnter 'exit' to Terminate process");		 
	    System.out.print("\nEnter : ");
		String n=scclass.sc.next();
		if(NumberUtils.isDigits(n)) {
		switch (n) {
		case "1":
			dishNew();
			break;
		case "2":
			dishRetrieve();
			break;
		case "3":
			dishUpdate();
			break;
		case "4":
			dishDelete();
			break;
		default:
			System.out.println("Enter correct digit");
		}
		}
		else {
			System.out.println("Successfully modification made");
			break;
		}
	    }
	}
	
	//------------------------------------Dish Detail Retrieve------------------------------------------
	public static void dishRetrieve() throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resproject","root","root");
			Statement stmt=con.createStatement();
			String query="select * from dish_details"; 
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
	
	//---------------------------Update-----------------------------------------------------
		public static void dishUpdate() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resproject","root","root");
			System.out.print("Enter Dish ID to update  ");
			int a=scclass.sc.nextInt();
			System.out.println("\nWhat you need to update..??");
			System.out.println("1.Name update ");
			System.out.println("2.Price update ");
			System.out.println("3.Quantity update ");
			int N=scclass.sc.nextInt();
			String str_pa=null,str_va=null;
			switch (N) {
			case 1:
				System.out.print("Enter Name :");
				str_pa="dish_name=";
				str_va=scclass.sc.next();
				break;
			case 2:
				System.out.print("Enter Price :");
				str_pa="dish_price=";
				str_va=scclass.sc.next();
				break;
			case 3:
				System.out.print("Enter Quantity :");
				str_pa="dish_quantity=";
				str_va=scclass.sc.next();
				break;
			}
			String query="UPDATE dish_details SET "+str_pa+" '"+str_va+"' WHERE dish_id='"+a+"'";
			PreparedStatement ps=con.prepareStatement(query);
			int count=ps.executeUpdate();
			if(count>0)
			{
				System.out.println("Data updated successfully");
			}
			else
			{
				System.out.println("Unable to update data");
			}
			
			ps.close();
			con.close();
		}	
		//---------------------------------Create--------------------------------------------------------
	public static void dishNew() throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resproject","root","root");
			System.out.print("\nEnter the Name : ");
			String name=scclass.sc.next();
			System.out.println("Enter the Price : ");
			int price=scclass.sc.nextInt();
			System.out.println("Enter the Quantity : ");
			int quantity=scclass.sc.nextInt();
			String query="insert into dish_details(dish_name,dish_price,dish_quantity) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, price);
			ps.setInt(3, quantity);
			int count=ps.executeUpdate();
			if(count>0)
			{
				System.out.println("Created successfully");
			}
			else
			{
				System.out.println("Oops! Unable to create. Please try again!!");
			}
			ps.close();
			con.close();
		}	
	//----------------------------------Delete----------------------------------------------------------
	public static void dishDelete() throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resproject?autoReconnect=true&useSSL=false","root","root");
			System.out.println("Please enter which Dish ID to be deleted");
			int dishid=scclass.sc.nextInt();
			String query="DELETE from dish_details WHERE dish_id='"+dishid+"' ";
			PreparedStatement ps=con.prepareStatement(query);
			int count=ps.executeUpdate();
			if(count>0)
			{
				System.out.println("Data Deleted Successfully");
			}
			else
			{
				System.out.println("Unable to delete data");
			}
			ps.close();
			con.close();
	}

}
