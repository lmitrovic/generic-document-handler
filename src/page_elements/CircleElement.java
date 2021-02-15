package page_elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import view_painters.CirclePainter;

public class CircleElement extends PageElement{


	public CircleElement(Color strokeColor, Paint paint, Stroke stroke, Dimension dimension, Point position) {
		super(strokeColor, paint, stroke, dimension, position);
		super.elementPainter = new CirclePainter(this);
	}
	
	public CircleElement(CircleElement circle){
		super(circle);
		elementPainter = new CirclePainter(this);
		setName("Circle clone");
	}

	
	public static PageElement drawDevice(Point pos,int number) {
		Point position = (Point) pos.clone();
		Paint paint = Color.CYAN;
		//BasicStroke(float sirinaLinije,int stilKrajaLinije,int stilOblikaSpojaDveLinije)
		Stroke stroke = new BasicStroke(2,00,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL );
		Dimension dimension = new Dimension(60,60);
		
		CircleElement circleElem = new CircleElement(Color.BLUE,paint,stroke,dimension,position);
		circleElem.setName("GerudokCircle " + number);
		
		return circleElem;
	}
	
	@Override
	public PageElement clone() {
		return new CircleElement(this);
	}


}
