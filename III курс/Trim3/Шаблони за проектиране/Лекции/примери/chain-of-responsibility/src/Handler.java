public class Handler {
  
  private Handler successor;
  
  public void parse(String fileName){
    if ( getSuccessor() != null ){
      getSuccessor().parse(fileName);
    }
    else{
      System.out.println("Unable to find the correct handler for the file: "+fileName);
    }
  }
  
  protected boolean canHandleFile(String fileName, String format){
    return (fileName == null) || (fileName.endsWith(format));
        
  }

  Handler getSuccessor() {
    return successor;
  }

  void setSuccessor(Handler successor) {
    this.successor = successor;
  }
}