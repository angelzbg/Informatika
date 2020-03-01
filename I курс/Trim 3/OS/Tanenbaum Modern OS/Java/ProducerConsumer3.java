//Figure 2-27 Main Class which uses the ProducerConsumerMonitor with multiple
//              producers and consumers

import ProducerConsumerMonitor;
import Item;


class ProducerConsumer3 extends Thread {
    
    private ProducerConsumerMonitor theMonitor;



    // Inner classes for the Producers and Consumers
    class Producer extends Thread {
        public void run() {
            while(true) {
                Item data = produce_item();
                System.out.println("Producer " + myNumber 
                                    + " trying to insert");
                theMonitor.insert(data);
                
                try{sleep(1000);}
                catch(InterruptedException ex){};
            }
        }
        
        private Item produce_item(){
            Item data;
            try{sleep(1000);}
            catch(InterruptedException ex){};
            data = new Item(myNumber,itemCount++);
            System.out.println("Producer " + myNumber 
                                + "  making item " + data);

            return data;
        }
        
        // Count of Items created
        private int itemCount;
        // Identification number for the Producer
        private int myNumber;

        public Producer(int x){
            myNumber = x;
            itemCount = 0;
        }
        
    }

    public class Consumer extends Thread {
        public void run() {
            while(true) {
                System.out.println("Consumer " + myNumber 
                                    + " trying to remove");
                Item data = theMonitor.remove();
                consume_item(data);
            }
        }
        
        private void consume_item(Item data){
            System.out.println("Consumer " + myNumber 
                                + " used item " + data);
            try{sleep(1000);}
            catch(InterruptedException ex){};
        }
        
        // Identification number for the Consumer
        private int myNumber;

        public Consumer(int x){
            myNumber = x;
        }
    }
    
    
    // What the ProducerConsumer Thread does
    public void run(){
        theMonitor = new ProducerConsumerMonitor();
        
        final int PRODUCERS = 10;
        final int CONSUMERS = 10;
        Producer p;
        Consumer c;
        
        // Make and start the Producer threads
        for(int i=0; i<PRODUCERS; i++){
            p = new Producer(i);
            p.start();
        }
        
        // Make and start the Consumer threads
        for(int i=0; i<CONSUMERS; i++){
            c = new Consumer(i);
            c.start();
        }
    }

    // Start the whole thing going          
    public static void main(String args[]) {
    
        ProducerConsumer3 pc = new ProducerConsumer3();
        pc.start();

    }
}
