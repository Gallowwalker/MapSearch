package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import map.Node;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public final class NodeUserInterface extends CustomInterface {
	
	private String frameTitle = "Add new node";
	private String mode = null;
	
	private String nodeName = null;
	private double nodeWeight = 0.0d;
	private int nodeX = 0;
	private int nodeY = 0;
	
	private JFrame nodeWindow = null;
	private JPanel mainPanel = null;
	private JButton okButton = null, cancelButton = null;
	private JLabel nodeNameLabel = null, nodeWeightLabel = null, nodeXLabel = null, nodeYLabel = null, nodeImageLabel = null;
	private JTextField nodeNameTextField = null, nodeWeightTextField = null, nodeXTextField = null, nodeYTextField = null;
	private JComboBox<String> nodeNameComboBox = null;
	private Node node = null;
	private Object selectedItem = null;

	public NodeUserInterface() {
		initialize();
	}
	
	public NodeUserInterface(String title, String mode) {
		this.frameTitle = title;
		this.mode = mode;
		initialize();
	}
	
	protected void initialize() {
		nodeWindow = new JFrame(frameTitle);
		nodeWindow.setResizable(false);
		nodeWindow.setBounds(833, 427, 402, 215);
		nodeWindow.getContentPane().setLayout(null);
		nodeWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 396, 187);
		mainPanel.setLayout(null);
		
		nodeWindow.getContentPane().add(mainPanel);
		
		nodeNameLabel = new JLabel("Node Name");
		nodeNameLabel.setBounds(10, 10, LABEL_WIDTH, LABEL_HEIGHT);
		
		nodeWeightLabel = new JLabel("Node Weight");
		nodeWeightLabel.setBounds(10, 43, LABEL_WIDTH, LABEL_HEIGHT);
		
		nodeXLabel = new JLabel("Coordinate X");
		nodeXLabel.setBounds(10, 76, LABEL_WIDTH, LABEL_HEIGHT);
		
		nodeYLabel = new JLabel("Coordinate Y");
		nodeYLabel.setBounds(10, 109, LABEL_WIDTH, LABEL_HEIGHT);
		
		nodeWeightTextField = new JTextField();
		nodeWeightTextField.setBounds(83, 43, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		nodeWeightTextField.setColumns(10);
		
		nodeXTextField = new JTextField();
		nodeXTextField.setBounds(83, 76, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		nodeXTextField.setColumns(10);
		
		nodeYTextField = new JTextField();
		nodeYTextField.setBounds(83, 109, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		nodeYTextField.setColumns(10);
		
		if (mode != null && mode.equals("editMode")) {
			nodeNameComboBox = new JComboBox<>();
			nodeNameComboBox.setBounds(83, 10, COMBO_BOX_WIDTH, COMBO_BOX_HEIGHT);
			nodeNameComboBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent event) {
					selectedItem = nodeNameComboBox.getSelectedItem();
					node = graph.getNode(selectedItem.toString());
					if (!map.isEmpty()) {
						updateFields();
					}
					
				}
			});
			
			if (map.isEmpty()) {
				nodeNameComboBox.addItem("No existing nodes");
			} else {
				for (String key : map.keySet()) {
					nodeNameComboBox.addItem(key);
				}
			}
			
			
		} else {
			nodeNameTextField = new JTextField();
			nodeNameTextField.setBounds(83, 10, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
			nodeNameTextField.setColumns(10);
		}
		
		nodeImageLabel = new JLabel();
		nodeImageLabel.setBounds(243, 23, 128, 128);
		nodeImageLabel.setIcon(new ImageIcon("img\\node.png"));
		
		okButton = new JButton("Ok");
		okButton.setBounds(10, 152, BUTTON_WIDTH, BUTTON_HEIGHT);
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (mode != null && mode.equals("editMode")) {
					if (!map.isEmpty()) {
						validate();
					} else {
						dialog.showErrorDialog("No existing nodes to edit.");
					}
				}
				validate();
			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(114, 152, BUTTON_WIDTH, BUTTON_HEIGHT);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				nodeWindow.dispose();
			}
		});
		
		mainPanel.add(nodeNameLabel);
		mainPanel.add(nodeWeightLabel);
		mainPanel.add(nodeXLabel);
		mainPanel.add(nodeYLabel);
		
		if (mode != null && mode.equals("editMode")) {
			mainPanel.add(nodeNameComboBox);
		} else {
			mainPanel.add(nodeNameTextField);
		}
		
		mainPanel.add(nodeWeightTextField);
		mainPanel.add(nodeXTextField);
		mainPanel.add(nodeYTextField);
		
		mainPanel.add(nodeImageLabel);
		
		mainPanel.add(okButton);
		mainPanel.add(cancelButton);
		
		nodeWindow.setVisible(true);
	}
	
	protected void validate() {
		byte errorFlags = 0;
		nodeName = nodeNameTextField.getText();
		
		if (!nodeName.isEmpty() && nodeName.length() > 0 && nodeName != null) {
			
			String textField = nodeWeightTextField.getText();
			
			if (!textField.isEmpty() && textField.matches("^[0-9]+([\\,\\.][0-9]+)?$")) {
				nodeWeight = Double.parseDouble(textField);
			} else if (textField.isEmpty()) {
				//errorFlags++;
				//dialog.showErrorDialog("You must enter value for the node weight.");
			} else {
				errorFlags++;
				dialog.showErrorDialog("The node weight must be a numeric value.");
			}
			
			textField = nodeXTextField.getText();
			
			if (!textField.isEmpty() && textField.matches("^[0-9]+([\\,\\.][0-9]+)?$")) {
				if (isInteger(textField)) {
					nodeX = Integer.parseInt(textField);
				} else {
					dialog.showInformationDialog("Coordinate value of X can't be double. Rounding and casting down automatically to integer.");
					nodeX = (int) Math.round(Double.parseDouble(textField));
					nodeXTextField.setText(String.valueOf(nodeX));
				}
			} else if (textField.isEmpty()) {
				//errorFlags++;
				//dialog.showErrorDialog("You must enter value for coordinate X.");
			} else {
				errorFlags++;
				dialog.showErrorDialog("The node X coordinate must be a numeric value.");
			}
			
			textField = nodeYTextField.getText();
			
			if (!textField.isEmpty() && textField.matches("^[0-9]+([\\,\\.][0-9]+)?$")) {
				if (isInteger(textField)) {
					nodeY = Integer.parseInt(textField);
				} else {
					dialog.showInformationDialog("Coordinate value of Y can't be double. Rounding and casting down automatically to integer.");
					nodeY = (int) Math.round(Double.parseDouble(textField));
					nodeYTextField.setText(String.valueOf(nodeY));
				}
			} else if (textField.isEmpty()) {
				//errorFlags++;
				//dialog.showErrorDialog("You must enter value for coordinate Y.");
			} else {
				errorFlags++;
				dialog.showErrorDialog("The node Y coordinate must be a numeric value.");
			}
			
			if (errorFlags == 0) {
				boolean nodeErrorFlag = graph.addNode(new Node(nodeName, nodeWeight, nodeX, nodeY));
				if (nodeErrorFlag) {
					boolean nodeWarningFlag = dialog.showWarningDialog("The same node already exist. Do you want to override its properties with the new ones?");
					if (nodeWarningFlag) {
						dialog.showInformationDialog("Node properties were overridden successfully.");
						nodeWindow.dispose();
					}
				} else {
					dialog.showInformationDialog("New node was added successfully.");
					nodeWindow.dispose();
				}
			}
			
		} else {
			dialog.showErrorDialog("Node must have at least name. The other parameters are optional.");
		}
	}
	
	private void updateFields() {
		nodeWeightTextField.setText(String.valueOf(node.getNodeWeight()));
		nodeXTextField.setText(String.valueOf(node.getX()));
		nodeYTextField.setText(String.valueOf(node.getY()));
	}
	
}
