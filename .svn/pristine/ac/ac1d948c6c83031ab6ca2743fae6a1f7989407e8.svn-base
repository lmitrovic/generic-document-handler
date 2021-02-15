package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import exception.DeleteWorkspaceException;
import exception.ErrorHandler;
import gui.MainFrame;
import gui_delete.AddToProjDialog;
import gui_delete.DeleteDialog;
import model.Document;
import model.Page;
import model.Project;
import model.Workspace;


public class DeleteNode extends AbstractGeRuDok {
	
	public DeleteNode() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/delete_icon.png"));
		putValue(NAME, "Delete node");
		putValue(SHORT_DESCRIPTION, "Delete node");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JTree tree = MainFrame.getInstance().getTree();
		Object selected = tree.getLastSelectedPathComponent();
		if (selected!=null) {
		Object[] path = tree.getSelectionPath().getPath();
		
		
        try {
			isWorkspace(selected);
			
			if (selected instanceof Project) {

				if(((Project) selected).getName().equals("RECYCLE BIN")) {
					JOptionPane.showMessageDialog(null, "You can't delete RECYCLE BIN. You can only delete documents of it.");
                    return;					
				}
				if (((Project)selected).getDocumentCount()==0) {
					Workspace parent = (Workspace) ((Project)selected).getParent();
					parent.deleteProject(((Project)selected));
					return;
				}
				
				DeleteDialog dialog = new DeleteDialog();
				dialog.setVisible(true);
				
				dialog.getButtonDelete().addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent arg0) {}
					
					@Override
					public void mousePressed(MouseEvent arg0) {
						Project project = (Project) selected;
						Workspace parent = (Workspace) project.getParent();
						
						//ako u projektu postoje shared doc potrebno ih je ukloniti iz svakog projekta
						//zato cemo njih posebno obrisati
						List<Document> documents = new ArrayList<Document>();
						for(Document doc : project.getDocuments()) 
							documents.add(doc);
						
						for(Document doc : documents) {
							if(doc.isShared())
								project.deleteDocument(doc);
						}
							
						//na kraju brise se ceo projekat sa svim svojim dokumentima
						parent.deleteProject(project);	
						
					}
					
					@Override
					public void mouseExited(MouseEvent arg0) {}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {}
					
					@Override
					public void mouseClicked(MouseEvent arg0) {}
				});
				
				dialog.getButtonAddToProj().addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {}
					
					@Override
					public void mousePressed(MouseEvent e) {
						Project project = (Project) selected;
						ArrayList<Document> documents = project.getDocuments();
						

						Workspace parent = (Workspace) project.getParent();
						parent.deleteProject(project);
						
						AddToProjDialog addDialog = new AddToProjDialog(documents);
						addDialog.setVisible(true);
						dialog.setVisible(false);
					}
					
					@Override
					public void mouseExited(MouseEvent e) {}
					
					@Override
					public void mouseEntered(MouseEvent e) {}
					
					@Override
					public void mouseClicked(MouseEvent e) {}
				});
				
				dialog.getButtonRecycle().addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {}
					
					@Override
					public void mousePressed(MouseEvent e) {
						Project project = (Project) selected;
						ArrayList<Document> documents = project.getDocuments();

					    List<Project> projects = ((Workspace) MainFrame.getInstance().getTree().getModel().getRoot()).getProjects();
                       	Project p = null;
					    
					    for(Project pro : projects) {
					    	if(pro.getName().equals("RECYCLE BIN"))
					    		p = pro;
					    }
					    
					 //   if(p == null) p = new Project("RECYCLE BIN");
					    
		             //   ((Workspace) MainFrame.getInstance().getTree().getModel().getRoot()).addProject(p);

						for(int j=0; j<documents.size(); j++) {
								Document d = project.getDocuments().get(j).clone(p);
								p.addDocument(d);
								for(int i=0; i<documents.get(j).getPageCount(); i++) {
									d.addPage(documents.get(j).getPage(i).clone(d));
								}

						}

						//ako je u listi dokumenata shared document, njega iz svih projekata treba da uklonimo
						//tj. prebaciti u recycle bin
						List<Document> docs = new ArrayList<Document>();
						for(Document doc : project.getDocuments()) 
							docs.add(doc);
						
						for(Document doc : docs) {
							if(doc.isShared())
								project.deleteDocument(doc);
						}
						
						Workspace parent = (Workspace) project.getParent();
						parent.deleteProject(project);		               		                
		                
		                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
						
						dialog.setVisible(false);
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {}
					
					@Override
					public void mouseEntered(MouseEvent e) {}
					
					@Override
					public void mouseClicked(MouseEvent e) {}
				});
				
			} else if (selected instanceof Document) {

				Document document = (Document) selected;
				Project project = (Project) path[1];
				project.deleteDocument(document);

			} else if (selected instanceof Page) {

				Page page = (Page) selected;
				Document parent = (Document) page.getParent();
				parent.deletePage(page);
			} 

		} catch (DeleteWorkspaceException e) {
			ErrorHandler.solve(e);
		}
		
		
	  }
	}
	
	private void isWorkspace(Object o) throws DeleteWorkspaceException {
		if(o instanceof Workspace)
			throw new DeleteWorkspaceException();
	}

}
