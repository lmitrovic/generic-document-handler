package exception;

import javax.swing.JOptionPane;

public class SaveWorkspaceException extends Exception{
	
	public SaveWorkspaceException() {
		
	}
	
	public void showMessage() {
		JOptionPane.showMessageDialog(null, "You must select a workspace");
	}

}
