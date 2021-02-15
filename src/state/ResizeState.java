package state;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import commands.AddElementCommand;
import commands.ResizeElementCommand;
import exception.ErrorHandler;
import exception.SelectedPageElementException;
import page_elements.PageElement;
import page_elements.TriangleElement;
import view.PageView;

public class ResizeState extends State{
	
	PageView mediator;
	Point start;
	static int br=0;
	static boolean flag;
	ArrayList<Dimension> startDim;
	ArrayList<Dimension> end;
	
	public ResizeState(PageView mediator) {
		this.mediator=mediator;
		flag=true;
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.startDim=new ArrayList<Dimension>();
        ResizeElementCommand.flag=true;
		SelectState.br = 0;
		start = e.getPoint();
	/*	PageElement element;
		if (mediator.getModel().getSelected().size()!=0) element = mediator.getModel().getSelected().get(0);
		else element=null;*/
        try {
        	for (PageElement element : mediator.getModel().getSelected()) {
        	startDim.add((Dimension) element.getDimension().clone());
			mediator.getModel().isSelected(element);
			element.getElementPainter().setShape(null);
			mediator.repaint();
			if (flag) element.getDimensions().add(element.getDimension());
        	}
			mediator.repaint();
		} catch (SelectedPageElementException e1) {
			ErrorHandler.solve(e1);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		flag=false;
		if (br==0) start = e.getPoint();
	/*	PageElement element;
		if (mediator.getModel().getSelected().size()!=0) element = mediator.getModel().getSelected().get(0);
		else element=null;*/
		try {
			for (PageElement element : mediator.getModel().getSelected()) {
			mediator.getModel().isSelected(element);
			int i = (int) element.getDimension().getWidth();
			int j = (int) element.getDimension().getHeight();
		//	if (!(element instanceof TriangleElement)) {
			
			if (e.getPoint().getX() < start.getX() && e.getPoint().getY() < start.getY())
				element.setDimension(new Dimension(i+1,j+1));
			if (e.getPoint().getX() > start.getX() && e.getPoint().getY() > start.getY())
				element.setDimension(new Dimension(i-1,j-1));
			
		/*	}else {
				
				if (e.getPoint().getY() > start.getY())
					element.setDimension(new Dimension(i+1,j+1));
				if (e.getPoint().getX() > start.getX())
					element.setDimension(new Dimension(i-1,j-1));
			}*/
			element.getElementPainter().setShape(null);
			br++;
			mediator.repaint();
			}

		} catch (SelectedPageElementException e1) {
			ErrorHandler.solve(e1);
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		this.end= new ArrayList<Dimension>();
		for (PageElement element : mediator.getModel().getSelected()) {
			end.add((Dimension) element.getDimension().clone());
		}
		br=0;
		mediator.getCommandManager().addCommand(new ResizeElementCommand(mediator.getModel(),startDim,end));
		//zbog kasnijeg unosenja teksta u element, 
		//svaki put kada se isti selektuje bice u pocetnoj poziciji (nerotiran)
	//	System.out.println("Da bi Vam element novih dimenzija ponovo bio rotiran, "
	//			+ "potrebno je promeniti stanje u Select i kliknuti na belu povrsinu.");
	}

}
