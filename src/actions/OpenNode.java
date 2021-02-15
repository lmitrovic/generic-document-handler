package actions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;

import gui.MainFrame;
import model.Document;
import model.Project;
import view.DocumentView;
import view.ProjectView;

public class OpenNode implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		Object object = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		if (object instanceof Document) {
			Document document = (Document)object;
			if (arg0.getClickCount() == 2) {
	//			Project project = (Project) document.getParent();
				Project project = null;
				if(document.isShared()) {
					Object[] objectsInPath = MainFrame.getInstance().getTree().getSelectionPath().getPath();
                    project = (Project)objectsInPath[1];
				}
				else
					project = document.getFirstParent();
				
				JInternalFrame[] projectViews = MainFrame.getInstance().getWorkspaceView().getAllFrames();
				for (JInternalFrame frame : projectViews) {
					Project p =((ProjectView) frame).getProject();
					if (p.equals(project)) {
						ProjectView pw = (ProjectView)frame;
						pw.setVisible(true);
						for (DocumentView dv : MainFrame.getInstance().getDeleteDocView()) {
							if (dv.getDocument().equals(document))
								pw.getTabPane().add(dv);
						}
					}
				}
				ProjectView projectView = focusProject(project);
				focusDocument(document, projectView);
			}
			
		}else if (object instanceof Project) {
			Project project = (Project)object;
			if (arg0.getClickCount() == 2) {
		
			for (ProjectView frame : MainFrame.getInstance().getCloseProject()) {
				Project p = frame.getProject();
				if (p.equals(project)) {
					frame.setVisible(true);
				}
			}
		}
		}
		
	}
	private ProjectView focusProject(Project project) {
		JInternalFrame[] projectViews = MainFrame.getInstance().getWorkspaceView().getAllFrames();
		for (JInternalFrame frame : projectViews) {
			Project p = ((ProjectView) frame).getProject();
			if (p.equals(project)) {
				try {
					((ProjectView) frame).setSelectedFromTree(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
				return (ProjectView) frame;
			}
		}
		return null;
	}
	
	private DocumentView focusDocument(Document document, ProjectView pv) {
		JTabbedPane tabPane = pv.getTabPane();
		int tabCount = tabPane.getTabCount();
		for (int i = 0; i < tabCount; i++) {
			DocumentView dv = (DocumentView) tabPane.getComponentAt(i);
			if (document.equals(dv.getDocument())) {
				tabPane.setSelectedComponent(dv);
				return dv;
			}
		}
		return null;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
