//Fig 2-29
final static int N = 100;                   // Number of slots in the buffer


public class Producer extends Thread {      // Producer thread
    private Consumer c;                     // Remember my associated consumer
    
    public void run() {                     
        Item data;                          
        Message m;                          // Message buffer
        
        while(true) {                       
            data = produce_item();          // Generate something for the 
                                            // buffer
            m = Message.receive(c);         // Wait on instance of consumer 
                                            // thread
            m = Message.build_message(data);// Construct a message to send
            m.send(c);                      // Send data item to consumer
        }
    }
    ...
}

public class Consumer extends Thread {      // Consumer thread
    private Producer p;                     // Remember my associated producer

    public void run() {
        Item data;                          
        Message m;                          // Message buffer
        
        m = Message.build_empty();          // Send N empties
        for(int i=0; i<N; i++)
            m.send(p);
                            
        while(true) {
            m = Message.receive(p);         // Get message containing data item
            data = m.extract_item();        // Extract the data item from 
                                            // message
            m.send(producer);               // Send back empty reply            
            consume_item(data);             // Do something with the data item
        }
    }
    ...
}

