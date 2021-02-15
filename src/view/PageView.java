package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import clipboard.PageElementSelection;
import commands.CommandManager;
import commands.DragAndDropElementCommand;
import commands.PasteElementCommand;
import gui.MainFrame;
import model.Document;
import model.Page;
import model.PageModel;
import model.Project;
import notification.NotificationType;
import page_elements.CircleElement;
import page_elements.PageElement;
import page_elements.RectangleElement;
import page_elements.TriangleElement;
import state.ResizeState;
import state.RotateState;
import state.SelectState;
import state.StateManager;
import view_painters.CirclePainter;
import view_painters.ElementPainter;
import view_painters.RectanglePainter;
import view_painters.TrianglePainter;



public class PageView  extends JPanel implements Observer {

	public static final int PAGE_HEIGHT = 385;
	public static final int PAGE_WIDTH = 595;
	
	Page page;
	String name = null;
	private Rectangle2D selectionRectangle = new Rectangle2D.Double();
	Point lastPosition=null;
	
	//PageView mediator, upravlja state-om i poziva metode  za inicijalizaciju
	private StateManager stateManager = new StateManager(this);
	private CommandManager commandManager=new CommandManager();

	
	public static final int OR=1;
	public static final int AND=2;
	public static final int INPUT=3;
	public static final int CIRCLE=4;
	public static final int RECTANGLE=5;
	public static final int TRIANGLE=6;
	
	
	public PageView(Page page) {
		this.page = page;
		this.name = page.getName();
		setPreferredSize(new Dimension(PAGE_WIDTH, PAGE_HEIGHT));
	    setBackground(Color.WHITE);
		TitledBorder border = BorderFactory.createTitledBorder(name);
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		PageController c = new PageController();
		this.addMouseListener(c);
		this.addMouseMotionListener(c);
		
	}
	
	public Page getPage() {
		return page;
	}
	
	public StateManager getStateManager() {
		return stateManager;
	}
	
	public void setStateManager(StateManager stateManager) {
		this.stateManager = stateManager;
	}

	@Override
	public void update(Observable obs, Object arg) {
		if(arg == null) return;
		Page p = (Page) arg;
		Document document = (Document)p.getParent();
//*		Project project = (Project) document.getParent();
	    Project project = (Project) document.getParents().get(0);
		project.setProjectModified(true);
		
		NotificationType type = p.getNotificationType();
		
		if(type == NotificationType.RENAME_PAGE) {
			TitledBorder border = BorderFactory.createTitledBorder(page.getName());
			border.setTitleColor(Color.BLACK);
			setBorder(border);
			
            DocumentView docView = getDocumentView();
            docView.renameMiniView(p);
		}
		
		if(type == NotificationType.NEW_PAGE_ELEMENT) 
			repaint();
		
		if(type == NotificationType.REMOVE_PAGE_ELEMENT)
			repaint();
		if(type == NotificationType.SET_DIMENSION)
			repaint();
		if(type == NotificationType.REPAINT)
			repaint();
		if(type == NotificationType.ROTATE)
			repaint();
		
		
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	}
	
	public PageModel getModel() {
		return page.getModel();
	}

	//metode za inic.
	public void startCircleState() {
		stateManager.setCircleState();
	}
	
	public void startRectangleState() {
		stateManager.setRectangleState();
	}
	
	public void startSelectState() {
		stateManager.setSelectState();
	}
	
	public void startTriangleState() {
		stateManager.setTriangleState();
	}
	
	public void startResizeState() {
		stateManager.setResizeState();
	}
	
	public void startRotateState() {
		stateManager.setRotateState();
	}
	
	public void startDragAndDropState() {
		stateManager.setDragAndDropState();
	}
	public void startDeleteState() {
		stateManager.setDeleteState();
	}
	public void startLassoState() {
		stateManager.setLassoState();
	}
		
	private class PageController extends MouseAdapter implements MouseMotionListener{
		@Override
		public void mousePressed(MouseEvent e) {
			Point p = e.getPoint();
			setLastPosition(p);
			stateManager.getCurrentState().mousePressed(e);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			   stateManager.getCurrentState().mouseReleased(e);
		}
		@Override
		public void mouseDragged(MouseEvent e ){
			   stateManager.getCurrentState().mouseDragged(e);
		}
		
	}
	
	protected void paintComponent(Graphics g) {
		this.setBackground(Color.WHITE);
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//poboljsanje kvaliteta izgleda grafike, ublazavanje ostrih ivica 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//iteratorom prolazi se kroz sve graficke elemente koje stranica sadrzi
		//i za svaki element pravi se njegov painter
		//metodi paint prosledjuje se graphics2d i elem koji treba da se iscrta
		Iterator<PageElement> it = page.getModel().getElementIterator();
		while(it.hasNext()){
			PageElement element = it.next();
			
			ElementPainter painter =  element.getElementPainter();
			painter.paint(g2, element);
		}
		g2.setPaint(Color.BLACK);
		g2.setStroke(new BasicStroke( (int)1.5 , BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, (float)1 ,
				new float[] { (float)3, (float)5 }, 0));
		g2.draw(selectionRectangle);
		if (stateManager.getCurrentState() instanceof SelectState || stateManager.getCurrentState() instanceof ResizeState)
		paintSelectRectangle(g2);

	}
	
	private void paintSelectRectangle(Graphics2D g2) {
		   
		   Iterator<PageElement> it = page.getModel().getSelectedElementIterator();
		   while (it.hasNext()) {
			 PageElement element = it.next();
		    if (element!=null) {
			Dimension dimension = new Dimension();
			dimension.setSize(element.getDimension());
			g2.setPaint(Color.BLACK);
			g2.setStroke(new BasicStroke( (int)1.5 , BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, (float)1 ,
					new float[] { (float)3, (float)5 }, 0));
			
			
			
            if (!(element instanceof TriangleElement)) 
			g2.drawRect((int) element.getPosition().getX(), (int) element.getPosition().getY(), (int) dimension.getWidth(), (int) dimension.getHeight());
            else g2.drawRect((int) element.getPosition().getX(), (int) ((int) element.getPosition().getY()-element.getDimension().getHeight()), (int) dimension.getWidth(), (int) dimension.getHeight());
           // else  g2.draw(element.getElementPainter().getShape());
           if (!(element instanceof TriangleElement))
        	   paintSelectionHandle(g2, getHandlePoint(element.getPosition(), dimension));
           else paintSelectionHandle(g2, getHandlePointTriangle(element.getPosition(), dimension));
		   }
		   }
	}
	
	private void paintSelectionHandle(Graphics2D g2, Point2D position) {
		double size = 10;
		g2.fill(new Rectangle2D.Double(position.getX() - size / 2, position.getY() - size / 2, size, size));
	}
	
	
	private Point2D getHandlePoint(Point2D topLeft, Dimension2D size) {
		double x = topLeft.getX();
		double y = topLeft.getY();
		return new Point2D.Double(x, y);
		
	}
	private Point2D getHandlePointTriangle(Point2D topLeft, Dimension2D size) {
		double x = topLeft.getX();
		double y = topLeft.getY()-size.getHeight();
		return new Point2D.Double(x, y);
		
	}
	
	public Point getLastPosition() {
		return lastPosition;
	}
	
	public void setLastPosition(Point lastPosition) {
		this.lastPosition = lastPosition;
	}
	
	public void setSelectionRectangle(Rectangle2D selectionRectangle) {
		this.selectionRectangle = selectionRectangle;
	}
	
	public Rectangle2D getSelectionRectangle() {
		return selectionRectangle;
	}
	
	public void paste(Point point) {
		System.out.println("Paste "+point);
		int c=0;
		Transferable clipboardContent = MainFrame.getInstance().getClipboard().getContents(MainFrame.getInstance());
		
		if((clipboardContent != null )&&(clipboardContent.isDataFlavorSupported(PageElementSelection.elementFlavor))) {
			try {
				PageElement element = null;
				List<PageElement> elements = (ArrayList<PageElement>) clipboardContent.getTransferData(PageElementSelection.elementFlavor);
				List<PageElement> pasted = new ArrayList<PageElement>();
				for(int i=0; i<elements.size(); i++) {
					element = elements.get(i).clone();
					element.setPosition(new Point((int)(point.getX()+c),(int)(point.getY()+c)));
                    c+=10;
                    
					if(elements.get(i) instanceof CircleElement) {				
						element.setElementPainter(new CirclePainter(element));
					}
					if(elements.get(i) instanceof TriangleElement) {
						element.setElementPainter(new TrianglePainter(element));
					}
					if(elements.get(i) instanceof RectangleElement) {
						element.setElementPainter(new RectanglePainter(element));
					}
                    pasted.add(element);
				}
				this.getCommandManager().addCommand(new PasteElementCommand(this.getModel(),pasted));

				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public CommandManager getCommandManager() {
		return commandManager;
	}
	
	public void setCommandManager(CommandManager commandManager) {
		this.commandManager = commandManager;
	}

	
	private DocumentView getDocumentView() {
		ProjectView projView = (ProjectView) MainFrame.getInstance().getWorkspaceView().getSelectedFrame();
		DocumentView docView = null;
		if (projView !=null) 
		    docView = (DocumentView) projView.getTabPane().getSelectedComponent();
       
		return docView;
	}
	
}
