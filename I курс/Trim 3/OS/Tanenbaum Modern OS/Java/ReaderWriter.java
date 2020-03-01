//Figure 2-34

import Semaphore;

public class ReaderWriter extends Thread {
    
    // Shared objects
    // controls access to rc
    public static Semaphore mutex = new Semaphore(1);   
    
    // controls access to the database
    public static Semaphore db = new Semaphore(1);  
        
    // # of processes reading 
    public static int rc = 0;                           
            
                        
    class DBReader extends Thread {
        private int myNumber;               // Id for the Reader
        
        public DBReader(int i) {            // Constructor for the Reader
            myNumber = i;
        }
        
        public void run(){                  // What a reader does
            while(true) {
                mutex.down();               // Get exclusive access to rc
                rc = rc + 1;                // One reader more now
                if (rc == 1)                // If this is the first reader
                    db.down();              // Get access to database
                mutex.up();                 // Release access to rc
                read_data_base();           // Access the data
                
                mutex.down();               // Get exclusive access to rc
                rc = rc - 1;                // One reader fewer now
                if (rc == 0) 
                    ReaderWriter.db.up();   // If this is the last reader
                ReaderWriter.mutex.up();    // Release access to rc
                use_data_read();            // Noncritical region
            }
        }
        
        public void read_data_base(){
            System.out.println("Reader " + myNumber + " is reading data base");
            try {
                sleep(1000);
            } catch (InterruptedException ex){ }
        }

        public void use_data_read(){
            System.out.println("Reader " + myNumber + " is using the data ");
            try {
                sleep(5000);
            } catch (InterruptedException ex){ }
        }


    } //end of Reader Class

    private class DBWriter extends Thread {
        private int myNumber;               // Id for the Reader
        
        public DBWriter(int i) {            // Constructor for the Reader
            myNumber = i;
        }

        public void run(){                  // What a writer does
            while(true) {
                think_up_data();            // Noncritical region
                db.down();                  // Get exclusive access to database
                write_data_base();          // Update the data
                db.up();                    // Release access to the database
            }
        }
        
        
        public void think_up_data(){
            System.out.println("Writer " + myNumber + " is thinking up data ");
            try {
                sleep(10000);
            } catch (InterruptedException ex){ }
        }
        
        public void write_data_base(){
            System.out.println("Writer " + myNumber + " is writing  data ");
            try {
                sleep(1000);
            } catch (InterruptedException ex){ }
        }

    } //end of Writer Class
            
    
    // How to start things up
    public void run(){                          
        final int READERS = 3;
        final int WRITERS = 4;
        DBReader r;
        DBWriter w;
        
        for(int i=0; i<READERS; i++) {
            // Create and start each reader
            r = new DBReader(i);
            r.start();
        }
        
        for(int i=0; i<WRITERS; i++) {
            // Create and start each writer
            w = new DBWriter(i);
            w.start();
        }
    }
    
    
    // Start the program
    public static void main(String args[]) {
        
        ReaderWriter rw = new ReaderWriter();
        rw.start();

    }

}
                        
