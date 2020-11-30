package lockedMe.com;
import java.util.Scanner;


import java.io.*;



public class FileOperations {
	public void handleFiles() throws Exception, IOException{
	boolean userflag = true;
	while (userflag){
		
	
	try{
	System.out.println("1. Add user mentioned files");
    System.out.println("2. Delete user mentioned files");
    System.out.println("3. Search user mentioned files");
    System.out.println("Any key to previous menu");
	String option2;
    
    Scanner opt2 = new Scanner(System.in);
    option2 = opt2.next();
    

    
	switch(option2){
	case "1":
		addFile addfile = new addFile();
		addfile.fileadd();
		continueflow2 cf1 = new continueflow2();
		userflag = cf1.continuetransaction();
		//continue;
		break;
	case "2":
		deleteFile delfile = new deleteFile();
		delfile.fileDelete();
		continueflow2 cf2 = new continueflow2();
		userflag = cf2.continuetransaction();
		//continue;
		break;
	case "3":
		SearchFile searchit = new SearchFile();
		searchit.search();
		continueflow2 cf3 = new continueflow2();
		userflag = cf3.continuetransaction();
		//continue;
		break;
	default:
		userflag = false;
		//continue;
		break;
	
	}
	//return true;
	}catch(Exception e){
		System.out.println("invalid input");
		//userflag = false;
	}
    }
	
	}
}

class findMyFile implements FilenameFilter{
	String fileToSearch;
	public findMyFile(File location,String fileToSearch){
		
		this.fileToSearch = fileToSearch;
		
	}
	public boolean accept(File location, String name ){
		return name.startsWith(fileToSearch);
		
	}
}
class SearchFile{
	public void search(){
		System.out.println("Enter name of the directory you want to search files in the"
				+ " format C://Users//bhaskar//Desktop//");
		Scanner S = new Scanner(System.in);
		String pathnames;
		pathnames = S.next();
		File location = new File(pathnames);
		//File [] files = location.listFiles();
		System.out.println("Enter name of the file to be searched");
		@SuppressWarnings("resource")
		Scanner filesrch = new Scanner(System.in);
		String srchfile;
		srchfile = filesrch.next();
		findMyFile srch = new findMyFile(location, srchfile);
		
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
				System.out.println("We have found the file you mentioned: "+ flist[i]);
			}
			}
		}
	}
}
class deleteFile{
	public void fileDelete(){
		System.out.println("Enter the full path of the file to be deleted in "
				+ "the format C://Users//bhaskar//Desktop//Filename.txt");
		Scanner S = new Scanner(System.in);
		String pathnames;
		pathnames = S.next();
		File location = new File(pathnames);
		if (location.delete()){
			System.out.println("Delete Successfull");
		}
		else{
			System.out.println("File not Found");
		}
		
	}
}
class addFile{
	public void fileadd() throws IOException,SecurityException{
		System.out.println("Enter the full path of the file to be added "
				+ "in the format C://Users//bhaskar//Desktop//Filename.txt");
		Scanner S = new Scanner(System.in);
		String pathnames;
		pathnames = S.next();
		File location = new File(pathnames);
	
		/*try{
			FileWriter location = new FileWriter(pathnames);
			location.write("hi");
			location.close();
			
		}catch(IOException ioe){
			System.out.println("Could not create file");
			ioe.printStackTrace();
		}*/
		if ( location.createNewFile() ){
			System.out.println("File Created successfully");
		}
		else
		{
			System.out.println("Could not create file");
		}
		
	}
}

abstract class continueflow{
	abstract public boolean continuetransaction();
}
class continueflow2 extends continueflow{
    public boolean continuetransaction(){
    String ip1;
    
	System.out.println("Press Any key to continue");
    Scanner input1 = new Scanner(System.in);
    ip1 = input1.next();
    return true;
    }
}