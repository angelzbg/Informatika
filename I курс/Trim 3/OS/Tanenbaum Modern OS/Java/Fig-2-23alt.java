//Fig 2-23
static final int N = 100;                   // Size of the buffer
static int count = 0;                       // Number of items in buffer


public class Producer extends Thread {      // Producer thread
    private Consumer c;                     // Remember my associated consumer
    
    public void run() {                     
        Item data;                          
                
        while(true) {                       
            data = produce_item();          // Generate the next item
            try{
                if(count == N) suspend();   // If the buffer is full, go to 
                                            // sleep
            } catch(InterruptedException) {};
            
            insert_item(data);              // Add the item to the buffer
            count++;                        // Increment count of items in 
                                            // buffer
            if(count == 1) c.resume();      // Was the buffer empty?
    }
    ...
}

public class Consumer extends Thread {      // Consumer thread
    private Producer p;                     // Remember my associated producer
    
    public void run() {
        Item data;                          
        
        while(true) {
            try{
                if(count == 0) suspend();   // If the buffer is empty, go to 
                                            // sleep
            } catch(InterruptedException) {};

            item = remove_item();           // Get the item from the buffer
            count--;                        // Decrement count of items in 
                                            // buffer
            if(count == N-1) p.resume();    // Was the buffer full?
            consume_item(item);             // Do something with the item
        }
    }
    ...
}

