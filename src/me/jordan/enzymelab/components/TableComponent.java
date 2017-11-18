package me.jordan.enzymelab.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import me.jordan.enzymelab.utils.Utils;

public class TableComponent {

	private JLayeredPane pane;
	private JButton closeButton;
	private JLabel backgroundImage;
	private JLabel sub1, sub2, sub3, sub4, sub5;
	private JLabel p1, p2, p3, p4, p5;
	private int x = 311, y = 91;

	public TableComponent(JLayeredPane pane){
		this.setPane(pane);
		
		closeButton = new JButton();
		closeButton.setIcon(new ImageIcon(Utils.getImage("TB.png")));
		closeButton.setRolloverEnabled(true);
		closeButton.setRolloverIcon(new ImageIcon(Utils.getImage("HoverCloseTB.png")));
		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setSize(21, 19);
		closeButton.setLocation(490 + x, 3 + y);
		closeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
		closeButton.setVisible(false);
		
		backgroundImage = new JLabel();
		backgroundImage.setIcon(new ImageIcon(Utils.getImage("table.png")));
		backgroundImage.setBorder(null);
		backgroundImage.setLocation(x, y);
		backgroundImage.setSize(515, 150);
		backgroundImage.setVisible(false);
		
		sub1 = new JLabel("0");
		sub1.setLocation(121 + x, 50 + y);
		sub1.setSize(119, 19);
		sub1.setHorizontalAlignment(JLabel.CENTER);
		sub1.setVerticalAlignment(JLabel.CENTER);
		sub1.setVisible(false);
		
		sub2 = new JLabel("0");
		sub2.setLocation(121 + x, 70 + y);
		sub2.setSize(119, 19);
		sub2.setHorizontalAlignment(JLabel.CENTER);
		sub2.setVerticalAlignment(JLabel.CENTER);
		sub2.setVisible(false);
		
		sub3 = new JLabel("0");
		sub3.setLocation(121 + x, 90 + y);
		sub3.setSize(119, 19);
		sub3.setHorizontalAlignment(JLabel.CENTER);
		sub3.setVerticalAlignment(JLabel.CENTER);
		sub3.setVisible(false);
		
		sub4 = new JLabel("0");
		sub4.setLocation(121 + x, 110 + y);
		sub4.setSize(119, 19);
		sub4.setHorizontalAlignment(JLabel.CENTER);
		sub4.setVerticalAlignment(JLabel.CENTER);
		sub4.setVisible(false);
		
		sub5 = new JLabel("0");
		sub5.setLocation(121 + x, 129 + y);
		sub5.setSize(119, 19);
		sub5.setHorizontalAlignment(JLabel.CENTER);
		sub5.setVerticalAlignment(JLabel.CENTER);
		sub5.setVisible(false);
		
		p1 = new JLabel("0");
		p1.setLocation(241 + x, 50 + y);
		p1.setSize(272, 19);
		p1.setHorizontalAlignment(JLabel.CENTER);
		p1.setVerticalAlignment(JLabel.CENTER);
		p1.setVisible(false);
		
		p2 = new JLabel("0");
		p2.setLocation(241 + x, 70 + y);
		p2.setSize(272, 19);
		p2.setHorizontalAlignment(JLabel.CENTER);
		p2.setVerticalAlignment(JLabel.CENTER);
		p2.setVisible(false);
		
		p3 = new JLabel("0");
		p3.setLocation(241 + x, 89 + y);
		p3.setSize(272, 19);
		p3.setHorizontalAlignment(JLabel.CENTER);
		p3.setVerticalAlignment(JLabel.CENTER);
		p3.setVisible(false);
		
		p4 = new JLabel("0");
		p4.setLocation(241 + x, 110 + y);
		p4.setSize(272, 19);
		p4.setHorizontalAlignment(JLabel.CENTER);
		p4.setVerticalAlignment(JLabel.CENTER);
		p4.setVisible(false);
		
		p5 = new JLabel("0");
		p5.setLocation(241 + x, 130 + y);
		p5.setSize(272, 19);
		p5.setHorizontalAlignment(JLabel.CENTER);
		p5.setVerticalAlignment(JLabel.CENTER);
		p5.setVisible(false);
		
		pane.add(closeButton, 2);
		pane.add(sub1, 2);
		pane.add(sub2, 2);
		pane.add(sub3, 2);
		pane.add(sub4, 2);
		pane.add(sub5, 2);
		pane.add(p1, 2);
		pane.add(p2, 2);
		pane.add(p3, 2);
		pane.add(p4, 2);
		pane.add(p5, 2);
		pane.add(backgroundImage, 15);
	}
	
	public void setVisible(boolean t){
		
		if(t == false){
			closeButton.setVisible(false);
			sub1.setVisible(false);
			sub2.setVisible(false);
			sub3.setVisible(false);
			sub4.setVisible(false);
			sub5.setVisible(false);
			p1.setVisible(false);
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(false);
			p5.setVisible(false);
			backgroundImage.setVisible(false);
		}else{
			closeButton.setVisible(true);
			sub1.setVisible(true);
			sub2.setVisible(true);
			sub3.setVisible(true);
			sub4.setVisible(true);
			sub5.setVisible(true);
			p1.setVisible(true);
			p2.setVisible(true);
			p3.setVisible(true);
			p4.setVisible(true);
			p5.setVisible(true);
			backgroundImage.setVisible(true);
		}
		
	}

	public void reset(){
		sub1.setText("0");
		sub2.setText("0");
		sub3.setText("0");
		sub4.setText("0");
		sub5.setText("0");
		p1.setText("0");
		p2.setText("0");
		p3.setText("0");
		p4.setText("0");
		p5.setText("0");
	}
	
	public JLayeredPane getPane() {
		return pane;
	}

	public void setPane(JLayeredPane pane) {
		this.pane = pane;
	}

	public JButton getCloseButton() {
		return closeButton;
	}

	public void setCloseButton(JButton closeButton) {
		this.closeButton = closeButton;
	}

	public JLabel getSub1() {
		return sub1;
	}

	public void setSub1(JLabel sub1) {
		this.sub1 = sub1;
	}

	public JLabel getSub2() {
		return sub2;
	}

	public void setSub2(JLabel sub2) {
		this.sub2 = sub2;
	}

	public JLabel getSub3() {
		return sub3;
	}

	public void setSub3(JLabel sub3) {
		this.sub3 = sub3;
	}

	public JLabel getSub4() {
		return sub4;
	}

	public void setSub4(JLabel sub4) {
		this.sub4 = sub4;
	}

	public JLabel getSub5() {
		return sub5;
	}

	public void setSub5(JLabel sub5) {
		this.sub5 = sub5;
	}

	public JLabel getP1() {
		return p1;
	}

	public void setP1(JLabel p1) {
		this.p1 = p1;
	}

	public JLabel getP2() {
		return p2;
	}

	public void setP2(JLabel p2) {
		this.p2 = p2;
	}

	public JLabel getP3() {
		return p3;
	}

	public void setP3(JLabel p3) {
		this.p3 = p3;
	}

	public JLabel getP4() {
		return p4;
	}

	public void setP4(JLabel p4) {
		this.p4 = p4;
	}

	public JLabel getP5() {
		return p5;
	}

	public void setP5(JLabel p5) {
		this.p5 = p5;
	}
	
}

