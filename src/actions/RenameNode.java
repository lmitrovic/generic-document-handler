package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.tree.TreePath;

import exception.ErrorHandler;
import exception.RenameWorkspaceException;
import exception.WrongNameException;
import gui.MainFrame;
import gui.RenameDialog;
import model.Document;
import model.Page;
import model.Project;
import model.Workspace;

public class RenameNode extends AbstractGeRuDok{


	public RenameNode() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/rename_icon.png"));
		putValue(NAME, "Rename node");
		putValue(SHORT_DESCRIPTION, "Rename node");
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTree tree = MainFrame.getInstance().getTree();
		Object object = tree.getLastSelectedPathComponent();
		TreePath path = tree.getSelectionPath();
/*		if (path != null) {
			tree.startEditingAtPath(path); 
            
			                                //bira cvor odredjenom stazom i pokrece uredjivanje
		}                                   //uredjivanje nece uspeti ako CellEditor ne dozvoljava
		                                    //uredjivanje te stavke
*/	    
		RenameDialog dialog = new RenameDialog();
		dialog.setVisible(true);
		dialog.getButton().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				String newName = dialog.getField().getText();
				dialog.setVisible(false);
				
				if(object instanceof Project) {
					try {
						((Project) object).setName(newName);
					} catch (WrongNameException e1) {
						ErrorHandler.solve(e1);
					}
				}
				else if(object instanceof Document) {
					((Document) object).setName(newName);
				}
				else if(object instanceof Page) {
					((Page) object).setName(newName);
				}
				else if (object instanceof Workspace) {
					try {
						((Workspace)object).setName(newName);
					} catch (RenameWorkspaceException e1) {
						ErrorHandler.solve(e1);
					}
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
 
	
	    
	
}
