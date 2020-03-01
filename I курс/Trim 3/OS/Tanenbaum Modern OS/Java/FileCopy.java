//Figure 6-5

// A File copy program with minimal error checking and reporting

import java.io.*;

public class FileCopy extends Object {


    public static void main(String args[]) {
        
        FileInputStream in_fd = null;
        FileOutputStream out_fd = null;
        
        final int BUFFERSIZE = 4096;
        int rd_count = 0;                       // Amount of data read
    
        byte buffer[] = new byte[BUFFERSIZE];   // Use a buffer of size 4096
    
        if (args.length != 2) System.exit(1);   // Expecting two arguments
            
        try{
            in_fd = new FileInputStream(args[0]);   // Open the source file
        } catch(FileNotFoundException ex) {
            System.exit(2);                         // Could not open the file
        }
        
        try{        
            out_fd = new FileOutputStream(args[1]); // Open the destination         
                                                    // file
        } catch(FileNotFoundException ex) {
            System.exit(3);                         // Could not open the file
        }
        
        while(true) {
            try{
                rd_count = in_fd.read(buffer);      // Read a block of data
            } catch(IOException ex) {
                System.exit(5);                     // Failure on read of file
            }
            
            if(rd_count <=0) break;                 // If end of file exit loop
            
            try{
                out_fd.write(buffer,0,rd_count);    // Write data
            } catch(IOException ex) {
                System.exit(4);                     // Failure on read of file
            }
        }
        
        // Close the files
        try{
            in_fd.close();
            out_fd.close();             
        } catch(IOException ex) {
            System.exit(6);                         // Failure on closing 
        }
        
        System.exit(0);                             // Normal completion
        
    }                   
}
                    
                        
                        
