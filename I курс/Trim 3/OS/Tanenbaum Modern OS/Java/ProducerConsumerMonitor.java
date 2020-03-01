//Figure 2-27

import java.util.Vector;
import Item;

class ProducerConsumerMonitor extends Object {
    private final int N = 5;
    private int count = 0;
    private Vector theData;
    
    synchronized public void insert(Item data) {
        while (count == N) {
            try{ 
                System.out.println("\tFull, waiting");
                wait(5000);                         // Full, wait to add
            } catch (InterruptedException ex) {};
        }
            
        insert_item(data);
        count++;
        if(count == 1) {
            System.out.println("\tNot Empty, notify");
            notify();                               // Not empty, notify a 
                                                    // waiting consumer
        }
    }
    
    synchronized public Item remove() {
        Item data;
        while(count == 0)
            try{ 
                System.out.println("\tEmpty, waiting");
                wait(5000);                         // Empty, wait to consume
            } catch (InterruptedException ex) {};

        data = remove_item();
        count--;
        if(count == N-1){ 
            System.out.println("\tNot full, notify");
            notify();                               // Not full, notify a 
                                                    // waiting producer
        }
        return data;
    }
    
    private void insert_item(Item data){
        theData.addElement(data);
    }
    
    private Item remove_item(){
        Item data = (Item) theData.firstElement();
        theData.removeElementAt(0);
        return data;
    }
    
    public ProducerConsumerMonitor(){
        theData = new Vector();
    }
}

