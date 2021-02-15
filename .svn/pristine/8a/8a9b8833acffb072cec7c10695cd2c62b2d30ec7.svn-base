package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import actions.CascadeDocument;
import actions.CloseAllDocument;
import actions.CloseDocument;
import actions.CloseProject;
import actions.DocumentNext;
import actions.DocumentPrevius;
import actions.NewDocument;
import actions.NewPage;
import actions.NewProject;
import actions.OpenProject;
import actions.OpenWorkspace;
import actions.RenameNode;
import actions.SaveDocument;
import actions.SaveProject;
import actions.SaveAsWorkspace;
import actions.TileHorizontallyDocument;
import actions.TileVerticallyDocument;


public class MyMenu extends JMenuBar {
	
	   MyMenu(MainFrame parent){
		   
		    JMenu file=new JMenu("File");
		    file.setMnemonic(KeyEvent.VK_F);
		    
	//	    file.add(new OpenWorkspace());
		    file.add(MainFrame.getInstance().getActionManager().getOpenProjectAction());
		    file.add(MainFrame.getInstance().getActionManager().getOpenWorkspaceAction());		    
		    file.add(MainFrame.getInstance().getActionManager().getSaveProjectAction());
		    
		    file.addSeparator();
		    
		    file.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
		    file.add(MainFrame.getInstance().getActionManager().getNewDocumentAction());
		    file.add(MainFrame.getInstance().getActionManager().getNewPageAction());
		    
		    file.addSeparator();
		    
		    file.add(MainFrame.getInstance().getActionManager().getRenameNodeAction());
		    
	//	    file.addSeparator();
		    
	//	    file.add(new SaveDocument());
	//	    file.add(new SaveProject());
	//	    file.add(new SaveWorkspace());
		    
		    file.addSeparator();
		    
		    file.add(MainFrame.getInstance().getActionManager().getCloseDocumentAction());
		    file.add(MainFrame.getInstance().getActionManager().getCloseAllDocumentAction());
		    file.add(MainFrame.getInstance().getActionManager().getCloseProjectAction());
	
		    file.addSeparator();
		    
		    file.add(MainFrame.getInstance().getActionManager().getImportAction());
		    file.add(MainFrame.getInstance().getActionManager().getExportAction());
		    
		    file.addSeparator();
		    
		    file.add(MainFrame.getInstance().getActionManager().getRecycleDocumentsAction());		   
		    
		    JMenu edit = new JMenu("Edit");
		    
		    edit.add(MainFrame.getInstance().getActionManager().getUndoAction());
		    edit.add(MainFrame.getInstance().getActionManager().getRedoAction());

		    edit.addSeparator();
		    
		    edit.add(MainFrame.getInstance().getActionManager().getCutAction());
		    edit.add(MainFrame.getInstance().getActionManager().getCopyAction());
		    edit.add(MainFrame.getInstance().getActionManager().getPasteAction());

			JMenu window = new JMenu("Window");
			
			window.add(new CascadeDocument());
			window.add(new TileHorizontallyDocument());
			window.add(new TileVerticallyDocument());
			
			window.addSeparator();
			
			window.add(new DocumentPrevius());
			window.add(new DocumentNext());
			
			JMenu help=new JMenu("Help");
			
			JMenuItem about = new JMenuItem("About");
			help.add(about);
			about.addActionListener(new ActionListener() {
		
				//akcija otvaranja aboutDialog-a
				@Override
				public void actionPerformed(ActionEvent e) {
				       
					AboutDialog dialog = new AboutDialog(parent,"About team",true);
					dialog.setVisible(true);
				}
			});
			
			add(file);
			add(edit);
			add(window);
			add(help);
	   }
	

}
