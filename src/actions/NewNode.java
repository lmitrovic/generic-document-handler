package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import factory.DocumentF;
import factory.NodeF;
import factory.PageF;
import factory.ProjectF;
import factory.Utils;
import gui.MainFrame;
import model.Document;
import model.Node;
import model.Page;
import model.Project;
import model.Workspace;

public class NewNode extends AbstractGeRuDok{
	
	public NewNode() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/new_project.png"));
		putValue(NAME, "New node");
		putValue(SHORT_DESCRIPTION, "New node");
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = MainFrame.getInstance().getTree();
	    TreePath path = tree.getSelectionPath();
	    tree.expandPath(path);
	    Node selectedComponent=null;
	    if (path!=null)
		   selectedComponent = (Node) path.getLastPathComponent();
	    else
		   selectedComponent = (Node) tree.getModel().getRoot();
		if (!(selectedComponent instanceof Page)) {
		    NodeF node = Utils.returnNode(selectedComponent);
		    Node n = node.orderNode(selectedComponent);
		}	    
	    SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	}


}
