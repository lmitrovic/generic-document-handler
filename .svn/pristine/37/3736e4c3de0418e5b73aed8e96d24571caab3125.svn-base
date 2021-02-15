package actions;


import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.KeyStroke;

import gui.MainFrame;
import model.Page;
import model.Project;
import state.SelectState;
import view.DocumentView;
import view.PageView;
import view.ProjectView;

public class OPaste extends AbstractGeRuDok{
	
	public static Point point;
	
	public OPaste() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/paste_icon.png"));
		putValue(NAME, "Paste");
		putValue(SHORT_DESCRIPTION, "Paste");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();
		
		if(selectedComponent instanceof Page) {
			ProjectView projView = (ProjectView) MainFrame.getInstance().getWorkspaceView().getSelectedFrame();
			if(projView != null) {
				DocumentView docView = (DocumentView) projView.getTabPane().getSelectedComponent();
				ArrayList<PageView> pages = docView.getPanel().getPageViews();
				
				if(selectedComponent instanceof Page) {
					Page page = (Page) selectedComponent;
					for(PageView view : pages) {
						if(view.getPage().equals(page)) {
							view.paste(SelectState.pastePosition);
						}
					}
				}	
			}
			
		}
		
		if(selectedComponent instanceof Project) {
			ProjectView projView = (ProjectView) MainFrame.getInstance().getWorkspaceView().getSelectedFrame(); 
			
			if(projView != null) {
				projView.paste((Project)selectedComponent);
			}
		}
		
	}


}
