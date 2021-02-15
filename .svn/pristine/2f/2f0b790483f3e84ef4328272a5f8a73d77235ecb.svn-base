package guiWindowListener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import exception.ErrorHandler;
import exception.FileWorkspaceException;
import gui.MainFrame;
import model.Project;
import model.Workspace;
import model.WorkspaceModel;
import view.DocumentView;
import view.PageView;
import view.ProjectView;
import view.WorkspaceView;

public class MyWindowListener implements WindowListener{

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		JFrame frame = (JFrame) arg0.getComponent();
		int code = JOptionPane.showConfirmDialog(frame, "Do you want to save this workspace?", 
				   "Exit Application", JOptionPane.YES_NO_OPTION);
		if(code == JOptionPane.YES_OPTION) {
			JTree tree = MainFrame.getInstance().getTree();
			Object selectedComponent = tree.getModel().getRoot();
			
			if (selectedComponent instanceof Workspace) {
				Workspace workspace = (Workspace) selectedComponent;
				File workspaceFile = workspace.getWorkspaceFile();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Ukoliko fajl vec nije snimljen, poziva se Save As
				if (workspaceFile == null) {
					
					JFileChooser jfc = new JFileChooser();
					
					File fileToSave = null;
					
					if(selectedComponent instanceof Workspace) {
						jfc.setDialogTitle("Select a folder to save workspace");
						jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

						workspace = (Workspace) selectedComponent;
						
						//bira se fajl u koji korisnik zeli da sacuva projekat
						int choosedOption = jfc.showSaveDialog(MainFrame.getInstance());
						if (choosedOption != JFileChooser.APPROVE_OPTION) {
							return;
						}
						
						fileToSave = jfc.getSelectedFile();
						File workspaceFolder = new File(fileToSave.getAbsolutePath() + "\\workspace");
						workspaceFolder.mkdir(); //kreira se direktorijum sa imenom putanje
						workspaceFile = new File(workspaceFolder + "\\" + "Workspace.ws");

						//project.setProjectModified(false);
						
						

						for (int i=0; i<workspace.getChildCount();i++) {
							Project project = workspace.getProject(i);
							ObjectOutputStream os;
							try {
								File projectFile = new File(workspaceFolder + "\\" + project.getName() + ".pro");
								project.setProjectFile(projectFile);
								os = new ObjectOutputStream(new FileOutputStream(projectFile));
								os.writeObject(project);

								os.close();

							} catch(Exception e1) {
								e1.printStackTrace();
							}
						}
						
						ObjectOutputStream os;
						try {
							os = new ObjectOutputStream(new FileOutputStream(workspaceFile));
							os.writeObject(workspace);
							workspace.setWorkspaceFile(workspaceFile);
							//project.setProjectModified(false);

						} catch(FileNotFoundException e1) {
							e1.printStackTrace();
						} catch(IOException e2) {
							e2.printStackTrace();
						}

					}
					frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
					return;
				}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
			//	if (!project.isProjectModified()) return;

				//dodavanje dokumenata projekta u folder projekta
				for (Project pro : workspace.getProjects()) {
					File projectFile = pro.getProjectFile();

					if (projectFile == null) {
						projectFile = new File(workspaceFile.getParent() + "\\" + pro.getName() + ".doc");
						pro.setProjectFile(projectFile);
					}

					//ako je promenjeno ime dokumenta, menjamo i ime fajla
					if (!projectFile.getName().equals(pro.getName() + ".pro")) {
						try {
							Files.deleteIfExists(projectFile.toPath());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						pro.setProjectFile(new File(projectFile.getParent() + "\\" + pro.getName() + ".pro"));
					}

					// Zapis dokumenta u fajl
					ObjectOutputStream os;
					try {
						os = new ObjectOutputStream(new FileOutputStream(pro.getProjectFile()));
						os.writeObject(pro);

						os.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			    ObjectOutputStream os;
				try {
					os = new ObjectOutputStream(new FileOutputStream(workspaceFile));
					os.writeObject(workspace);
					workspace.setWorkspaceFile(workspaceFile);
				//	project.setProjectModified(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				
			}
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
		else if (code == JOptionPane.NO_OPTION)
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		else if (code == JOptionPane.CLOSED_OPTION)
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	     JFrame frame = (JFrame) arg0.getComponent();
	     File fileToSave=null;
			int code = JOptionPane.showConfirmDialog(frame, "Do you want to continue using saved workspace?", 
					   "Exit Application", JOptionPane.YES_NO_OPTION);
			if(code == JOptionPane.YES_OPTION) {
				JFileChooser jfc = new JFileChooser();
				JTree tree = MainFrame.getInstance().getTree();
			    TreePath path = tree.getSelectionPath();
				Workspace workspace = (Workspace) tree.getModel().getRoot();

			    tree.expandPath(path);
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
					 	     MainFrame.getInstance().getTree().addProject(w.getProject(i));
						    
							 for (int k=0;k<p.getDocumentCount();k++){
								  DocumentView view=new DocumentView(p.getDocument(k));
							      pv.addDocumentView(view);
							      p.getDocument(k).addObserver(view);
								    
							     for (int j=0;j<p.getDocument(k).getPageCount();j++) {
							    	PageView pageView = new PageView(p.getDocument(k).getPage(j));
							    	view.addPageView(pageView);
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
			else
				frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	     
	}
	
	private void isValid(File selectedFile) throws FileWorkspaceException{
		if(!(selectedFile.getName().endsWith(".ws"))) 
			throw new FileWorkspaceException();
	}

	

}
