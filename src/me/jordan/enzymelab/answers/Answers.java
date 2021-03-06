package me.jordan.enzymelab.answers;

/**
 * Jordan Cole
 * Nov 15, 2017
 * Period 2
 */

public class Answers {
	
	public static int BASE_TEMP = 37;

	public static int get05Answer(int temperature, int phLevel){
		
		int answer = 72;
		
		if(temperature > BASE_TEMP){
			int toSubtract = temperature - BASE_TEMP;
			answer-=toSubtract;
		}else if(temperature < BASE_TEMP){
			int toSubtract = BASE_TEMP - temperature;
			answer -= toSubtract;
		}
		
		return answer;
	}
	
	public static int get1Answer(int temperature, int phLevel){
		int answer = 0;
		
		switch(phLevel){
			case 3: answer = 39;
					break;
			case 5: answer = 81;
					break;
			case 7: answer = 145;
					break;
			case 9: answer = 91;
					break;
			case 11: answer = 49;
					 break;
		}
		
		if(temperature > BASE_TEMP){
			int toSubtract = temperature - BASE_TEMP;
			answer-=toSubtract;
		}else if(temperature < BASE_TEMP){
			int toSubtract = BASE_TEMP - temperature;
			answer -= toSubtract;
		}
		
		return answer;
	}
	
	public static int get2Answer(int temperature, int phLevel){
		int answer = 0;
		
		switch(phLevel){
			case 3: answer = 82;
					break;
			case 5: answer = 168;
					break;
			case 7: answer = 300;
					break;
			case 9: answer = 189;
					break;
			case 11: answer = 103;
					 break;
		}
		
		if(temperature > BASE_TEMP){
			int toSubtract = temperature - BASE_TEMP;
			answer-=toSubtract;
		}else if(temperature < BASE_TEMP){
			int toSubtract = BASE_TEMP - temperature;
			answer -= toSubtract;
		}
		
		return answer;
	}
	
	public static int get4Answer(int temperature, int phLevel){
		int answer = 0;
		
		switch(phLevel){
			case 3: answer = 96;
					break;
			case 5: answer = 198;
					break;
			case 7: answer = 350;
					break;
			case 9: answer = 223;
					break;
			case 11: answer = 121;
					 break;
		}
		
		if(temperature > BASE_TEMP){
			int toSubtract = temperature - BASE_TEMP;
			answer-=toSubtract;
		}else if(temperature < BASE_TEMP){
			int toSubtract = BASE_TEMP - temperature;
			answer -= toSubtract;
		}
		
		return answer;
	}
}
