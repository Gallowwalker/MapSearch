package gui;

import javax.swing.JFrame;

import processors.DialogProcessor;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class UserInterface {

	private JFrame mainWindow = null;
	private JPanel buttonsPanel = null;
	private JButton newMapButton = null, loadMapButton = null, saveMapButton = null;
	private JButton dijkstraSearchButton = null, greedySearchButton = null, customSearchButton = null;
	private JButton resetButton = null, exitButton = null;
	private JLabel optionsLabel = null, algoritmLabel = null, otherLabel = null;
	
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
		buttonsPanel.setBounds(0, 0, 149, 921);
		buttonsPanel.setLayout(null);
		
		mainWindow.getContentPane().add(buttonsPanel);
		
		optionsLabel = new JLabel("Options");
		optionsLabel.setBounds(50, 11, 129, 28);
		
		newMapButton = new JButton("New Map");
		newMapButton.setBounds(10, 44, 129, 28);
		
		loadMapButton = new JButton("Load Map");
		loadMapButton.setBounds(10, 77, 129, 28);
		
		saveMapButton = new JButton("Save Map");
		saveMapButton.setBounds(10, 110, 129, 28);
		
		algoritmLabel = new JLabel("Algoritms");
		algoritmLabel.setBounds(50, 176, 129, 28);
		
		dijkstraSearchButton = new JButton("Implement Dijkstra");
		dijkstraSearchButton.setBounds(10, 209, 129, 28);
		
		greedySearchButton = new JButton("Implement Greedy");
		greedySearchButton.setBounds(10, 242, 129, 28);
		
		customSearchButton = new JButton("Implement Other");
		customSearchButton.setBounds(10, 275, 129, 28);
		
		otherLabel = new JLabel("Other");
		otherLabel.setBounds(60, 341, 129, 28);
		
		resetButton = new JButton("Reset Search");
		resetButton.setBounds(10, 374, 129, 28);
		
		exitButton = new JButton("Exit Program");
		exitButton.setBounds(10, 407, 129, 28);
		
		buttonsPanel.add(optionsLabel);
		buttonsPanel.add(newMapButton);
		buttonsPanel.add(loadMapButton);
		buttonsPanel.add(saveMapButton);
		buttonsPanel.add(algoritmLabel);
		buttonsPanel.add(dijkstraSearchButton);
		buttonsPanel.add(greedySearchButton);
		buttonsPanel.add(customSearchButton);
		buttonsPanel.add(otherLabel);
		buttonsPanel.add(resetButton);
		buttonsPanel.add(exitButton);
		
		displayArea.setBounds(149, 0, 1525, 921);
		mainWindow.getContentPane().add(displayArea);
		
		mainWindow.setVisible(true);
	}
	
	public DialogProcessor getDialogProcessor() {
        return dialogProcessor;
    }
}
