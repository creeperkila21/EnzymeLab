package me.jordan.enzymelab;

import javax.swing.JFrame;

import me.jordan.enzymelab.frame.EnzymeFrame;
import me.jordan.enzymelab.tube.Tube;

public class EnzymeLab {

	public static double currentTemperature = 37;
	public static Tube tube1 = new Tube();
	public static Tube tube2 = new Tube();
	public static Tube tube3 = new Tube();
	public static Tube tube4 = new Tube();
	public static Tube tube5 = new Tube();
	
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
