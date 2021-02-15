package commands;

import java.util.ArrayList;
import java.util.List;

import model.PageModel;
import page_elements.PageElement;

public class PasteElementCommand extends AbstractCommand {
	
	PageModel model;
	List<PageElement> elements=new ArrayList<PageElement>();
	
	public PasteElementCommand(PageModel model,List<PageElement> elements) {
		this.model=model;
		this.elements=elements;
	}

	@Override
	public void doCommand() {
		for (PageElement element : elements) {
		model.addPageElements(element);
		model.getSelected().add(element);
		}
	}

	@Override
	public void undoCommand() {
		for (PageElement element : elements) {
		 model.removePageElements(element);
		 model.getSelected().remove(element);
		}
	}
	
}
