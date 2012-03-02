package GetBoundsXMLParsing;

import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * 
 * @author Gokul
 *
 */
public class GetNativeScreenResolution {
	/**
	 * Native screen resolution with width and height
	 * 
	 * @return	i with width and height
	 */
	public static int[] screenres(){
		 Toolkit toolkit =  Toolkit.getDefaultToolkit ();
	        Dimension dim = toolkit.getScreenSize();
	       int[] i= {dim.width,dim.height};
		return i;
	}
	
	
}
