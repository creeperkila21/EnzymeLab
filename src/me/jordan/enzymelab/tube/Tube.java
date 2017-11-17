package me.jordan.enzymelab.tube;

import me.jordan.enzymelab.EnzymeLab;
import me.jordan.enzymelab.answers.Answers;

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
	
	public Tube(String name, int x, int y, int x1, int y1){
		System.out.println(x + " : " + x1);
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.name = name;
		amountOfSubstrate = 0;
		temperature = 37;
	}
	
	public double getTemperature(){
		return temperature;
	}
	
	public double getamountOfSubstrate(){
		return amountOfSubstrate;
	}
	
	public int getAmountOfProduct(){
		if(amountOfSubstrate == 0.5){
			return Answers.get05Answer(temperature, EnzymeLab.currentPh);
		}else if(amountOfSubstrate == 1.0){
			return Answers.get1Answer(temperature, EnzymeLab.currentPh);
		}else if(amountOfSubstrate == 2.0){
			return Answers.get2Answer(temperature, EnzymeLab.currentPh);
		}else if(amountOfSubstrate == 4.0 || amountOfSubstrate == 8.0){
			return Answers.get4Answer(temperature, EnzymeLab.currentPh);
		}
		return 0;
	}
	
	public void setAmountOfSubstrate(double sub){
		this.amountOfSubstrate = sub;
	}
	
	public boolean contains(int cX, int cY){
		
		if(cX >= x && cX <= x1 && cY >= y && cY <= y1) return true;
		
		return false;
	}
	
	public String getName(){
		return name;
	}
}
