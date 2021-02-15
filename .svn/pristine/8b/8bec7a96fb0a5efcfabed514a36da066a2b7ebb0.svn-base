	package gui;

import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;


public class MyToolbar extends JToolBar{

	public MyToolbar() {
		
		super(JToolBar.HORIZONTAL);
		setBackground(Color.WHITE);
		add(MainFrame.getInstance().getActionManager().getOpenWorkspaceAction());
		add(MainFrame.getInstance().getActionManager().getOpenProjectAction());
	
		addSeparator();

		add(MainFrame.getInstance().getActionManager().getImportAction());
		add(MainFrame.getInstance().getActionManager().getExportAction());
		
		addSeparator();
		//add(MainFrame.getInstance().getActionManager().getNewProjectAction());
		//add(MainFrame.getInstance().getActionManager().getNewDocumentAction());
		//add(MainFrame.getInstance().getActionManager().getNewPageAction());
		add(MainFrame.getInstance().getActionManager().getNewNodeAction());
		
		addSeparator();
				
		add(MainFrame.getInstance().getActionManager().getSaveProjectAction());
		add(MainFrame.getInstance().getActionManager().getSaveWsAction());

		
		addSeparator();	

		add(MainFrame.getInstance().getActionManager().getRenameNodeAction());
		add(MainFrame.getInstance().getActionManager().getDeleteNodeAction());
		
		addSeparator();

		add(MainFrame.getInstance().getActionManager().getCloseProjectAction());
		add(MainFrame.getInstance().getActionManager().getCloseDocumentAction());
		add(MainFrame.getInstance().getActionManager().getCloseAllDocumentAction());
		
		addSeparator();
		
		add(MainFrame.getInstance().getActionManager().getRecycleDocumentsAction());		
		
		addSeparator();
		
		add(MainFrame.getInstance().getActionManager().getUndoAction());
		add(MainFrame.getInstance().getActionManager().getRedoAction());
		
		addSeparator();
		
		add(MainFrame.getInstance().getActionManager().getCutAction());
		add(MainFrame.getInstance().getActionManager().getCopyAction());
		add(MainFrame.getInstance().getActionManager().getPasteAction());		

/*		
		add(new CascadeDocument());
		add(new TileHorizontallyDocument());
		add(new TileVerticallyDocument());
		
		addSeparator();
		
		add(new DocumentPrevius());
		add(new DocumentNext());
*/		

		//toolbar je pokretljiv
		setFloatable(false);
	}
	
}
