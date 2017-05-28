package processors;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogProcessor {
	
	private JFrame dialogFrame = new JFrame();
	
	private static final String ERROR_DIALOG_TITLE = "Error";
	private static final String INFORMATION_DIALOG_TITLE = "Information";
	private static final String WARNING_DIALOG_TITLE = "Warning";
	private static final Object[] ERROR_DIALOG_BUTTONS = {"Ok"};
	private static final Object[] INFORMATION_DIALOG_BUTTONS = {"Ok"};
	private static final Object[] WARNING_DIALOG_BUTTONS = {"Yes", "No"};
	
	
	
	public void showInformationDialog(String dialogMessage) {
		JOptionPane.showOptionDialog(dialogFrame, dialogMessage, INFORMATION_DIALOG_TITLE, JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, INFORMATION_DIALOG_BUTTONS, INFORMATION_DIALOG_BUTTONS[0]);
		dialogFrame.dispose();
	}
	
	public boolean showQuestionDialog(String dialogMessage) {
		int choice = JOptionPane.showOptionDialog(dialogFrame, dialogMessage, WARNING_DIALOG_TITLE, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, WARNING_DIALOG_BUTTONS, WARNING_DIALOG_BUTTONS[0]);
		switch (choice) {
			case 0:
				dialogFrame.dispose();
				return true;
			case 1:
				dialogFrame.dispose();
				return false;
			default:
				dialogFrame.dispose();
				return false;
		}
	}
	
	public boolean showWarningDialog(String dialogMessage) {
		int choice = JOptionPane.showOptionDialog(dialogFrame, dialogMessage, WARNING_DIALOG_TITLE, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, WARNING_DIALOG_BUTTONS, WARNING_DIALOG_BUTTONS[0]);
		switch (choice) {
			case 0:
				dialogFrame.dispose();
				return true;
			case 1:
				dialogFrame.dispose();
				return false;
			default:
				dialogFrame.dispose();
				return false;
		}
	}
	
	public void showErrorDialog(String dialogMessage) {
		JOptionPane.showOptionDialog(dialogFrame, dialogMessage, ERROR_DIALOG_TITLE, JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, ERROR_DIALOG_BUTTONS, ERROR_DIALOG_BUTTONS[0]);
		dialogFrame.dispose();
	}

}
