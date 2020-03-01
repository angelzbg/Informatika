//Figure 2-36

import Semaphore;

public class SleepingBarber extends Thread {
    
    // Shared objects
    // Number of customers waiting for service
    public static Semaphore customers = new Semaphore(0);
    
    // Number of barbers waiting for customers
    public static Semaphore barbers = new Semaphore(0);
            
    // For mutual exclusion
    public static Semaphore mutex = new Semaphore(1);   
        
    // Customers are waiting (not being cut)
    public static int waiting = 0;                          
    
    // Chairs for waiting customers     
    public static final int CHAIRS = 5;                     
                        
    class Barber extends Thread {
        
        public void run(){                  // What a barber does
            while(true) {
                customers.down();           // Go to sleep if no customers
                mutex.down();               // Acquire access to waiting
                waiting = waiting - 1;      // Decrement count of waiting 
                                            // customers
                barbers.up();               // One barber is now ready to cut 
                                            /  hair             
                mutex.up();                 // Release waiting
                cut_hair();                 // Noncritical region
            }
        }
    } //end of Barber Class

    private class Customer extends Thread {

        public void run(){                  // What a customer does
            mutex.down();                   // Acquire access to waiting
            if(waiting < CHAIRS){
                waiting = waiting + 1;      // Increment count of waiting 
                                            // customers
                customers.up();             // Wake up barber if needed             
                mutex.up();                 // Release waiting
                barbers.down();             // Go to sleep if number of free 
                                            // barbers is 0
                get_haircut();              // Noncritical region
            } else {
                mutex.up();                 // Shop is full do not wait
            }
        }
        
    } //end of Customer Class
    

}
                        
