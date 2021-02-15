package commands;

import model.Document;
import model.Project;

public class PasteDocumentCommand extends AbstractCommand{
	
	Project project;
	Document document;
	Document docToCopy;
	
	public PasteDocumentCommand(Project project,Document docToCopy,Document document) {
		this.project=project;
		this.docToCopy=docToCopy;
		this.document=document;
	}

	@Override
	public void doCommand() {
		System.out.println("Projekat treba da bude selektovan da bi se dogodio undo/redo");
		this.document = new Document(project);
		project.addDocument(document);
		for(int i=0; i<docToCopy.getPageCount(); i++) {
			document.addPage(docToCopy.getPage(i).clone(document));
		}
	}

	@Override
	public void undoCommand() {
		System.out.println("Potrebno je selektovati projakt -> undo");
		project.deleteDocument(document);
	}

}
