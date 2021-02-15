package page_elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import view_painters.TrianglePainter;

public class TriangleElement extends PageElement{

	public TriangleElement(Color strokeColor, Paint paint, Stroke stroke, Dimension dimension, Point position) {
		super(strokeColor, paint, stroke, dimension, position);
		super.elementPainter = new TrianglePainter(this);
	}
	
	public TriangleElement(TriangleElement triangle) {
		super(triangle);
		elementPainter = new TrianglePainter(this);
		setName("Triangle clone");
	}
	
	public static PageElement drawDevice(Point pos,int number) {
		Paint paint = Color.YELLOW;
		Stroke stroke = new BasicStroke(2,00,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL);
		Point position = (Point) pos.clone();
		position.setLocation(position.getX(),position.getY()+60);
		Dimension dimension = new Dimension(100,50);
		TriangleElement triangle = new TriangleElement(Color.DARK_GRAY,paint,stroke,dimension,position);
		triangle.setName("GerudokTriangle " + number);
		
		return triangle;
	}

	@Override
	public PageElement clone() {
		return new TriangleElement(this);
	}

}
