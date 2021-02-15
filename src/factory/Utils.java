package factory;

import model.Document;
import model.Project;
import model.Workspace;

public class Utils {
	
	  public static  NodeF returnNode(Object o) {
	    	if(o instanceof Workspace) return new ProjectF();
	    	else if(o instanceof Project) return new DocumentF();
	    	else if(o instanceof Document) return new PageF();
			return null;
	    	
	    }

}
