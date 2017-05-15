package main;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.UserInterface;

public class Main {
	
	private static UserInterface userInterface = null;

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
	
	public static UserInterface getUserInterface() {
		return userInterface;
	}

}
