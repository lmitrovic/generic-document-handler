package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.AbstractAction;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;


import factory.DocumentF;

import factory.NodeF;
import factory.PageF;

import factory.ProjectF;
import gui.MainFrame;
import model.Document;
import model.Project;
import model.Workspace;
import view.ProjectView;
import view.WorkspaceView;



public class NewProject extends AbstractGeRuDok {
	
	public NewProject() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/new_project.png"));
		putValue(NAME, "New project");
		putValue(SHORT_DESCRIPTION, "New project");
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = MainFrame.getInstance().getTree();
	    TreePath path = tree.getSelectionPath();
	    tree.expandPath(path);
	    
	    Project p = new Project("");
	 
	    ( (Workspace) tree.getModel().getRoot()).addObserver(MainFrame.getInstance().getWorkspaceView());
	  
	    ( (Workspace) tree.getModel().getRoot()).addProject(p);
	    SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	  
	}
  

}
