package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.tree.TreePath;


import gui.MainFrame;
import model.Document;
import model.Page;


public class NewPage extends AbstractGeRuDok {
	
	public NewPage() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/new_page.png"));
		putValue(NAME, "New page");
		putValue(SHORT_DESCRIPTION, "New page");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();
		TreePath path = tree.getSelectionPath();
		if (selectedComponent instanceof Document) {
			tree.expandPath(path);
			Document document = (Document) selectedComponent;
			Page page = new Page(document);
			document.addPage(page);
		}
		
	}
	
	

}
