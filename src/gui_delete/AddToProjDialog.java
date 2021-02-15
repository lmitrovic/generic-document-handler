package gui_delete;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import gui.MainFrame;
import model.Document;
import model.Page;
import model.Project;
import model.Workspace;

public class AddToProjDialog extends JDialog {
	
	JLabel label;
	List<Document> documents = new ArrayList<Document>();
	List<Project> projects = new ArrayList<Project>();
    JPanel panel1;
    JPanel panel2;
    List<JButton> buttons = new ArrayList<JButton>();
	
	public AddToProjDialog(ArrayList<Document> documents) {
		setLayout(new BorderLayout());
		setSize(600,150);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Transfering documents in project...");
	
		Workspace w =  (Workspace) MainFrame.getInstance().getTree().getModel().getRoot();
		this.projects = w.getProjects();
		
		
		this.panel1 = new JPanel(new FlowLayout());
		this.label = new JLabel("Choose a project for documents: ");
		label.setSize(new Dimension(70,20));
		panel1.add(label);
        add(panel1, BorderLayout.NORTH);

				
		this.panel2 = new JPanel(new FlowLayout());
		for(int i=0; i<projects.size(); i++) {
			Project p = projects.get(i);
			if (p.getName()!="RECYCLE BIN") {
			JButton button = new JButton(p.getName());
			panel2.add(button);
			button.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					
					for(int j=0; j<documents.size(); j++) {
						if(!(documents.get(j).isShared())) {
							Document d = documents.get(j).clone(p);
							p.addDocument(d);
							for(int i=0; i<documents.get(j).getPageCount(); i++) {
								d.addPage(documents.get(j).getPage(i).clone(d));
							}							
						}
						else {
							//ako je shared doc vec u projektu, besmisleno je dodavati ga ponovo
							if(p.getDocuments().contains(documents.get(j)))
								continue;
							
							//ako nije, nalazi se u nekom drugom projektu
							//zato moraju biti sinhronizovani
							else {
								Document d = documents.get(j);
								d.addObserver(p);
								d.addParent(p);
								p.addDocument(d);
								
								List<Page> duplicatePages = new ArrayList<Page>();
								for(Page p : d.getPages())
									duplicatePages.add(p);
								
								for(Page p : duplicatePages)
									d.deletePage(p);
								
								for(Page p : duplicatePages)
									d.addPage(p);

							}
						}

					}
					
					SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
					setVisible(false);
				}
			
				
				@Override
				public void mouseExited(MouseEvent e) {}
				
				@Override
				public void mouseEntered(MouseEvent e) {}
				
				@Override
				public void mouseClicked(MouseEvent e) {}
			});
		}
		add(panel2, BorderLayout.CENTER);
		
	}
	}

}
