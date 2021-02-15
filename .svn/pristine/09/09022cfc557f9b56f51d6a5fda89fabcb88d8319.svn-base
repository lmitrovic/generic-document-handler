package view;

import java.beans.PropertyVetoException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;

import gui.MainFrame;
import model.Project;
import model.Workspace;
import notification.NotificationType;

public class WorkspaceView extends JDesktopPane implements Observer{
	
	@Override
	public void update(Observable arg0, Object arg1) {
		Project project = (Project) arg1;
		NotificationType type = project.getNotificationType();
		
		
		if(type == NotificationType.ADD_PROJECT) {
			ProjectView pv = new ProjectView();
			pv.setProject(project);
			add(pv);
			pv.setVisible(true);
			project.addObserver(pv);
			
			
			
			
		}else if (type == NotificationType.REMOVE_PROJECT) {

			for (JInternalFrame frame : getAllFrames()) {
				ProjectView projectView = (ProjectView) frame;
				if (projectView.getProject().equals(project)) {
					try {
						projectView.setClosed(true);
					} catch (PropertyVetoException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	}

}
