package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AdminModify {

    public static void main(String[] args) {
		System.out.println("Enter according to Modify dish details");
		System.out.println("Enter 1 to create new dish record");
		System.out.println("Enter 2 to retrieve all dishes details");
		System.out.println("Enter 3 to update dish");
		System.out.println("Enter 4 to delete dish");
		System.out.println("Enter 0 to terminate process");
		Scanner sc=new Scanner(System.in);
		try {
		  while(true) {
		   int n=sc.nextInt();
		   if(n==1 || n==2 || n==3 || n==4 ||n==0) {
		     switch (n) {
		       case 1:
		           dishNew();
			       break;
		       case 2:
			       dishRetrieve();
			       break;
		       case 3:
			       dishUpdate();
			       break;
		       case 4:
			       dishDelete();
			       break;
		       case 0:
			       System.out.print("Modification done successfully");
			       break;
		      }
		    }
	      }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }
	public static void dishUpdate() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?autoReconnect=true&useSSL=false","root","root");
			Scanner sc=new Scanner(System.in);
			System.out.print("please enter which dish to update");
			String a=sc.nextLine();
			System.out.println("What you need to update..??");
			System.out.println("Enter 1 to update name");
			System.out.println("Enter 2 to update price");
			System.out.println("Enter 3 to update quantity");
			int N=sc.nextInt();
			String str_pa=null,str_va=null;
			switch (N) {
			case 1:
				System.out.println("Enter Name :");
				str_pa="dish_name=";
				Scanner sc1=new Scanner(System.in);
				str_va=sc1.nextLine();
				break;
			case 2:
				System.out.println("Enter Price :");
				str_pa="dish_price=";
				Scanner sc2=new Scanner(System.in);
				str_va=sc2.nextLine();
				break;
			case 3:
				System.out.println("Enter Quantity :");
				str_pa="dish_quantity=";
				Scanner sc3=new Scanner(System.in);
				str_va=sc3.nextLine();
				break;
			}
			String query="UPDATE dish_details SET "+str_pa+" '"+str_va+"' WHERE (dish_name='"+a+"')";
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
	public static void dishNew() throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter the Name : ");
			String name=scanner.nextLine();
			System.out.println("Enter the Price : ");
			int price=scanner.nextInt();
			System.out.println("Enter the Quantity : ");
			scanner.nextLine();
			int quantity=scanner.nextInt();
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
 public static void dishDelete() throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?autoReconnect=true&useSSL=false","root","root");
			Scanner sc=new Scanner(System.in);
			System.out.println("Please enter which dish to be deleted");
			String dishname=sc.nextLine();
			String query="DELETE from dish_details WHERE dish_name='"+dishname+"' ";
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
	public static void dishRetrieve() throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
			Statement stmt=con.createStatement();
			String query="select * from dish_details"; 
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				System.out.println("Id : "+rs.getInt(1)+" Name : "+rs.getString("dish_name")
				+" Price : "+rs.getInt("dish_price")+" Quantity : "+rs.getInt(4));
			}
			rs.close();
			stmt.close();
			con.close();
	}

}
