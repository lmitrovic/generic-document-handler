package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gui_editor.TextEditorMenubar;
import page_elements.PageElement;

public class TxtEditor extends JDialog{
	
	PageElement element;
	
	public TxtEditor(PageElement element) {
		this.element=element;
		setSize(500,500);
		setTitle("Text Editor");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setSize(new Dimension(500,300));
		setVisible(true);
		
		JPanel top = new JPanel(new BorderLayout());
		
		TextEditorMenubar menubar = new TextEditorMenubar(element);
		top.add(menubar,BorderLayout.NORTH);
		
		TextEditorToolbar toolbar = new TextEditorToolbar();
		toolbar.setPreferredSize(new Dimension(500,33));
		
		top.add(toolbar,BorderLayout.SOUTH);
		add(top,BorderLayout.NORTH);
		
		JScrollPane scroll=new JScrollPane(element.getTextArea());
		add(scroll, BorderLayout.CENTER);
		
	}
	
}
