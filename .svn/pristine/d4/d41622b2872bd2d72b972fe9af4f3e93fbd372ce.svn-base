package view_painters;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

import page_elements.PageElement;
import page_elements.RectangleElement;

public class RectanglePainter extends ElementPainter{
	
	

	public RectanglePainter(PageElement element) {
		super(element);

	}
	
	@Override
	public void paint(Graphics2D graf, PageElement element) {
		
        RectangleElement rectangle = (RectangleElement) element;
		
		//kreiranje figure upotrebom poligona, povezivanje tacaka koristeci linije
        if (element.getElementPainter().getShape()==null) {
		super.shape = new GeneralPath();
		element.getElementPainter().setShape(shape);
        
       // super.shape = new GeneralPath(element.getElementPainter().getShape());
        
       
		//moveTo pocetna pozicija
		((GeneralPath)shape).moveTo(rectangle.getPosition().getX(),rectangle.getPosition().getY());
		
		//kreira se linija koja se zavrsava u novoj tacki 
		((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getDimension().width,rectangle.getPosition().getY());
		((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getDimension().width,rectangle.getPosition().getY()+rectangle.getDimension().height);
		((GeneralPath)shape).lineTo(rectangle.getPosition().getX(),rectangle.getPosition().getY()+rectangle.getDimension().height);
		
		//zatvaranje poligona, povezuje poslednju kreiranu tacku i pocetnu
		((GeneralPath)shape).closePath();
        }
		//iscrtavanje elementa
		
		graf.setPaint(element.getStrokeColor());
		graf.setStroke(element.getStroke());
		graf.draw(element.getElementPainter().getShape());  //iscrtavanje konture (spoljasnjosti) shape-a
	    	
		graf.setPaint(element.getPaint());
		graf.fill(getShape());  //iscrtavanje unutrasnjosti shape-a
		
	}
	

}
