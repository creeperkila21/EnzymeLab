package me.jordan.enzymelab.frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import me.jordan.enzymelab.components.SubstrateComponent;
import me.jordan.enzymelab.images.Images;
import me.jordan.enzymelab.utils.Utils;

public class EnzymeFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private JButton closeButton;
	private JPanel dragPane;
	private Point initialClick;
	private JScrollPane pane;
	private SubstrateComponent firstComponent;
	private SubstrateComponent secondComponent;
	private SubstrateComponent thirdComponent;
	private SubstrateComponent fourthComponent;
	private SubstrateComponent fifthComponent;
	private JLayeredPane layer;
	private JButton image;
	
	public EnzymeFrame(){
		initComponents();
	}
	
	@Override
	public void paint(Graphics g){
		//g.drawImage(Images.baseImage, 0, 0, null);
		image.repaint();
		closeButton.repaint();
		firstComponent.repaint();
		pane.repaint();
	}
	
	public void initComponents(){
		
		image = new JButton();
		image.setSize(1010, 710);
		image.setIcon(new ImageIcon(Images.baseImage));
		image.setLocation(0, 0);
		image.setBorderPainted(false);
		image.setContentAreaFilled(false);
		image.setFocusPainted(false);
		
		layer = new JLayeredPane();
		layer.setSize(1010, 710);
		layer.setLayout(null);
		
		firstComponent = new SubstrateComponent(this, "first", Utils.getImage("firstSubstrate.png"), 483, 517);
		secondComponent = new SubstrateComponent(this, "second", Utils.getImage("secondSubstrate.png"), 567, 517);
		thirdComponent = new SubstrateComponent(this, "third", Utils.getImage("thirdSubstrate.png"), 645, 517);
		fourthComponent = new SubstrateComponent(this, "fourth", Utils.getImage("fourthSubstrate.png"), 721, 517);
		fifthComponent = new SubstrateComponent(this, "fifth", Utils.getImage("fifthSubstrate.png"), 792, 517);
		
		JTextArea text = new JTextArea();
		text.setEditable(false);
		text.setHighlighter(null);
		text.setSize(250, 480);
		text.setBackground(new Color(243, 249, 239));
		try {
			Utils.loadInfo(text);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pane = new JScrollPane(text);
		pane.setBorder(null);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setBackground(new Color(243, 249, 239));
		pane.setSize(250, 480);
		pane.getVerticalScrollBar().setBorder(null);
		pane.setLocation(27, 148);
		
		dragPane = new JPanel();
		dragPane.setSize(950, 50);
		
	    dragPane.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	            initialClick = e.getPoint();
	            getComponentAt(initialClick);
	        }
	    });

	    dragPane.addMouseMotionListener(new MouseMotionAdapter() {
	        @Override
	        public void mouseDragged(MouseEvent e) {
	            int thisX = getLocation().x;
	            int thisY = getLocation().y;

	            int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
	            int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

	            int X = thisX + xMoved;
	            int Y = thisY + yMoved;
	            setLocation(X, Y);
	        }
	    });
		
		closeButton = new JButton();
		closeButton.setVisible(true);
		closeButton.setSize(28, 28);
		closeButton.setBackground(new Color(200, 232, 175));
		closeButton.setIcon(new ImageIcon(Utils.getImage("CloseButton.png")));
		closeButton.setRolloverEnabled(true);
		closeButton.setRolloverIcon(new ImageIcon(Utils.getImage("CloseButtonHover.png")));
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setLocation(970, 10);
		closeButton.paintComponents(getGraphics());
		closeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		dragPane.setOpaque(false);
		dragPane.setLayout(null);
		layer.add(dragPane, 2);
		layer.add(closeButton, 2);
		layer.add(pane, 2);
		layer.add(firstComponent, 1);
		layer.add(secondComponent, 1);
		layer.add(thirdComponent, 1);
		layer.add(fourthComponent, 1);
		layer.add(fifthComponent, 1);
		layer.add(image, 20);
		add(layer);
	}
	
}
