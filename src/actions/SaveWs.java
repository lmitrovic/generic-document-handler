package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

import javax.swing.JTree;
import javax.swing.KeyStroke;

import exception.ErrorHandler;
import exception.SaveProjectException;
import exception.SaveWorkspaceException;
import gui.MainFrame;
import model.Document;
import model.Project;
import model.Workspace;

public class SaveWs extends AbstractGeRuDok {
	
	public SaveWs() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/save_icon.png"));
		putValue(NAME, "Save workspace");
		putValue(SHORT_DESCRIPTION, "Save workspace");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();
		try {
			selectedNode(selectedComponent);
			Workspace workspace = (Workspace) selectedComponent;
			File workspaceFile = workspace.getWorkspaceFile();

			// Ukoliko fajl vec nije snimljen, poziva se Save As
			if (workspaceFile == null) {
			MainFrame.getInstance().getActionManager().getSaveAsWorkspaceAction().actionPerformed(arg0);
			return;
			}

			//dodavanje projekta u folder workspace-a
			for (Project pro : workspace.getProjects()) {
				File projectFile = pro.getProjectFile();
				if (projectFile == null) {
					projectFile = new File(workspaceFile.getParent() + "\\" + pro.getName() + ".doc");
					pro.setProjectFile(projectFile);
				}

				// Zapis projekta u fajl
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
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
			
		}catch(SaveWorkspaceException e) {
			ErrorHandler.solve(e);
		}
	}
	
	private void selectedNode(Object node) throws SaveWorkspaceException {
		
		if (!(node instanceof Workspace)) throw new SaveWorkspaceException();
	}

}
