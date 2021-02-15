package gui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import page_elements.PageElement;

public class ImageEditor {
	
    private JFrame j;
    private JPanel jpanel;
    JLabel image;
    Image img;
    PageElement element;

    public ImageEditor(PageElement element) {
    	this.element=element;
        j = new JFrame("Image Editor");
        j.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        j.setLocationByPlatform(true);
        j.setLayout(new BorderLayout());

        jpanel = new JPanel();
        jpanel.setLayout(new BorderLayout());
        image = new JLabel(" ");
        jpanel.add(image, BorderLayout.CENTER);
        j.add(jpanel, BorderLayout.CENTER);
        
        JButton btn = new JButton("CHOOSE IMAGE");
        j.add(btn, BorderLayout.NORTH);
        
       if (element.getLabel()!=null) image.setIcon(element.getLabel().getIcon());

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    try {
                    	Image im = ImageIO.read(file);
                    	im= im.getScaledInstance(image.getWidth(), image.getHeight(),Image.SCALE_AREA_AVERAGING);
                        image.setIcon(new ImageIcon(im));
                        element.setLabel(image);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        j.setResizable(true);
        j.setVisible(true);
        j.setSize(800, 500);
		j.setLocationRelativeTo(null);

    }

  
}