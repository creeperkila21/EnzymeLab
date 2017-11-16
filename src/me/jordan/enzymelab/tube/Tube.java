package me.jordan.enzymelab.tube;

import me.jordan.enzymelab.EnzymeLab;
import me.jordan.enzymelab.answers.Answers;

/**
 * Jordan Cole
 * Nov 15, 2017
 * Period 2
 */

public class Tube {

	private int phLevel;
	private double amountOfSubstrate;
	
	public Tube(){
		
	}
	
	public int getPHLevel(){
		return phLevel;
	}
	
	public double getamountOfSubstrate(){
		return amountOfSubstrate;
	}
	
	public int getAmountOfProduct(){
		if(amountOfSubstrate == 0.5){
			return Answers.get05Answer(EnzymeLab.currentTemperature, phLevel);
		}else if(amountOfSubstrate == 1.0){
			return Answers.get1Answer(EnzymeLab.currentTemperature, phLevel);
		}else if(amountOfSubstrate == 2.0){
			return Answers.get2Answer(EnzymeLab.currentTemperature, phLevel);
		}else{
			return Answers.get4Answer(EnzymeLab.currentTemperature, phLevel);
		}
	}
	
	public void setAmountOfSubstrate(double sub){
		this.amountOfSubstrate = sub;
	}
	
}
