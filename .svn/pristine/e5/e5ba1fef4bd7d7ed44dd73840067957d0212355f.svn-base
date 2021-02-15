package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JTree;
import javax.swing.KeyStroke;

import exception.ErrorHandler;
import exception.SaveProjectException;
import gui.MainFrame;
import model.Project;

public class SaveProject extends AbstractGeRuDok {
	
	public SaveProject() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/save_icon.png"));
		putValue(NAME, "Save project");
		putValue(SHORT_DESCRIPTION, "Save project");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();
		
		try {
			selectedNode(selectedComponent);
			Project project = (Project) selectedComponent;
			File projectFile = project.getProjectFile();
	
			//ukoliko projekat nije modifikovan nemamo sta da sacuvamo
			if (!project.isProjectModified())	return;
			
			// Ukoliko fajl vec nije snimljen, poziva se Save As
			if (projectFile == null) {
			MainFrame.getInstance().getActionManager().getSaveAsProjectAction().actionPerformed(e);
			return;
			}

		    ObjectOutputStream os;
			try {
				os = new ObjectOutputStream(new FileOutputStream(projectFile));
				os.writeObject(project);
				project.setProjectFile(projectFile);
				project.setProjectModified(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
			
		}catch(SaveProjectException e1) {
			ErrorHandler.solve(e1);
		}
		
	}
	
	private void selectedNode(Object node) throws SaveProjectException {
		
		if (!(node instanceof Project)) throw new SaveProjectException();
	}
	
}
