package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import commands.AddElementCommand;
import view.PageView;

public class TriangleState extends State{
	
	private PageView mediator;
	
	
	public TriangleState(PageView mediator) {
		this.mediator = mediator;
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint(); 
		ResizeState.flag=true;
		RotateState.flag=true;
		DragAndDropState.flag=true;
		if(e.getButton() == MouseEvent.BUTTON1) {
			 if (mediator.getModel().getDeviceAtPosition(position) == -1){
				// PageElement device = TriangleElement.drawDevice(position,mediator.getModel().getDeviceCount());
				// mediator.getModel().addPageElements(device);
				 mediator.getCommandManager().addCommand(new AddElementCommand(mediator.getModel(),position,PageView.TRIANGLE));

			 }
		}

	}


}
