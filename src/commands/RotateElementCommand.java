package commands;


import model.PageModel;
import page_elements.PageElement;

public class RotateElementCommand extends AbstractCommand {
	
	PageModel model;
	public static boolean flag;
	
	public RotateElementCommand(PageModel model) {
		this.model=model;
		flag=true;
	}

	@Override
	public void doCommand() {
		for (PageElement element : model.getSelected()) {
			int i=-1;
			if (flag) { 
				element.getAngles().add(element.getAngleRotation());
			    i = element.getAngles().size()-1;
			}else {
				i=element.getAngles().size()-1;
				if (i>=0) {
				double ang = element.getAngles().get(0);
				model.rotatePageElement(element, 2*Math.PI-element.getAngles().get(i) +element.getAngles().get(0));
				element.getAngles().remove(ang);
				element.getAngles().add(ang);
			}
			}
		}
	}

	@Override
	public void undoCommand() {
		flag=false;
		for (PageElement element : model.getSelected()) {
			int i = element.getAngles().size()-1;
			if (i-1>=0) {
			double ang = element.getAngles().get(i);
			model.rotatePageElement(element, 2*Math.PI-ang+element.getAngles().get(i-1));
			element.getAngles().remove(ang);
			element.getAngles().add(0,ang);
			}
			
		}
	}

}
