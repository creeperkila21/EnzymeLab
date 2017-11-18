package me.jordan.enzymelab.frame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import me.jordan.enzymelab.EnzymeLab;
import me.jordan.enzymelab.components.SubstrateComponent;
import me.jordan.enzymelab.components.TableComponent;
import me.jordan.enzymelab.components.TempSelector;
import me.jordan.enzymelab.images.Images;
import me.jordan.enzymelab.tube.Tube;
import me.jordan.enzymelab.utils.Utils;

public class EnzymeFrame extends JFrame {

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
	private JLabel image;
	public static TempSelector firstSel;
	public static TempSelector secondSel;
	public static TempSelector thirdSel;
	public static TempSelector fourthSel;
	public static TempSelector fifthSel;
	private JLabel phValue;
	private JButton calculateButton;
	public static TableComponent table;
	private JButton resetButton;
	private List<JLabel> toRemove = new ArrayList<JLabel>();

	public EnzymeFrame() {
		super("Enzyme Lab");
		initComponents();
	}

	@Override
	public void paint(Graphics g) {
		image.repaint();
		closeButton.repaint();
		for(JLabel label : toRemove){
			label.repaint();
		}
		firstComponent.repaint();
		secondComponent.repaint();
		thirdComponent.repaint();
		fourthComponent.repaint();
		fifthComponent.repaint();
		pane.repaint();
	}

	public void initComponents() {
		
		resetButton = new JButton();
		resetButton.setIcon(new ImageIcon(Utils.getImage("ResetButton.png")));
		resetButton.setRolloverEnabled(true);
		resetButton.setRolloverIcon(new ImageIcon(Utils.getImage("HoverResetButton.png")));
		resetButton.setSize(58, 25);
		resetButton.setLocation(633, 609);
		resetButton.setBorderPainted(false);
		resetButton.setFocusPainted(false);
		resetButton.setContentAreaFilled(false);
		resetButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
			
		});
		
		calculateButton = new JButton();
		calculateButton.setIcon(new ImageIcon(Utils.getImage("Computer.png")));
		calculateButton.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				calculateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				calculateButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		calculateButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				table.setVisible(true);
			}
			
		});
		calculateButton.setBorderPainted(false);
		calculateButton.setFocusPainted(false);
		calculateButton.setContentAreaFilled(false);
		calculateButton.setSize(161, 253);
		calculateButton.setLocation(290, 350);
		
		phValue = new JLabel("pH 7");
		phValue.setVerticalAlignment(JLabel.CENTER);
		phValue.setHorizontalAlignment(JLabel.CENTER);
		phValue.setLocation(783, 476);
		phValue.setSize(38, 25);

		firstSel = new TempSelector(530, 481, false);
		firstSel.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object item = e.getItem();
					
					String text = (String) item;
					
					if(text.equalsIgnoreCase("15C")){
						EnzymeLab.tube1.setTemperature(15);
					}else if(text.equalsIgnoreCase("29C")){
						EnzymeLab.tube1.setTemperature(29);
					}else if(text.equalsIgnoreCase("37C")){
						EnzymeLab.tube1.setTemperature(37);
					}else if(text.equalsIgnoreCase("45C")){
						EnzymeLab.tube1.setTemperature(45);
					}else if(text.equalsIgnoreCase("59C")){
						EnzymeLab.tube1.setTemperature(59);
					}
				}
			}

		});

		secondSel = new TempSelector(581, 481, false);
		secondSel.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object item = e.getItem();
					
					String text = (String) item;
					
					if(text.equalsIgnoreCase("15C")){
						EnzymeLab.tube2.setTemperature(15);
					}else if(text.equalsIgnoreCase("29C")){
						EnzymeLab.tube2.setTemperature(29);
					}else if(text.equalsIgnoreCase("37C")){
						EnzymeLab.tube2.setTemperature(37);
					}else if(text.equalsIgnoreCase("45C")){
						EnzymeLab.tube2.setTemperature(45);
					}else if(text.equalsIgnoreCase("59C")){
						EnzymeLab.tube2.setTemperature(59);
					}
				}
			}

		});
		thirdSel = new TempSelector(628, 481, false);
		thirdSel.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object item = e.getItem();
					
					String text = (String) item;
					
					if(text.equalsIgnoreCase("15C")){
						EnzymeLab.tube3.setTemperature(15);
					}else if(text.equalsIgnoreCase("29C")){
						EnzymeLab.tube3.setTemperature(29);
					}else if(text.equalsIgnoreCase("37C")){
						EnzymeLab.tube3.setTemperature(37);
					}else if(text.equalsIgnoreCase("45C")){
						EnzymeLab.tube3.setTemperature(45);
					}else if(text.equalsIgnoreCase("59C")){
						EnzymeLab.tube3.setTemperature(59);
					}
				}
			}

		});
		fourthSel = new TempSelector(677, 481, true);
		fourthSel.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object item = e.getItem();
					
					String text = (String) item;
					
					if(text.equalsIgnoreCase("15C")){
						EnzymeLab.tube4.setTemperature(15);
					}else if(text.equalsIgnoreCase("29C")){
						EnzymeLab.tube4.setTemperature(29);
					}else if(text.equalsIgnoreCase("37C")){
						EnzymeLab.tube4.setTemperature(37);
					}else if(text.equalsIgnoreCase("45C")){
						EnzymeLab.tube4.setTemperature(45);
					}else if(text.equalsIgnoreCase("59C")){
						EnzymeLab.tube4.setTemperature(59);
					}
				}
			}

		});
		
		fifthSel = new TempSelector(727, 481, false);

		fifthSel.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object item = e.getItem();
					
					String text = (String) item;
					
					if(text.equalsIgnoreCase("15C")){
						EnzymeLab.tube5.setTemperature(15);
					}else if(text.equalsIgnoreCase("29C")){
						EnzymeLab.tube5.setTemperature(29);
					}else if(text.equalsIgnoreCase("37C")){
						EnzymeLab.tube5.setTemperature(37);
					}else if(text.equalsIgnoreCase("45C")){
						EnzymeLab.tube5.setTemperature(45);
					}else if(text.equalsIgnoreCase("59C")){
						EnzymeLab.tube5.setTemperature(59);
					}
				}
			}

		});
		
		image = new JLabel();
		image.setSize(1010, 710);
		image.setIcon(new ImageIcon(Images.baseImage));
		image.setLocation(0, 0);

		layer = new JLayeredPane();
		layer.setSize(1010, 710);
		layer.setLayout(null);

		firstComponent = new SubstrateComponent(this, "first",
				Utils.getImage("firstSubstrate.png"), 483, 517, 0.5);
		secondComponent = new SubstrateComponent(this, "second",
				Utils.getImage("secondSubstrate.png"), 567, 517, 1.0);
		thirdComponent = new SubstrateComponent(this, "third",
				Utils.getImage("thirdSubstrate.png"), 645, 517, 2.0);
		fourthComponent = new SubstrateComponent(this, "fourth",
				Utils.getImage("fourthSubstrate.png"), 721, 517, 4.0);
		fifthComponent = new SubstrateComponent(this, "fifth",
				Utils.getImage("fifthSubstrate.png"), 792, 517, 8.0);

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
		dragPane.setCursor(new Cursor(Cursor.HAND_CURSOR));

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
		closeButton.setRolloverIcon(new ImageIcon(Utils
				.getImage("CloseButtonHover.png")));
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setLocation(970, 10);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.paintComponents(getGraphics());
		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		
		//311 91
		
		dragPane.setOpaque(false);
		dragPane.setLayout(null);
		layer.add(dragPane, 2);
		layer.add(closeButton, 2);
		layer.add(pane, 2);
		layer.add(calculateButton, 2);
		layer.add(firstComponent, 1);
		layer.add(secondComponent, 1);
		layer.add(thirdComponent, 1);
		layer.add(fourthComponent, 1);
		layer.add(fifthComponent, 1);
		layer.add(firstSel, 1);
		layer.add(secondSel, 1);
		layer.add(thirdSel, 1);
		layer.add(fourthSel, 1);
		layer.add(fifthSel, 1);
		layer.add(phValue, 2);
		layer.add(resetButton, 2);
		layer.add(image, 20);
		table = new TableComponent(layer);
		add(layer);
	}

	public JLayeredPane getLayer() {
		return layer;
	}

	@SuppressWarnings("deprecation")
	public void reset(){
		
		for(JLabel j : toRemove){
			layer.remove(j);
		}
		
		layer.repaint();
		
		table.reset();
		
		for(Tube t : EnzymeLab.allTubes){
			t.reset();
		}
		
		EnzymeFrame.firstSel.enable();
		EnzymeFrame.secondSel.enable();
		EnzymeFrame.thirdSel.enable();
		EnzymeFrame.fourthSel.enable();
		EnzymeFrame.fifthSel.enable();
		
	}
	
	public List<JLabel> getToRemove() {
		return toRemove;
	}

	public void setToRemove(List<JLabel> toRemove) {
		this.toRemove = toRemove;
	}

}
