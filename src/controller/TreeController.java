package controller;

import java.awt.Color;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import gui.MainFrame;
import model.Document;
import model.Page;
import model.Project;
import view.DocumentView;
import view.MiniPageView;
import view.PageView;
import view.ProjectView;

//Ako želimo da detektujemo kada se menja selektovani čvor u stablu potrebno je da se
//implementira TreeSelectionListener

public class TreeController implements TreeSelectionListener{
	
	public void valueChanged(TreeSelectionEvent e) {
		
		//Klasa TreePath predstavlja putanju do nekog čvora u stablu
		TreePath path = e.getPath();
		Object selectedComponent = path.getLastPathComponent();

		if (selectedComponent instanceof Project) {
			Project project = (Project) selectedComponent;
			focusProject(project);
			
			
		}else if (selectedComponent instanceof Document) {
			Document document = (Document) selectedComponent;
	//		ProjectView projectView = focusProject((Project)document.getParent());
			if(!(document.isShared())) {
			    ProjectView projectView = focusProject(document.getFirstParent());
				focusDocument(document, projectView);				
			}
	/*	    ProjectView projectView = focusProject(document.getParents().get(0));
			focusDocument(document, projectView);
	*/		
			else {
				Object[] objectsInPath = MainFrame.getInstance().getTree().getSelectionPath().getPath();
				Project parentFromPath = null;
				if(objectsInPath[1] instanceof Project)
					parentFromPath = (Project)objectsInPath[1];
				if(document.getParents().contains(parentFromPath)) {
				    ProjectView projectView = focusProject(parentFromPath);
					focusDocument(document, projectView);
				}
				else
					return;
			}
			
		}else if (selectedComponent instanceof Page) {
			Page page = (Page) selectedComponent;
			Document document = (Document) page.getParent();
/*			Project project = (Project) document.getParent();
		    ProjectView projectView = focusProject(document.getParents().get(0));
			DocumentView docView = focusDocument(document,projectView);
			
			focusProject(project);
			focusDocument(document, projectView);
			focusPage(page,docView);
*/          
			if(!(document.isShared())) {
			   Project project = (Project) document.getFirstParent();
			   ProjectView projectView = focusProject(project);
			   DocumentView docView = focusDocument(document,projectView);
				
			   focusProject(project);
			   focusDocument(document, projectView);
			   focusPage(page,docView);
			}
			else {
				Object[] objectsInPath = MainFrame.getInstance().getTree().getSelectionPath().getPath();
				Project parentFromPath = null; 
				
				if(objectsInPath[1] instanceof Project)
					parentFromPath = (Project)objectsInPath[1];
				if(document.getParents().contains(parentFromPath)) {					
				    ProjectView projectView = focusProject(parentFromPath);
				    DocumentView docView = focusDocument(document,projectView);
				    
				    focusProject(parentFromPath);
					focusDocument(document, projectView);
					focusPage(page,docView);
				}
				else
					return;			   
			}
		}
	}
	
	
	private ProjectView focusProject(Project project) {
		JInternalFrame[] projectViews = MainFrame.getInstance().getWorkspaceView().getAllFrames();
		for (JInternalFrame frame : projectViews) {
			Project p = ((ProjectView) frame).getProject();
			if (p.equals(project)) {
				try {
					((ProjectView) frame).setSelectedFromTree(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
				return (ProjectView) frame;
			}
		}
		
		return null;
	}
	
	private DocumentView focusDocument(Document document, ProjectView pv) {
		JTabbedPane tabPane = pv.getTabPane();
		int tabCount = tabPane.getTabCount();
		for (int i = 0; i < tabCount; i++) {
			DocumentView dv = (DocumentView) tabPane.getComponentAt(i);
			if (document.equals(dv.getDocument())) {
				tabPane.setSelectedComponent(dv);
				return dv;
			}
		} 
		return null;
	}
	
	private PageView focusPage(Page page, DocumentView dv) {
/*		for (PageView pv : dv.getDocumentPanel().getPageViews()) {
			if (pv.getPage().equals(page)) {
				pv.scrollRectToVisible(pv.getBounds());
				return pv;
			}
		}
		return null;
*/	
		ArrayList<MiniPageView> miniViews = dv.getMiniPanel().getMiniViews();
		for (MiniPageView mp : miniViews) {
			mp.setBackground(Color.WHITE);
		}
		
		Color c = Color.decode("#cce6ff");
		for (MiniPageView mp : miniViews) {
			if (mp.getPage().equals(page)) {
				mp.setBackground(c);
				mp.scrollRectToVisible(mp.getBounds());
			}
		}

		PageView view = null;

		for (PageView pv : dv.getDocumentPanel().getPageViews()) {
			pv.setVisible(true);
		}
 		
		for (PageView pv : dv.getDocumentPanel().getPageViews()) {
			if (pv.getPage().equals(page)) {
				pv.scrollRectToVisible(pv.getBounds());
				view = pv;
			}
			else
				pv.setVisible(false);
		}
		return view;	
	
	}
	

}
