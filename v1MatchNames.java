import java.util.*;

public class v1MatchNames {
	//This is the initial code for a plant ID game
	//V1.0 will simply have a basic input in response to a question
	//will require input from user, reading a table or library and a randomizer
	public static void main(String[] args) {
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
		Scanner uip = new Scanner(System.in);
		
		while(lives > 0 && q<10) { //q limit should be changed to 15 in the end
			String latin = "blank"; //this will be filled from table/matrix based on plant id#
			//need code for choosing latin name
			String common = "blank";
			//this will be filled from table/matrix based on plant id#
			//need code for choosing common name
			boolean food = true; //this will change when poisonous plants are added
		//questions
			//question 1
			while(lives > 0 && q<5) {
				latin = "instance"; //using a library, randomlist[q] will return the latin name from matrix
				common = "instance"; //using a library, randomlist[q] will return the common name from matrix
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
				}
				if( q == 5)
					break;
			}
			//question 2
			while(lives > 0 && q<10) {
				latin = "instance2"; //using a library, randomlist[q] will return the latin name from matrix
				food = true; //using a library, randomlist[q] will return the common name from matrix
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
				
				}
				
			}
			if( lives == 0)
				System.out.println("\n\nGame Over\n\n");
			System.out.println("\nThank you for playing\n\n");
			System.out.println("you answered " + q + "/15 questions!\nYou earned " + points + " points!");

			
			
			
		}
		
			
		//int num = (int)(Math.random() * 10 + 1);
		//System.out.println(num);
		
		

	}

}
