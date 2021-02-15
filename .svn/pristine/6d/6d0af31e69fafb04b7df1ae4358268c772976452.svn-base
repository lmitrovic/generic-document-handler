package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTree;
import javax.swing.KeyStroke;

import exception.CloseProjectException;
import exception.ErrorHandler;
import gui.MainFrame;
import model.Project;

public class CloseProject extends AbstractGeRuDok {
	
	public CloseProject() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/closeproj_icon.jpg"));
		putValue(NAME, "Close project");
		putValue(SHORT_DESCRIPTION, "Close project");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selected = tree.getLastSelectedPathComponent();
		
		try {
			whatIs(selected);
			
			if(selected instanceof Project) {
				((Project) selected).closeProject();
			}

		} catch (CloseProjectException e1) {
			ErrorHandler.solve(e1);
		}
		
	}
	
	private void whatIs(Object o) throws CloseProjectException {
		if(!(o instanceof Project))
			throw new CloseProjectException();
	}

}
