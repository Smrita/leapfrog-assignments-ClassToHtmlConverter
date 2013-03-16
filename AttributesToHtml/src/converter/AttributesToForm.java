package converter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.net.URL;



/**Converts the attributes extracted to html form dynamically
 * <pre>
 * @author Smrita
 * </pre>
 */
public class AttributesToForm 
{
	/**
	 * {@linkplain converter.AttributesRetriever}
	 */
    AttributesRetriever cf;
    /**
     * the attributes of entity class are retrieved and stored in fields
	 * {@link java.lang.reflect.Field} 
     */
    Field[] field;
    /**
     * Its the HTML file
     */
    File file;
    /**
     * name of HTML file
     */
    public String fileName;
    
    /**
     * 
     * @throws ClassNotFoundException
     *          Error is thrown when file is not found
     */
    public AttributesToForm() throws ClassNotFoundException
    {
          cf=new AttributesRetriever();//instantinate object variable of attribute retriever
          field=cf.getFields();
    }
    /**
     * It makes the content of HTML 
     * * @return A string which contains the total content of the HTML file
     */
    
    public String makeHtmlContent()
    {
        
          String pageStart="<html>\n"
                  + "<head> \n<title></title>\n</head>\n"
                  + "<body>\n"
                  + "<form>\n";
          String pageMiddle="";
          pageMiddle+=pageStart;
          for(int i=0;i<field.length;i++)
          {
              String temp="<p>"+field[i].getName().toUpperCase()+"\t<input type=\"text\"\t name=\""+field[i].getName()+"\"\tplaceholder=\"type your "+field[i].getName()+" here...\"></p>\n";
              
              pageMiddle=pageMiddle+" "+temp;
          }
              
          String pageEnd="</form>\n"
                  + "</body>\n"+
                          "</html>" ;
          pageMiddle+=pageEnd;
        
               
          return pageMiddle;
    }
    /**
     * creates a file
     * 
     */
    public void createFile()
   {      
        
          /* to create the file in specified directory*/
         // String dirName="D://javaworkspace//Netbeans7-2//ClassToForm";
       //  file = new File(dirName, fileName);
          file=new File(fileName);
      
    }
    /**
     * It writes the content returned by {@link converter.AttributesToForm.makeHtmlContent()}
     * to a file created by {@link converter.createFile()} using {@link java.io.BufferedWriter}
     * {@see java.io.BufferedWriter} 
     */
    
    public void writeToFile()
    {
             try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                        String content=makeHtmlContent();
                   
                            
                                bw.write(content);
                                bw.newLine();
                       
                        
                         bw.close();
                } catch (Exception e) {
                }

    }
    
    /**
     * Opens the created HTML file
     * @throws URISyntaxException
     * @throws IOException
     */
    
    public void openHtml() throws URISyntaxException, IOException
    {

       // Runtime.getRuntime().exec("hh.exe form.html");//for windows
          //Runtime.getRuntime().exec("firefox form.html");//for linux
          Runtime.getRuntime().exec("firefox "+fileName);//for linux
    }
    
    
}
