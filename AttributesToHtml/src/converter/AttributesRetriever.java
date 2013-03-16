package converter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.lang.reflect.Field;

/**
 * This class retrieves the attributes in the entity class.
 * 
 * @author Smrita
 */
public class AttributesRetriever {
	/**
	 * the attributes of entity class are retrieved and stored in fields
	 * {@link java.lang.reflect.Field}
	 * {@see java.lang.reflect.Field}
	 */
    Field[] fields;

    /**
     * @param args the command line arguments
     * retrieves the declared fields in class mentioned inside {@code class.forName(packagename.classname) }
     */
    public Field[] getFields() throws ClassNotFoundException
    {
        Class<?> c=Class.forName("entityclass.FormFieldsDeterminer");
        //fields=entityclass.FormFieldsDeterminer.class.getDeclaredFields(); 
        fields=c.getDeclaredFields();
   
       
        return fields;
    }
    
    
    
  
}

