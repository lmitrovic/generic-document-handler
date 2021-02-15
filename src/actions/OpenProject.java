package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import exception.ErrorHandler;
import exception.FileProjectException;
import gui.MainFrame;
import model.Document;
import model.Project;
import view.DocumentView;
import view.MiniPageView;
import view.PageView;
import view.ProjectView;

public class OpenProject extends AbstractGeRuDok {
	
	public OpenProject() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/open_icon.png"));
		putValue(NAME, "Open project");
		putValue(SHORT_DESCRIPTION, "Open project");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		File workspaceFile=null;
		if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
			try {
				isValid(jfc.getSelectedFile());
				ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				  
				Project p=null;
				try {
					p = (Project) os.readObject();
					workspaceFile = jfc.getSelectedFile();
					File projectFolder = new File(workspaceFile.getAbsolutePath());
					projectFolder.mkdir(); //kreira se direktorijum sa imenom putanje
					File projectFile = new File(projectFolder+"");
					p.setProjectFile(projectFile);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
				 ProjectView pv = new ProjectView();
				 pv.setProject(p);
				 MainFrame.getInstance().getWorkspaceView().add(pv);
				 pv.setVisible(true);
				 p.addObserver(pv);

			     MainFrame.getInstance().getTree().addProject(p);
					
					  for (int i=0;i<p.getDocumentCount();i++){
					    DocumentView view=new DocumentView(p.getDocument(i));
					    pv.addDocumentView(view);
					    p.getDocument(i).addObserver(view);
					    
					    for (int j=0;j<p.getDocument(i).getPageCount();j++) {
					    	PageView pageView = new PageView(p.getDocument(i).getPage(j));
							MiniPageView miniView = new MiniPageView(p.getDocument(i).getPage(j),view);
					    	view.addPageView(pageView);
					    	pageView.setVisible(false);
					    	view.addMiniPageView(miniView);
					    	p.getDocument(i).getPage(j).addObserver(pageView);
					    }
					    
					}
					  
			} catch(FileProjectException e1) {
				ErrorHandler.solve(e1);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
		
	   }	
		
	}
	
	private void isValid(File selectedFile) throws FileProjectException{
		if(!(selectedFile.getName().endsWith(".pro"))) 
			throw new FileProjectException();
	}
	

}
