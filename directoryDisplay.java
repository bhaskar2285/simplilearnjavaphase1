package lockedMe.com;
import java.io.*;
import java.util.Scanner;

import java.util.Arrays;
import java.text.SimpleDateFormat;


public class directoryDisplay {
	public static void main(String [] args) throws IOException{
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
	    
		continueflow4 cf1 = new continueflow4();
		userflag = cf1.continuetransaction();
		
		while (userflag){

		System.out.println("Select your options from the menu below");
		System.out.println("1. Display files in directory in ascending order");
		System.out.println("2. Add/Delete/Search mentioned files");
		System.out.println("3. Exit App");
		
		String option;
		
		try{
			Scanner opt = new Scanner(System.in);
		    option = opt.next();
		
		
		
		
		switch (option){
		case "1":
			
			directoryDisplayAscending asc = new directoryDisplayAscending();
			asc.DisplayAscending();
			continueflow3 cf = new continueflow3();
			userflag = cf.continuetransaction();
			break;
			
		case "2": 
		    {   FileOperations fileh = new FileOperations();
	            try{
	            	//userflag = fileh.handleFiles();
	            	fileh.handleFiles();
	            }catch(Exception E){
	            	System.out.println("Continuing with some issues in file handling");
	            	userflag = true;
	            }
	            //userflag = continuetransaction();
	            break;
		    }

		case "3":
			System.out.println("Good Bye, Thank you for using our app");
			userflag = false;
			break;
	    default:
	    	System.out.println("Please Select the correct option 1, 2 or 3");
			//userflag = false;
			break;
		
			
			
		

		}

	    
		}catch(Exception e){
			System.out.println("Invalid input");
			//e.printStackTrace();
		}	
		}
	
	}

    
    

}


class  directoryDisplayAscending{
	public void DisplayAscending () {
	System.out.println("Enter name of the directory in format (C://Users//bhaskar//Desktop//)");
	Scanner S = new Scanner(System.in);
	String  pathnames; 
	pathnames = S.next();
	
	SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/YYYY h:mm:ss a");
	long sizeoffile = 0l;
	try{
	File location = new File(pathnames);
	
	File [] files = location.listFiles();
	 Arrays.sort(files);
	 System.out.println("---------------------------------------------------------------------------------------");
	 System.out.println(" " + "Filename               " + " | " + "Last-Modified               " + " | " + "Size");  
	 System.out.println("---------------------------------------------------------------------------------------");
	 for(File f : files){
		 sizeoffile = f.length();
	     //System.out.println(" " + f.getAbsoluteFile() + "| " + dateformat.format(f.lastModified()) + "| " + sizeoffile + " Bytes");
		 System.out.println(" " + f.getName() + "| " + dateformat.format(f.lastModified()) + "| " + sizeoffile + " Bytes");
	 }
	}catch(Exception e){
		System.out.println("Directory not found ");
		
	}
    
	}
}


class continueflow3 extends  continueflow {
    public boolean continuetransaction(){
    String ip1;
    
	System.out.println("Do you want to continue? Press Yes (Y) to continue,Any other key to quit");
    Scanner input1 = new Scanner(System.in);
    ip1 = input1.next();
    if (ip1.equals("Y") || ip1.equals("y") ){
    	return  true;
    }
    else
    {
    	System.out.println("Good Bye, Thank you for using our app");
    	return false;
    }
    }
}

class continueflow4 extends  continueflow {
    public boolean continuetransaction(){
    String ip1;
    
	System.out.println(" Press Yes (Y) to Enter ,Any other key to quit");
    Scanner input1 = new Scanner(System.in);
    ip1 = input1.next();
    if (ip1.equals("Y") || ip1.equals("y") ){
    	return  true;
    }
    else
    {
    	System.out.println("Good Bye, Thank you for using our app");
    	return false;
    }
    }
}
