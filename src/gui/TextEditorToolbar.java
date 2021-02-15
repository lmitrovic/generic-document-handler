package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.text.StyledEditorKit;

    public class TextEditorToolbar extends JToolBar {

	public TextEditorToolbar() {
		super(JToolBar.HORIZONTAL);
		setFloatable(false);
		setCursor(getCursor());
		JButton bold = new JButton();
        bold.setIcon(new ImageIcon("images/bold.png"));
		bold.setToolTipText("Bold Text");
		bold.addActionListener(new StyledEditorKit.BoldAction());
		add(bold);

		JButton italic = new JButton();
        italic.setIcon(new ImageIcon("images/italic.png"));
		
		italic.setToolTipText("Italic Text");
		italic.addActionListener(new StyledEditorKit.ItalicAction());
		add(italic);

		JButton underline = new JButton();
        underline.setIcon(new ImageIcon("images/underline.png"));
		underline.setToolTipText("Underline Text");
		underline.addActionListener(new StyledEditorKit.UnderlineAction());
		add(underline);
		
	}


}