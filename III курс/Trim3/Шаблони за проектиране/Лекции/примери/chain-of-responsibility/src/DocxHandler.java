public class DocxHandler extends Handler {

  public DocxHandler(Handler successor){
    this.setSuccessor(successor);
  }
  
  @Override
  public void parse(String fileName) {
    if ( canHandleFile(fileName, ".docx")){
      System.out.println("A DOCX handler is handling the file: "+fileName);
    }
    else{
      super.parse(fileName);
    }

  }

}