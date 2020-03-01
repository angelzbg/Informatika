//Figure 2-32


public class Philosopher extends Thread {
    public final static int N = 5;              // Number of philosophers
    private static Stick allChopSticks[];       // Shared resources

    private int i;                              // Id from 0 to 4
    
    public Philosopher( int x) {    // Construct the Philospher
        i = x;                                  // Remember ID
    }
                            
    public void run() {
        while(true) {                       
            think();                            // Philosopher is thinking
            take_fork(i);                       // Take left fork
            take_fork( (i+1)%N );               // Take right fork
            eat();                              // Yum-yum spaghetti
            put_fork(i);                        // Put left fork back on table
            put_fork( (i+1)%N );                // Put right fork back on table
            
    }
}
                            
                        
