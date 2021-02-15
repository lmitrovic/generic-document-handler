package actions;



public class ActionManager {

	private NewProject newProjectAction;
	private NewDocument  newDocumentAction;
	private NewPage newPageAction;
	private NewNode newNodeAction;
	
	private OpenNode openNodeAction;
	private OpenProject openProjectAction;
	private OpenWorkspace openWorkspaceAction;
	
	private SaveProject saveProjectAction;
	private SaveAsProject saveAsProjectAction;
	private SaveAsWorkspace saveAsWorkspaceAction;
	private SaveWs saveWsAction;
	
	private RenameNode renameNodeAction;
	
	private CloseAllDocument closeAllDocumentAction;
	private CloseDocument closeDocumentAction;
	private CloseProject closeProjectAction;
	
	private DeleteNode deleteNodeAction;
	
	private PCircle circleAction;
	private PRectangle rectangleAction;
	private PSelect selectAction;
	private PTriangle triangleAction;
	private PRotate rotateAction;
	private PResize resizeAction;
	
	private DeletePageElement deleteElement;
	
	private DragAndDrop dragAndDrop;
	
	private OCut cutAction;
	private OCopy copyAction;
	private OPaste pasteAction;

	private Redo redoAction;
	private Undo undoAction;
	
	private Import importAction;
	private Export exportAction;
	
	private RecycleDocuments recycleDocumentsAction;
	
	
	public ActionManager(){
		initialiseActions();
	}

	private void initialiseActions() {
     
		newProjectAction=new NewProject();
		newDocumentAction=new NewDocument();
		newPageAction=new NewPage();
		newNodeAction=new NewNode();
		
		openNodeAction=new OpenNode();
		openProjectAction = new OpenProject();
		openWorkspaceAction = new OpenWorkspace();
		
		saveProjectAction = new SaveProject();
		saveAsProjectAction = new SaveAsProject();
		saveAsWorkspaceAction=new SaveAsWorkspace();
		saveWsAction=new SaveWs();
		
		renameNodeAction=new RenameNode();
	
		closeAllDocumentAction=new CloseAllDocument();
		closeDocumentAction=new CloseDocument();
		closeProjectAction=new CloseProject();
		
		deleteNodeAction=new DeleteNode();

		circleAction = new PCircle();
		rectangleAction = new PRectangle();
		selectAction = new PSelect();
		triangleAction = new PTriangle();
		rotateAction = new PRotate();
		resizeAction = new PResize();
		deleteElement = new DeletePageElement();
		dragAndDrop = new DragAndDrop();
		
		cutAction = new OCut();
		copyAction = new OCopy();
		pasteAction = new OPaste();
		
		undoAction = new Undo();
		redoAction = new Redo();
		
		importAction = new Import();
		exportAction = new Export();
		
		recycleDocumentsAction = new RecycleDocuments();
		
	}
	
	
	
	
	public RecycleDocuments getRecycleDocumentsAction() {
		return recycleDocumentsAction;
	}

	public void setRecycleDocumentsAction(RecycleDocuments recycleDocumentsAction) {
		this.recycleDocumentsAction = recycleDocumentsAction;
	}

	public Import getImportAction() {
		return importAction;
	}

	public void setImportAction(Import importAction) {
		this.importAction = importAction;
	}

	public Export getExportAction() {
		return exportAction;
	}

	public void setExportAction(Export exportAction) {
		this.exportAction = exportAction;
	}

	public OCut getCutAction() {
		return cutAction;
	}

	public void setCutAction(OCut cutAction) {
		this.cutAction = cutAction;
	}

	public OCopy getCopyAction() {
		return copyAction;
	}

	public void setCopyAction(OCopy copyAction) {
		this.copyAction = copyAction;
	}

	public OPaste getPasteAction() {
		return pasteAction;
	}

	public void setPasteAction(OPaste pasteAction) {
		this.pasteAction = pasteAction;
	}

	public Redo getRedoAction() {
		return redoAction;
	}

	public void setRedoAction(Redo redoAction) {
		this.redoAction = redoAction;
	}

	public Undo getUndoAction() {
		return undoAction;
	}

	public void setUndoAction(Undo undoAction) {
		this.undoAction = undoAction;
	}

	public void setSaveAsWorkspaceAction(SaveAsWorkspace saveAsWorkspaceAction) {
		this.saveAsWorkspaceAction = saveAsWorkspaceAction;
	}

	public DragAndDrop getDragAndDrop() {
		return dragAndDrop;
	}
	public void setDragAndDrop(DragAndDrop dragAndDrop) {
		this.dragAndDrop = dragAndDrop;
	}
	
	public DeletePageElement getDeleteElement() {
		return deleteElement;
	}
	public void setDeleteElement(DeletePageElement deleteElement) {
		this.deleteElement = deleteElement;
	}
	
	public PResize getResizeAction() {
		return resizeAction;
	}
	
	public void setResizeAction(PResize resizeAction) {
		this.resizeAction = resizeAction;
	}
	
	public PRotate getRotateAction() {
		return rotateAction;
	}
	
	public void setRotateAction(PRotate rotateAction) {
		this.rotateAction = rotateAction;
	}
	
	public SaveWs getSaveWsAction() {
		return saveWsAction;
	}
	public void setSaveWsAction(SaveWs saveWsAction) {
		this.saveWsAction = saveWsAction;
	}
	
	public OpenWorkspace getOpenWorkspaceAction() {
		return openWorkspaceAction;
	}
	
	public void setOpenWorkspaceAction(OpenWorkspace openWorkspaceAction) {
		this.openWorkspaceAction = openWorkspaceAction;
	}

	public OpenProject getOpenProjectAction() {
		return openProjectAction;
	}

	public void setOpenProjectAction(OpenProject openProjectAction) {
		this.openProjectAction = openProjectAction;
	}

	public SaveProject getSaveProjectAction() {
		return saveProjectAction;
	}

	public void setSaveProjectAction(SaveProject saveProjectAction) {
		this.saveProjectAction = saveProjectAction;
	}

	public SaveAsProject getSaveAsProjectAction() {
		return saveAsProjectAction;
	}
	
	public SaveAsWorkspace getSaveAsWorkspaceAction() {
		return saveAsWorkspaceAction;
	}
	
	public void setSaveWorkspaceAction(SaveAsWorkspace saveWorkspaceAction) {
		this.saveAsWorkspaceAction = saveWorkspaceAction;
	}
	
	public PCircle getCircleAction() {
		return circleAction;
	}

	public void setCircleAction(PCircle circleAction) {
		this.circleAction = circleAction;
	}

	public PRectangle getRectangleAction() {
		return rectangleAction;
	}

	public void setRectangleAction(PRectangle rectangleAction) {
		this.rectangleAction = rectangleAction;
	}

	public PSelect getSelectAction() {
		return selectAction;
	}

	public void setSelectAction(PSelect selectAction) {
		this.selectAction = selectAction;
	}

	public PTriangle getTriangleAction() {
		return triangleAction;
	}

	public void setTriangleAction(PTriangle triangleAction) {
		this.triangleAction = triangleAction;
	}

	public void setSaveAsProjectAction(SaveAsProject saveAsProjectAction) {
		this.saveAsProjectAction = saveAsProjectAction;
	}

	public NewProject getNewProjectAction() {
		return newProjectAction;
	}

	public void setNewProjectAction(NewProject newProjectAction) {
		this.newProjectAction = newProjectAction;
	}

	public NewDocument getNewDocumentAction() {
		return newDocumentAction;
	}

	public void setNewDocumentAction(NewDocument newDocumentAction) {
		this.newDocumentAction = newDocumentAction;
	}

	public NewPage getNewPageAction() {
		return newPageAction;
	}

	public void setNewPageAction(NewPage newPageAction) {
		this.newPageAction = newPageAction;
	}

	public NewNode getNewNodeAction() {
		return newNodeAction;
	}

	public void setNewNodeAction(NewNode newNodeAction) {
		this.newNodeAction = newNodeAction;
	}

	public OpenNode getOpenNodeAction() {
		return openNodeAction;
	}

	public void setOpenNodeAction(OpenNode openNodeAction) {
		this.openNodeAction = openNodeAction;
	}

	public RenameNode getRenameNodeAction() {
		return renameNodeAction;
	}

	public void setRenameNodeAction(RenameNode renameNodeAction) {
		this.renameNodeAction = renameNodeAction;
	}

	public CloseAllDocument getCloseAllDocumentAction() {
		return closeAllDocumentAction;
	}

	public void setCloseAllDocumentAction(CloseAllDocument closeAllDocumentAction) {
		this.closeAllDocumentAction = closeAllDocumentAction;
	}

	public CloseDocument getCloseDocumentAction() {
		return closeDocumentAction;
	}

	public void setCloseDocumentAction(CloseDocument closeDocumentAction) {
		this.closeDocumentAction = closeDocumentAction;
	}

	public CloseProject getCloseProjectAction() {
		return closeProjectAction;
	}

	public void setCloseProjectAction(CloseProject closeProjectAction) {
		this.closeProjectAction = closeProjectAction;
	}

	public DeleteNode getDeleteNodeAction() {
		return deleteNodeAction;
	}

	public void setDeleteNodeAction(DeleteNode deleteNodeAction) {
		this.deleteNodeAction = deleteNodeAction;
	}
	
	

	
}
