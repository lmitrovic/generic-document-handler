package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.tree.TreePath;

import exception.CloseProjectException;
import exception.ErrorHandler;
import gui.MainFrame;
import model.Document;
import model.Project;

public class CloseAllDocument extends AbstractGeRuDok{
	
	public CloseAllDocument() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/closealldoc_icon.png"));
		putValue(NAME, "Close all documents");
		putValue(SHORT_DESCRIPTION, "Close all documents");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selected = tree.getLastSelectedPathComponent();
//		TreePath path = tree.getSelectionPath();
		
		try {
			whatIs(selected);
			
			if(selected instanceof Project) {
				((Project) selected).closeAll();;
			}

		} catch (CloseProjectException e1) {
			ErrorHandler.solve(e1);
		}		
		
	}
	
	private void whatIs(Object o) throws CloseProjectException {
		if(!(o instanceof Project))
			throw new CloseProjectException();
	}

}
