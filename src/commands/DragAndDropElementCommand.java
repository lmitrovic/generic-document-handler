package commands;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.PageModel;
import page_elements.PageElement;

public class DragAndDropElementCommand extends AbstractCommand {
	
	PageModel model;
	public static boolean flag;
	List<PageElement> elements = new ArrayList<PageElement>();
	private ArrayList<Point> start = new ArrayList<Point>();
	private ArrayList<Point> end = new ArrayList<Point>();
    int i;
	
	public DragAndDropElementCommand(PageModel model,List<PageElement> elements,ArrayList<Point> start,ArrayList<Point> end) {
		this.model=model; 
		flag=true;
		this.elements=elements;
		this.start=start;
		this.end=end;
		i=0;
	}

	@Override
	public void doCommand() {
		int i=0;
		if (!flag) {
		for (PageElement element : elements) {
			if (i>=0 && i<start.size() && i<end.size()) {
			element.getPosition().translate((int)(end.get(i).getX()-start.get(i).getX()), (int)(end.get(i).getY()-start.get(i).getY()));
			element.getElementPainter().setShape(null);
			i++;
		   }
		}
		model.repaint();
		}
	}

	@Override
	public void undoCommand() {
		int i=0;
		flag=false;
		for (PageElement element : elements) {
			if (i>=0 && i<start.size() && i<end.size()) {
			element.getPosition().translate((int)(start.get(i).getX()-end.get(i).getX()), 
					(int)(start.get(i).getY()-end.get(i).getY()));
			
			element.getElementPainter().setShape(null);
			i++;
			}
		}
		model.repaint();
	}

}
