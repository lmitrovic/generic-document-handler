package gui_editor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.text.StyledEditorKit;

import page_elements.PageElement;

public class TextEditorMenubar extends JMenuBar{
	
	PageElement element;
	
	public TextEditorMenubar(PageElement element) {
		this.element = element;
	 
		setBackground(Color.WHITE);
		
		JMenu size=new JMenu("Font Size");
		size.setIcon(new ImageIcon("images/font_size.png"));
		
		JMenuItem i10= new JMenuItem("10");
		JMenuItem i12= new JMenuItem("12");
		JMenuItem i14= new JMenuItem("14");
		JMenuItem i16= new JMenuItem("16");
		JMenuItem i18= new JMenuItem("18");
		JMenuItem i20 = new JMenuItem("20");
		JMenuItem i22 = new JMenuItem("22");
		JMenuItem i24 = new JMenuItem("24");
		JMenuItem i26 = new JMenuItem("26");
		JMenuItem i28 = new JMenuItem("28");
		JMenuItem i30 = new JMenuItem("30");
		size.add(i10);
		size.add(i12);
		size.add(i14);
		size.add(i16);
		size.add(i18);
		size.add(i20);
		size.add(i22);
		size.add(i24);
		size.add(i26);
		size.add(i28);
		size.add(i30);
		
	     add(size);
		 
	     i10.addActionListener(new StyledEditorKit.FontSizeAction(element.getTextArea().getSelectedText(), 10));
		 i12.addActionListener(new StyledEditorKit.FontSizeAction(element.getTextArea().getSelectedText(), 12));
		 i14.addActionListener(new StyledEditorKit.FontSizeAction(element.getTextArea().getSelectedText(), 14));
		 i16.addActionListener(new StyledEditorKit.FontSizeAction(element.getTextArea().getSelectedText(), 16));
		 i18.addActionListener(new StyledEditorKit.FontSizeAction(element.getTextArea().getSelectedText(), 18));
		 i20.addActionListener(new StyledEditorKit.FontSizeAction(element.getTextArea().getSelectedText(), 20));
		 i22.addActionListener(new StyledEditorKit.FontSizeAction(element.getTextArea().getSelectedText(), 22));
		 i24.addActionListener(new StyledEditorKit.FontSizeAction(element.getTextArea().getSelectedText(), 24));
		 i26.addActionListener(new StyledEditorKit.FontSizeAction(element.getTextArea().getSelectedText(), 26));
		 i28.addActionListener(new StyledEditorKit.FontSizeAction(element.getTextArea().getSelectedText(), 28));
		 i30.addActionListener(new StyledEditorKit.FontSizeAction(element.getTextArea().getSelectedText(), 30));
		 
		 
		 
		JMenu color=new JMenu("Font Color");
		color.setIcon(new ImageIcon("images/color.png"));
		
		JMenuItem black= new JMenuItem("Black");
		JMenuItem red= new JMenuItem("Red");
		JMenuItem blue= new JMenuItem("Blue");
		JMenuItem green= new JMenuItem("Green");
		JMenuItem yellow= new JMenuItem("Yellow");
		JMenuItem orange= new JMenuItem("Orange");
		JMenuItem pink= new JMenuItem("Pink");


		color.add(black);
		color.add(red);
		color.add(blue);
		color.add(green);
		color.add(yellow);
		color.add(orange);
		color.add(pink);

		add(color);
		
		black.addActionListener(new StyledEditorKit.ForegroundAction(element.getTextArea().getSelectedText(), Color.BLACK));
		red.addActionListener(new StyledEditorKit.ForegroundAction(element.getTextArea().getSelectedText(), Color.RED));
		blue.addActionListener(new StyledEditorKit.ForegroundAction(element.getTextArea().getSelectedText(), Color.BLUE));
		green.addActionListener(new StyledEditorKit.ForegroundAction(element.getTextArea().getSelectedText(), Color.GREEN));
		yellow.addActionListener(new StyledEditorKit.ForegroundAction(element.getTextArea().getSelectedText(), Color.YELLOW));
		orange.addActionListener(new StyledEditorKit.ForegroundAction(element.getTextArea().getSelectedText(), Color.ORANGE));
		pink.addActionListener(new StyledEditorKit.ForegroundAction(element.getTextArea().getSelectedText(), Color.PINK));
		
		
		JMenu fontS = new JMenu("Font Style");
		fontS.setIcon(new ImageIcon("images/font_style.png"));
		
		JMenuItem f1 = new JMenuItem("Dialog (Default)");
		JMenuItem f2 = new JMenuItem("Times Roman");
		JMenuItem f3 = new JMenuItem("Courier");
		JMenuItem f4 = new JMenuItem("Algerian");
		JMenuItem f5 = new JMenuItem("Calibri");
		JMenuItem f6 = new JMenuItem("Arial");
		JMenuItem f7 = new JMenuItem("Gigi");

		f1.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
		Font font = new Font("Dialog", Font.PLAIN,element.getTextArea().getFont().getSize());
		element.getTextArea().setFont(font);
		}
		});
		f2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		       Font f = new Font("TimesRoman", Font.PLAIN, element.getTextArea().getFont().getSize());
		element.getTextArea().setFont(f);

		}
		});
		        f3.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		Font font = new Font("Courier", Font.PLAIN,element.getTextArea().getFont().getSize());
		element.getTextArea().setFont(font);
		}
		});
		        f4.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		Font font = new Font("Algerian", Font.PLAIN,element.getTextArea().getFont().getSize());
		element.getTextArea().setFont(font);
		}
		});
		        f5.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		Font font = new Font("Calibri", Font.PLAIN,element.getTextArea().getFont().getSize());
		element.getTextArea().setFont(font);
		}
		});
		        f6.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		Font font = new Font("Arial", Font.PLAIN,element.getTextArea().getFont().getSize());
		element.getTextArea().setFont(font);
		}
		});
		        f7.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		Font font = new Font("Gigi", Font.PLAIN,element.getTextArea().getFont().getSize());
		element.getTextArea().setFont(font);
		}
		});
		       
		fontS.add(f1);
		fontS.add(f2);
		fontS.add(f3);
		fontS.add(f4);
		fontS.add(f5);
		fontS.add(f6);
		fontS.add(f7);
		
		add(fontS);

	}

}
