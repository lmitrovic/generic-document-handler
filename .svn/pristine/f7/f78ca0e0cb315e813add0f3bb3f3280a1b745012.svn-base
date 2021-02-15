package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import exception.ErrorHandler;
import exception.RenameWorkspaceException;
import exception.WrongNameException;
import model.Document;
import model.Page;
import model.Project;
import model.Workspace;

/* Da bismo omogućili editovanje stavki JTree-a možemo da nasledimo klasu DefaultTreeCellEditor*/

public class TreeEditor extends DefaultTreeCellEditor implements ActionListener {
	 private Object stavka=null;
	    private JTextField edit=null;
	    
		public TreeEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
			super(arg0, arg1);
		}
        
		//Ova metoda vraća komponentu koja će služiti za editovanje stavke u stablu 
		public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, 
				boolean arg3, boolean arg4, int arg5) {
  
			stavka=arg1;
			edit=new JTextField(arg1.toString());
			edit.addActionListener(this);
			return edit;
		}
        
		//Pod kojim uslovima stavka može da se edituje 
		public boolean isCellEditable(EventObject arg0) {
			if (arg0 instanceof MouseEvent)
				if (((MouseEvent)arg0).getClickCount()==3){
					return true;
				}
					return false;
		}

		
		
		public void actionPerformed(ActionEvent e) {
			if (stavka instanceof Project){
				try {
					((Project)stavka).setName(e.getActionCommand());
				} catch (WrongNameException e1) {
					ErrorHandler.solve(e1);
				}	
			}else if(stavka instanceof Document){
				((Document)stavka).setName(e.getActionCommand());
			}else if(stavka instanceof Page){
				((Page)stavka).setName(e.getActionCommand());
			}else if (stavka instanceof Workspace) {
				try {
					((Workspace)stavka).setName(e.getActionCommand());
				} catch (RenameWorkspaceException e1) {
					ErrorHandler.solve(e1);
				}
			}
			else
				return;
		}

}
