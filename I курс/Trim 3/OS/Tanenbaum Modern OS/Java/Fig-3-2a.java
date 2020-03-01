//Figure 3-2a

import Semaphore;

public class SomeClass extends Object {
    
    // Shared objects
    // Proctect resource One
    public static Semaphore resource_1 = new Semaphore(1);  
    
    // Proctect resource Two
    public static Semaphore resource_2 = new Semaphore(1);  
                        
    class User1 extends Thread {
        
        public void process_A(){                    
            resource_1.down();                  
            resource_2.down();                  
            use_both_resources();                       
            resource_2.up();                        
            resource_1.up();                        
        }
    }
        
    class User2 extends Thread {
        
        public void process_B(){                    
            resource_1.down();                  
            resource_2.down();                  
            use_both_resources();                       
            resource_2.up();                        
            resource_1.up();                        
        }
    }

}

                        
                        
