package actions;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.KeyStroke;

import clipboard.PageElementSelection;
import commands.CutElementCommand;
import gui.MainFrame;
import model.Page;
import page_elements.PageElement;
import state.SelectState;
import view.DocumentView;
import view.PageView;
import view.ProjectView;

public class OCut extends AbstractGeRuDok{
	
	public OCut() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/cut_icon.png"));
		putValue(NAME, "Cut");
		putValue(SHORT_DESCRIPTION, "Cut");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();
		
		if(!(selectedComponent instanceof Page))
			return;
		
		Page page = (Page) selectedComponent;
		if(page.getModel().getSelected().size() > 0) {
			//za cut contents-u prosledjujemo napravljenu kopiju selektovanih elemenata
			//zbog kasnijeg brisanja selektovanih elemenata
			PageElementSelection contents = new PageElementSelection((ArrayList<PageElement>) page.getModel().getSelectedList());
			MainFrame.getInstance().getClipboard().setContents(contents, MainFrame.getInstance());
			System.out.println("Klikom na neko mesto na stranici izabrati poziciju, pa onda uraditi PASTE akciju.");
			
			ProjectView projView = (ProjectView) MainFrame.getInstance().getWorkspaceView().getSelectedFrame();
			if(projView != null) {
				DocumentView docView = (DocumentView) projView.getTabPane().getSelectedComponent();
				ArrayList<PageView> pages = docView.getPanel().getPageViews();
				
					for(PageView view : pages) 
						if(view.getPage().equals(page)) 
						     view.getCommandManager().addCommand(new CutElementCommand(page.getModel(), contents.getPageElements()));	
			}
			/*for(PageElement element : contents.getPageElements()) {
				page.getModel().removePageElements(element);
				page.getModel().getSelected().remove(element);
			}*/
		}

	}


}
