package UI;

import java.io.File;

import javax.swing.JFileChooser;

public class FileChoose {
	static File golabFile;

	public static File fileChoose(){
		JFileChooser filechooser = new JFileChooser();
		if(filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			  golabFile = filechooser.getSelectedFile();	    	 
		}
		return golabFile;
	}
	
//	public static void main(String[] args){
//		File retfile = FileChoose.fileChoose();
//		if(retfile!=null){System.out.println("No... YOU FUCKED UP");
//		}
//		
//		
//	}
	
	
}
