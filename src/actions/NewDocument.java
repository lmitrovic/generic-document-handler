package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import gui.MainFrame;
import model.Document;
import model.Project;
import view.DocumentView;

public class NewDocument extends AbstractGeRuDok{
	
	public NewDocument() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/new_document.png"));
		putValue(NAME, "New document");
		putValue(SHORT_DESCRIPTION, "New document");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = MainFrame.getInstance().getTree();
		
		Object selectedComponent = tree.getLastSelectedPathComponent();
		TreePath path = tree.getSelectionPath();
		if(selectedComponent instanceof Project) {
			tree.expandPath(path);
			Project project = (Project) selectedComponent;
			Document doc = new Document(project);
			project.addDocument(doc);
		}
		
		
	}
}
	
	


