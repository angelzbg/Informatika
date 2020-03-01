//Figure 2-23

static final int N = 100;                   // Size of the buffer
static int count = 0;                       // Number of items in buffer

static void producer(){                     
    Item item;
    
    while(true) {                           // Loop forever
        item = produce_item();              // Generate the next item
        if(count == N) sleep();             // If the buffer is full, go to 
                                            // sleep
        insert_item(item);                  // Add the item to the buffer
        count++;                            // Increment count of items in 
                                            // buffer
        if(count == 1) wakeup(consumerThread);  // Was the buffer empty?
}

static void consumer(){                     
    Item item;
    
    while(true) {                           // Loop forever
        if(count == 0) sleep();             // If the buffer is empty, go to 
                                            // sleep
        item = remove_item();               // Get the item from the buffer
        count--;                            // Decrement count of items in 
                                            //buffer
        if(count == N-1) wakeup(producerThread);    // Was the buffer full?
        consume_item(item);                 // Do something with the item
}

