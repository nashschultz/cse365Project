import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFileChooser;

public class SaveCsv {
	
	Source source;
	
	public SaveCsv(Source s) {
		source = s;
	}
	
	public String convertToCSV(String[] data) {
	    return Stream.of(data)
	      .collect(Collectors.joining(","));
	}
	
	public void saveToCsv() throws FileNotFoundException {
		if (source.getRoster().size() > 0) {
			JFileChooser f = new JFileChooser();
	        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
	        f.showSaveDialog(null);
	        
	        
			
			ArrayList<String[]> data = new ArrayList<String[]>();
			data.add(source.getRoster().get(0).getHeader());
			for (int i = 0; i < source.getRoster().size(); i++) {
				data.add(source.getRoster().get(i).getPersonArray());
			}
			
			for (int i = 0; i < data.get(0).length; i++) {
				System.out.println(data.get(0)[i]);
			}
		
			File csvOutputFile = new File(f.getCurrentDirectory() + "/Roster.csv");
		    try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
		        data.stream()
		          .map(this::convertToCSV)
		          .forEach(pw::println);
		    }
		}
	}

}
