import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class World extends JFrame implements ActionListener {
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem aboutMenu, loadRoster, addAttendance, save, plotData;
	private JTable table;
	private DefaultTableModel model;
	Source source = new Source();

	public World() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		
		aboutMenu = new JMenuItem("About");
		
		loadRoster = new JMenuItem("Load Roster");
		addAttendance = new JMenuItem("Add Attendace");
		save = new JMenuItem("Save");
		plotData = new JMenuItem("Plot Data");
		
		fileMenu.add(loadRoster);
		fileMenu.add(addAttendance);
		fileMenu.add(save);
		fileMenu.add(plotData);
		
		aboutMenu.addActionListener(this);
		loadRoster.addActionListener(this);
		addAttendance.addActionListener(this);
		save.addActionListener(this);
		plotData.addActionListener(this);
		
		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		
		setJMenuBar(menuBar);
		
		setLayout(new FlowLayout());
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		World world = new World();
		world.setSize(500, 500);
		world.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == aboutMenu) {
			JOptionPane.showMessageDialog(this, "CSE360 Final Project\nNash Schultz\nAdd All Names Here");
		} else if (e.getSource() == loadRoster) {
			// load the roster csv
			LoadRoster loadRoster = new LoadRoster();
			try {
				loadRoster.loadRoster(source);
				
				String[] columnNames = {"ID", "First Name", "Last Name", "Program", "Level", "ASURITE"};
				Object[][] data = new Object[source.getRoster().size()][6];
				for (int i = 0; i < source.getRoster().size(); i++) {
					data[i] = source.getRoster().get(i).getPersonArray();
					System.out.println(data[i][2]);
				}
			    model = new DefaultTableModel();
			    model.addColumn("ID");
			    model.addColumn("First Name");
			    model.addColumn("Last Name");
			    model.addColumn("Program");
			    model.addColumn("Level");
			    model.addColumn("ASURITE");
			    for (int i = 0; i < data.length; i++) {
			    	model.addRow(data[i]);
			    }
			    
				table = new JTable(model);
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setSize(500, 500);
				add(scrollPane);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == addAttendance) {
			// add attendance
			LoadAttendance loadAttendance = new LoadAttendance();
			try {
				String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec" };
				Integer[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
				JComboBox monthBox = new JComboBox(months);
				monthBox.setSelectedIndex(0);
				
				JComboBox dayBox = new JComboBox(days);
				dayBox.setSelectedIndex(0);
				
				JPanel popUp = new JPanel();
				popUp.add(monthBox);
				popUp.add(dayBox);
				
				String colName = "";

				int result = JOptionPane.showConfirmDialog(null, popUp, 
			               "Please enter the date", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
			         colName = months[monthBox.getSelectedIndex()] + " " + days[dayBox.getSelectedIndex()];
			    }
				
				loadAttendance.loadAttendance(source, colName);
				
				Integer[] times = new Integer[source.getRoster().size()];
				for (int i = 0; i < source.getRoster().size(); i++) {
					times[i] = source.getRoster().get(i).getTime(colName);
				}
				model.addColumn(colName, times);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == save) {
			// save 
			SaveCsv save = new SaveCsv(source);
			try {
				save.saveToCsv();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == plotData) {
			// plot data
		}
	}

}
