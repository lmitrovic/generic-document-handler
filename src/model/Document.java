package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;

import javax.swing.tree.TreeNode;

import notification.NotificationType;

public class Document extends Node{
	
	private String name;
	private ArrayList<Page> pages;
	private NotificationType type;
//	private Project parent = null;
	private File documentFile = null;
	
	private ArrayList<Project> parents = new ArrayList<Project>();
	private boolean shared;
    private Project firstParent;
	
	public Document(Node node) {
//*		this.parent = (Project)node;
		//setParent(parent);
	
		parents.add((Project)node);
		this.shared = false;      //prilikom prvog instanciranja doc nije shared
		this.firstParent = (Project)node;
		
//*		this.name = parent.getName();
        this.name = ((Project) node).getName(); 
		pages = new ArrayList<Page>();
	}

	public Document(Project parent, Document document) {
//*		this.parent = parent;
		this.parents.add(parent);
		this.firstParent = parent;
		this.shared = document.isShared();
		
		this.name = document.getName();

		pages = new ArrayList<Page>();
		
	}
	
	public Project getFirstParent() {
		return firstParent;
	}

	public boolean isShared() {
		return shared;
	}
	
	public void setShared(boolean shared) {
		this.shared = shared;
	}
	
	public void addParent(Project p) {
		this.parents.add(p);
	}
	
	public ArrayList<Project> getParents() {
		return parents;
	}
	
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		Page page = new Page(this);
		page.setNotificationType(NotificationType.RENAME_DOCUMENT);
		notifyObservers(page);
	}
	
	public void addPage(Page p) {
		pages.add(p);
		
		if (p.getName() == null)
			p.setName("Page " + pages.size());
		p.setNotificationType(NotificationType.ADD_PAGE);
		notifyObservers(p);
	}
	
	public void deletePage(Page page) {
		pages.remove(page);
		page.setNotificationType(NotificationType.REMOVE_PAGE);
		notifyObservers(page);
	}
	
	public void closeDocument() {
		Page page = new Page(this);
		page.setNotificationType(NotificationType.CLOSE_DOCUMENT);
		notifyObservers(page);
	}
	
	@Override
	public void notifyObservers(Object arg) {
	    setChanged();
		super.notifyObservers(arg);
	}
/*	
	public void setParent(TreeNode parent) {
		this.parent = (Project) parent;
	}
*/	
	public ArrayList<Page> getPages() {
		return pages;
	}
	
	public int getPageIndex(Page p) {
		return pages.indexOf(p);
	}
	
	public int getPageCount() {
		return pages.size();
	}
	
	public Page getPage(int index) {
		return pages.get(index);
	}
	
	@Override
	public Enumeration<Page> children() {
		return (Enumeration<Page>) pages;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return getPage(childIndex);
	}

	@Override
	public int getChildCount() {
		return pages.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return getPageIndex((Page) node);
	}

	@Override
	public TreeNode getParent() {
		return this.firstParent;
	}

	@Override
	public boolean isLeaf() {
		return pages.size()==0;
	}
	
	public void setNotificationType(NotificationType type) {
		this.type = type;
	}
	
	public NotificationType getNotificationType() {
		return this.type;
	}

	@Override
	public void update(Observable arg0, Object arg1) {		
		setChanged();
		notifyObservers();
//		((Project)this.getParent()).setProjectModified(true);
	    this.getParents().get(0).setProjectModified(true);
	}

	public File getDocumentFile() {
		return documentFile;
	}

	public void setDocumentFile(File documentFile) {
		this.documentFile = documentFile;
	}

	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}
/*
	public void setParent(Project parent) {
		this.parent = parent;
	}
*/
	@Override
	public void addChild(Node node) {
		Page p = (Page) node;
        pages.add(p);
		
		if (p.getName() == null)
			p.setName("Page " + pages.size());
		p.setNotificationType(NotificationType.ADD_PAGE);
		notifyObservers(p);
		
	}
	
	public Document clone(Project parent) {
		return new Document(parent, this);
	}


}
