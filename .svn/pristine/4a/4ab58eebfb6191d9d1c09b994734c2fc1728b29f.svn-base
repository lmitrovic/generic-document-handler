package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreeModel;

import exception.ErrorHandler;
import exception.FileProjectException;
import exception.FileWorkspaceException;
import gui.MainFrame;
import model.Project;
import model.Workspace;
import model.WorkspaceModel;
import view.DocumentView;
import view.MiniPageView;
import view.PageView;
import view.ProjectView;
import view.WorkspaceView;

public class OpenWorkspace extends AbstractGeRuDok {
	
	public OpenWorkspace() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/switch_icon.png"));
		putValue(NAME, "Switch workspace");
		putValue(SHORT_DESCRIPTION, "Switch workspace");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = MainFrame.getInstance().getTree();
		Workspace workspace = (Workspace) tree.getModel().getRoot();
		
		JFileChooser jfc = new JFileChooser();
		File fileToSave=null;
		
		if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
			try {
				isValid(jfc.getSelectedFile());
				ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				  
				Workspace w=null;
				try {
					w = (Workspace) os.readObject();
					fileToSave = jfc.getSelectedFile();
					File workspaceFolder = new File(fileToSave.getAbsolutePath());
					workspaceFolder.mkdir(); //kreira se direktorijum sa imenom putanje
					File workspaceFile = new File(workspaceFolder+"");
					w.setWorkspaceFile(workspaceFile);
					for(Project p : workspace.getProjects()) {
						p.closeProject();
					}
					
					workspace.getProjects().removeAll(workspace.getProjects());
					TreeModel treeModel = new WorkspaceModel();
					tree.setModel(treeModel);
					
					workspace = (Workspace) tree.getModel().getRoot();
					workspace.setWorkspaceFile(workspaceFile);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				 
			     for(int i=0; i<w.countProjects(); i++) {				    
			    	 ProjectView pv = new ProjectView();
			    	 pv.setProject(w.getProject(i));
					 MainFrame.getInstance().getWorkspaceView().add(pv);
			    	 pv.setVisible(true);
			    	 w.getProject(i).addObserver(pv);
			    	 Project p = w.getProject(i); 
			    	 ((Workspace) tree.getModel().getRoot()).addProject(p);
			 	    SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());

				    
					 for (int k=0;k<p.getDocumentCount();k++){

						  DocumentView view=new DocumentView(p.getDocument(k));
					      pv.addDocumentView(view);
					      p.getDocument(k).addObserver(view);
						    
					     for (int j=0;j<p.getDocument(k).getPageCount();j++) {
					    	PageView pageView = new PageView(p.getDocument(k).getPage(j));
					    	MiniPageView miniView = new MiniPageView(p.getDocument(i).getPage(j),view);
					    	view.addPageView(pageView);
					    	pageView.setVisible(false);
					    	view.addMiniPageView(miniView);
					    	p.getDocument(k).getPage(j).addObserver(pageView);
					    }

						    
					}
					 
			     }
				    ((Workspace) tree.getModel().getRoot()).addObserver(MainFrame.getInstance().getWorkspaceView());

					
					  
			} catch (FileWorkspaceException e1) {
				ErrorHandler.solve(e1);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 


		}
		
	}
	
	private void isValid(File selectedFile) throws FileWorkspaceException{
		if(!(selectedFile.getName().endsWith(".ws"))) 
			throw new FileWorkspaceException();
	}

	
	
}	
	


