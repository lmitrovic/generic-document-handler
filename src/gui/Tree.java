package gui;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeCellRenderer;


import controller.TreeController;
import model.Project;
import model.WorkspaceModel;
import view.TreeRenderer;
import view.TreeEditor;



public class Tree extends JTree {
	
public Tree() {
		
		addTreeSelectionListener(new TreeController());
	    setCellEditor(new TreeEditor(this,new DefaultTreeCellRenderer()));
	    setCellRenderer(new TreeRenderer());
	    setEditable(true);
	    setComponentPopupMenu(new MyPopupMenu());  //setovanje Popup menija
	}
	
	// Metoda za dodavanje novog projekta u workspace 
	
	public void addProject(Project project){
		((WorkspaceModel)getModel()).addProject(project);
		SwingUtilities.updateComponentTreeUI(this);
	}

}
