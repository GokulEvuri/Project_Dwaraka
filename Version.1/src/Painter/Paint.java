package Painter;

//import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
//import org.openstreetmap.osm.data.coordinates.LatLon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openstreetmap.osm.data.MemoryDataSet;
import org.openstreetmap.osm.io.FileLoader;
//import org.openstreetmap.osmosis.core.domain.v0_5.Way;
//import org.openstreetmap.osmosis.core.domain.v0_5.WayNode;
//
//import Temp.MyCoordinates;
//import UI.FileChoose;
//import UI.mainJFrameSet;
//
//import GetBoundsXMLParsing.GetBounds;


public class Paint {
	public String[] MajorTags = {"building","highway","amenity","shop","route"};
	public String[] MinorTagsb = {"yes"};
	public String[] MinorTagsh = {"traffic_signals","bus_stop","crossing","residintial","unclassified","cycleway","steps","footway","service"};
	public String[] MinorTagsa = {"cafe","fast_food","resturant","bank","ferry_terminal","parking"};
	public String[] MinorTagss = {"kiosk"};
	public String[] MinorTagsr = {"ferry"};
	public int NoOfStuffHadInData;

	public void paintosm(File file){
//			int i = loading(file).getWaysCount();
			int i = MajorTags.length;
			while(i>0){
				Iterator<org.openstreetmap.osmosis.core.domain.v0_6.Way> l	=	loading(file).getWaysByTag("building","yes");
				org.openstreetmap.osmosis.core.domain.v0_6.WayNode nodeid =	l.next().getWayNodes().get(i);
				loading(file).getNodeByID(nodeid.getNodeId()).getLatitude();
				i--;
				return;
			}
	}
	public MemoryDataSet loading(File file){
		FileLoader fl = new FileLoader(file);
		return fl.parseOsm();
	}
	
	public  void DrawLatLon(){	
		 test();		
	}
	public ArrayList<Point> test(){
		ArrayList<Point> latlon = new ArrayList<Point>();
//		MyCoordinates myObject = new MyCoordinates();
		int xindary;
		int yindary;
		Point m;
		Paint pnt = new Paint();
		
		File localfile = new File("C:\\map.osm");//test
	Iterator<org.openstreetmap.osmosis.core.domain.v0_6.Way> itrloc =	loading(localfile).getWaysByTag("building","yes");
	
		while(itrloc.hasNext()) {
		org.openstreetmap.osmosis.core.domain.v0_6.Way pis = 	itrloc.next();
//		System.out.println(pis.getId());//here loop it 
		List<org.openstreetmap.osmosis.core.domain.v0_6.WayNode> ipo = pis.getWayNodes();
		int k = ipo.size();
		int ir = 0;
		while(k>0){
			GetBoundsXMLParsing.GetBounds coorb = new GetBoundsXMLParsing.GetBounds();
			double[] coord = coorb.getLocDouble();
			int[] res = GetBoundsXMLParsing.GetNativeScreenResolution.screenres();
//			long por =	ipo.get(ir).getNodeId();
			
			 xindary = latlonconvert.LonToX(pnt.loading(localfile).getNodeByID(ipo.get(ir).getNodeId()).getLongitude(), coord[1],coord[3], res[0]);
			 yindary = latlonconvert.LatToY(pnt.loading(localfile).getNodeByID(ipo.get(ir).getNodeId()).getLatitude(), coord[0],coord[2],res[1]);
			
//			myObject.longi = xindary;
//			myObject.lat = yindary;
			m = new Point(xindary,yindary);
//			System.out.println(por);
			latlon.add(m);
//			latlon.add(myObject);
			ir++;
			k--;
			}
//		latlon.add(myObject);
		itrloc.remove();
//		ir++;
		NoOfStuffHadInData = ir++;
		}
		System.out.println(NoOfStuffHadInData);
		return latlon;
	
}
}
