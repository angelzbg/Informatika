public class TextHandler extends Handler{

  public TextHandler(Handler successor){
    this.setSuccessor(successor);
  }
  
  @Override
  public void parse(String fileName) {
    if ( canHandleFile(fileName, ".txt")){
      System.out.println("A text handler is handling the file: "+fileName);
    }
    else{
      super.parse(fileName);
    }
    
  }

}