package me.jordan.enzymelab;

import javax.swing.JFrame;

import me.jordan.enzymelab.frame.EnzymeFrame;

public class EnzymeLab {

	public static void main(String[] args){
		new EnzymeLab();
	}
	
	private EnzymeFrame frame;
	
	public EnzymeLab(){
		frame = new EnzymeFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1010, 710);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	
}
