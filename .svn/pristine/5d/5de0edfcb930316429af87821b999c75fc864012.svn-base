package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import page_elements.PageElement;

public class ChooseEditor extends JDialog {
	
	JLabel label;
	JButton textEditor;
	JButton imageEditor;
	JPanel panel1;
    JPanel panel;
    PageElement element;
    
    public ChooseEditor(PageElement element) {
    	this.element=element;
    	setLayout(new BorderLayout());
		setSize(400,100);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Choose Editor");
		
		this.panel1 = new JPanel(new FlowLayout());
		this.label = new JLabel("Do you want to open Text Editor or Image Editor?");
		label.setSize(new Dimension(70,20));
		panel1.add(label);
        add(panel1, BorderLayout.NORTH);
		
        this.panel = new JPanel(new FlowLayout());
		this.textEditor = new JButton("Text Editor");
		panel.add(textEditor);
		this.textEditor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				TxtEditor txt = new TxtEditor(element);
				txt.setVisible(true);
				setVisible(false);
			}
			
		});
		
		this.imageEditor = new JButton("Image Editor");
		panel.add(imageEditor);
		this.imageEditor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ImageEditor image=new ImageEditor(element);
				setVisible(false);
			}
			
		});
		
		panel.setVisible(true);
		add(panel, BorderLayout.CENTER);
	}

}
