package serialization_wrapper;

import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.Stroke;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StrokeWrapper implements Serializable, Stroke{

	Stroke stroke;
	
	public StrokeWrapper(Stroke stroke) {
		this.stroke = stroke;
	}
	
	//serijalizacija
	private void writeObject(ObjectOutputStream os) throws IOException {
		if(stroke instanceof BasicStroke) {
			BasicStroke bs = (BasicStroke) stroke;
			os.writeFloat(bs.getLineWidth());
			os.writeInt(bs.getEndCap());
			os.writeInt(bs.getLineJoin());
			os.writeFloat(bs.getMiterLimit());
			os.writeObject(bs.getDashArray());
			os.writeFloat(bs.getDashPhase());
		}
	}
	
	//deserijalizacija
	private void readObject(ObjectInputStream os) throws IOException, ClassNotFoundException {
		//if(stroke instanceof BasicStroke)
		    stroke = new BasicStroke(os.readFloat(),os.readInt(), os.readInt(), os.readFloat(), (float[])os.readObject(), os.readFloat());
	}

	
	//za prosledjeni Shape kreira se Stroke koji je potreban
	@Override
	public Shape createStrokedShape(Shape shape) {
		return stroke.createStrokedShape(shape);
	}

}
