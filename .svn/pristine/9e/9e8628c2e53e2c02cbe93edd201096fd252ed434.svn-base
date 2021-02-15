package view_painters;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

import page_elements.CircleElement;
import page_elements.PageElement;

public class CirclePainter extends ElementPainter{

	public CirclePainter(PageElement element) {
		super(element);

	}
	
	@Override
	public void paint(Graphics2D graf, PageElement element) {
		
        CircleElement c = (CircleElement) element;
		
        if (element.getElementPainter().getShape()==null) {
    		super.shape = new GeneralPath();
    		element.getElementPainter().setShape(shape);
		
		((GeneralPath)shape).moveTo(c.getPosition().getX()+c.getDimension().getWidth()/2,c.getPosition().getY());
		
		((GeneralPath)shape).quadTo(c.getPosition().getX()+c.getDimension().getWidth(), c.getPosition().getY(), 
									c.getPosition().getX()+c.getDimension().getWidth(), c.getPosition().getY()+c.getDimension().getHeight()/2);	
		((GeneralPath)shape).quadTo(c.getPosition().getX()+c.getDimension().getWidth(), c.getPosition().getY()+c.getDimension().getHeight(),
									c.getPosition().getX()+c.getDimension().getWidth()/2, c.getPosition().getY()+c.getDimension().getHeight());
		((GeneralPath)shape).quadTo(c.getPosition().getX(), c.getPosition().getY()+c.getDimension().getHeight(),
				c.getPosition().getX(), c.getPosition().getY()+c.getDimension().getHeight()/2);

		((GeneralPath)shape).quadTo(c.getPosition().getX(), c.getPosition().getY(),
				c.getPosition().getX()+c.getDimension().getWidth()/2,c.getPosition().getY());
		//iscrtavanje elementa
        }
		
		graf.setPaint(element.getStrokeColor());
		graf.setStroke(element.getStroke());
		graf.draw(getShape());  //iscrtavanje konture (spoljasnjosti) shape-a
	    	
		graf.setPaint(element.getPaint());
		graf.fill(getShape());  //iscrtavanje unutrasnjosti shape-a
		
	}
	

}
