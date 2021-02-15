package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTree;
import javax.swing.KeyStroke;

import exception.CloseDocumentException;
import exception.ErrorHandler;
import gui.MainFrame;
import model.Document;

public class CloseDocument extends AbstractGeRuDok {
	
	public CloseDocument() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/closedoc_icon.png"));
		putValue(NAME, "Close document");
		putValue(SHORT_DESCRIPTION, "Close document");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selected = tree.getLastSelectedPathComponent();
		
		try {
			whatIs(selected);
			
			if(selected instanceof Document) {
				((Document) selected).closeDocument();
			}

		} catch (CloseDocumentException e) {
			ErrorHandler.solve(e);
		}
				
	}
	
	private void whatIs(Object o) throws CloseDocumentException {
		if(!(o instanceof Document))
			throw new CloseDocumentException();
	}

}
