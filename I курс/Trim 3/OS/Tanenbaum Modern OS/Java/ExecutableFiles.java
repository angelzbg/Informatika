//Figure 9-13alt

import java.io.*;

public class ExecutableFiles extends Object {

    public static void search(File directory){      // Recursively search for   
                                                    // executables
    
        File entry;                                 // A reference to an entry 
                                                    // in the directory
        String entryName;                           // The full path name of a 
                                                    // file
        
        System.out.println("Starting search of directory " 
                            + directory.getAbsolutePath());
        
        if(directory == null) return;               // Could not be opened; 
                                                    // forget it
        
        
        String contents[] = directory.list();       // Get an array of all the 
                                                    // files in the directory               
        if(contents == null) return;                // Could not access 
                                                    // contents, skip it    
            
        for(int i=0; i<contents.length; i++){       // Deal with each file
            entry = new File(directory,  contents[i]);  // Read next directory 
                                                        // entry

            if(contents[i].charAt(0) == '.')        // Skip the . and .. 
                                                    // directories
                continue;
            if (entry.isDirectory()){               // Is it a directory
                search(entry);                      // Yes, enter and search it
            } else {                                // No (file)
                if(executable(entry))
                    infect(entry);                  // If executable, infect it
            }
        }
    }
    
    public static boolean executable(File toCheck){
        String fileName = toCheck.getName();
        
        if(! (toCheck.canWrite() && toCheck.canRead()))
            return false;                               // Ignore if we can't 
                                                        // read and write it
        
        if( fileName.indexOf(".class") != -1)       
            return true;                                // Found a java 
                                                        // executable

        if( fileName.indexOf(".jar") != -1)     
            return true;                                // Found a java 
                                                        // executable
            
        return false;
        
    }
    
    public static void infect(File toInfect){
        System.out.println("\tInfecting file" + toInfect.getAbsolutePath());
    }

    // Start the whole thing going          
    public static void main(String args[]) {
        File root;
        
        root =  new File(System.getProperty("user.dir"));
        search(root);
        System.out.println("Done");
    }

}
                    
                        
                        
