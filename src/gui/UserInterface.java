package gui;

import javax.swing.JFrame;

import processors.DialogProcessor;
import javax.swing.JPanel;

import map.Graph;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class UserInterface {
	
	private int componentWidth = 129, componentHeight = 28;

	private JFrame mainWindow = null;
	private JPanel buttonsPanel = null;
	private JButton newMapButton = null, loadMapButton = null, saveMapButton = null;
	private JButton addNodeButton = null, addLinkButton = null;
	private JButton dijkstraSearchButton = null, greedySearchButton = null, customSearchButton = null;
	private JButton resetButton = null, exitButton = null;
	private JLabel optionsLabel = null, algoritmLabel = null, otherLabel = null;
	
	private Graph graph = new Graph();
	
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
		optionsLabel.setBounds(50, 11, componentWidth, componentHeight);
		
		
		newMapButton = new JButton("New Map");
		newMapButton.setBounds(10, 44, componentWidth, componentHeight);
		
		loadMapButton = new JButton("Load Map");
		loadMapButton.setBounds(10, 77, componentWidth, componentHeight);
		
		saveMapButton = new JButton("Save Map");
		saveMapButton.setBounds(10, 110, componentWidth, componentHeight);
		
		addNodeButton = new JButton("Add Node");
		addNodeButton.setBounds(10, 176, componentWidth, componentHeight);
		addNodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				NodeUserInterface nodeInterface = new NodeUserInterface();
			}
		});
		
		addLinkButton = new JButton("Add Link");
		addLinkButton.setBounds(10, 209, componentWidth, componentHeight);
		addLinkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				LinkUserInterface linkInterface = new LinkUserInterface();
			}
		});
		
		
		algoritmLabel = new JLabel("Algoritms");
		algoritmLabel.setBounds(50, 275, componentWidth, componentHeight);
		
		
		dijkstraSearchButton = new JButton("Implement Dijkstra");
		dijkstraSearchButton.setBounds(10, 308, componentWidth, componentHeight);
		
		greedySearchButton = new JButton("Implement Greedy");
		greedySearchButton.setBounds(10, 341, componentWidth, componentHeight);
		
		customSearchButton = new JButton("Implement Other");
		customSearchButton.setBounds(10, 374, componentWidth, componentHeight);
		
		
		otherLabel = new JLabel("Other");
		otherLabel.setBounds(60, 440, componentWidth, componentHeight);
		
		
		resetButton = new JButton("Reset Search");
		resetButton.setBounds(10, 473, componentWidth, componentHeight);
		
		exitButton = new JButton("Exit Program");
		exitButton.setBounds(10, 506, componentWidth, componentHeight);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//mainWindow.dispose();
				System.exit(0);
			}
		});
		
		buttonsPanel.add(optionsLabel);
		
		buttonsPanel.add(newMapButton);
		buttonsPanel.add(loadMapButton);
		buttonsPanel.add(saveMapButton);
		buttonsPanel.add(addNodeButton);
		buttonsPanel.add(addLinkButton);
		
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
	
	public Graph getGraph() {
		return this.graph;
	}
	
	public DialogProcessor getDialogProcessor() {
        return dialogProcessor;
    }
}
