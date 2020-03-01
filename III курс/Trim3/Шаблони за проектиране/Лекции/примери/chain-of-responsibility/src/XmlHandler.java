public class XmlHandler extends Handler {
  
  @Override
  public void parse(String fileName) {
    if ( canHandleFile(fileName, ".xml")){
      System.out.println("A XML handler is handling the file: "+fileName);
    }
    else{
      super.parse(fileName);
    }
  }

}