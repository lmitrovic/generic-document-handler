package page_elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextPane;

import serialization_wrapper.StrokeWrapper;
import view_painters.ElementPainter;

//apstraktna klasa koja opisuje elemente stranice

public abstract class PageElement implements Serializable{

	protected Color strokeColor;
	protected Paint paint;
	protected StrokeWrapper stroke;   //umesto Stroke koristimo njegov wrapper
	                                  //da bi mogao da se serijalizuje
	protected String name;
	
	protected ElementPainter elementPainter;
	
	protected Dimension dimension;
	protected Point position;    // (x,y)
	protected double angleRotation;
	private ArrayList<Dimension> dimensions= new ArrayList<Dimension>();
	private ArrayList<Double> angles= new ArrayList<Double>();
	private ArrayList<Point> start = new ArrayList<Point>();
	private ArrayList<Point> end = new ArrayList<Point>();
	private JTextPane textArea = null;
	private JLabel label;
	
	public PageElement(Color strokeColor, Paint paint, Stroke stroke, Dimension dimension, Point position) {
		this.strokeColor = strokeColor;
		this.paint = paint;
		setStroke(stroke);
		
		position.setLocation(position.getX()-dimension.getWidth()/2,position.getY()-dimension.getHeight()/2);
		//element se kreira u centru
		this.position = position;
		this.dimension = dimension;
		this.angleRotation=0;	
		this.textArea = new JTextPane();
	}
	
	public PageElement(PageElement element) {
		this.stroke=element.stroke;
		this.paint=element.paint;
		this.strokeColor=element.strokeColor;
		this.name=element.name;
		this.elementPainter=element.elementPainter;
		
		this.position = element.position;
		this.dimension = element.dimension;
		this.angleRotation = element.angleRotation;
		this.textArea=element.textArea;
		this.label = element.label;
		this.start=element.start;
		this.end=element.end;
	}
	
	abstract public PageElement clone();
	
	public ArrayList<Point> getStart() {
		return start;
	}
	public ArrayList<Point> getEnd() {
		return end;
	}
	
	public ArrayList<Dimension> getDimensions() {
		return dimensions;
	}
	public ArrayList<Double> getAngles() {
		return angles;
	}
	
	public void addAngleRotation(Double angle) {
		this.angleRotation+=angle;
	}
	
	public double getAngleRotation() {
		return angleRotation;
	}
	
	public void setAngleRotation(double angleRotation) {
		this.angleRotation = angleRotation;
	}

	public Color getStrokeColor() {
		return strokeColor;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = new StrokeWrapper(stroke);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ElementPainter getElementPainter() {
		return elementPainter;
	}

	public void setElementPainter(ElementPainter elementPainter) {
		this.elementPainter = elementPainter;
	}
	
	public String toString() {
		return name;
	}
	
	public JTextPane getTextArea() {
		return textArea;
	}
	
	public void setTextArea(JTextPane textArea) {
		this.textArea = textArea;
	}
	
	public void setText(String text) {
		textArea.setText(text);
	}
	
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	
}
