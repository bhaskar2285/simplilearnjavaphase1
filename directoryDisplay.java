package lockedMe.com;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.text.SimpleDateFormat;


public class directoryDisplay {
	public static void main(String [] args) throws IOException{
		
		// added IOException to main to handle the IOException raised in runtime
		boolean userflag = true;
	    
		
		System.out.println("#################################################");
	    System.out.println("#                                               #");
	    System.out.println("#                  LockedMe.com                 #");
	    System.out.println("#              Developer-Bhaskar Singh          #");
	    System.out.println("#              Welcome to LockedMe.com App.     #");
	    System.out.println("#  The app helps user to list the files in the  #");
	    System.out.println("#  user specified directory.Also user can  add ,#");
	    System.out.println("#  delete and search the files they want.       #");
	    System.out.println("#################################################");
	    
	    // create object cf1 for to continue the flow to below menu from other menu's
		continueflow4 cf1 = new continueflow4();
		userflag = cf1.continuetransaction();
		
		while (userflag){

		      System.out.println("Please select from the options in the menu below:");
		      System.out.println("1. Display files in directory in ascending order");
		      System.out.println("2. Add/Delete/Search mentioned files");
		      System.out.println("3. Exit App");
		      
		      String option;
		      
		      try{ 
		    	  
		    	  // use try catch block to handle any invalid input from user
		          // user scanner class to take the input from user for select the option
		          Scanner opt = new Scanner(System.in);
		          option = opt.next();
		          //opt.close();
		          
		          switch (option){
		          case "1":
		         
		          	    // use the directory display class to display the contents in the directory sorted in ascending
		          	    directoryDisplayAscending asc = new directoryDisplayAscending();
		          	    asc.DisplayAscending();
		          	    
		          	    
		          	    //use the continueflow3 class to ask user for continuing the flow or quit
		          	    // userflag is used to control the flow to display menu:if userflag is false then 
		          	    //while loop is discontinued and app closes else it continues.
		          	    
		          	    continueflow3 cf = new continueflow3();
		          	    userflag = cf.continuetransaction();
		          	    break;
		          	
		          case "2": 
		              {   // use the FilOperations class to perform the Fileoperations like add,delete and Search
		              	FileOperations fileh = new FileOperations();
	                      try{
	                      
	                    	//use try catch block to handle any exception related to file handling methods
	                      	fileh.handleFiles();
	                      }catch(Exception E){
	                      	
	                    	System.out.println("Continuing with some issues in file handling");
	                      	userflag = true;
	                      
	                      }
	                     
	                      break;
		              }
                  
		          case "3":// to close app by making the userflag false
		          	    System.out.println("Good Bye, Thank you for using our app");
		          	    userflag = false;
		          	    break;
	              
		          default:
	              	    System.out.println("Please Select the correct option 1, 2 or 3");
		          	    //userflag = false;
		          	    break;
		                
		          }
                  
		      }catch(Exception e){
		      	       //catch exception for any invalid input entered by the user
		      	       System.out.println("Invalid input");
		      	       
		      	       //e.printStackTrace();
		      }
		}
	
	}
}

//directory display class to display directory contents sorted in ascending order
class  directoryDisplayAscending{
	public void DisplayAscending () {
	    
		System.out.println("Enter name of the directory in format (C://Users//bhaskar//Desktop//)");
	    
	    // Take input from user for the directory name the user wants to look the contents of
	    Scanner S = new Scanner(System.in);
	    String  pathnames; 
	    
	    pathnames = S.nextLine();
	    
	    //S.close();
	    
	    // format the date and time using the SimpleDateFormat class
	    SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/YYYY h:mm:ss a");
	    
	    long sizeoffile = 0l;
	    
	    try{
	        // use Try catch block for any exception raised
	        // Use File class and pass pathnames to constructor for initialization
	         File location = new File(pathnames);
	        
	         //used files array to get the list of files from listfiles method and fill up the files array
	         File [] files = location.listFiles();
	        // use the Arrays.sort method to sort the files in ascending order
             
	         Arrays.sort(files);
	         
	         System.out.println("---------------------------------------------------------------------------------------");
	         System.out.println(" " + "Filename               " + " | " + "Last-Modified               " + " | " + "Size");  
	         System.out.println("---------------------------------------------------------------------------------------");
	         
	         //Use for loop to display the contents of the directory showing details like name,last modifed & file size.

	         for(File f:files){
	        	 
	        	 
	        	 sizeoffile = f.length();
	             
	        	 //System.out.println(" " + f.getAbsoluteFile() + "| " + dateformat.format(f.lastModified()) + "| " + sizeoffile + " Bytes");
	        	 System.out.println(" " + f.getName() + "| " + dateformat.format(f.lastModified()) + "| " + sizeoffile + " Bytes");
	             
	        	 
	         }
	    }catch(Exception e){
	    	  System.out.println("Directory not found ");
	    	  //e.printStackTrace();
	    	  
	    	
	    }
    
	}
}


//continueflow3 class inherits the mehods of abstract class continueflow
// this class is used when user have already finished to display directory contents
class continueflow3 extends  continueflow {
    public boolean continuetransaction(){
        
    	String ip1;
        
	    System.out.println("Do you want to continue? Press Yes (Y) to continue,Any other key to quit");
        try{
	    Scanner input1 = new Scanner(System.in);
        ip1 = input1.next();
        //input1.close();
        
        if (ip1.equals("Y") || ip1.equals("y") ){
        	return  true;
        }
        else
        {
        	System.out.println("Good Bye, Thank you for using our app");
        	return false;
        }
        }catch(Exception e){
			
			System.out.println("invalid input");
			return true;
		}
    }
}

//continueflow4 class inherits the mehods of abstract class continueflow
//this class is used at the start of the application and enter the menu for file handling
class continueflow4 extends  continueflow {
    public boolean continuetransaction(){
        
    	String ip1;
        
	    System.out.println(" Press Yes (Y) to Enter ,Any other key to quit");
        try{
        	
	    Scanner input1 = new Scanner(System.in);
        ip1 = input1.next();
        //input1.close();
        
        if (ip1.equals("Y") || ip1.equals("y") ){
        	return  true;
        }
        else
        {
        	System.out.println("Good Bye, Thank you for using our app");
        	return false;
        }
        
        }catch(Exception e){
			
			System.out.println("invalid input");
			return true;
		}       
    }
}
