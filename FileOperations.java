package lockedMe.com;
import java.util.Scanner;
import java.io.*;



public class FileOperations {
	public void handleFiles() throws Exception{
	// add class Exception to check for any exception thrown by the class
	
	//try catch block to handle any exception that occur during option selection
    boolean userflag = true;
	while (userflag){
	
	try{

		System.out.println("Welcome to File Handling Menu, Please select from the options below:");
	    System.out.println("1. Add user mentioned files");
        System.out.println("2. Delete user mentioned files");
        System.out.println("3. Search user mentioned files");
        System.out.println("Press any other key to go to previous menu");
	    
        String option2;
        
        // take input from user to select the desired file operation
        Scanner opt2 = new Scanner(System.in);
        option2 = opt2.next();
        
        //opt2.close();
            
	    switch(option2){
	        
	        case "1":
	        	//use addfile class to add file to user mentioned directory
	        	addFile addfile = new addFile();
	        	addfile.fileadd();
	        	continueflow2 cf1 = new continueflow2();
	        	userflag = cf1.continuetransaction();
	        	break;
	        
	        case "2":
	        	//use deletefile class to delete file from user mentioned directory
	        	deleteFile delfile = new deleteFile();
	        	delfile.fileDelete();
	        	continueflow2 cf2 = new continueflow2();
	        	userflag = cf2.continuetransaction();
	        	break;
	        
	        case "3":
	        	//use searchfile class to search file from user mentioned directory
	        	SearchFile searchit = new SearchFile();
	        	searchit.search();
	        	continueflow2 cf3 = new continueflow2();
	        	userflag = cf3.continuetransaction();
	        	break;
	        
	        default:
	        	userflag = false;
	        	break;
	        
	        }
	    }catch(Exception e){
	    	    
	    	    System.out.println("invalid input");
	    }
    }
	
	}
}
// filenamefilter interface class to use call the accept method inorder to search a user mentioned file
class findMyFile implements FilenameFilter{
	
	String fileToSearch;
	//initialize constructor with file name and location of the file to search
	public findMyFile(File location,String fileToSearch){
		
		this.fileToSearch = fileToSearch;
		
	}
	//accept method to search the file in the user mentioned location
	public boolean accept(File location, String name ){
		return name.startsWith(fileToSearch);
		
	}
}
//Search file class is used to search a user mentioned file in the user mentioned directory

class SearchFile{
	public void search(){
		
		System.out.println("Enter name of the directory you want to search files in the"
				+ " format C://Users//bhaskar//Desktop//");
		//take input from user for the pathname of the directory
		Scanner S = new Scanner(System.in);
		String pathnames;
		pathnames = S.nextLine();
		//S.close();
		
		//use file class constructor to initialize it with the pathname
		File location = new File(pathnames);
		
		System.out.println("Enter name of the file to be searched:");
		
		//Take input from user reqgarding the filename
		
		
		Scanner filesrch = new Scanner(System.in);
		String srchfile;
		srchfile = filesrch.nextLine();
		//filesrch.close();
		
		//use findmyfile class to search the file 
		findMyFile srch = new findMyFile(location, srchfile);
		
		//load the flist array with files found by the names entered by user
		String[] flist = location.list(srch);
			
		if (flist == null){
			System.out.println("directory not found");
			
		}
		else{
			if (flist.length == 0){
				System.out.println("No files found");
			}
			else{
			for(int i=0;i<flist.length;i++){
				// display the files found to the user
				System.out.println("We have found the file you mentioned: "+ flist[i]);
			}
			}
		}

	}
}

//user delete file class to delete files from a directory
class deleteFile{
	public void fileDelete(){
		
		System.out.println("Enter the full path of the file to be deleted in "
				+ "the format C://Users//bhaskar//Desktop//Filename.txt");
		
		// take input from the user for the filelocation and file the user need to delete
		
		Scanner S = new Scanner(System.in);
		String pathnames;
		pathnames = S.nextLine();
		//S.close();
		
		//use file class to call the delete method to delete the file
		File location = new File(pathnames);
		
		if (location.delete()){
			System.out.println("Delete Successfull");
		}
		else{
			System.out.println("File not Found");
		}
		
	}
}

// add class to add file to the user mentioned directory
class addFile{
	public void fileadd() throws IOException,SecurityException{
		System.out.println("Enter the full path of the file to be added "
				+ "in the format C://Users//bhaskar//Desktop//Filename.txt");
		
		Scanner S = new Scanner(System.in);
		String pathnames;
		pathnames = S.nextLine();
		//S.close();
		
		File location = new File(pathnames);
	    
		if ( location.createNewFile() ){
			System.out.println("File Created successfully");
		}
		else
		{
			System.out.println("Could not create file");
		}
        
		
	}
}

//abstract class to add logic to continue the go back forth across menu

abstract class continueflow{
	abstract public boolean continuetransaction();
}

//continueflow class to continue option selection after one user operation is completed

class continueflow2 extends continueflow{
    public boolean continuetransaction(){
        
        
	    System.out.println("Press Any key to continue");
        Scanner input1 = new Scanner(System.in);
        input1.next();
        
        //input1.close();
        
        return true;
    }
}