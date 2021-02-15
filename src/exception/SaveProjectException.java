package exception;

import javax.swing.JOptionPane;

public class SaveProjectException extends Exception {
	
	public SaveProjectException() {
		
	}
	
	public void showMessage() {
		JOptionPane.showMessageDialog(null,"You must select a project." );
	}

}
