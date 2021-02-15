package factory;

import model.Document;
import model.Node;
import model.Project;

public class DocumentF extends NodeF {

	
	@Override
	public Node createNode(Node n) {
		
        Document doc = new Document(n);
		return doc;
	}

}
