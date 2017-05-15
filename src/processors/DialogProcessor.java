package processors;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogProcessor {
	
	public void showErrorDialog(JFrame frame, String dialogTitle, String dialogMessage, Object[] dialogOptionButtons) {
		JOptionPane.showOptionDialog(frame, dialogMessage, dialogTitle, JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, dialogOptionButtons, dialogOptionButtons[0]);
		return;
	}

}
