package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class DeleteNodeInterface extends CustomInterface {

	private JFrame nodeWindow = null;
	private JPanel mainPanel = null;
	
	private JLabel nodeLabel = null;
	private JComboBox<String> nodeComboBox = null;
	private JButton okButton = null, cancelButton = null;

	public DeleteNodeInterface() {
		initialize();
	}

	protected void initialize() {
		nodeWindow = new JFrame("Delete node");
		nodeWindow.setResizable(false);
		nodeWindow.setBounds(833, 427, 402, 215);
		nodeWindow.getContentPane().setLayout(null);
		nodeWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 396, 187);
		mainPanel.setLayout(null);
		
		nodeWindow.getContentPane().add(mainPanel);
		
		nodeLabel = new JLabel("Select node");
		nodeLabel.setBounds(95, 50, LABEL_WIDTH, LABEL_HEIGHT);
		
		nodeComboBox = new JComboBox<>();
		nodeComboBox.setBounds(170, 50, COMBO_BOX_WIDTH, COMBO_BOX_HEIGHT);
		
		if (map.isEmpty()) {
			nodeComboBox.addItem("No existing nodes");
		} else {
			for (String key : map.keySet()) {
				nodeComboBox.addItem(key);
			}
		}
		
		okButton = new JButton("Ok");
		okButton.setBounds(93, 132, BUTTON_WIDTH, BUTTON_HEIGHT);
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				validate();
			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(195, 132, BUTTON_WIDTH, BUTTON_HEIGHT);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				nodeWindow.dispose();
			}
		});
		
		mainPanel.add(nodeLabel);
		mainPanel.add(nodeComboBox);
		mainPanel.add(okButton);
		mainPanel.add(cancelButton);
		
		nodeWindow.setVisible(true);
	}
	
	protected void validate() {
		if (!nodeComboBox.getSelectedItem().toString().equals("No existing nodes")) {
			boolean errorFlag = graph.removeNode(graph.getNode(nodeComboBox.getSelectedItem().toString()));
			if (errorFlag) {
				dialog.showErrorDialog("There is no such node in the map.");
			} else {
				nodeComboBox.removeAllItems();
				if (map.isEmpty()) {
					nodeComboBox.addItem("No existing nodes");
				} else {
					for (String key : map.keySet()) {
						nodeComboBox.addItem(key);
					}
				}
				dialog.showInformationDialog("Node has been removed successfully.");
			}
		} else {
			dialog.showErrorDialog("No existing nodes to delete.");
		}
	}
}
