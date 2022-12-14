import java.io.*;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;

public class v1MatchNames {
	//This is the initial code for a plant ID game
	//V1.0 will simply have a basic input in response to a question
	//will require input from user, reading a table or library and a randomizer
	private static final int ROWS = 5;
	private static final int COLUMNS = 4;
	
	public static void main(String[] args) throws IOException
	{ 
		// Code for importing the table will go here
		int lives = 3;
		int points = 0;
		
		System.out.println("Hello, welcome to 4ag!ng - the plant ID game!\n\n");
		System.out.println("In this game you will match the latin names of plants with their common names.\n");
		//System.out.println("You will then match their latin names with their pictures.\n");
		//System.out.println("Following this, you will match their common names with their pictures.\n");
		System.out.println("Finally, you will determine whether the plant is edible.\n");
		System.out.println("If you miss three questions you are done!\n\n");//later will be dead
		System.out.println("Good luck!\nPress enter to proceed.");
		//user input enter to run
		
		//while loop must break if lives reach 0
		//while loop must not repeat questions
		//while loop must randomize questions based on table
			//each plant was given a number on the table
			//if a list of those numbers could be randomized ie(1,2,3) into (2,1,3)
			//could take list[i] ask question about it then i++
			//rerandomize for each question set
		int q = 0;

		File temp = new File("Plants.txt");
//		Scanner file = new Scanner(temp);		//Read file
//		System.out.println(file.nextLine());	//Read file
		

		//The portion of code below imports my array. Thanks to DevMecha on youtube https://www.youtube.com/watch?v=haQ2VD5GXyA for the walkthrough
		String[][] plantArray = new String[ROWS][COLUMNS];
		Scanner file = new Scanner(temp);
		while (file.hasNextLine()) {
			for (int i = 0; i < plantArray.length; i++) {
				String[] line = file.nextLine().trim().split(",");
				for (int j = 0; j < line.length; j++) {
					plantArray[i][j] = String.format(line[j]);
					
				}
			}
		}
		System.out.println(Arrays.deepToString(plantArray));
		
		
		//Begin Game

		Scanner uip = new Scanner(System.in);
		
		while(lives > 0 && q<10) { //q limit should be changed to 15 in the end
			String latin = "blank"; 
			String common = "blank";
			boolean food = true; //this will change when poisonous plants are added
			//list =  (0,1,2,3,4);
			
		//questions
			//question 1
			while(lives > 0 && q<5) {
//				Collections.shuffle(list);
				latin = plantArray[q][2]; //using a library, randomlist[q] will return the latin name from matrix
				common = plantArray[q][1]; //using a library, randomlist[q] will return the common name from matrix
				System.out.println("\nWhat is the common name for " + latin + "?");
				String ans = uip.nextLine();
				if (ans.compareTo(common) == 0) {
					System.out.println("Correct, " + latin + " is the latin name for " + common);
					points++;
					q++;
				} else {
					System.out.println("Sorry, but " + ans + " is not recognized as the common name for " + latin);
					lives--;
					q++;
					System.out.println("\nYou have " + lives + " lives remaining");
				}
				if( q == 5)
					break;
			}
			//question 2
			while(lives > 0 && q < 10) {
				latin = plantArray[q-5][2]; //using a library, randomlist[q] will return the latin name from matrix
				String edible = plantArray[q-5][3];
				food = Boolean.parseBoolean(edible); //using a library, randomlist[q] will return the common name from matrix
				System.out.println("\ntrue or false:\n" + latin + " is edible");
				boolean ans2 = Boolean.parseBoolean( uip.nextLine() );

				if (ans2 == food) {
					points++;
					q++;
					if (food)
						System.out.println("Correct, " + latin + " or " + common + " is known to be edible.");
					else
						System.out.println("Correct, " + latin + " or " + common + " is known to be poisonous and not edible.");
				} else {
					lives--;
					q++;
					if (food)
						System.out.println("Incorrect, " + latin + " or " + common + " is known to be edible.");
					else
						System.out.println("Incorrect, " + latin + " or " + common + " is known to be poisonous and not edible.");
					System.out.println("You have " + lives + " remaining");
				}
				
			}
			if( lives == 0)
				System.out.println("\n\nGame Over\n\n");
			System.out.println("\nThank you for playing!\n\n");
			if( q == 1)
				System.out.println("You answered " + q + "/15 questions!\nYou earned " + 1 + " point!");
			else
				System.out.println("You answered " + q + "/15 questions!\nYou earned " + points + " points!");

			
			
			
		}
		
			
		//int num = (int)(Math.random() * 10 + 1);
		//System.out.println(num);
		
		

	}

}
