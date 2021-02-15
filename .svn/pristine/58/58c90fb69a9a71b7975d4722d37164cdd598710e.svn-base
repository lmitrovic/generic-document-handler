package model;

import javax.swing.tree.DefaultTreeModel;

import gui.MainFrame;

//Interfejs TreeModel definiše pozadinsku strukturu podataka za JTree

public class WorkspaceModel extends DefaultTreeModel{

	public WorkspaceModel() {
		super(new Workspace());  //root je Workspace
	}
	
	public void addProject(Project project){
		((Workspace)getRoot()).addProject(project);
	}

	
	public boolean isLeaf(Object node) {
		return (node instanceof Page);
	}
	
	public Object getChild(Object parent,int index) {
		if(parent instanceof Page)
			return null;
		
		else if(parent instanceof Document)
			return ((Document)parent).getPage(index);
		
		else if(parent instanceof Project) 
			return ((Project)parent).getDocument(index);
		
		else if(parent instanceof Workspace)
			return ((Workspace)parent).getProject(index);
		
		return root;
	}
	
}
