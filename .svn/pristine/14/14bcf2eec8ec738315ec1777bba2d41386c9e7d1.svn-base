package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import commands.ResizeElementCommand;
import gui.ChooseEditor;
import gui.ImageEditor;
import gui.TxtEditor;
import page_elements.PageElement;
import view.PageView;

public class SelectState extends State{
	
	private PageView mediator;
	public static int br;
	public static Point pastePosition;
	
	public SelectState(PageView mediator) {
		this.mediator = mediator;
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
	    Point position = e.getPoint();
		int index;
		PageElement element;
		if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount()==1) {
			
			index = mediator.getModel().getDeviceAtPosition(position);
			if (index!=-1) {
			mediator.getModel().getSelected().removeAll(mediator.getModel().getSelected());
	        element = (PageElement) mediator.getModel().getDeviceAt(index);
			mediator.getModel().getSelected().add(element);
			element.getElementPainter().setShape(null);
			br=0;
			}else {
				//nakon manipulacije nad elementom vracamo ga da bude rotiran kao i pre manipulacije
				for (PageElement el : mediator.getModel().getSelected()) {
				if (br==0) {
					RotateState.rotatePageElement(el, el.getAngleRotation());		
				}
				//el=null;
				}
				br++;
				mediator.getModel().getSelected().removeAll(mediator.getModel().getSelected());
			}
		}else if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount()==2){
			index = mediator.getModel().getDeviceAtPosition(position);
			if (index!=-1) {
		        element = (PageElement) mediator.getModel().getDeviceAt(index);
				ChooseEditor editor = new ChooseEditor(element);
				editor.setVisible(true);
				}
		}
		mediator.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (mediator.getModel().getSelected().size()!=0) mediator.startDragAndDropState();
		else mediator.startLassoState();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		pastePosition=e.getPoint();
		//System.out.println("Da bi Vam element ponovo bio rotiran, kliknuti na belu povrsinu.");
	}
	
	
}
