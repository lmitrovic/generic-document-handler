package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;

import javax.swing.tree.TreeNode;

import exception.ErrorHandler;
import exception.WrongNameException;
import notification.NotificationType;

public class Project extends Node{

	private Workspace parent = null;
	private NotificationType type;
	private ArrayList<Document> documents;
	private String name;
	private boolean projectModified;
	private File projectFile = null;
	
	
	public Project(String name) {
		this.documents = new ArrayList<Document>();
		this.name = name;
		this.addObserver(this);
	}
	
	public ArrayList<Document> getDocuments() {
		return documents;
	}
	
	public String toString() {
		return name;
	}
	
	public boolean isProjectModified() {
		return projectModified;
	}

	public void setProjectModified(boolean projectModified) {
		this.projectModified = projectModified;
	}

	public File getProjectFile() {
		return projectFile;
	}

	public void setProjectFile(File projectFile) {
		this.projectFile = projectFile;
	}

	@Override
	public Enumeration<Document> children() {
		return (Enumeration<Document>) documents;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return getDocument(childIndex);
	}

	@Override
	public int getChildCount() {
		return getDocumentCount();
	}

	@Override
	public int getIndex(TreeNode node) {
		return getDocumentIndex((Document) node);
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}
	
	public void setParent(Workspace parent) {
		this.parent = parent;
	}

	@Override
	public boolean isLeaf() {
		return documents.size()==0;
	}
	public void setName(String name) throws WrongNameException{
		if (name.equals("") || name.equals(" ") || name.equals("RECYCLE BIN")|| name.equals("recycle bin")) throw new WrongNameException();
		this.name=name;
		Document d = new Document(this);
		d.setNotificationType(NotificationType.RENAME_PROJECT);
		notifyObservers(d);
	}
	
	public void addDocument(Document d) {
		documents.add(d);
		if (d.getName()==null) d.setName(this.name + "-Document "+ String.valueOf(documents.size()));
		d.setNotificationType(NotificationType.ADD_DOCUMENT);
		notifyObservers(d);
		
	}
	
	public void deleteDocument(Document document) {
		if(!(document.isShared()))
		     documents.remove(document);
		else {
			for(Project p : document.getParents())
				p.deleteDoc(document);
		}
		
        document.setNotificationType(NotificationType.REMOVE_DOCUMENT);
		notifyObservers(document);
	}
	
    private void deleteDoc(Document document) {
    	documents.remove(document);
        document.setNotificationType(NotificationType.REMOVE_DOCUMENT);
		notifyObservers(document);
    }
	
	public void closeAll() {
		Document d = new Document(this);
		d.setNotificationType(NotificationType.CLOSE_ALL);
		notifyObservers(d);
	}
	
	public void closeProject() {
		Document d = new Document(this);
		d.setNotificationType(NotificationType.CLOSE_PROJECT);
		notifyObservers(d);
	}
	
	public int getDocumentCount() {
		return documents.size();
	}

	public Document getDocument(int index) {
		return documents.get(index);
	}
	
	public int getDocumentIndex(Document d) {
		return documents.indexOf(d);
	}
	
	public String getName() {
		return name;
	}
	
	public void setNotificationType(NotificationType type) {
		this.type = type;
	}
	
	public NotificationType getNotificationType() {
		return this.type;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(!projectModified) {
			this.setProjectModified(true);
		}
	}
	
	@Override
	public void notifyObservers(Object arg) {
		setChanged();
		super.notifyObservers(arg);
	}

	@Override
	public void addChild(Node node) {
		if (this.getName()!="RECYCLE BIN") {
		Document d = (Document)node;
		documents.add(d);
		d.setName(this.name + "-Document "+ String.valueOf(documents.size()));
		d.setNotificationType(NotificationType.ADD_DOCUMENT);
		notifyObservers(d);
		}
	}
}
