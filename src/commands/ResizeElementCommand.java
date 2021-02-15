package commands;

import java.awt.Dimension;
import java.util.ArrayList;

import model.PageModel;
import page_elements.PageElement;

public class ResizeElementCommand extends AbstractCommand{
	
	PageModel model;
	public static boolean flag;
	ArrayList<Dimension> start=new ArrayList<Dimension>();
	ArrayList<Dimension> end=new ArrayList<Dimension>();

	public ResizeElementCommand(PageModel model,ArrayList<Dimension> start, ArrayList<Dimension> end){
		this.model=model;
		this.start=start;
		this.end=end;
		flag =true;
	}

	@Override
	public void doCommand() {
		if (model.getSelected().size()>0) {
		int i=0;
		for (PageElement element: model.getSelected()) {
			if (i>=0 && i<end.size()) model.setDimension(element,end.get(i));
			i++;
		}
		}	
	}

	@Override
	public void undoCommand() {
		int i=0;
		for (PageElement element: model.getSelected()) {
			if (i>=0 && i<end.size())model.setDimension(element, start.get(i));
			i++;
		}
	}
}
