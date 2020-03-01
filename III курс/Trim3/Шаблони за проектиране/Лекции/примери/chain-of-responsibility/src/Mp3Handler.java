public class Mp3Handler extends Handler {

  public Mp3Handler(Handler successor){
    this.setSuccessor(successor);
  }
  
  @Override
  public void parse(String fileName) {
    if ( canHandleFile(fileName, ".mp3")){
      System.out.println("A Mp3 handler is handling the file: "+fileName);
    }
    else{
      super.parse(fileName);
    }

  }

}