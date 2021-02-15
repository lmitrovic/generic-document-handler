package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.KeyStroke;

import gui.MainFrame;
import model.Document;
import model.Project;
import model.Workspace;

public class SaveAsWorkspace extends AbstractGeRuDok{
	
	public SaveAsWorkspace() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/save_icon.png"));
		putValue(NAME, "Save workspace");
		putValue(SHORT_DESCRIPTION, "Save workspace");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();
		
		if(selectedComponent instanceof Workspace) {
			jfc.setDialogTitle("Select a folder to save workspace");
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			Workspace workspace = (Workspace) selectedComponent;
			
			//bira se fajl u koji korisnik zeli da sacuva projekat
			if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
			
			File workspaceFolder = new File(jfc.getSelectedFile().getAbsolutePath() + "\\workspace");
			workspaceFolder.mkdir(); //kreira se direktorijum sa imenom putanje
			File workspaceFile = new File(workspaceFolder + "\\" + "Workspace.ws");

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

			} catch(FileNotFoundException e1) {
				e1.printStackTrace();
			} catch(IOException e2) {
				e2.printStackTrace();
			}

		}
	}
	}

}
