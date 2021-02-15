package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import exception.ErrorHandler;
import exception.RenameWorkspaceException;
import exception.WrongNameException;
import gui.MainFrame;
import notification.NotificationType;

public class Workspace extends Node{

	private ArrayList<Project> projects = new ArrayList<Project>();
	private File workspaceFile = null;
	private String name;
	
	public Workspace() {
		super();
	}
	
	public String toString() {
		return "Workspace";
	}
	
	public void setName(String name) throws RenameWorkspaceException {
		if (!(name.equals("Workspace"))) throw new RenameWorkspaceException();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public Enumeration<Project> children() {
		return (Enumeration<Project>) projects;
	}
	public void setWorkspaceFile(File workspaceFile) {
		this.workspaceFile = workspaceFile;
	}
	public File getWorkspaceFile() {
		return workspaceFile;
	}
	

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		return getProject(arg0);
	}

	@Override
	public int getChildCount() {
		return countProjects();
	}

	@Override
	public int getIndex(TreeNode arg0) {
		return getProjectIndex((Project) arg0);
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	public void addProject(Project p) {
		projects.add(p);
		p.setParent(this);
		if (p.getName().equals("") || p.getName().equals(" "))
			try {
				p.setName("Project "+ String.valueOf(projects.size()));
			} catch (WrongNameException e) {
				e.showMessage();
			}
		p.setNotificationType(NotificationType.ADD_PROJECT);
		notifyObservers(p);
		
	}
	
	public void deleteProject(Project project) {
		projects.remove(project);
        project.setNotificationType(NotificationType.REMOVE_PROJECT);
		notifyObservers(project);
	}
	
	@Override
	public void notifyObservers(Object arg) {
	    setChanged();
		super.notifyObservers(arg);
	}
	
	public int getProjectIndex(Project p) {
		return projects.indexOf(p);
	}
	
	public Project getProject(int index) {
		return projects.get(index);
	}
	
	public int countProjects() {
		return projects.size();
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	@Override
	public void addChild(Node node) {
		Project p = (Project) node;
		projects.add(p);
		p.setParent(this);
		if (p.getName().equals("") || p.getName().equals(" "))
			try {
				p.setName("Project "+ String.valueOf(projects.size()-1));
			} catch (WrongNameException e) {
				ErrorHandler.solve(e);
			}
		p.setNotificationType(NotificationType.ADD_PROJECT);
		notifyObservers(p);
		
	}
	
	
	
}
