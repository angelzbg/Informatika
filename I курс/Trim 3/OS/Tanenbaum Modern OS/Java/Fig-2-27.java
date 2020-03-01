//Figure 2-27

class ProducerConsumerMonitor extends Object {
    private final int N = 5;
    private int count = 0;
    private Vector theData;
    
    synchronized public void insert(Item data) {
        while (count == N) {
            try{ 
                wait(5000);                     // Full, wait to add
            } catch (InterruptedException ex) {};
        }
            
        insert_item(data);
        count++;
        if(count == 1) {
            notify();                           // Not empty, notify a waiting 
                                                // consumer
        }
    }
    
    synchronized public Item remove() {
        Item data;
        while(count == 0)
            try{ 
                wait(5000);                     // Empty, wait to consume
            } catch (InterruptedException ex) {};

        data = remove_item();
        count--;
        if(count == N-1){ 
            notify();                           // Not full, notify a waiting 
                                                // producer
        }
        return data;
    }
}

// Main Class which uses the ProducerConsumerMonitor
class ProducerConsumer2 extends Thread {
    
    private ProducerConsumerMonitor theMonitor;

    // Inner classes for the Producer and Consumer
    class Producer extends Thread {
        public void run() {
            while(true) {
                Item data = produce_item();
                theMonitor.insert(data);
            }
        }
    }

    public class Consumer extends Thread {
        public void run() {
            while(true) {
                Item data = theMonitor.remove();
                consume_item(data);
            }
        }       
    }
    
}

                            
                            

