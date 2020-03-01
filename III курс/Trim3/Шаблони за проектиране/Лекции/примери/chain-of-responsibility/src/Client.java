import java.util.List;
import java.util.ArrayList;

public class Client {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    //List of file names to parse. 
    List<String> fileList = populateFiles();
    
    //No successor for this handler because this is the last in chain. 
    Handler xmlHandler = new XmlHandler();

    //XmlHandler is the successor of Mp3Handler.
    Handler mp3Handler = new Mp3Handler(xmlHandler);
    
    //Mp3Handler is the successor of DocxHandler.
    Handler docxHandler = new DocxHandler(mp3Handler);
    
    //DocxHandler is the successor of TextHandler.
    //TextParser is the start of the chain. 
    Handler textHandler = new TextHandler(docxHandler);
    
    //Pass the file name to the first handler in the chain.
    for ( String fileName : fileList){
      textHandler.parse(fileName);
    }

  }
  
  private static List<String> populateFiles(){
    
    List<String> fileList = new ArrayList<String>();
    fileList.add("textFile.txt");
    fileList.add("someFile.jpg");
    fileList.add("xmlFile.xml");
    fileList.add("mp3File.mp3");
    fileList.add("wordFile.docx");
    
    return fileList;
  }

}
