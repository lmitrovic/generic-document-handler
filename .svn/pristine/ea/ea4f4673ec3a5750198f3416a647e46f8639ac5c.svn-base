package actions;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.KeyStroke;

import exception.ErrorHandler;
import exception.PaletteActionException;
import gui.MainFrame;
import model.Page;
import model.Project;
import view.DocumentView;
import view.PageView;
import view.ProjectView;

public class Undo extends AbstractGeRuDok{
	
    static boolean flag;
	
	public Undo() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/undo_icon.png"));
		putValue(NAME, "Undo");
		putValue(SHORT_DESCRIPTION, "Undo");
		flag=true;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();

		if (selectedComponent instanceof Page) {
			
			ProjectView projView = (ProjectView) MainFrame.getInstance().getWorkspaceView().getSelectedFrame();
			if (projView != null) {
			DocumentView docView = (DocumentView) projView.getTabPane().getSelectedComponent();
			ArrayList<PageView> pages = docView.getPanel().getPageViews();
			
			if(selectedComponent instanceof Page) {
				Page page = (Page) selectedComponent;
				for(PageView view : pages) {
					if(view.getPage().equals(page)) {
						view.getCommandManager().undoCommand();
						break;
					}
				}			
			}
		  }
		}else if (selectedComponent instanceof Project) {
			ProjectView projView = (ProjectView) MainFrame.getInstance().getWorkspaceView().getSelectedFrame();
            projView.getCommandManager().undoCommand();
		}

	}

}
