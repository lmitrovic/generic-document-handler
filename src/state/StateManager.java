package state;

import view.PageView;

public class StateManager {
	
	private State currentState;
	
	CircleState circleState;
	RectangleState rectangleState;
	SelectState selectState;
	TriangleState triangleState;
	ResizeState resizeState;
	RotateState rotateState;
	DragAndDropState dragAndDropState;
	DeleteState deleteState;
	LassoState lassoState;
	
	
	public StateManager(PageView mediator) {		
		this.circleState = new CircleState(mediator);
	    this.rectangleState = new RectangleState(mediator);
	    this.triangleState = new TriangleState(mediator);
	    this.selectState = new SelectState(mediator);
	    this.resizeState = new ResizeState(mediator);
	    this.rotateState = new RotateState(mediator);
	    this.dragAndDropState = new DragAndDropState(mediator);
	    this.deleteState = new DeleteState(mediator);
	    this.lassoState = new LassoState(mediator);
		this.currentState = selectState;

	}
	
	
	public State getCurrentState() {
		return this.currentState;
	}
	
	public void setCircleState() {
		this.currentState = circleState;
	}
	
	public void setRectangleState() {
		this.currentState = rectangleState;
	}

	public void setSelectState() {
		this.currentState = selectState;
	}
	
	public void setTriangleState() {
		this.currentState = triangleState;
	}
	
	public void setResizeState() {
		this.currentState = resizeState;
	}
	
	public void setRotateState() {
		this.currentState = rotateState;
	}
	public void setDragAndDropState() {
		this.currentState = dragAndDropState;
	}
	public void setDeleteState() {
		this.currentState = deleteState;
	}
	public void setLassoState() {
		this.currentState = lassoState;
	}
}
