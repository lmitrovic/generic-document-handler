package gui_delete;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeleteDialog extends JDialog{
	
	JLabel label;
	JButton buttonDelete;
	JButton buttonAddToProj;
	JButton buttonRecycle;
	JPanel panel1;
    JPanel panel;
	
	public DeleteDialog() {
		setLayout(new BorderLayout());
		setSize(600,150);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Deleting documents of this project...");
		
		this.panel1 = new JPanel(new FlowLayout());
		this.label = new JLabel("What do you want to do with documents of this project?");
		label.setSize(new Dimension(70,20));
		panel1.add(label);
        add(panel1, BorderLayout.NORTH);
		
        this.panel = new JPanel(new FlowLayout());
		this.buttonDelete = new JButton("Just delete");
		panel.add(buttonDelete);
		this.buttonAddToProj = new JButton("Add them in another project");
		panel.add(buttonAddToProj);
		this.buttonRecycle = new JButton("Transfer them in recycle bin");
		panel.add(buttonRecycle);
		panel.setVisible(true);
		
		add(panel, BorderLayout.CENTER);
	
	}
	
	public JButton getButtonAddToProj() {
		return buttonAddToProj;
	}
	
	public JButton getButtonDelete() {
		return buttonDelete;
	}
	
	public JButton getButtonRecycle() {
		return buttonRecycle;
	}
	

}
