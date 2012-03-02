package Painter;

public class latlonconvert {


	public double[] longi(double targetLat,double targetLon, double minLat, double minLon,double maxLat, double maxLon, double maxXPixel, double minXPixel,double maxYPixel, double minYPixel){
		double pixelX = Math.abs(((Math.abs(targetLon) - Math.abs(minLon)) / (Math.abs(maxLon) - Math.abs(minLon))) * (Math.abs(maxXPixel) - Math.abs(minXPixel)));
		double pixelY = Math.abs(((Math.abs(targetLat) - Math.abs(minLat)) / (Math.abs(maxLat) - Math.abs(minLat))) * (Math.abs(maxYPixel) - Math.abs(minYPixel)));
		double[] d = {pixelX,pixelY};
		return d;
	}
	
	public double[] longi(double targetLat,double targetLon, double minLat, double minLon,double maxLat, double maxLon, double maxXPixel, double maxYPixel){
		double pixelX = Math.abs(((Math.abs(targetLon) - Math.abs(minLon)) / (Math.abs(maxLon) - Math.abs(minLon))) * (Math.abs(maxXPixel)));
		double pixelY = Math.abs(((Math.abs(targetLat) - Math.abs(minLat)) / (Math.abs(maxLat) - Math.abs(minLat))) * (Math.abs(maxYPixel)));
		double[] d = {pixelX,pixelY};
		
		return d;
	}
	
	
	public static int LonToX(double aLongitude, double MIN_LON,double MAX_LON,double X_Pix) {
        double yD = aLongitude - MIN_LON;
        double length = MAX_LON - MIN_LON;
        double procent = yD / length;
        yD = procent * X_Pix;
        int y = (int)yD;
        return y;
    }
	
	public static int LatToY(double aLatitude,double MIN_LAT,double MAX_LAT,double Y_Pix) {
        double yD = aLatitude - MIN_LAT;
        double length = MAX_LAT - MIN_LAT;
        double procent = yD / length;
        yD = procent * Y_Pix;
        int y = (int)yD;
        return y;
    }
	
	
	
}
