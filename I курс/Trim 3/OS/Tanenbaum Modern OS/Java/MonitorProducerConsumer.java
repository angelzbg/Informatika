//Figure 2-27

synchronized class MonitorProducerConsumer {
    private boolean full, empty;
    private integer count;
    
    public void insert(Item data) {
        if(count == N) wait(full);
        insert_item(item);
        count++;
        if(count == 1) signal(empty);
    }
    
    public Item remove() {
        Item data;
        if(count == 0) wait(empty);
        data = remove_item();
        count--;
        if(count == N-1) signal(full);
    }
    
    ...
}

static MonitorProducerConsumer theMonitor
    = new MonitorProducerConsumer();

public class Producer extends Thread {
    public void run() {
        while(true) {
            Item data = produce_item();
            theMonitor.insert(data);
        }
    }
    ...
}

public class Consumer extends Thread {
    public void run() {
        while(true) {
            Item data = theMonitor.remove(data);
            consume_item(data);
        }
    }
    ...
}
                        
