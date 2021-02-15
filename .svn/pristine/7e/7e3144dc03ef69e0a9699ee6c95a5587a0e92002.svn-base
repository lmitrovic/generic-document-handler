package actions;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.KeyStroke;

import commands.AddElementCommand;
import commands.DeleteElementCommand;
import exception.ErrorHandler;
import exception.PaletteActionException;
import gui.MainFrame;
import model.Page;
import page_elements.PageElement;
import state.DeleteState;
import view.DocumentView;
import view.PageView;
import view.ProjectView;

public class DeletePageElement extends AbstractGeRuDok{
	
	public DeletePageElement() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/deleteElement_icon.png"));
		putValue(NAME, "Delete element");
		putValue(SHORT_DESCRIPTION, "Delete element");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
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
					cursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
					view.setCursor(cursor);
                   // for (PageElement element : view.getModel().getSelected())
				    view.getCommandManager().addCommand(new DeleteElementCommand(view.getModel(),view.getModel().getSelected()));

					
					view.startDeleteState();
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
