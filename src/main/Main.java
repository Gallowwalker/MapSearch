package main;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.UserInterface;

public class Main {
	
	/**
	 * User interface instance.
	 */
	private static UserInterface userInterface = null;
	
	/**
	 * Gets the default look and feel of the OS, creates the user interface and launches the application.
	 * @param args Environment arguments.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception) {
                    exception.printStackTrace();
                }
				try {
					userInterface = new UserInterface();
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Return the user interface.
	 * @return User interface instance.
	 */
	public static UserInterface getUserInterface() {
		return userInterface;
	}

}
