package com;

import java.util.Scanner;
public class Admin1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the Name: ");
		String name=sc.nextLine();
		System.out.println();
		System.out.print("Enter the ID: ");
		String id=sc.nextLine();
		 try  
	        {   
			 checking(name,id);  
	        }  
	     catch (InvalidNameAndId ex)  
	        {  
	            System.out.println(ex);
	        }  
	}

    static void checking(String name,String id) throws InvalidNameAndId{    
       if(name.equals("admin") && id.equals("admin"))
       {  
    	   System.out.println("welcome!!!");     
       }  
       else
       {   
           throw new InvalidNameAndId("Name/Id is Invalid"); 
       }   
    }   
}

class InvalidNameAndId  extends Exception  
{  
    public InvalidNameAndId (String str)  
    {   
        super(str);  
    }  
}  
