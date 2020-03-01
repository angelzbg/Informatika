//Figure 2-34

import Semaphore;

public class ReaderWriter extends Thread {
    
    // Shared objects
    public static Semaphore mutex = new Semaphore(1);   // control access to rc
    public static Semaphore db = new Semaphore(1);      // control access to 
                                                        // the database
    public static int rc = 0;                           // # of processes 
                                                        // reading 
            
                        
    class DBReader extends Thread {

        public void run(){                      // What a reader does
            while(true) {
                mutex.down();                   // Get exclusive access to rc
                rc = rc + 1;                    // One reader more now
                if (rc == 1)                    // If this is the first reader
                    db.down();                  // Get access to database
                mutex.up();                     // Release access to rc
                read_data_base();               // Access the data
            
                mutex.down();                   // Get exclusive access to rc
                rc = rc - 1;                    // One reader fewer now
                if (rc == 0) 
                    ReaderWriter.db.up();       // If this is the last reader
                ReaderWriter.mutex.up();        // Release access to rc
                use_data_read();                // Noncritical region
            }
        }

    } //end of Reader Class

    private class DBWriter extends Thread {

        public void run(){                      // What a writer does
            while(true) {
                think_up_data();                // Noncritical region
                db.down();                      // Get exclusive access to 
                                                // database
                write_data_base();              // Update the data
                db.up();                        // Release access to the 
                                                // database
            }
        }
    } //end of Writer Class

}
                        
