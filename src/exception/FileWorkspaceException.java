package exception;

import javax.swing.JOptionPane;

public class FileWorkspaceException extends Exception{
	
	public FileWorkspaceException() {
		
	}
	
	public void showMessage() {
		JOptionPane.showMessageDialog(null, "The file extension must be .ws");
	}


}
