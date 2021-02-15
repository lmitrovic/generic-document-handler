package view_painters;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

import javax.swing.JTextPane;

import page_elements.PageElement;

public  class ElementPainter implements Serializable{

	Shape shape;
	
	
	public ElementPainter(PageElement element) {
		
		
	}
	
	public Shape getShape() {
		return shape;
	}
	
	public void setShape(Shape shape) {
		this.shape = shape;

	}
	
	//iscrtavanje elementa
	public void paint(Graphics2D graf, PageElement element) {
		//iscrtavanje elementa
		
				graf.setPaint(element.getStrokeColor());
				graf.setStroke(element.getStroke());
				graf.draw(getShape());  //iscrtavanje konture (spoljasnjosti) shape-a
			    	
				graf.setPaint(element.getPaint());
				graf.fill(getShape());  //iscrtavanje unutrasnjosti shape-a
	}
	
	//proverava da li se element nalazi na zadatoj poziciji
	public boolean isElementAt(Point pos) {
		return getShape().contains(pos);
	}

}
