package view_painters;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import page_elements.PageElement;
import page_elements.TriangleElement;

public class TrianglePainter extends ElementPainter{

	public TrianglePainter(PageElement element) {
		super(element);

	}
	
	@Override
	public void paint(Graphics2D graf, PageElement element) {
		TriangleElement triangle = (TriangleElement) element;
		//upotreba poligona, povezivanje tacaka koristeci linije...
		//super.shape = new GeneralPath();
		  if (element.getElementPainter().getShape()==null) {
				super.shape = new GeneralPath();
				element.getElementPainter().setShape(shape);
		
		//moveTo(), zadavanje pocetnih koordinata T(x,y)
		((GeneralPath)shape).moveTo(triangle.getPosition().getX(),triangle.getPosition().getY());
	
		//lineTo(), povlacenje linija od tacke do nove tacke
		((GeneralPath)shape).lineTo(triangle.getPosition().getX()+triangle.getDimension().width,triangle.getPosition().getY());
		((GeneralPath)shape).lineTo(triangle.getPosition().getX()+triangle.getDimension().width/2, triangle.getPosition().getY() - triangle.getDimension().height);

		//closePath(), zatvaranje linije; povlacenje linije od posl kreirane do pocetne
		((GeneralPath)shape).closePath();
		  }
		//iscrtavanje elementa
		
		graf.setPaint(element.getStrokeColor());
		graf.setStroke(element.getStroke());
		graf.draw(getShape());  //iscrtavanje konture (spoljasnjosti) shape-a
			    	
		graf.setPaint(element.getPaint());
		graf.fill(getShape());  //iscrtavanje unutrasnjosti shape-a
				
	}

}
