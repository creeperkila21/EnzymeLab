package me.jordan.enzymelab.components;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import me.jordan.enzymelab.EnzymeLab;
import me.jordan.enzymelab.frame.EnzymeFrame;
import me.jordan.enzymelab.tube.Tube;

public class SubstrateComponent extends JButton {

	private static final long serialVersionUID = 1L;

	private String name;
	private BufferedImage image;
	private volatile int screenX = 0;
	private volatile int screenY = 0;
	private volatile int myX = 0;
	private volatile int myY = 0;
	private int currentX;
	private int currentY;
	private boolean setBack = true;
	private SubstrateComponent comp;
	private EnzymeFrame frame;
	private double amount;

	public SubstrateComponent(EnzymeFrame frame, String name, BufferedImage image, int x, int y, double amount) {
		this.setAmount(amount);
		currentX = x;
		currentY = y;
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setOpaque(false);
		setLocation(x, y);
		this.comp = this;
		this.name = name;
		this.image = image;
		this.setSize(image.getWidth(), image.getHeight());
		this.setIcon(new ImageIcon(image));
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);

		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				screenX = e.getXOnScreen();
				screenY = e.getYOnScreen();

				myX = getX();
				myY = getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if(setBack){
					comp.setLocation(currentX, currentY);
				}
				
				comp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				int deltaX = e.getXOnScreen() - screenX;
				int deltaY = e.getYOnScreen() - screenY;

				setLocation(myX + deltaX, myY + deltaY);
				
				int x = (int)frame.getMousePosition().getX();
				int y = (int)frame.getMousePosition().getY();
				
				boolean contains = false;
				Tube tube = null;
				
				for(Tube t : EnzymeLab.allTubes){
					if(contains) continue;
					if(t.getamountOfSubstrate() != 0) continue;
					if(t.contains(x, y)){
						tube = t;
						contains = true;
					}
				}
				
				if(contains){
					System.out.println(tube.getName());
					comp.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}else{
					comp.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
			}

		});

	}
	
	public EnzymeFrame getFrame(){
		return frame;
	}
	
	public String getName(){
		return name;
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
