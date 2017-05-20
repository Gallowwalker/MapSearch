package gui;

import javax.swing.JFrame;

import processors.DialogProcessor;
import javax.swing.JPanel;

import map.Graph;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class UserInterface {
	
	private static final int COMPONENT_WIDTH = 129, COMPONENT_HEIGHT = 28;

	private JFrame mainWindow = null;
	private JPanel buttonsPanel = null;
	private JButton newMapButton = null, loadMapButton = null, saveMapButton = null;
	private JButton addNodeButton = null, editNodeButton = null, deleteNodeButton = null;
	private JButton addLinkButton = null, editLinkButton = null, deleteLinkButton = null;
	private JButton dijkstraSearchButton = null, greedySearchButton = null, customSearchButton = null;
	private JButton resetButton = null, exitButton = null;
	private JLabel mapOptionsLabel = null, nodeOptionsLabel = null, linkOptionsLabel = null, algoritmLabel = null, otherLabel = null;
	
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
		
		mapOptionsLabel = new JLabel("Map Options");
		mapOptionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mapOptionsLabel.setBounds(10, 11, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		
		
		newMapButton = new JButton("New Map");
		newMapButton.setBounds(10, 44, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		
		loadMapButton = new JButton("Load Map");
		loadMapButton.setBounds(10, 77, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		
		saveMapButton = new JButton("Save Map");
		saveMapButton.setBounds(10, 110, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		
		
		nodeOptionsLabel = new JLabel("Node Options");
		nodeOptionsLabel.setBounds(10, 143, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		nodeOptionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		addNodeButton = new JButton("Add Node");
		addNodeButton.setBounds(10, 176, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		addNodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				NodeUserInterface nodeInterface = new NodeUserInterface();
			}
		});
		
		editNodeButton = new JButton("Edit Node");
		editNodeButton.setBounds(10, 209, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		editNodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				NodeUserInterface nodeInterface = new NodeUserInterface("Edit node", "editMode");
			}
		});
		
		deleteNodeButton = new JButton("Delete Node");
		deleteNodeButton.setBounds(10, 242, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		deleteNodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				NodeUserInterface nodeInterface = new NodeUserInterface();
			}
		});
		
		
		linkOptionsLabel = new JLabel("Link Options");
		linkOptionsLabel.setBounds(10, 275, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		linkOptionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		addLinkButton = new JButton("Add Link");
		addLinkButton.setBounds(10, 308, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		addLinkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				LinkUserInterface linkInterface = new LinkUserInterface();
			}
		});
		
		editLinkButton = new JButton("Edit Link");
		editLinkButton.setBounds(10, 341, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		editLinkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				LinkUserInterface linkInterface = new LinkUserInterface("Edit link", "editMode");
			}
		});
		
		deleteLinkButton = new JButton("Delete Link");
		deleteLinkButton.setBounds(10, 374, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		deleteLinkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				LinkUserInterface linkInterface = new LinkUserInterface();
			}
		});
		
		
		algoritmLabel = new JLabel("Algoritms");
		algoritmLabel.setHorizontalAlignment(SwingConstants.CENTER);
		algoritmLabel.setBounds(10, 684, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		
		
		dijkstraSearchButton = new JButton("Implement Dijkstra");
		dijkstraSearchButton.setBounds(10, 717, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		
		greedySearchButton = new JButton("Implement Greedy");
		greedySearchButton.setBounds(10, 750, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		
		customSearchButton = new JButton("Implement Other");
		customSearchButton.setBounds(10, 783, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		
		
		otherLabel = new JLabel("Other");
		otherLabel.setHorizontalAlignment(SwingConstants.CENTER);
		otherLabel.setBounds(10, 816, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		
		
		resetButton = new JButton("Reset Search");
		resetButton.setBounds(10, 849, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		
		exitButton = new JButton("Exit Program");
		exitButton.setBounds(10, 882, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//mainWindow.dispose();
				System.exit(0);
			}
		});
		
		buttonsPanel.add(mapOptionsLabel);
		
		buttonsPanel.add(newMapButton);
		buttonsPanel.add(loadMapButton);
		buttonsPanel.add(saveMapButton);
		
		buttonsPanel.add(nodeOptionsLabel);
		
		buttonsPanel.add(addNodeButton);
		buttonsPanel.add(editNodeButton);
		buttonsPanel.add(deleteNodeButton);
		
		buttonsPanel.add(linkOptionsLabel);
		
		buttonsPanel.add(addLinkButton);
		buttonsPanel.add(editLinkButton);
		buttonsPanel.add(deleteLinkButton);
		
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
