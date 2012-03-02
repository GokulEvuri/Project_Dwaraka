package UI;



//import gokulGPSProj.TestXMLReader;

import java.awt.Graphics;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import GetBoundsXMLParsing.*;
import Painter.Paint;

public class mainJFrameSet extends JFrame {
  private DrawPanelSet drawArea;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JMenuBar mainMenu;
  private javax.swing.JMenu menuFile;
  private javax.swing.JMenuItem mItemOpen;
  private javax.swing.JMenuItem mItemExit;

  static File glofile;
	
	private static final long serialVersionUID = 1L;
	
	public mainJFrameSet() {
		drawArea = new DrawPanelSet();
		jScrollPane1 = new javax.swing.JScrollPane();
		mainMenu = new javax.swing.JMenuBar();
		menuFile = new javax.swing.JMenu();
		mItemOpen = new javax.swing.JMenuItem();
		mItemExit = new javax.swing.JMenuItem();
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jScrollPane1.setViewportView(drawArea);
		this.getContentPane().add(jScrollPane1);
		
		mItemOpen.setText("Open");
		
		mItemOpen.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	mItemOpenActionPerformed(evt);
		    }
		});
	
		menuFile.add(mItemOpen);
		
		// Create exit menu item and add to file menu
		mItemExit.setText("Exit");
		
		mItemExit.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		        mItemExitActionPerformed(evt);
		    }
		});
		
		menuFile.add(mItemExit);
		
		// Add file menu to main menu and set as menu bar
		menuFile.setText("File");
		mainMenu.add(menuFile);
		this.setJMenuBar(mainMenu);
		
      drawArea.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
    	  public void mouseMoved(java.awt.event.MouseEvent evt)
    	  {
    		  
    	  }});
  		
      drawArea.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
          public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
          	
          }
          	
      });

		this.pack();
	}
	
	

	public static void GetItRool() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      new mainJFrameSet().setVisible(true);
	}
	
  private void mItemOpenActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser filechooser = new JFileChooser();
		if(filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			 glofile = filechooser.getSelectedFile();
			 GetBounds gb = new GetBounds();
			 String[] Coords = gb.getLocation();
			 System.out.println("minLat: " + Coords[0]+"\tminLong: "+Coords[1]+"\tmaxLat: " + Coords[2]+"\tmaxLong: "+Coords[3]);
			 Paint pnt = new Paint();
;
			 pnt.DrawLatLon();
		}
		drawArea.repaint();
  }// Gokul
	
  private void mItemExitActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
  }

  public static File getFile(){
	  return glofile;
  }
}