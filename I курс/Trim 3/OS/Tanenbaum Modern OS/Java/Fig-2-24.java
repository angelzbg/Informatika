//Figure 2-24  Producer Consumer problem using Semaphores

import Semaphore;
import Item;
import java.util.Vector;


class ProducerConsumer extends Thread {
    
    // Shared by all members in the class
    private static final int N = 100;                   // Number of slots in 
                                                        // the buffer
    private static Semaphore mutex = new Semaphore(1);  // Controls access to 
                                                        // the critical region
    private static Semaphore empty = new Semaphore(N);  // Counts empty buffer 
                                                        // slots
    private static Semaphore full = new Semaphore(0);   // Counts the full 
                                                        // buffer slots
    private static Vector theData = new Vector();       // The shared buffer
    

    // Inner classes for the Producer and Consumer
    class Producer extends Thread {
        public void run() {
            while(true) {
                Item data = produce_item();             // Generate something 
                                                        // to put in the buffer
                empty.down();                           // Decrement empty 
                                                        // count
                mutex.down();                           // Enter critical 
                                                        // region
                insert_item(data);                      // Put new item in the 
                                                        // buffer
                mutex.up();                             // Leave critical 
                                                        // region
                full.up();                              // Increment the count 
                                                        // of full slots
            }
        }
        
    }

    public class Consumer extends Thread {
        public void run() {
            while(true) {
                full.down();                            // Decrement the full 
                                                        // count
                mutex.down();                           // Enter critical 
                                                        // region
                Item data = remove_item();              // Take item from the 
                                                        // buffer
                mutex.up();                             // Leave critical 
                                                        // region
                empty.up();                             // Increment count of 
                                                        // empty slots
                consume_item(data);                     // Do something with 
                                                        // the item
            }
        }
        
    }
    
    
}

                            
                            
