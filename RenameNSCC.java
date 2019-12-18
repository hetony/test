import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RenameNSCC {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Path of folder where files are located 
        String folder_path = 
               "/Users/mba/Downloads/nscc"; 
  
        // creating new folder 
        File myfolder = new File(folder_path); 
  
        File[] file_array = myfolder.listFiles(); 
        for (int i = 0; i < file_array.length; i++) 
        { 
  
            if (file_array[i].isFile()) 
            { 
  
            	
                //File myfile = new File(folder_path + 
                //         "\\" + file_array[i].getName());
                
                File myfile = file_array[i];
                
                String fileName = myfile.getName();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
                
                String dateFrom = "12-Dec-19";
                String dateTo = "13-Dec-19";
                
                if (fileName.contains(dateFrom) && sdf.format(myfile.lastModified()).contains(dateTo)) {
                	
                	String newFileName = folder_path + "/" + fileName.replace(dateFrom, dateTo);
                	System.out.println("oldFileName=" + fileName + " => newFileName=" + newFileName);
                	//myfile.renameTo(new File(newFileName));
                }
                
                
                //System.out.println("Before Format : " + myfile.lastModified());
            	
            	
            		
            	//System.out.println("After Format : " + sdf.format(myfile.lastModified()));
                
                //System.out.println(convertTime(myfile.lastModified()));
                
                //System.out.println(myfile.getName() + " creation time :"
                //        + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                //                   .format(getCreationTime(myfile).toMillis()));
                /*
                String long_file_name = file_array[i].getName(); 
                
                String[] tokens = long_file_name.split("\\s"); 
                String new_file_name = tokens[1]; 
                System.out.println(long_file_name); 
                System.out.print(new_file_name); 
  
                // file name format: "Snapshot 11 (12-05-2017 11-57).png" 
                // To Shorten it to "11.png", get the substring which 
                // starts after the first space character in the long 
                // _file_name. 
                myfile.renameTo(new File(folder_path + 
                             "\\" + new_file_name + ".png")); 
                             
                             */
            } 
        } 
    } 

	public static String convertTime(long time){
	    Date date = new Date(time);
	    Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
	    return format.format(date);
	}
	
	public static FileTime getCreationTime(File file) throws IOException {
	    Path p = Paths.get(file.getAbsolutePath());
	    BasicFileAttributes view
	        = Files.getFileAttributeView(p, BasicFileAttributeView.class)
	                    .readAttributes();
	    FileTime fileTime=view.creationTime();
	    //  also available view.lastAccessTine and view.lastModifiedTime
	    return fileTime;
	  }

}
