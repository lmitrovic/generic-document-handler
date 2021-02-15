package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RenameDialog extends JDialog{
	
	JLabel label;
	JTextField field;
	JButton button;
	
	public RenameDialog() {
		setLayout(new FlowLayout());
		setSize(400,150);
		setLocationRelativeTo(null);

		
		this.label = new JLabel("Write a new name:");
		label.setSize(new Dimension(70,20));
		add(label);
		
		this.field = new JTextField();
	    field.setPreferredSize(new Dimension(100,20));;
	    add(field);
	    
	    this.button = new JButton("OK");
	    button.setSize(new Dimension(50,50));
	    add(button);

	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JTextField getField() {
		return field;
	}

	public void setField(JTextField field) {
		this.field = field;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}
	
	

}
