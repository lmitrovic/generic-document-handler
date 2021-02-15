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
import view.DocumentView;
import view.PageView;
import view.ProjectView;

public class PTriangle extends AbstractGeRuDok{

	
	public PTriangle() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/triangle_icon.png"));
		putValue(NAME, "Triangle");
		putValue(SHORT_DESCRIPTION, "Draw a triangle");

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
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
						Cursor cursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
						view.setCursor(cursor);
						view.startTriangleState();
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
