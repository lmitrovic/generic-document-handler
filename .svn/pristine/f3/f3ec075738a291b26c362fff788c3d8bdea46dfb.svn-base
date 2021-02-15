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
import page_elements.TriangleElement;
import state.SelectState;
import view.DocumentView;
import view.PageView;
import view.ProjectView;

public class PResize extends AbstractGeRuDok{

	
	public PResize() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/resize_icon.jpg"));
		putValue(NAME, "Resize");
		putValue(SHORT_DESCRIPTION, "Resize an element");

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();
		ProjectView proView = (ProjectView) MainFrame.getInstance().getWorkspaceView().getSelectedFrame();
		if (proView != null) {
		DocumentView documentView = (DocumentView) proView.getTabPane().getSelectedComponent();
		ArrayList<PageView> pagesView = documentView.getPanel().getPageViews();
		for (PageView pv : pagesView) {
			if (pv.isVisible()) selectedComponent = pv.getPage();
		}
		}
		try {
			selectedNode(selectedComponent);
			
			ProjectView projView = (ProjectView) MainFrame.getInstance().getWorkspaceView().getSelectedFrame();
			if (projView != null) {
			DocumentView docView = (DocumentView) projView.getTabPane().getSelectedComponent();
			ArrayList<PageView> pages = docView.getPanel().getPageViews();
			
			if(selectedComponent instanceof Page) {
				Page page = (Page) selectedComponent;
				for(PageView view : pages) {
					if(view.getPage().equals(page)) {
						Cursor cursor = null;
						if (!(view.getModel().getSelected() instanceof TriangleElement))
						cursor = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
						else cursor = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
						view.setCursor(cursor);
						view.startResizeState();
						break;
					}
				}		
			}
		  }

		} catch (PaletteActionException e1) {
			ErrorHandler.solve(e1);
		}
	}
	
	private void selectedNode(Object node) throws PaletteActionException{
		if((!(node instanceof Page)) || node==null)
			throw new PaletteActionException();
		
	}


}
