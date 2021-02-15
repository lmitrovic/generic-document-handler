package clipboard;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import model.Document;

public class DocumentSelection implements Transferable, ClipboardOwner{

	static public DataFlavor elementFlavor;
	private DataFlavor[] approvedFlavors = { elementFlavor };
    public Document document;
    
    
	public DocumentSelection(Document document) {
		this.document = document;
		
		try {
			elementFlavor = new DataFlavor(Class.forName("model.Document"),"Document");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	
	@Override
	public void lostOwnership(Clipboard arg0, Transferable arg1) {
		// TODO Auto-generated method stub
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if (flavor.equals(elementFlavor))
			return (document);
		else
			throw new UnsupportedFlavorException(elementFlavor);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return (approvedFlavors); 
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		if(flavor.equals(elementFlavor))
			return true;
		return false;
	}
	
	public Document getDocument() {
		return document;
	}

}
