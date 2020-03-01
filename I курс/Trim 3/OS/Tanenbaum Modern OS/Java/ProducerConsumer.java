//Figure 2-26  Producer Consumer problem using Semaphores

import Semaphore;
import Item;
import java.util.Vector;


class ProducerConsumer extends Thread {
    
    // Shared by all members in the class
    // Number of slots in the buffer
    private static final int N = 100;                   
    
    // Controls access to the critical region
    private static Semaphore mutex = new Semaphore(1);  
    
    // Counts empty buffer slots
    private static Semaphore empty = new Semaphore(N);  
    
    // Counts the full buffer slots
    private static Semaphore full = new Semaphore(0);   
    
    // The shared buffer
    private static Vector theData = new Vector();       

    // Inner classes for the Producer and Consumer
    class Producer extends Thread {
        public void run() {
            while(true) {
                Item data = produce_item();     // Generate something to put in 
                                                // the buffer
                empty.down();                   // Decrement empty count
                mutex.down();                   // Enter critical region
                insert_item(data);              // Put new item in the buffer
                mutex.up();                     // Leave critical region
                full.up();                      // Increment the count of full 
                                                // slots
            }
        }
        
        // Sleep a bit then make an item
        private Item produce_item(){
            Item data;
            try{sleep(1000);}
            catch(InterruptedException ex){};
            data = new Item(0,itemCount++);
            System.out.println("Producer  making item " + data);

            return data;
        }
        
        // Put data at the end of the vector
        private void insert_item(Item data){
            theData.add(data);
        }
        
        // Count of Items created
        private int itemCount = 0;
        
    }

    public class Consumer extends Thread {
        public void run() {
            while(true) {
                full.down();                    // Decrement the full count
                mutex.down();                   // Enter critical region
                Item data = remove_item();      // Take item from the buffer
                mutex.up();                     // Leave critical region
                empty.up();                     // Increment count of empty 
                                                // slots
                consume_item(data);             // Do something with the item
            }
        }
        
        // Print something out and then sleep a bit
        private void consume_item(Item data){
            System.out.println("Consumer used item " + data);
            try{sleep(7000);}
            catch(InterruptedException ex){};
        }
        
        // Get the first element from the vector
        private Item remove_item(){
            Item data = (Item) theData.firstElement();
            theData.removeElementAt(0);
            return data;
        }

        
    }
    
    
    // What the ProducerConsumer Thread does
    public void run(){
        Producer p;
        Consumer c;
        
        // Make and start the producer
        p = new Producer();
        p.start();
        
        // Make and start the consumer
        c = new Consumer();
        c.start();
    }

    // Start the whole thing going          
    public static void main(String args[]) {
    
        ProducerConsumer pc = new ProducerConsumer();
        pc.start();

    }
}

                            
                            
