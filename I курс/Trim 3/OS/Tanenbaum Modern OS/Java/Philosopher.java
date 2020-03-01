//Figure 2-33

import Semaphore;

public class Philosopher extends Thread {
    // Shared by all Philosophers
    public final static int N = 5;              // Number of philosophers
    
    public final static int THINKING = 0;       // Philosopher is thinking
    public final static int HUNGRY = 1;         // Philosopher is hungry
    public final static int EATING = 2;         // Philosopher is eating
    
    private static int state[] = new int[N];    // Array to keep track of 
                                                // everyones state
    
    private static Semaphore mutex = new Semaphore(1);  // Mutual exclusion for 
                                                        // critical regions
    private static Semaphore s[] = new Semaphore[N];    // One for each 
                                                        // Philosopher

    // Instance variable
    public int myNumber;                    // Which philosopher am I
    public int myLeft;                      // Number of my left neighbor
    public int myRight;                     // Number of my right neighbor
    
    public Philosopher(int i) {             // Make a philosopher
        myNumber = i;
        myLeft = (i+N-1) % N;               // Compute the left neighbor
        myRight = (i+1) % N;                // Compute the right neighbor
    }
    
    public void run() {                     // And away we go
        while(true){
            think();                        // Philosopher is thinking
            take_forks();                   // Acquire two forks or block
            eat();                          // Yum-yum, spahgetti
            put_forks();                    // Put both forks back on the table
        }
    }
    
    public void take_forks(){               // Take the forks I need
        mutex.down();                       // Enter critical region
        state[myNumber] = HUNGRY;           // Record the fact that I am hungry
        test(myNumber);                     // Try to acquire two forks
        mutex.up();                         // Leave critical region
        s[myNumber].down();                 // Block if forks were not acquired
    }
    
    public void put_forks(){                    
        mutex.down();                       // Enter critical region
        state[myNumber] = THINKING;         // Philosopher has finished eating
        test(myLeft);                       // See if left neighbor can now eat
        test(myRight);                      // See if right neighbor can now 
                                            // eat
        mutex.up();                         // Leave critical region
    }
    
    public void test(int k){                // Test philosopher k, 
                                            // from 0 to N-1
        int onLeft = (k+N-1) % N;           // K's left neighbor
        int onRight = (k+1) % N;            // K's right neighbor
        if( state[k] == HUNGRY 
            && state[onLeft] != EATING
            && state[onRight] != EATING ) {
            
            // Grab those forks
            state[k] = EATING;
            s[k].up();
        }
    }
    
    public void think(){
        System.out.println("Philosopher " + myNumber + " is thinking");
        try {
            sleep(1000);
        } catch (InterruptedException ex){ }
    }
    
    public void eat(){
        System.out.println("Philosopher " + myNumber + " is eating");
        try {
            sleep(5000);
        } catch (InterruptedException ex){ }
    }
            
    public static void main(String args[]) {
    
        Philosopher p[] = new Philosopher[N];
        
        for(int i=0; i<N; i++) {
            // Create each philosopher and their semaphore
            p[i] = new Philosopher(i);
            s[i] = new Semaphore(0);
            
            // Start the threads running
            p[i].start();
        }

    }
    
        
}
                    
                        
                        
