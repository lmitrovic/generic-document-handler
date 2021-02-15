package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class TileHorizontallyDocument extends AbstractGeRuDok {
	
	public TileHorizontallyDocument() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("gui_icons/tile_horizontally.png"));
		putValue(NAME, "Tile Horizontally");
		putValue(SHORT_DESCRIPTION, "Tile Horizontally");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
