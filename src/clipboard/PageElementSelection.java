package clipboard;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import page_elements.PageElement;

//klasa koja predstavlja sadrzaj clipboard-a u app
public class PageElementSelection implements Transferable, ClipboardOwner{
    
	/**pomocu klase DataFlavor opisuje se koje sve vrste podataka 
	ce biti upisivane/iscitane iz sadrzaja clipboard-a**/
	
	static public DataFlavor elementFlavor;

	//niz koji sadrzi vrste podataka koji su podrzani u CCP operacijama
	private DataFlavor[] approvedFlavors = { elementFlavor };
	
	//lista elementa koji se nalaze u clipboard-u
	public List<PageElement> pageElements;
	

	
	public PageElementSelection(ArrayList<PageElement> pageElements) {
		this.pageElements = pageElements;
		
		try {
			elementFlavor = new DataFlavor(Class.forName("java.util.ArrayList"),"PageElements");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	
	@Override
	public void lostOwnership(Clipboard arg0, Transferable arg1) {
	}

	//metoda vraca objekat koji je predmet CCP operacija 
	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if (flavor.equals(elementFlavor))
			return (pageElements);
		else
			throw new UnsupportedFlavorException(elementFlavor);
	}

	//metoda vraca niz DataFlavor objekata koji koji predstavljaju skup klasa
	//koji mogu biti sadrzani u CCP operacijama 
	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return (approvedFlavors); 
	}

	//provera za prosledjeni element, da li on moze ucestvovati u CCP operacijama
	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		if(flavor.equals(elementFlavor))
			return true;
		return false;
	}

	public List<PageElement> getPageElements() {
		return pageElements;
	}
	
}
