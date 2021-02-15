package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import gui.MainFrame;
import model.Document;
import model.Page;
import model.Project;
import notification.NotificationType;

public class DocumentView extends JScrollPane implements Observer{
	
	private Document document;
	private DocumentPanel panel;
	private JLabel label;
	private String name;
	private DocumentMiniPanel miniPanel;
	private JPanel view;
	int rows = 0;
	
	public DocumentView(Document document) {
		this.document = document;
		
        this.name = document.getName();
        this.panel = new DocumentPanel();
        this.view = new JPanel(new BorderLayout());
        
        this.miniPanel = new DocumentMiniPanel();
        miniPanel.setLayout(new GridLayout(rows,1));
		miniPanel.setBackground(Color.LIGHT_GRAY);
		rows++;
		this.label = new JLabel("Pages of doc");
		label.setBackground(Color.DARK_GRAY);
	    miniPanel.add(label);
	    
		JScrollPane scrollPane = new JScrollPane(miniPanel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(100,100));
		view.add(scrollPane,BorderLayout.WEST);
		view.add(panel,BorderLayout.CENTER);
		setViewportView(this.view);
	}

	public Document getDocument() {
		return document;
	}
	
	public DocumentPanel getDocumentPanel() {
		return this.panel;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public DocumentPanel getPanel() {
		return panel;
	}

	public void setPanel(DocumentPanel panel) {
		this.panel = panel;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public void addPageView(PageView view) {
		panel.getPageViews().add(view);
		panel.add(view);
		panel.validate();
	}
	public void removePageView(PageView view) {
		panel.getPageViews().remove(view);
		panel.remove(view);
		panel.validate();
	}
	
	public void addMiniPageView(MiniPageView mini) {
		miniPanel.getMiniViews().add(mini);
		miniPanel.add(mini);
		miniPanel.validate();
	}
	
	public void removeMiniPageView(MiniPageView mini) {
		miniPanel.getMiniViews().remove(mini);
		miniPanel.remove(mini);
		miniPanel.validate();
	}

	@Override
	public void update(Observable arg0, Object arg) {
		if (arg == null) return;
		Page page = (Page) arg;
		NotificationType type = page.getNotificationType();
		
		if (type == NotificationType.ADD_PAGE) {
			PageView pageView = new PageView(page);
			addPageView(pageView);
			pageView.setVisible(false);
			page.addObserver(pageView);
			
			//dodavanje i odgovarajuceg miniPageView-a
			MiniPageView miniView = new MiniPageView(page,this);
            addMiniPageView(miniView);
			
			validate();
		}else if (type == NotificationType.REMOVE_PAGE) {
			
			ArrayList<PageView> pageViews = this.panel.getPageViews();
			ArrayList<PageView> toRemove = new ArrayList<PageView>();
			
			for (PageView view : pageViews) {
				if(view.getPage().equals(page))
					toRemove.add(view);
			}
			
			for(PageView view : toRemove){
				removePageView(view);
			}
			
			//brisanje miniPageView-a 
			ArrayList<MiniPageView> miniViews = this.miniPanel.getMiniViews();
			ArrayList<MiniPageView> remove = new ArrayList<MiniPageView>();
			
			for(MiniPageView view : miniViews) {
				if(view.getPage().equals(page))
					remove.add(view);
			}
			
			for(MiniPageView view : remove) {
				removeMiniPageView(view);
			}
			validate();
			
		}
		else if(type == NotificationType.RENAME_DOCUMENT) {
			setName(document.getName());
			JTabbedPane tabbedPane = (JTabbedPane) this.getParent();
			tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), document.getName()); //azuriramo ime i u tabu
			validate();
		}
		else if(type == NotificationType.CLOSE_DOCUMENT) {
			Project project = (Project) document.getParent();
			JTabbedPane tabPane = getTabs(project);
			int numberOfTabs = tabPane.getTabCount();
			
			for(int i=0; i<numberOfTabs; i++) {
				if(tabPane.getComponentAt(i).equals(this)) {
					MainFrame.getInstance().getDeleteDocView().add(this);
					tabPane.remove(i);
					break;
				}
			}
			validate();
			
			
		}
		
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	}
	
	private JTabbedPane getTabs(Project project) {
	    JInternalFrame[] frames = MainFrame.getInstance().getWorkspaceView().getAllFrames();
	    JTabbedPane tabPane = null;
	    
	    for(JInternalFrame frame : frames) {
	    	Project p = ((ProjectView) frame).getProject();
	    	if(p.equals(project))
	    		tabPane = ((ProjectView) frame).getTabPane();
	    }
	    	
	    return tabPane; 	
	}

	public DocumentMiniPanel getMiniPanel() {
		return miniPanel;
	}
	
	public void renameMiniView(Page page) {
		if(!(((Document) page.getParent()).isShared())) {
			for(MiniPageView view : miniPanel.getMiniViews()) {
				Page p = view.getPage();
				if(p.getModel().equals(page.getModel()) && p.getParent().equals(page.getParent()))
					view.rename(page);
			}			
		}
		//ukoliko je document view shared moramo proci kroz sve njegove document view
		else {
			List<DocumentView> docViews = getDocumentViews((Document) page.getParent());
			for(DocumentView view : docViews) {
				for(MiniPageView mini : view.getMiniPanel().getMiniViews()) {
					Page p = mini.getPage();
					if(p.getModel().equals(page.getModel()) && p.getParent().equals(page.getParent()))
						mini.rename(page);	
				}
			}
		}
	
	}
	
	
	private List<DocumentView> getDocumentViews(Document document) {
		List<DocumentView> docViews = new ArrayList<DocumentView>();
		
		List<Project> projects = document.getParents();
		List<ProjectView> projViews = new ArrayList<ProjectView>();
		
		for(Project p : projects) {
			projViews.add(getProjectView(p));
		}
		
		int n = document.getParents().size();
		for(int i=0; i<n; i++) 
            docViews.add(getDocumentView(document,projViews.get(i)));		   
		
		return docViews;
	}
	
	private ProjectView getProjectView(Project project) {
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
	
	private DocumentView getDocumentView(Document document, ProjectView pv) {
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
	
}
