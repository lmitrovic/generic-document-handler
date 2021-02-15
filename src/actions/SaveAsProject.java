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
import model.Project;

public class SaveAsProject extends AbstractGeRuDok{

	public SaveAsProject() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/save_icon.png"));
		putValue(NAME, "Save as project");
		putValue(SHORT_DESCRIPTION, "Save as project");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();
		
		if(selectedComponent instanceof Project) {
			Project project = (Project) selectedComponent;
			
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jfc.setDialogTitle("Saving project...");
			if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
			
			File projectFolder = new File(jfc.getSelectedFile().getAbsolutePath() +"\\"+project.getName());
			projectFolder.mkdir(); //kreira se direktorijum sa imenom putanje
			File projectFile = new File(projectFolder + "\\" + "Project.pro");

			ObjectOutputStream os;
			try {
				os = new ObjectOutputStream(new FileOutputStream(projectFile));
				os.writeObject(project);
				project.setProjectFile(projectFile);
				project.setProjectModified(false);

			} catch(FileNotFoundException e1) {
				e1.printStackTrace();
			} catch(IOException e2) {
				e2.printStackTrace();
			}

		}
		}
	}
}
