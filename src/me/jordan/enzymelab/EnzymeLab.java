package me.jordan.enzymelab;

import java.awt.Image;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import me.jordan.enzymelab.frame.EnzymeFrame;
import me.jordan.enzymelab.tube.Tube;
import me.jordan.enzymelab.utils.Utils;

public class EnzymeLab {

	public static int currentPh = 7;
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public static Tube tube1 = new Tube("1", 540, 344, 559, 454, 540, 402);
	public static Tube tube2 = new Tube("2", 586, 344, 606, 454, 586, 402);
	public static Tube tube3 = new Tube("3", 634, 344, 654, 454, 634, 402);
	public static Tube tube4 = new Tube("4", 684, 344, 704, 454, 684, 402);
	public static Tube tube5 = new Tube("5", 732, 344, 752, 454, 732, 402);
	
	public static List<Tube> allTubes = new ArrayList<Tube>();
	
	public static void main(String[] args){
		allTubes.add(tube1);
		allTubes.add(tube2);
		allTubes.add(tube3);
		allTubes.add(tube4);
		allTubes.add(tube5);
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
		frame.setIconImage(Utils.getImage("logo.png"));
		frame.setVisible(true);
		
		if(OS.indexOf("mac") != -1){
		    setImage(Utils.getImage("logo.png"));
		}
	}
	
	public void setImage(Image image){
		try {
		    String className = "com.apple.eawt.Application";
		    Class<?> cls = Class.forName(className);
		    Object application = cls.newInstance().getClass().getMethod("getApplication").invoke(null);
		    application.getClass().getMethod("setDockIconImage", java.awt.Image.class)
		        .invoke(application, image);
		}
		catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException
		        | InvocationTargetException | NoSuchMethodException | SecurityException
		        | InstantiationException e) {
		    e.printStackTrace();
		}
	}
	
}
