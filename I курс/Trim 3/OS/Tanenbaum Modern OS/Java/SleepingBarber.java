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
        private int myNumber;               // Id for the Barber
        
        public Barber(int i) {              // Constructor for the Barber
            myNumber = i;
        }
        
        public void run(){                  // What a barber does
            while(true) {
                customers.down();           // Go to sleep if no customers
                mutex.down();               // Acquire access to waiting
                waiting = waiting - 1;      // Decrement count of waiting 
                                            // customers
                barbers.up();               // One barber is now ready to cut 
                                            // hair              
                mutex.up();                 // Release waiting
                cut_hair();                 // Noncritical region
            }
        }
        
        public void cut_hair(){
            System.out.println("Barber " + myNumber + " is cutting hair");
            try {
                sleep(7500);
            } catch (InterruptedException ex){ }
        }
    } //end of Barber Class

    private class Customer extends Thread {
        private int myNumber;               // Id for the Customer
        
        public Customer(int i) {            // Constructor for the Customer
            myNumber = i;
        }

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
        
        
        public void get_haircut(){
            System.out.println("Customer " + myNumber 
                                + " is getting his hair cut");
            try {
                sleep(10000);
            } catch (InterruptedException ex){ }
        }
    } //end of Customer Class
    
            
    public static void main(String args[]) {
        
        SleepingBarber holder = new SleepingBarber();
        
        holder.start();
        
    }
    
    // This thread spins off a number of customers
    public void run(){                          
        
        final int BARBERS = 3;
        
        Barber aBarber;
        Customer aCustomer;
        
        for(int i=0; i<BARBERS; i++) {
            // Create the barbers
            aBarber = new Barber(i);
            
            // Start the threads running
            aBarber.start();
        }

        int customerNumber = 0;
        while(true){
            aCustomer = new Customer(customerNumber++);
            
            // Start the customer running
            aCustomer.start();
            
            // Wait a bit and make another customer
            try {
                sleep(1000);
            } catch(InterruptedException ex) {};
        }
    } //end of run method for SleepingBarber

}
                        
