package processors;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogProcessor {
	
	private String errorDialogTitle = "Error";
	private String informationDialogTitle = "Information";
	private String warningDialogTitle = "Warning";
	
	private JFrame dialogFrame = new JFrame();
	private Object[] errorDialogButtons = {"Ok"};
	private Object[] informationDialogButtons = {"Ok"};
	private Object[] warningDialogButtons = {"Yes", "No"};
	
	public void showErrorDialog(String dialogMessage) {
		JOptionPane.showOptionDialog(dialogFrame, dialogMessage, errorDialogTitle, JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, errorDialogButtons, errorDialogButtons[0]);
		dialogFrame.dispose();
	}
	
	public void showInformationDialog(String dialogMessage) {
		JOptionPane.showOptionDialog(dialogFrame, dialogMessage, informationDialogTitle, JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, informationDialogButtons, informationDialogButtons[0]);
		dialogFrame.dispose();
	}
	
	public boolean showWarningDialog(String dialogMessage) {
		int choice = JOptionPane.showOptionDialog(dialogFrame, dialogMessage, warningDialogTitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, warningDialogButtons, warningDialogButtons[0]);
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

}
