import java.util.Scanner;

public class Homework1 {

	public static void main(String[] args) {
		
		//get input from user
		int x = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a integer that is between (inclusice) 1 and 10000000: ");
		
		//Validate input
		if(scan.hasNextInt()) {
			x = scan.nextInt();
		}else {
			//exits program if number was not integer
			System.err.println("Number entered was not an integer");
			System.exit(0);
		}
		
		checkInput(x);
			
		checkHCN(x);		
				
		//check if it is HCN
		//if it is not see the closest one
		
	}

	private static void checkHCN(int x) {
		
		int positiveFoundNum = 0;
		int negativeFoundNum = 0;
		
		//Hard code HCN's in list is from: https://www.numbersaplenty.com/set/highly_composite_number/more.php
		int[] hcnArray = new int[] {1,2,4,6,12,24,36,48,60,120,180,240,360,720,840,1260,1680,2520,5040,7560,10080,15120,
									20160,25200,27720,45360,50400,55440,83160,110880,166320,221760,277200,332640,498960,
									554400,665280,720720,1081080,1441440,2162160,2882880,3603600,4324320,6486480,7207200,
									8648640, 10810800};
		
		int i = 0;
		while(i < hcnArray.length) {
			if(x == hcnArray[i]) {
				System.out.println("x is HCN");
			}
			i++;
		}
		
		boolean running = true;
		int addToCompare = 0;
		while(running == true) {
		
			int compareValuePos = x + addToCompare;
			int compareValueNeg = x - addToCompare;
			
			int h = 0;
			while(h < hcnArray.length) {
				if(compareValuePos == hcnArray[h]) {
					//System.out.println("The closest number is " + hcnArray[h] + ", which is a postive " + addToCompare + " number away.");
					positiveFoundNum = hcnArray[h];
					running = false;
				}
				h++;
			}
			
			int j = 0;
			while(j < hcnArray.length) {
				if(compareValueNeg == hcnArray[j]) {
					//System.out.println("The closest number is " + hcnArray[j] + ", which is a negative " + addToCompare + " number away.");
					negativeFoundNum = hcnArray[j];
					running = false;
				}
				j++;
			}
			
			addToCompare++;
			
		}
		
		if(negativeFoundNum != 0 && positiveFoundNum != 0) {
			System.out.println(x +" is directly between two number, " + negativeFoundNum + " and " + positiveFoundNum + " with a distance of " + (addToCompare - 1));
		}else if(positiveFoundNum != 0) {
			System.out.println("The closest number is " + positiveFoundNum + ", which is postive " + (addToCompare - 1) + " number away.");
		}else if(negativeFoundNum != 0) {
			System.out.println("The closest number is " + negativeFoundNum + ", which is negative " + (addToCompare - 1) + " number away.");
		}
		
	}

	private static void checkInput(int x) {
		if(x < 1) {
			System.err.println("Number entered was too low");
			System.exit(0);
		}
		
		if(x > 10000000) {
			System.err.println("Number entered was too high");
			System.exit(0);
		}
		
	}
}
