import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class World extends JFrame implements ActionListener {
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem aboutMenu, loadRoster, addAttendance, save, plotData;
	
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
				loadRoster.loadRoster();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == addAttendance) {
			// add attendance
		} else if (e.getSource() == save) {
			// save 
		} else if (e.getSource() == plotData) {
			// plot data
		}
	}

}
