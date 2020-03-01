// This count implements a classic counting Semaphore
// It has two synchronized operations which it can perform
// up - increments the count of the semaphore and wakes up
//      waiting threads
// down - decrements the count of the semaphore or if zero
//      suspends the thread


class Semaphore extends Object
{
    private int count;
    
    public Semaphore(int startingCount){
        count = startingCount;
    }
    
    public void down(){
        synchronized (this) {           
            while (count <= 0) {
                // We must wait
                try {
                    wait();
                } catch (InterruptedException ex) {
                    // I was interupted, continue onwards
                }
            }
                
            // We can decrement the count
            count--;
        } 
                
    }
    
    public void up(){
        synchronized (this) {
            count++;
            //notify a waiting thread to wakeup         
            if (count == 1 ) {              
                notify();
            }
        }
    }
}

