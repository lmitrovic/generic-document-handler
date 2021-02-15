package state;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;

import page_elements.PageElement;
import view.PageView;

public class LassoState extends State {
	
	PageView mediator;
	Rectangle2D rect=new Rectangle2D.Double();

	
	public LassoState(PageView mediator) {
		this.mediator = mediator;
	}
	

	
	@Override
	public void mouseDragged(MouseEvent e) {
		Point position=e.getPoint();
		
		if(!e.isControlDown()) mediator.getModel().getSelected().removeAll(mediator.getModel().getSelected());
		
		double width=position.getX()-mediator.getLastPosition().getX();
		double height=position.getY()-mediator.getLastPosition().getY();
		
		if((width<0)&&(height<0)){
			rect.setRect(position.getX(), position.getY(),Math.abs(width),Math.abs(height));
		}
		else if((width<0)&&(height>=0)){
			rect.setRect(position.getX(), mediator.getLastPosition().getY(),Math.abs(width),Math.abs(height));
		}
		else if((width>0)&&(height<0)){
			rect.setRect(mediator.getLastPosition().getX(), position.getY(), Math.abs(width),Math.abs(height));
		}
		else{
			rect.setRect(mediator.getLastPosition().getX(), mediator.getLastPosition().getY(),Math.abs(width),Math.abs(height));
		}		
		mediator.setSelectionRectangle(rect);
		selectElements(rect,mediator.getModel().getPageElements());
		mediator.repaint();
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		mediator.setSelectionRectangle(new Rectangle2D.Double(0, 0, 0, 0));
		SelectState.br=0;
		mediator.startSelectState();
		mediator.repaint();
	}
	
	public void selectElements(Rectangle2D rec,List<PageElement> list){
		Iterator<PageElement> it = list.iterator();
		while(it.hasNext()){
			PageElement device=it.next();
				if(rec.intersects(device.getPosition().getX(), device.getPosition().getY(),
						device.getDimension().getWidth(), device.getDimension().getHeight())){
					if(!(mediator.getModel().getSelected().contains(device))) { 
						device.getElementPainter().setShape(null);
						mediator.getModel().getSelected().add(device);
					}
				}
			
	}
			
	}

}
