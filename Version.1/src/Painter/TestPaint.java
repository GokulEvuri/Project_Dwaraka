package Painter;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.*;

import GetBoundsXMLParsing.GetNativeScreenResolution;
//import Temp.MyCoordinates;
//import GetBoundsXMLParsing.GetNativeScreenResolution;

public class TestPaint extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 Point p1;
	 Point p2;

	 Paint pnt = new Paint();
	public static void main(String[] args){
		
		Paint pnt = new Paint();
//		
		new TestPaint().drawer(pnt.test());

		
	}
	
	ArrayList<Point> ar = pnt.test();
	
	public void drawer(ArrayList<Point> ar) {
//		ArrayList<MyCoordinates> thiar = new ArrayList<MyCoordinates>();
//		thiar.get(0).lat
		JFrame jf = new JFrame();
		JPanel jp = this;
		Graphics g ;
		int[] scrres = GetNativeScreenResolution.screenres();
		jf.setSize(scrres[0], scrres[1]);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(null);
//		this.setBounds(0,0,500,500);
		jf.add(this);
		jp.setSize(scrres[0], scrres[1]);
		jf.add(jp);
//		paint(g);
//		int lowh = ar.size();
//		int ilo = 0;
//		while(lowh >= 0){
//			p1 = new Point(ar.get(ilo).x, ar.get(ilo).y);
//			p2 = new Point(ar.get(ilo+1).x, ar.get(ilo+1).y);
//			System.out.println(p1.x+" "+p1.y+" "+p2.x+" "+p2.y);
//			
////			TestPaint.paint(p1, p2);
//			
////			g.drawLine(ar.get(ilo).lat, ar.get(ilo).longi, ar.get(ilo+1).lat, ar.get(ilo+1).longi);
//		
//			
//		repaint();
////		ilo++;
//		lowh--;
//		}
		
	}

//public void paintComponent(Graphics g){
//	
//}
	
	  public void paint(Graphics g) {
	        g.setColor(Color.blue);
	        ((Graphics2D) g).setStroke(new BasicStroke(5));
	      
	        int lowh = ar.size();
			int ilo = 0;
			while(lowh > 1){
//				p1 = new Point(ar.get(ilo).x, ar.get(ilo).y);
//				p2 = new Point(ar.get(ilo+1).x, ar.get(ilo+1).y);
//				System.out.println(p1.x+" "+p1.y);
				g.drawLine(ar.get(ilo).x,ar.get(ilo).y, ar.get(ilo+1).x, ar.get(ilo+1).y);
//				g.drawLine(ar.get(ilo).lat, ar.get(ilo).longi, ar.get(ilo+1).lat, ar.get(ilo+1).longi);
//				g.drawLine(ar.get(lowh).x,ar.get(lowh).y, ar.get(lowh-1).x, ar.get(lowh-1).y);
//				g.fillOval(p1.x, p1.y, 4, 6);
				repaint();
			ilo++;
			lowh--;
			}
//	        g.drawLine(p1.x, p1.y, p2.x, p2.y);
//	        g.drawLine(579,113,562,91);
//	    
//	        g.fillRect(20, 20, 50, 100);
	        
	    }

}
