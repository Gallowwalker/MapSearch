package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import algorithms.CheapestPathSearch;
import algorithms.GreedyByCoordinates;
import algorithms.ShortestPathSearch;
import javafx.scene.text.Text;
import map.Node;

public final class AlgorithmInterface extends CustomInterface {

	private JFrame mainWindow = null;
	private JPanel panel1 = null;
	private Node node = null;
	private Object comboBoxSelectedItem = null, comboBox_1SelectedItem = null;

	/**
	 * Create the application.
	 */
	public AlgorithmInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		mainWindow = new JFrame("Algorithms");
		mainWindow.setResizable(false);
		mainWindow.setBounds(522, 141, 1024, 768);
		mainWindow.getContentPane().setLayout(null);
		mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel1 = new JPanel();
		panel1.setBounds(0, 0, 149, 740);
		panel1.setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(149, 0, 866, 740);
		panel2.setLayout(null);
		
		mainWindow.getContentPane().add(panel1);
		
		mainWindow.getContentPane().add(panel2);
		
		JTextArea txtrTextarea = new JTextArea();
		txtrTextarea.setWrapStyleWord(true);
		txtrTextarea.setBounds(0, 0, 866, 740);
		
		panel2.add(txtrTextarea);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWindow.dispose();
			}
		});
		btnClose.setBounds(10, 706, 129, 23);
		panel1.add(btnClose);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graph.resetAll();
				txtrTextarea.setText("");
				dialog.showInformationDialog("All settings and values has been reset.");
			}
		});
		btnNewButton.setBounds(10, 672, 129, 23);
		panel1.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 39, 129, 20);
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				comboBoxSelectedItem = comboBox.getSelectedItem();
				node = graph.getNode(comboBoxSelectedItem.toString());
				if (!map.isEmpty()) {

				}
				
			}
		});
		
		if (map.isEmpty()) {
			comboBox.addItem("No existing nodes");
		} else {
			for (String key : map.keySet()) {
				comboBox.addItem(key);
			}
		}
		
		panel1.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Start Node");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 14, 129, 14);
		panel1.add(lblNewLabel);
		
		JLabel lblEndNode = new JLabel("End Node");
		lblEndNode.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndNode.setBounds(10, 70, 129, 14);
		panel1.add(lblEndNode);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 95, 129, 20);
		comboBox_1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				comboBox_1SelectedItem = comboBox_1.getSelectedItem();
				node = graph.getNode(comboBox_1SelectedItem.toString());
				if (!map.isEmpty()) {

				}
				
			}
		});
		
		if (map.isEmpty()) {
			comboBox_1.addItem("No existing nodes");
		} else {
			for (String key : map.keySet()) {
				comboBox_1.addItem(key);
			}
		}
		
		panel1.add(comboBox_1);
		
		JLabel lblAlgorithms = new JLabel("Algorithms");
		lblAlgorithms.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlgorithms.setBounds(10, 149, 129, 14);
		panel1.add(lblAlgorithms);
		
		JButton btnShortest = new JButton("Shortest Path");
		btnShortest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShortestPathSearch search = new ShortestPathSearch(txtrTextarea);
				if (search.hasPath(comboBoxSelectedItem.toString(), comboBox_1SelectedItem.toString())) {
					dialog.showInformationDialog("Path has been found.");
				} else {
					dialog.showInformationDialog("No path has been found.");
				}
			}
		});
		btnShortest.setBounds(10, 174, 129, 23);
		panel1.add(btnShortest);
		
		JButton btnCheapest = new JButton("Cheapest Path");
		btnCheapest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheapestPathSearch search = new CheapestPathSearch(txtrTextarea);
				if (search.hasPath(comboBoxSelectedItem.toString(), comboBox_1SelectedItem.toString())) {
					dialog.showInformationDialog("Path has been found.");
				} else {
					dialog.showInformationDialog("No path has been found.");
				}
			}
		});
		btnCheapest.setBounds(10, 208, 129, 23);
		panel1.add(btnCheapest);
		
		JButton btnCustom = new JButton("Custom");
		btnCustom.setBounds(10, 242, 129, 23);
		panel1.add(btnCustom);
		
		JButton btnGreedy = new JButton("Greedy");
		btnGreedy.setBounds(10, 276, 129, 23);
		btnGreedy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GreedyByCoordinates search = new GreedyByCoordinates(txtrTextarea);
				if (search.hasPath(comboBoxSelectedItem.toString(), comboBox_1SelectedItem.toString())) {
					dialog.showInformationDialog("Path has been found.");
				} else {
					dialog.showInformationDialog("No path has been found.");
				}
			}
		});
		panel1.add(btnGreedy);
		
		
		
		
		
		mainWindow.setVisible(true);
	}
}
