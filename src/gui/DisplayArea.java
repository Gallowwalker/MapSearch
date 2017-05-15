package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DisplayArea extends JPanel {
	
	private UserInterface parent = null;
	
	public DisplayArea(UserInterface userInterface) {
		super();
		setLayout(null);
		parent = userInterface;
	}
	
	protected void paintComponent(Graphics graphics) {
    	super.paintComponent(graphics);
    	this.setBackground(Color.WHITE);
    	//parent.getDialogProcessor().reDraw(this, graphics);
    }
}
