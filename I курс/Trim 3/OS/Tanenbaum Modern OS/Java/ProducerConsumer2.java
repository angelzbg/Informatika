//Figure 2-27 Main Class which uses the ProducerConsumerMonitor

import ProducerConsumerMonitor;
import Item;


class ProducerConsumer2 extends Thread {
    
    private ProducerConsumerMonitor theMonitor;



    // Inner classes for the Producer and Consumer
    class Producer extends Thread {
        public void run() {
            while(true) {
                Item data = produce_item();
                System.out.println("Producer trying to insert");
                theMonitor.insert(data);
            }
        }
        
        private Item produce_item(){
            Item data;
            try{sleep(1000);}
            catch(InterruptedException ex){};
            data = new Item(0,itemCount++);
            System.out.println("Producer  making item " + data);

            return data;
        }
        
        // Count of Items created
        private int itemCount = 0;
        
    }

    public class Consumer extends Thread {
        public void run() {
            while(true) {
                System.out.println("Consumer trying to remove");
                Item data = theMonitor.remove();
                consume_item(data);
            }
        }
        
        private void consume_item(Item data){
            System.out.println("Consumer used item " + data);
            try{sleep(7000);}
            catch(InterruptedException ex){};
        }
        
    }
    
    
    // What the ProducerConsumer Thread does
    public void run(){
        theMonitor = new ProducerConsumerMonitor();
        Producer p;
        Consumer c;
        
        // Make and start the producer
        p = new Producer();
        p.start();
        
        // Make and start the consumer
        c = new Consumer();
        c.start();
    }

    // Start the whole thing going          
    public static void main(String args[]) {
    
        ProducerConsumer2 pc = new ProducerConsumer2();
        pc.start();

    }
}

                            
                            
