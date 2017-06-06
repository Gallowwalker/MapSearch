package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import main.Main;
import map.Node;

public final class LinkUserInterface extends CustomInterface {
	
	private String frameTitle = "Add new link";
	private String mode = null;
	
	private byte pathType = 0;
	private byte linkType = 0;
	private double linkLength = 0.0d;
	/*private enum LINK_TYPE {
		ONE_WAY, TWO_WAY;
	}*/
	
	private HashMap<String, Byte> pathTypes = new HashMap<>();
	
	private Object fromNodeSelectedItem = null, toNodeSelectedItem = null;

	private JFrame linkWindow = null;
	private JPanel mainPanel = null;
	private JButton okButton = null, cancelButton = null;
	private JLabel fromNodeLabel = null, toNodeLabel = null, pathTypeLabel = null, linkLengthLabel = null, linkTypeLabel1 = null, linkTypeLabel2 = null, linkImageLabel = null;
	private JComboBox<String> fromNodeComboBox = null, toNodeComboBox = null, pathTypeComboBox = null;
	private JTextField linkLenghtTextField = null;
	private JRadioButton linkTypeRadioButton1 = null, linkTypeRadioButton2 = null;
	private ButtonGroup linkTypeButtonGroup = null;
	
	public LinkUserInterface() {
		initialize();
	}
	
	public LinkUserInterface(String title, String mode) {
		this.frameTitle = title;
		this.mode = mode;
		initialize();
	}
	
	protected void initialize() {
		linkWindow = new JFrame(frameTitle);
		linkWindow.setResizable(false);
		linkWindow.setBounds(833, 427, 402, 215);
		linkWindow.getContentPane().setLayout(null);
		linkWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 396, 187);
		mainPanel.setLayout(null);
		
		linkWindow.getContentPane().add(mainPanel);
		
		fromNodeLabel = new JLabel("From Node");
		fromNodeLabel.setBounds(10, 10, LABEL_WIDTH, LABEL_HEIGHT);
		
		toNodeLabel = new JLabel("To Node");
		toNodeLabel.setBounds(10, 43, LABEL_WIDTH, LABEL_HEIGHT);
		
		pathTypeLabel = new JLabel("Path Type");
		pathTypeLabel.setBounds(10, 76, LABEL_WIDTH, LABEL_HEIGHT);
		
		linkLengthLabel = new JLabel("Link Length");
		linkLengthLabel.setBounds(10, 109, LABEL_WIDTH, LABEL_HEIGHT);
		
		
		fromNodeComboBox = new JComboBox<>();
		fromNodeComboBox.setBounds(83, 10, COMBO_BOX_WIDTH, COMBO_BOX_HEIGHT);
		
		if (map.isEmpty()) {
			fromNodeComboBox.addItem("No existing nodes");
		} else {
			for (String key : map.keySet()) {
				fromNodeComboBox.addItem(key);
			}
		}
		
		fromNodeComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				fromNodeSelectedItem = fromNodeComboBox.getSelectedItem();
			}
	    });
		
		fromNodeSelectedItem = fromNodeComboBox.getSelectedItem();
		
		
		toNodeComboBox = new JComboBox<>();
		toNodeComboBox.setBounds(83, 43, COMBO_BOX_WIDTH, COMBO_BOX_HEIGHT);
		
		if (map.isEmpty()) {
			toNodeComboBox.addItem("No existing nodes");
		} else {
			for (String key : map.keySet()) {
				toNodeComboBox.addItem(key);
			}
		}
		
		toNodeComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				toNodeSelectedItem = toNodeComboBox.getSelectedItem();
			}
	    });
		
		toNodeSelectedItem = toNodeComboBox.getSelectedItem();
		
		
		
		pathTypes.put("Highway", (byte) 0);
		pathTypes.put("First Class", (byte) 1);
		pathTypes.put("Second Class", (byte) 2);
		
		
		pathTypeComboBox = new JComboBox<>();
		pathTypeComboBox.setBounds(83, 76, COMBO_BOX_WIDTH, COMBO_BOX_HEIGHT);
		for (String key : pathTypes.keySet()) {
			pathTypeComboBox.addItem(key);
		}
		
		
		linkLenghtTextField = new JTextField();
		linkLenghtTextField.setBounds(83, 109, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		
		
		linkTypeLabel1 = new JLabel("One Way Link");
		linkTypeLabel1.setBounds(243, 10, LABEL_WIDTH + 10, LABEL_HEIGHT);
		
		linkTypeLabel2 = new JLabel("Two Way Link");
		linkTypeLabel2.setBounds(243, 43, LABEL_WIDTH + 10, LABEL_HEIGHT);
		
		
		linkTypeRadioButton1 = new JRadioButton();
		linkTypeRadioButton1.setBounds(316, 10, 20, 20);
		
		linkTypeRadioButton2 = new JRadioButton();
		linkTypeRadioButton2.setBounds(316, 43, 20, 20);
		linkTypeRadioButton2.setSelected(true);
		
		
		linkTypeButtonGroup = new ButtonGroup();
		linkTypeButtonGroup.add(linkTypeRadioButton1);
		linkTypeButtonGroup.add(linkTypeRadioButton2);
		
		
		linkImageLabel = new JLabel();
		linkImageLabel.setBounds(243, 63, 128, 128);
		linkImageLabel.setIcon(new ImageIcon("img\\link.png"));
		
		
		okButton = new JButton("Ok");
		okButton.setBounds(10, 152, BUTTON_WIDTH, BUTTON_HEIGHT);
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				validate();
			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(114, 152, BUTTON_WIDTH, BUTTON_HEIGHT);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				linkWindow.dispose();
			}
		});
		
		if (mode != null && mode.equals("editMode")) {
			
		}
		
		mainPanel.add(fromNodeLabel);
		mainPanel.add(toNodeLabel);
		mainPanel.add(pathTypeLabel);
		mainPanel.add(linkLengthLabel);
		
		mainPanel.add(fromNodeComboBox);
		mainPanel.add(toNodeComboBox);
		mainPanel.add(pathTypeComboBox);
		mainPanel.add(linkLenghtTextField);
		
		mainPanel.add(linkTypeLabel1);
		mainPanel.add(linkTypeLabel2);
		
		mainPanel.add(linkTypeRadioButton1);
		mainPanel.add(linkTypeRadioButton2);
		
		mainPanel.add(linkImageLabel);
		
		mainPanel.add(okButton);
		mainPanel.add(cancelButton);
		
		linkWindow.setVisible(true);
	}
	
	protected void validate() {
		byte errorFlags = 0;
		
		if (!map.isEmpty() && map.size() > 1) {
			if (fromNodeSelectedItem == toNodeSelectedItem) {
				errorFlags++;
				dialog.showErrorDialog("You can't create link to the same node.");
			}
			
			pathType = pathTypes.get(pathTypeComboBox.getSelectedItem().toString());
			
			String textField = linkLenghtTextField.getText();
			
			if (!textField.isEmpty() && textField.matches("^[0-9]+([\\,\\.][0-9]+)?$")) {
				linkLength = Double.parseDouble(textField);
			} else if (textField.isEmpty()) {
				errorFlags++;
				dialog.showErrorDialog("Link length can't be empty.");
			} else {
				errorFlags++;
				dialog.showErrorDialog("Link length must be a numeric value.");
			}
			
			if (errorFlags == 0) {
				boolean oneLinkErrorFlag = false;
				boolean twoLinkErrorFlag = false;
				if (linkTypeRadioButton1.isSelected()) {
					linkType = 1;
					oneLinkErrorFlag = graph.addOneWayLink(fromNodeSelectedItem.toString(), toNodeSelectedItem.toString(), (byte) linkType, linkLength);
				} else {
					linkType = 2;
					twoLinkErrorFlag = graph.addTwoWayLink(fromNodeSelectedItem.toString(), toNodeSelectedItem.toString(), (byte) linkType, linkLength);
				}
				if (oneLinkErrorFlag || twoLinkErrorFlag) {
					boolean linkWarningFlag = dialog.showWarningDialog("The same link already exist. Do you want to override its properties with the new ones?");
					if (linkWarningFlag) {
						dialog.showInformationDialog("Node properties were overridden successfully.");
						linkWindow.dispose();
					}
				} else {
					dialog.showInformationDialog("New link was added successfully.");
					linkWindow.dispose();
				}
			}
			
		} else {
			if (mode != null && mode.equals("editMode")) {
				dialog.showErrorDialog("No existing nodes.");
			} else {
				dialog.showErrorDialog("Not enough nodes to create a link.");
			}
		}
	}

}
