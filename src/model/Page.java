package model;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;

import javax.swing.tree.TreeNode;

import notification.NotificationType;

public class Page extends Node{

	private String name;
	private Document parent;
	private NotificationType type;
	private PageModel model;
	
	public Page(Node node) {
		this.model = new PageModel();
		model.setPage(this);
		this.parent = (Document)node;
		addObserver(parent);
	}
	
	public Page(Document parent, Page page) {
		this.model = page.getModel().clone(page.getModel(),page);
		model.setPage(this);
		this.parent = parent;
		addObserver(this.parent);
		this.name = page.getName();
	}

	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public Enumeration<? extends TreeNode> children() {
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		return false;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return null;
	}

	@Override
	public int getChildCount() {
		return 0;
	}

	@Override
	public int getIndex(TreeNode node) {
		return -1;
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public boolean isLeaf() {
		return true;
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

	public void setName(String name) {
		this.name = name;
		this.setNotificationType(NotificationType.RENAME_PAGE);
		notifyObservers(this);
	}



	@Override
	public void update(Observable arg0, Object arg1) {
		// proesledjuje obavestenje o promeni
		notifyObservers();
		
	}
	
	@Override
	public void notifyObservers(Object arg) {
		setChanged();
		super.notifyObservers(arg);
	}
	
	public PageModel getModel() {
		return model;
	}
	
	public void setModel(PageModel model) {
		this.model = model;
	}

	@Override
	public void addChild(Node node) {
		// TODO Auto-generated method stub
		
	}
	
	public Page clone(Document parent) {
		return new Page(parent,this);
	}

}
