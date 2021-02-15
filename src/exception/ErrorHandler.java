package exception;

public class ErrorHandler {
	
	public static void  solve(Exception e) {
		if (e instanceof WrongNameException) new WrongNameException().showMessage();
		else if (e instanceof RenameWorkspaceException) new RenameWorkspaceException().showMessage();
		else if (e instanceof SelectedPageElementException) new SelectedPageElementException().showMessage();
		else if(e instanceof PaletteActionException) new PaletteActionException().showMessage();
		else if(e instanceof FileProjectException) new FileProjectException().showMessage();
		else if(e instanceof FileWorkspaceException) new FileWorkspaceException().showMessage();
		else if (e instanceof SaveProjectException) new SaveProjectException().showMessage();
		else if (e instanceof SaveWorkspaceException) new SaveWorkspaceException().showMessage();
		else if (e instanceof DeleteWorkspaceException) new DeleteWorkspaceException().showMessage();
		else if (e instanceof CloseProjectException) new CloseProjectException().showMessage();
		else if (e instanceof CloseDocumentException) new CloseDocumentException().showMessage();
		else if (e instanceof ImportDocumentException) new ImportDocumentException().showMessage();
		else if (e instanceof ShareDocumentException) new ShareDocumentException().showMessage();

	}

}
