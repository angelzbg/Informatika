//Figure 3-1b

import Semaphore;

public class SomeClass extends Object {
    
    // Shared objects
    // Proctect One resource
    public static Semaphore resource_1 = new Semaphore(1);
        
    // Proctect Two resource
    public static Semaphore resource_2 = new Semaphore(1);  
                        
    class User extends Thread {
        
        public void process_A(){                    
            resource_1.down();                  
            resource_2.down();                  
            use_both_resources();                       
            resource_2.up();                        
            resource_1.up();                        
        }
    }
        

}
                        
                        
