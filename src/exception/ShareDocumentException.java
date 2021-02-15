package exception;

import javax.swing.JOptionPane;

public class ShareDocumentException extends Exception{
	
	
	public ShareDocumentException() {
		
	}
	
	public void showMessage() {
		JOptionPane.showMessageDialog(null, "To share document you must select a document");
	}


}
