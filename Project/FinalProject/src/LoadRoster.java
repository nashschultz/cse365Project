import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class LoadRoster extends World {
	
	public void loadRoster() throws IOException {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "CSV", "csv");
		fileChooser.setFileFilter(filter);
		
		int returnCsv = fileChooser.showOpenDialog(getParent());
	    if(returnCsv == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            fileChooser.getSelectedFile().getName());
	       String row;
	       BufferedReader csvReader = new BufferedReader(new FileReader(fileChooser.getSelectedFile().getPath()));
	       while ((row = csvReader.readLine()) != null) {
	           String[] data = row.split(",");
	            
	       }
	       csvReader.close();
	    }
	}

}
