package exception;

import javax.swing.JOptionPane;

public class RenameWorkspaceException extends Exception{
	
	public RenameWorkspaceException() {
		
	}
	
	public void showMessage() {
		JOptionPane.showMessageDialog(null, "You can't rename a Workspace.");
	}

}
