package commands;


import java.util.ArrayList;
import java.util.List;

import model.PageModel;
import page_elements.PageElement;


public class DeleteElementCommand extends AbstractCommand {
	
	PageModel model;
	List<PageElement> elements=new ArrayList<PageElement>();
	ArrayList<PageElement> cpy = new ArrayList<PageElement>();

	
	public DeleteElementCommand(PageModel model,List<PageElement> elements) {
		this.model = model;
		this.elements=elements;
	}

	@Override
	public void doCommand() {
		this.cpy=new ArrayList<PageElement>();
		for (PageElement element : elements)
			cpy.add(element);
			
		
		for (PageElement element : elements) {
		model.removePageElements(element);
		}
		model.getSelected().removeAll(elements);
		
		this.elements=cpy;
	}

	@Override
	public void undoCommand() {
		for (PageElement element : elements) {
		model.addPageElements(element);	
		model.getSelected().addAll(elements);		
		}
	}

}
