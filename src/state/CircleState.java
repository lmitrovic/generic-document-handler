package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import commands.AddElementCommand;
import page_elements.CircleElement;
import page_elements.PageElement;
import view.PageView;

public class CircleState extends State{
	
	private PageView mediator;
	
	
	public CircleState(PageView mediator) {
		this.mediator = mediator;
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {	
		Point position = e.getPoint(); // (x,y) pozicija
		ResizeState.flag=true;
		RotateState.flag=true;
		DragAndDropState.flag=true;
		if(e.getButton() == MouseEvent.BUTTON1) {
			 if (mediator.getModel().getDeviceAtPosition(position) == -1){
				 mediator.getCommandManager().addCommand(new AddElementCommand(mediator.getModel(),position,PageView.CIRCLE));
			 }
		}
	}

}
