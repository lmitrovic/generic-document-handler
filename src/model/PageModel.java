package model;


import java.awt.Dimension;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exception.SelectedPageElementException;
import notification.NotificationType;
import page_elements.CircleElement;
import page_elements.PageElement;
import page_elements.RectangleElement;
import page_elements.TriangleElement;
import state.RotateState;
import view_painters.CirclePainter;
import view_painters.RectanglePainter;
import view_painters.TrianglePainter;

public class PageModel implements Serializable{
	
	Page page;
	private static int count = 0;
	protected List<PageElement> pageElements = new ArrayList<PageElement>();
	public List<PageElement> selected = new ArrayList<PageElement>();


	
	public PageModel() {	
	}
	
	public PageModel(PageModel pageModel, Page page) {
		this.page = page;
		PageElement element = null;
		
		for(int i=0; i<pageModel.getPageElements().size(); i++) {
			element = pageModel.getPageElements().get(i).clone();
			
			if(element instanceof CircleElement) 
				element.setElementPainter(new CirclePainter(element));
			
			else if(element instanceof TriangleElement)
				element.setElementPainter(new TrianglePainter(element));
			
			else if(element instanceof RectangleElement)
				element.setElementPainter(new RectanglePainter(element));
			
			this.addPageElements(element);
			this.page.setNotificationType(NotificationType.NEW_PAGE_ELEMENT);
			this.page.notifyObservers(this.page);
		}
				
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	public int getDeviceAtPosition(Point point) {
		for(int i=getDeviceCount()-1; i>=0; i--) {
			PageElement element = getDeviceAt(i);
			if (element.getElementPainter().getShape()==null) return -1;
			if(element.getElementPainter().isElementAt(point)){
				return i;
			}
		}
		return -1;
	}
	
    public List<PageElement> getSelected() {
	return selected;
    }
	
	public List<PageElement> getPageElements() {
		return pageElements;
	}
	
	public void addPageElements(PageElement element) {
		pageElements.add(element);
		page.setNotificationType(NotificationType.NEW_PAGE_ELEMENT);
		page.notifyObservers(page);
	}

	
	public void setDimension(PageElement element, Dimension dimension ) {
		element.setDimension(dimension);
		element.getElementPainter().setShape(null);
		page.setNotificationType(NotificationType.SET_DIMENSION);
		page.notifyObservers(page);
	}
	

	public void rotatePageElement(PageElement element, double teta) {
		if (element != null) {
			Point center = new Point((int)(element.getPosition().getX()+element.getDimension().getWidth()/2),
					                 (int)(element.getPosition().getY()+element.getDimension().getHeight()/2));
			Shape shape = element.getElementPainter().getShape();
			AffineTransform af = AffineTransform.getRotateInstance(teta, center.getX(),center.getY());
			Shape finaly = af.createTransformedShape(shape);
			element.getElementPainter().setShape(finaly);
			page.setNotificationType(NotificationType.ROTATE);
			page.notifyObservers(page);
			}
	}
	
	

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		PageModel.count = count;
	}

	public PageElement getDeviceAt(int index) {
	    return pageElements.get(index);
	}
	
	public int getDeviceCount() {
		return pageElements.size();
	}
	
	public Iterator<PageElement> getElementIterator() {
	    return pageElements.iterator(); 	
	}
	
	public Iterator<PageElement> getSelectedElementIterator() {
	    return selected.iterator(); 	
	}
	
	public void isSelected(PageElement element) throws SelectedPageElementException {
		if (element == null) throw new SelectedPageElementException();
	}
	
	public void removePageElements(PageElement element) {
		pageElements.remove(element);
		page.setNotificationType(NotificationType.REMOVE_PAGE_ELEMENT);
		page.notifyObservers(page);
	}
	
	public void repaint() {
		page.setNotificationType(NotificationType.REPAINT);
		page.notifyObservers(page);
	}

	public ArrayList<PageElement> getSelectedList() {
		ArrayList<PageElement> list = new ArrayList<PageElement>();
		list.addAll(selected);
		return list;
	}

	public PageModel clone(PageModel pageModel, Page page) {
		return new PageModel(pageModel, page);
	}

}
