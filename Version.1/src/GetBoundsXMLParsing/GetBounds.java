package GetBoundsXMLParsing;

import java.io.IOException;
import UI.mainJFrameSet;

import org.apache.xerces.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class GetBounds implements ContentHandler {

	public static String[] LatLongCoords = new String[4];
	
	public double[] getLocDouble(){
		String[] sarray = getLocation();
		if (sarray != null) {
			double intarray[] = new double[sarray.length];
			for (int i = 0; i < sarray.length; i++) {
			intarray[i] = Double.parseDouble(sarray[i]);
			}
			return intarray;
			}
			return null;
			}
		
	
	public String[] getLocation() 
	{
		ContentHandler contenthandler = new GetBounds();
		try
		{
			XMLReader parser = new SAXParser();
			parser.setContentHandler(contenthandler);
			/*use it when real program runs*/
//			parser.parse(mainJFrameSet.getFile().getAbsolutePath());
			parser.parse("C://map.osm");
		}
		catch (SAXException e) 
		{
			System.out.println("--Error in parsing the document");
		} 
		catch (IOException e) 
		{			 
			System.out.println("--Error could possibly be with the location of the file");
		}
		return LatLongCoords;
	}
	
	@Override
	public void characters(char[] ch, int start, int end) throws SAXException {}

	@Override
	public void endDocument() throws SAXException {}

	@Override
	public void endElement(String namespaceURI, String localName, String rawName)throws SAXException {}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {}

	@Override
	public void ignorableWhitespace(char[] arg0, int arg1, int arg2)throws SAXException {}

	@Override
	public void processingInstruction(String target, String data)throws SAXException {}

	@Override
	public void setDocumentLocator(Locator arg0) {}

	@Override
	public void skippedEntity(String name) throws SAXException {}

	@Override
	public void startDocument() throws SAXException {}

	@Override
	public void startElement(String namespaceURI, String localName,
			String rawName, Attributes atts) throws SAXException {
		int k = 0;
		if(localName=="bounds")		
		{
			for (int i=0; i<atts.getLength(); i++)
			{
				LatLongCoords[k++] = atts.getValue(i);
			}				
		}
	}

	@Override
	public void startPrefixMapping(String prefix, String uri)throws SAXException {}

}
