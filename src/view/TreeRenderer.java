package view;

import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Document;
import model.Project;

/*Ovu klasu je potrebno koristiti kada prilagođavamo prikaz čvorova stabla 
 (na primer želimo da imamo specifične ikone u stablu za pojedine vrste čvorova)*/

public class TreeRenderer extends DefaultTreeCellRenderer {
	
public TreeRenderer() {
		
	}

	  public Component getTreeCellRendererComponent(
              JTree tree,            //stablo koje se prikazuje
              Object value,          //stavka koja se iscrtava  
              boolean sel,           //da li je stavka selektovana
              boolean expanded,
              boolean leaf,          //da li je list
              int row,
              boolean hasFocus) {    //da li je u fokusu
              super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);
                  
             
             if (value instanceof Document ) {
                 URL imageURL = getClass().getResource("gui_icons/document.gif");
                 Icon icon = null;
                 if (imageURL != null)                       
                     icon = new ImageIcon(imageURL);
                 setIcon(icon);
 
             } else if (value instanceof Project ) {
            	 URL imageURL=null;
            	 if (((Project)value).getName()=="RECYCLE BIN"){
            		 imageURL = getClass().getResource("gui_icons/recycle_bin.jpg");
            	 } else {
            		 imageURL = getClass().getResource("gui_icons/project.gif");
            	 }
                 Icon icon = null;
                 if (imageURL != null)                       
                     icon = new ImageIcon(imageURL);
                 setIcon(icon);
                   
            } 
            return this;
}

}
