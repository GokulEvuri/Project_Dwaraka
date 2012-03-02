package Temp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openstreetmap.osmosis.core.domain.v0_6.Way;
import org.openstreetmap.osmosis.core.domain.v0_6.WayNode;

import Painter.Paint;
import Painter.latlonconvert;

public class Test {


	
	public static void main(String[] args){
		
		System.out.println(test().size());
	}
	
	public static ArrayList<MyCoordinates> test(){
		ArrayList<MyCoordinates> latlon = new ArrayList<MyCoordinates>();
		MyCoordinates myObject = new MyCoordinates();
		
		File localfile = new File("C:\\map.osm");//test
	java.util.Iterator<Way> itrloc =	Paint.loading(localfile).getWaysByTag("building","yes");
	
		while(itrloc.hasNext()) {
		Way pis = 	itrloc.next();
		System.out.println(pis.getId());//here loop it 
		List<WayNode> ipo = pis.getWayNodes();
		int k = ipo.size();
		int ir = 0;
		
		while(k>0){
			GetBoundsXMLParsing.GetBounds coorb = new GetBoundsXMLParsing.GetBounds();
			double[] coord = coorb.getLocDouble();
			int[] res = GetBoundsXMLParsing.GetNativeScreenResolution.screenres();
			int xindary = latlonconvert.LonToX(Paint.loading(localfile).getNodeByID(ipo.get(ir).getNodeId()).getLongitude(), coord[1],coord[3], res[0]);
			int yindary = latlonconvert.LatToY(Paint.loading(localfile).getNodeByID(ipo.get(ir).getNodeId()).getLatitude(), coord[0],coord[2],res[1]);
			myObject.longi = xindary;
			myObject.lat = yindary;
			latlon.add(myObject);
			ir++;
			k--;
			}
		itrloc.remove();
		ir++;
		}
		
		return latlon;
	
}
}