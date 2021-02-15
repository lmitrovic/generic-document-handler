package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTree;
import javax.swing.KeyStroke;

import clipboard.DocumentSelection;
import exception.ErrorHandler;
import exception.ImportDocumentException;
import exception.ShareDocumentException;
import gui.MainFrame;
import model.Document;
import model.Project;
import view.ProjectView;

public class Import extends AbstractGeRuDok{
	
	
	public Import() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/import_icon.png"));
		putValue(NAME, "Import");
		putValue(SHORT_DESCRIPTION, "Import document");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();

		try {
			whatIs(selectedComponent);
			
			ProjectView projView = (ProjectView) MainFrame.getInstance().getWorkspaceView().getSelectedFrame(); 
			
			if(projView != null) 
				projView.share((Project)selectedComponent);
			
			
		} catch (ImportDocumentException e1) {
			ErrorHandler.solve(e1);
		}

		
	}

	private void whatIs(Object o) throws ImportDocumentException {
		if(!(o instanceof Project))
			throw new ImportDocumentException();
	}

	

}
