//Figure 9-13

import UnixAPI.*;

import Semaphore;

public class ExecutableFiles extends Object {

    public static void search(String dir_name){     // Recursively search for 
                                                    // executables
        UnixDirectory dirp;                         // Reference to a directory 
                                                    // stream
        UnixDirectoryEntry dp;                      // A directory entry
        UnixStat sbuf;                              // For lstat to see if the 
                                                    // file is a sym link
        
        dirp = UnixAPI.opendir(dir_name);           // Open this directory
        if(dirp == null) return;                    // Could not be opened; 
                                                    // forget it
        
        while(true){
            dp = dirp.readdir()                     // Read next directory 
                                                    // entry
            if(dp == null) {                        // Null means we are done
                UnixAPI.chdir("..");                // Go back to parent 
                                                    // directory
                break;                              // Exit loop
            }
            if(dp.name.charAt(0) == '.')            // Skip the . and .. 
                                                    // directories
                continue;
            sbuf = UnixAPI.lstat(dp.name);          // Is the entry a symbolic 
                                                    // link
            if (UnixAPI.S_ISLNK(sbuf.st_mode))      // Skip symbolic links
                continue;
            if (UnixAPI.chdir(dp.name) == 0){       // If chdir succeeds,it 
                                                    // must be a dir
                search(".");                        // Yes, enter and search it
            } else {                                // No (file)
                if(UnixAPI.access(dp.name, UnixAPI.X_OK) == 0)
                    infect(dp.name);                // If executable, infect it
            }
            
            dirp.closedir();                        // Dir processed, close and 
                                                    // return       
}
                    
                        
                        
