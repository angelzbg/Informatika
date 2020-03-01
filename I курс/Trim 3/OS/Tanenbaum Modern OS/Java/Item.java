//Figure 2-27 Item class


// A very simple class that just stores a string and can print it out
class Item extends Object {
    private String myString;
    
    public Item (int first, int second) {
        myString = Integer.toString(first) + ":" + Integer.toString(second) ;
    }
    
    public String toString() {
        return myString;
    }
}
        

