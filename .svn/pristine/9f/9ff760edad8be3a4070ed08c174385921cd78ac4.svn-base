package state;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import commands.ResizeElementCommand;
import commands.RotateElementCommand;
import exception.ErrorHandler;
import exception.SelectedPageElementException;
import page_elements.PageElement;
import view.PageView;

public class RotateState extends State {
	
	PageView mediator;
	static boolean flag;
	
	public RotateState(PageView mediator) {
		this.mediator=mediator;
		flag=true;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		ResizeElementCommand.flag=true;
		for (PageElement element : mediator.getModel().getSelected()) {
		if(SelectState.br == 0) element.setAngleRotation(0);
		if (flag) element.getAngles().add(element.getAngleRotation());
		}
		SelectState.br = 1;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		flag=false;
		try {
			for (PageElement element : mediator.getModel().getSelected()) {
			mediator.getModel().isSelected(element);
			rotatePageElement(element, Math.PI/100);
			element.addAngleRotation(Math.PI/100);
			}
		} catch (SelectedPageElementException e1) {
			ErrorHandler.solve(e1);
		}
		mediator.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		mediator.getCommandManager().addCommand(new RotateElementCommand(mediator.getModel()));
	}
	
	public static void rotatePageElement(PageElement element, double teta) {
		if (element != null) {
			Point center = new Point((int)(element.getPosition().getX()+element.getDimension().getWidth()/2),
					                 (int)(element.getPosition().getY()+element.getDimension().getHeight()/2));
			Shape shape = element.getElementPainter().getShape();
			AffineTransform af = AffineTransform.getRotateInstance(teta, center.getX(),center.getY());
			Shape finaly = af.createTransformedShape(shape);
			element.getElementPainter().setShape(finaly);
			}
	}

}
