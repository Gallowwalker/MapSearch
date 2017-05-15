package gui;

import javax.swing.JFrame;

import processors.DialogProcessor;
import javax.swing.JPanel;
import javax.swing.JButton;

public class UserInterface {

	private JFrame mainWindow = null;
	private JPanel buttonsPanel = null;
	private JButton newMapButton = null;
	private JButton loadMapButton = null;
	private JButton saveMapButton = null;
	
	private DialogProcessor dialogProcessor = new DialogProcessor();
	private DisplayArea displayArea = new DisplayArea(this);
	
	public UserInterface() {
		initialize();
	}
	
	private void initialize() {
		mainWindow = new JFrame("Map Search Program");
		mainWindow.setResizable(false);
		mainWindow.setBounds(120, 50, 1680, 950);
		mainWindow.getContentPane().setLayout(null);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setBounds(0, 0, 199, 921);
		buttonsPanel.setLayout(null);
		
		mainWindow.getContentPane().add(buttonsPanel);
		
		newMapButton = new JButton("New Map");
		newMapButton.setBounds(10, 11, 89, 23);
		
		loadMapButton = new JButton("Load Map");
		loadMapButton.setBounds(10, 44, 89, 23);
		
		saveMapButton = new JButton("Save Map");
		saveMapButton.setBounds(10, 77, 89, 23);
		
		buttonsPanel.add(newMapButton);
		buttonsPanel.add(loadMapButton);
		buttonsPanel.add(saveMapButton);
		

		
		displayArea.setBounds(199, 0, 1475, 921);
		mainWindow.getContentPane().add(displayArea);
		
		mainWindow.setVisible(true);
	}
	
	public DialogProcessor getDialogProcessor() {
        return dialogProcessor;
    }
}
