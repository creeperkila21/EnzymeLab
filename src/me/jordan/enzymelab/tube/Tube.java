package me.jordan.enzymelab.tube;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import me.jordan.enzymelab.EnzymeLab;
import me.jordan.enzymelab.answers.Answers;
import me.jordan.enzymelab.frame.EnzymeFrame;
import me.jordan.enzymelab.utils.Utils;

/**
 * Jordan Cole
 * Nov 15, 2017
 * Period 2
 */

public class Tube {

	private double temperature;
	private double amountOfSubstrate;
	private int x, y, x1, y1;
	private String name;
	private int colorStartX, colorStartY;
	
	public Tube(String name, int x, int y, int x1, int y1, int colorStartX, int colorStartY){
		this.setColorStartX(colorStartX);
		this.setColorStartY(colorStartY);
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.name = name;
		amountOfSubstrate = 0;
		temperature = 15;
	}
	
	public void reset(){
		amountOfSubstrate = 0;
	}
	
	@SuppressWarnings("deprecation")
	public void init(EnzymeFrame frame){
		BufferedImage img = null;
		
		if(temperature == 37){
			img = Utils.getImage("lastBlue.png");
		}else if(temperature > 37 && temperature <= 55){
			img = Utils.getImage("thirdBlue.png");
		}else if(temperature > 55 && temperature <= 75){
			img = Utils.getImage("secondBlue.png");
		}else if(temperature > 75 && temperature < 85){
			img = Utils.getImage("firstBlue.png");
		}else if(temperature < 37 && temperature >= 20){
			img = Utils.getImage("thirdBlue.png");
		}else if(temperature < 20 && temperature >= 10){
			img = Utils.getImage("secondBlue.png");
		}else{
			img = Utils.getImage("firstBlue.png");
		}
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(img));
		label.setSize(22, 54);
		label.setLocation(colorStartX, colorStartY);
		if(name.equalsIgnoreCase("1")){
			EnzymeFrame.firstSel.disable();
		}else if(name.equalsIgnoreCase("2")){
			EnzymeFrame.secondSel.disable();
		}else if(name.equalsIgnoreCase("3")){
			EnzymeFrame.thirdSel.disable();
		}else if(name.equalsIgnoreCase("4")){
			EnzymeFrame.fourthSel.disable();
		}else if(name.equalsIgnoreCase("5")){
			EnzymeFrame.fifthSel.disable();
		}
		updateTable();
		frame.getToRemove().add(label);
		frame.getLayer().add(label, 2);
	}
	
	public void updateTable(){
		if(name.equalsIgnoreCase("1")){
			EnzymeFrame.table.getSub1().setText(getAmountOfSubstrate() + "");
			EnzymeFrame.table.getP1().setText(getAmountOfProduct() + "");
		}else if(name.equalsIgnoreCase("2")){
			EnzymeFrame.table.getSub2().setText(getAmountOfSubstrate() + "");
			EnzymeFrame.table.getP2().setText(getAmountOfProduct() + "");
		}else if(name.equalsIgnoreCase("3")){
			EnzymeFrame.table.getSub3().setText(getAmountOfSubstrate() + "");
			EnzymeFrame.table.getP3().setText(getAmountOfProduct() + "");
		}else if(name.equalsIgnoreCase("4")){
			EnzymeFrame.table.getSub4().setText(getAmountOfSubstrate() + "");
			EnzymeFrame.table.getP4().setText(getAmountOfProduct() + "");
		}else if(name.equalsIgnoreCase("5")){
			EnzymeFrame.table.getSub5().setText(getAmountOfSubstrate() + "");
			EnzymeFrame.table.getP5().setText(getAmountOfProduct() + "");
		}
	}
	
	public double getTemperature(){
		return temperature;
	}
	
	public double getAmountOfSubstrate(){
		return amountOfSubstrate;
	}
	
	public int getAmountOfProduct(){
		if(amountOfSubstrate == 0.5){
			return Answers.get05Answer((int)temperature, EnzymeLab.currentPh);
		}else if(amountOfSubstrate == 1.0){
			return Answers.get1Answer((int)temperature, EnzymeLab.currentPh);
		}else if(amountOfSubstrate == 2.0){
			return Answers.get2Answer((int)temperature, EnzymeLab.currentPh);
		}else if(amountOfSubstrate == 4.0 || amountOfSubstrate == 8.0){
			return Answers.get4Answer((int)temperature, EnzymeLab.currentPh);
		}
		return 0;
	}
	
	public void setAmountOfSubstrate(double sub){
		this.amountOfSubstrate = sub;
	}
	
	public void setTemperature(double num){
		this.temperature = num;
	}
	
	public boolean contains(int cX, int cY){
		
		if(cX >= x && cX <= x1 && cY >= y && cY <= y1) return true;
		
		return false;
	}
	
	public String getName(){
		return name;
	}

	public int getColorStartY() {
		return colorStartY;
	}

	public void setColorStartY(int colorStartY) {
		this.colorStartY = colorStartY;
	}

	public int getColorStartX() {
		return colorStartX;
	}

	public void setColorStartX(int colorStartX) {
		this.colorStartX = colorStartX;
	}
}
