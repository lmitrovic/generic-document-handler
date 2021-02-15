package gui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import actions.DeleteNode;
import actions.NewNode;
import actions.OCopy;
import actions.OPaste;
import actions.RenameNode;
import actions.Import;
import actions.Export;


public class MyPopupMenu extends JPopupMenu{
	
	private JMenuItem New;
	private JMenuItem rename;
	private JMenuItem delete;
	private JMenuItem copy;
	private JMenuItem paste;
	private JMenuItem Import;
	private JMenuItem Export;

	
	public MyPopupMenu() {
		this.New = new JMenuItem("New");
		New.addActionListener(new NewNode());
		
		this.rename = new JMenuItem("Rename");
		rename.addActionListener(new RenameNode());
		
		this.delete = new JMenuItem("Delete");
		this.delete.addActionListener(new DeleteNode());
		
		this.copy = new JMenuItem("Copy");
		this.copy.addActionListener(new OCopy());
		
		this.paste = new JMenuItem("Paste");
		this.paste.addActionListener(new OPaste());

		this.Import = new JMenuItem("Import document");
		this.Import.addActionListener(new Import());
		
		this.Export = new JMenuItem("Share document");
		this.Export.addActionListener(new Export());

		
		add(New);
		addSeparator();
		add(copy);
		add(paste);
		addSeparator();
		add(Export);
		add(Import);
		addSeparator();
		add(rename);
		addSeparator();
		add(delete);
	}

}
