package gui;

import javax.swing.JFrame;

import processors.DialogProcessor;

public class UserInterface {

	private JFrame mainWindow = null;
	private DialogProcessor dialogProcessor = null;
	private DisplayArea displayArea = null;
	
	public UserInterface() {
		initialize();
	}
	
	private void initialize() {
		mainWindow = new JFrame("Map Search Program");
		mainWindow.setResizable(false);
		mainWindow.setBounds(120, 50, 1680, 950);
		mainWindow.getContentPane().setLayout(null);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
	}
	
	public DialogProcessor getDialogProcessor() {
        return dialogProcessor;
    }

}
