package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTree;
import javax.swing.KeyStroke;

import clipboard.DocumentSelection;
import exception.ErrorHandler;
import exception.ShareDocumentException;
import gui.MainFrame;
import model.Document;

public class Export extends AbstractGeRuDok{

	
	public Export() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/export_icon.png"));
		putValue(NAME, "Export");
		putValue(SHORT_DESCRIPTION, "Share document");
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();

		try {
			whatIs(selectedComponent);
			
			Document document = (Document) selectedComponent;
			
			DocumentSelection contents = new DocumentSelection(document);
			MainFrame.getInstance().getClipboard().setContents(contents, MainFrame.getInstance());

			
		} catch (ShareDocumentException e1) {
			ErrorHandler.solve(e1);
		}
		
		System.out.println("You shared a document");

	}
	
	private void whatIs(Object o) throws ShareDocumentException {
		if(!(o instanceof Document))
			throw new ShareDocumentException();
	}


}
