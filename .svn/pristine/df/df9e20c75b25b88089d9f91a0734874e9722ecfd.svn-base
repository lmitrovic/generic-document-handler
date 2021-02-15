package factory;



import javax.swing.SwingUtilities;

import gui.MainFrame;
import model.Node;

//creator
public abstract class NodeF {
	
	public Node orderNode(Node n){
        Node node;
        node = createNode(n);
        n.addChild(node);
        return node;
    }
	
	
	public abstract Node createNode(Node n);
}
