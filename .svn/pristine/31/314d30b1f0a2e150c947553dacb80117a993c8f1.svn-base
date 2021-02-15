package actions;


import java.awt.Cursor;
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

public class Redo extends AbstractGeRuDok{
	
	
	public Redo() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/redo_icon.png"));
		putValue(NAME, "Redo");
		putValue(SHORT_DESCRIPTION, "Redo");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
						view.getCommandManager().doCommand();
						break;
					}
				}			
			}
		  }
		}else if (selectedComponent instanceof Project) {
			ProjectView projView = (ProjectView) MainFrame.getInstance().getWorkspaceView().getSelectedFrame();
            projView.getCommandManager().doCommand();
		}

		
	}

}
