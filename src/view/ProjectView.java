package view;

import java.awt.Color;
import java.awt.datatransfer.Transferable;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import clipboard.DocumentSelection;
import commands.CommandManager;
import commands.PasteDocumentCommand;
import gui.MainFrame;
import model.Document;
import model.Page;
import model.Project;
import notification.NotificationType;

public class ProjectView extends JInternalFrame implements Observer{
	
	private Project project;
	private JTabbedPane tabPane;
	private CommandManager commandManager=new CommandManager();
	
	public ProjectView() {
		
		super("" ,
		          true, //resizable
		          true, //closable
		          true, //maximizable
		          true);//iconifiable
		
		setIconifiable(true);
		setClosable(false);
		
		this.tabPane = new JTabbedPane();
	    add(tabPane);
		setSize(725,462);
 	    setVisible(true);
	}
	
	public void setProject(Project project){
		this.project = project; 
		this.setName(project.getName());
		setTitle(project.getName());
	}

	public Project getProject() {
		return project;
	}

	public JTabbedPane getTabPane() {
		return tabPane;
	}

	public void setTabPane(JTabbedPane tabPane) {
		this.tabPane = tabPane;
	}
	
	public CommandManager getCommandManager() {
		return commandManager;
	}

	public void addDocumentView(DocumentView documentView) {
		tabPane.add(documentView);
	}
	
	public void setSelectedFromTree(boolean selected) throws PropertyVetoException {
		super.setSelected(selected);
	}
	public void removeDocumentView(DocumentView docView) {
		tabPane.remove(docView);
	}
	
	@Override
	public void update(Observable obs, Object object) {
		
		Document document = (Document) object;
		NotificationType type = document.getNotificationType();
		
		if(type == NotificationType.ADD_DOCUMENT) {
			project.setProjectModified(true);
			DocumentView dv = new DocumentView(document);
			addDocumentView(dv);
			document.addObserver(dv);
			
			validate();
			
			
			
			
		} else if (type == NotificationType.REMOVE_DOCUMENT) {
			project.setProjectModified(true);
			ArrayList<DocumentView> toRemove = new ArrayList<DocumentView>();
			
			int tabsSize = tabPane.getTabCount();
			
			for (int i = 0; i < tabsSize; i++) {
				DocumentView dv = (DocumentView) tabPane.getComponentAt(i);
				if (dv.getDocument().equals(document)) {
					toRemove.add(dv);
				}
			}
			for (DocumentView dv : toRemove)
				removeDocumentView(dv);

		}
		else if(type == NotificationType.RENAME_PROJECT) {
			project.setProjectModified(true);
			setTitle(project.getName());    //menjamo naslov JInternalFrame-a
		    validate();
		}
		else if(type == NotificationType.CLOSE_ALL) {
			//tabPane.setVisible(false);
			//tabPane.removeAll();
			project.setProjectModified(true);
			Project project = this.getProject();
			
			JTabbedPane tabPane = getTabs(project);
			int tabCount = tabPane.getTabCount();
			for (int i = 0; i < tabCount; i++) {
				DocumentView dv = (DocumentView) tabPane.getComponentAt(0);
				MainFrame.getInstance().getDeleteDocView().add(dv);
				tabPane.remove(0);				
			}
			validate();
		}
		
		else if(type == NotificationType.CLOSE_PROJECT) {
			    project.setProjectModified(true);
				MainFrame.getInstance().getCloseProject().add(this);
				this.setVisible(false);
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
	
	public void paste(Project project) {
		Transferable clipboardContent = MainFrame.getInstance().getClipboard().getContents(MainFrame.getInstance());
		
		if((clipboardContent != null )&&(clipboardContent.isDataFlavorSupported(DocumentSelection.elementFlavor))) {
			try {
				Document document = new Document(project);
				Document docToCopy = (Document) clipboardContent.getTransferData(DocumentSelection.elementFlavor);

				if(docToCopy != null) {
					document = docToCopy.clone(project);					
					//project.addDocument(document);
					this.commandManager.addCommand(new PasteDocumentCommand(project,docToCopy,document));
					/*for(int i=0; i<docToCopy.getPageCount(); i++) {
						document.addPage(docToCopy.getPage(i).clone(document));
					}*/
				}
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void share(Project project) {
		Transferable clipboardContent = MainFrame.getInstance().getClipboard().getContents(MainFrame.getInstance());
		
		if((clipboardContent != null )&&(clipboardContent.isDataFlavorSupported(DocumentSelection.elementFlavor))) {
			try {
				Document document = new Document(project);
				Document docToShare = (Document) clipboardContent.getTransferData(DocumentSelection.elementFlavor);
				
				document = docToShare;
				
				document.addObserver(project);
				document.addParent(project);
				
				document.setShared(true);      //dokument je serovan
				
				project.addDocument(document);

				List<Page> duplicatePages = new ArrayList<Page>();
				for(Page p : document.getPages())
					duplicatePages.add(p);
				
				for(Page p : duplicatePages)
					document.deletePage(p);
				
				for(Page p : duplicatePages)
					document.addPage(p);
				
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
