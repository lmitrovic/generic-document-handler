package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.tree.TreePath;

import gui.MainFrame;
import model.Document;
import model.Page;
import model.Project;

import java.util.ArrayList;
import java.util.Observable;

public class MiniPageView extends JPanel {
	
	public static final int PAGE_HEIGHT = 50;
	public static final int PAGE_WIDTH = 50;
	
	String name = null;
	Page page;
	TitledBorder border;
	DocumentView documentView;
    
	public MiniPageView(Page page,DocumentView documentView) {
		
		this.documentView=documentView;
		this.page = page;
		this.name = page.getName();
		
		setPreferredSize(new Dimension(PAGE_WIDTH, PAGE_HEIGHT));
	    setBackground(Color.WHITE);
		this.border = BorderFactory.createTitledBorder(name);
        border.setTitleColor(Color.BLACK);
        setBorder(border);
        
        addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				ArrayList<MiniPageView> miniViews = documentView.getMiniPanel().getMiniViews();
				for(MiniPageView view : miniViews) view.setBackground(Color.WHITE);
				

				Document document = (Document) page.getParent();
		//		Project project = (Project) parent.getParent();
                if(!(document.isShared())) {
     			   Project project = (Project) document.getFirstParent();
    			   ProjectView projectView = focusProject(project);
    			   DocumentView docView = focusDocument(document,projectView);
    				
    			   focusProject(project);
    			   focusDocument(document, projectView);
    			   focusPage(page,docView);
    			   Color c = Color.decode("#cce6ff");
    			   for(MiniPageView view : miniViews) {
    				   if (view.getPage().equals(page)) view.setBackground(c);
    			   }
    			   
    			   JTree tree = MainFrame.getInstance().getTree();
    			   Object[] o = {MainFrame.getInstance().getTreeModel().getRoot(),((Document) page.getParent()).getFirstParent(),page.getParent(),page};
    			   TreePath path = new TreePath(o);
    			   tree.setSelectionPath(path);
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
    					Color c = Color.decode("#cce6ff");
    	    			   for(MiniPageView view : miniViews) {
    	    				   if (view.getPage().equals(page)) view.setBackground(c);
    	    			   }
    					
    	    			JTree tree = MainFrame.getInstance().getTree();
    	    			Object[] o = {MainFrame.getInstance().getTreeModel().getRoot(),parentFromPath,page.getParent(),page};
    	    			TreePath path = new TreePath(o);
    	    			tree.setSelectionPath(path);

    				}
    				else
    					return;
			     }
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
        
	}
	
	
	public Page getPage() {
		return page;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPage(Page page) {
		this.page = page;
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


	public void rename(Page page) {
		this.border = BorderFactory.createTitledBorder(page.getName());
		border.setTitleColor(Color.BLACK);
		setBorder(border);
	}
	

	public Border getBorder() {
		return this.border;
	}
}
