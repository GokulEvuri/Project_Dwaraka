package GetBoundsXMLParsing;



public class TestGetBounds {
	
	public static void main(String[] args) {
//		Instantiated LocationReader
		 GetBounds locreader = new GetBounds();
			        
//		 Calling the method getLocation of LocationReader
		 String[] Coords = locreader.getLocation();
		
//		 Displaying the coordinates
		 System.out.println("minLat: " + /*max lon max lat min lon min lat*/Coords[0]+"\tminLong: "+Coords[1]+"\tmaxLat: " + Coords[2]+"\tmaxLong: "+Coords[3]);

	}

}
