package gui;

import java.awt.Color;

import javax.swing.JToolBar;

public class Palette extends JToolBar{
	
	public Palette() {
		super(JToolBar.VERTICAL);
		setBackground(Color.WHITE);
		
		add(MainFrame.getInstance().getActionManager().getSelectAction());
		
		addSeparator();
		
        add(MainFrame.getInstance().getActionManager().getDragAndDrop());
        
        addSeparator();
		
		add(MainFrame.getInstance().getActionManager().getCircleAction());
		
		addSeparator();
		
		add(MainFrame.getInstance().getActionManager().getRectangleAction());
		
		addSeparator();
		
		add(MainFrame.getInstance().getActionManager().getTriangleAction());
				
		addSeparator();
		
		add(MainFrame.getInstance().getActionManager().getResizeAction());
		
		addSeparator();
		
		add(MainFrame.getInstance().getActionManager().getRotateAction());
		
        addSeparator();
		
		add(MainFrame.getInstance().getActionManager().getDeleteElement());
		
		setFloatable(false);

	}

}
