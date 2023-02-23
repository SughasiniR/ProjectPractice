package maven_project.res_project;

import java.util.*;

public class Admin {
	public static void main(String[] args) {
		
		HKDishes hkdish=new HKDishes();
		MenuUpdate menuupd=new MenuUpdate();
		 try  
	        {  
			 checking(); 
			 boolean as=true;
			 while(as) {
				 System.out.println("\n1. Modify Heaven's Kitchen Dishes \n2. To Retrieve HK Dishes \n3. To Modify Today's Menu \n4. To Retrieve Today's Menu \n5.To Logout");
				    System.out.print("\nEnter : ");
					int n=scclass.sc.nextInt();
					switch (n) {
					case 1:
						hkdish.modifyHKDishes();
						break;
					case 2:						
						hkdish.dishRetrieve();
						break;
					case 3:
						menuupd.modifyTodayMenu();
						break;
					case 4:
						menuupd.menuRetrieve();
						break;
					case 5:
						System.out.println("Successfully Logged Out");
					    as=false;
					    break;
					default:
						System.out.println("Enter correct digit");
					}
				    }
		    } 
	     catch (InvalidNameAndId ex) {  
	            System.out.println(ex);
	     }  
		 catch(Exception e) {
					e.printStackTrace();
		 }
		 
	}
	
//-------------------------------------Admin Login----------------------------------------------------
    static void checking() throws InvalidNameAndId{    	
    	System.out.println(" Enter Name and Password to login ");
		System.out.print("Enter the Name: ");
		String name=scclass.sc.nextLine();
		System.out.println();
		System.out.print("Enter the ID: ");
		String id=scclass.sc.nextLine();
       if(name.equals("admin") && id.equals("admin"))
       {  
    	   System.out.println();
    	   System.out.println(" -----Welcome To Heaven's Kitchen!!!----- ");     
       }  
       else
       {   
           throw new InvalidNameAndId("Name/Id is Invalid"); 
       }   
    }   
}
//------------------------------------------Exception Class---------------------------------------------
class InvalidNameAndId  extends Exception  
{  
    public InvalidNameAndId (String str)  
    {   
        super(str);  
    }  
}

class scclass
{
    static Scanner sc = new Scanner(System.in);
}