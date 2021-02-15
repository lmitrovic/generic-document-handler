package commands;

import java.awt.Point;

import model.PageModel;
import page_elements.CircleElement;
import page_elements.PageElement;
import page_elements.RectangleElement;
import page_elements.TriangleElement;
import view.PageView;

public class AddElementCommand extends AbstractCommand {
	
	PageModel model;
	Point lastPosition;
	PageElement device = null;
	//PageSelectionModel selectionModel;
	int deviceType;
	

	public AddElementCommand(PageModel model, Point lastPosition,int deviceType) {
		this.model = model;
		this.lastPosition = lastPosition;
		//this.selectionModel = selectionModel;
		this.deviceType=deviceType;
	}

	@Override
	public void doCommand() {
		if (device==null)
			if (deviceType==PageView.CIRCLE){
				device=CircleElement.drawDevice(lastPosition,model.getPageElements().size());
			}else if (deviceType==PageView.RECTANGLE){
				device=RectangleElement.drawDevice(lastPosition,model.getPageElements().size());
			}else {
				device=TriangleElement.drawDevice(lastPosition, model.getPageElements().size());
			}
			
		//model.getSelected().removeAll(model.getSelected());
		model.addPageElements(device);	
		model.getSelected().add(device);
	}

	@Override
	public void undoCommand() {
	    model.removePageElements(device);
	    model.getSelected().remove(device);

	}


}
