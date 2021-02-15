	package page_elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import view_painters.RectanglePainter;

public class RectangleElement extends PageElement{

	public RectangleElement(Color strokeColor, Paint paint, Stroke stroke, Dimension dimension, Point position) {
		super(strokeColor, paint, stroke, dimension, position);
		super.elementPainter = new RectanglePainter(this);
	}
	
	public RectangleElement(RectangleElement rectangle) {
		super(rectangle);
		super.elementPainter = new RectanglePainter(this);
		setName("Rectangle clone");
	}
	
	public static PageElement drawDevice(Point pos, int number) {
		Paint paint = Color.RED;
		Stroke stroke = new BasicStroke(2,00,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);
		Dimension size = new Dimension(75,45);
		Point position = (Point) pos.clone();
		
		RectangleElement rectangle = new RectangleElement(Color.BLACK,paint,stroke,size,position);
		rectangle.setName("GerudokRectangle" + number);
		
		return rectangle;
	}

	@Override
	public PageElement clone() {
		return new RectangleElement(this);
	}

}
