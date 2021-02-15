package state;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import commands.DragAndDropElementCommand;
import page_elements.PageElement;
import view.PageView;

public class DragAndDropState extends State {
	
	PageView mediator;
	static boolean flag;
	private ArrayList<Point> start = new ArrayList<Point>();
	private ArrayList<Point> end = new ArrayList<Point>();
	int c = 0;
	
	public DragAndDropState(PageView mediator) {
		this.mediator=mediator;
		flag=true;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		DragAndDropElementCommand.flag=true;
	    for (PageElement element : mediator.getModel().getSelected()) {
		    // if (flag) element.getPositions().add((Point) element.getPosition().clone());
	    	if (flag) {
	    		start.add((Point)element.getPosition().clone());
	    	}
	    }
	    
		flag=false;
		    for (PageElement element : mediator.getModel().getSelected()) {
		     Point start = element.getPosition();
			 element.getPosition().translate((int)(e.getX()-start.getX()+c),(int)(e.getY()-start.getY()+c));
		     element.getElementPainter().setShape(null);
		     c+=10;
		    }
		    c=0;
		    mediator.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		this.end=new ArrayList<Point>();
		c=0;
		flag=true;
		for (PageElement element : mediator.getModel().getSelected())
		      end.add((Point)element.getPosition().clone());
		    
		mediator.getCommandManager().addCommand(new DragAndDropElementCommand(mediator.getModel(),mediator.getModel().getSelected(),start,end));
		mediator.startSelectState();
		this.start=new ArrayList<Point>();
	}
	
}
