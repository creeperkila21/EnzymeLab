package me.jordan.enzymelab.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTextArea;

import me.jordan.enzymelab.EnzymeLab;

public class Utils {

	public static BufferedImage getImage(String name){
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(EnzymeLab.class.getResourceAsStream("/resources/" + name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return img;
	}
	
	@SuppressWarnings("resource")
	public static void loadInfo(JTextArea text) throws IOException{
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(EnzymeLab.class.getResource("/resources/SideText.txt").getFile())));
			
			String line = in.readLine();
			
			while(line != null){
				text.append(line + "\n");
				line = in.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
