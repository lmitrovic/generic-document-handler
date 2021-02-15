package actions;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.KeyStroke;

import clipboard.DocumentSelection;
import clipboard.PageElementSelection;
import gui.MainFrame;
import model.Document;
import model.Page;
import page_elements.PageElement;
import view.ProjectView;

public class OCopy extends AbstractGeRuDok{
	
	
	public OCopy() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/copy_icon.png"));
		putValue(NAME, "Copy");
		putValue(SHORT_DESCRIPTION, "Copy");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();
		
		if(selectedComponent instanceof Page) {
			Page page = (Page) selectedComponent;
			if(page.getModel().getSelected().size() > 0) {
				PageElementSelection contents = new PageElementSelection((ArrayList<PageElement>) page.getModel().getSelectedList());
				MainFrame.getInstance().getClipboard().setContents(contents, MainFrame.getInstance());
				System.out.println("Klikom na neko mesto na stranici izabrati poziciju, pa onda uraditi PASTE akciju.");
			}
		}
		
		if(selectedComponent instanceof Document) {
			Document document = (Document) selectedComponent;
			
			DocumentSelection contents = new DocumentSelection(document);
			MainFrame.getInstance().getClipboard().setContents(contents, MainFrame.getInstance());
		}
	}


}
