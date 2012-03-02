package UI;

import java.awt.Dimension;
import java.awt.Graphics;


import javax.swing.JPanel;

import GetBoundsXMLParsing.GetNativeScreenResolution;
import Temp.*;
public class DrawPanelSet extends JPanel {
	GetNativeScreenResolution res = new GetNativeScreenResolution();
    private static final long serialVersionUID = 1L;
	public DrawPanelSet() { 
		int[] resFinal = GetNativeScreenResolution.screenres();
		
		final int PANEL_WIDTH = (resFinal[0]-(resFinal[0]/16));
		final int PANEL_HEIGHT = (resFinal[1]-(resFinal[1]/12));
		  setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
          }


    public void paintComponent(Graphics g) {
//    	Test.test();
//    	while(Test.x.length!=0){
//    	g.fillOval(Test.x[0], Test.y[0], 6, 5);
//    	update(g);
//    	super.paintComponent(g);
//    	}    
	   
	    }
//    public void paint(Graphics g){
////    	g.drawOval(x, y, width, height)
//    	Test.test();
//    	g.fillOval(Test.x[0], Test.y[0], 6, 5);
//    	update(g);
//    }
    
    }