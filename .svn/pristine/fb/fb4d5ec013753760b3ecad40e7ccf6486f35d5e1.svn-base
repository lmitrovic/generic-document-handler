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
import view.DocumentView;
import view.PageView;
import view.ProjectView;

public class PRotate extends AbstractGeRuDok{

	
	public PRotate() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/rotate_icon.png"));
		putValue(NAME, "Rotate");
		putValue(SHORT_DESCRIPTION, "Rotate an element");

	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();
	
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
					cursor = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
					view.setCursor(cursor);
					view.startRotateState();
					break;
				}
			}		
		}
	   }
	  }	
	  catch(PaletteActionException e1) {
		  ErrorHandler.solve(e1);
	  }
		
	}

	
	private void selectedNode(Object node) throws PaletteActionException{
		if((!(node instanceof Page)) || node==null)
			throw new PaletteActionException();
		
	}
}
