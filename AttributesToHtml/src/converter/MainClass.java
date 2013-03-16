package converter;

import java.io.IOException;
import java.net.URISyntaxException;

import converter.AttributesToForm;
import converter.AttributesToForm.*;

public class MainClass
{
	public static void main(String[] args) throws ClassNotFoundException, IOException, URISyntaxException
    {
                
         AttributesToForm fc=new AttributesToForm();

         if(args.length>0)
            fc.fileName=args[0];
         else
        	 fc.fileName="form.html";
       
        
         fc.createFile();
         fc.writeToFile();
         fc.openHtml();
         
    }
    

}
