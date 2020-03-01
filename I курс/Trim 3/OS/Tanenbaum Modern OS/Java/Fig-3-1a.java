//Figure 3-1a

import Semaphore;

public class SomeClass extends Object {
    
    // Shared objects
    
    // Proctect One resource
    public static Semaphore resource_1 = new Semaphore(1);  
                        
    class User extends Thread {
        
        public void process_A(){                    
            resource_1.down();                  
            use_resource_1();                       
            resource_1.up();                        
        }
    }
        

}
                        
                        
