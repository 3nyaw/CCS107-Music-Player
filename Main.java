package PrelimLabExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		LinkedList list = new LinkedList(); // Create an instance of the LinkedList

		System.out.println("      Music Player");

		// Infinite loop for the menu
		while (true) {
			// Display menu options
			System.out.println
					   ("\n+------------------------+"
					+ "\n{ [1] Add a New Song     }"
					+ "\n{ [2] Insert a New Song  }"
					+ "\n{ [3] Remove a Song      }"
					+ "\n{ [4] Reorder Songs      }"
					+ "\n{ [5] Clear the Playlist }"
					+ "\n{ [0] Exit               }"
					+ "\n+------------------------+");
			System.out.print("\nWhat would you like to do? ");
			String input = reader.readLine();
			if(!isValidNumber(input)) { // Checks if the input is not a number
				System.out.println("\nInvalid input. Try again.");
				continue;
			}
			int command = Integer.parseInt(input);
			
			String title, artist, duration; 
			
			// Switch statement to handle different menu options
			switch(command) {
				case 1: // Add a new song at the end of the playlist
					System.out.println("\nAdd a Song");
					System.out.print("Enter the Title: ");
					title = reader.readLine();
					System.out.print("Enter the Artist: ");
					artist = reader.readLine();
					System.out.print("Enter the Duration: ");
					duration = reader.readLine();
					list.addNode(new Node(title, artist, duration)); // Call addNode method to add a song
					list.displayList();
					break;
				
				case 2: // Insert a song at a specific position
					int position;
					System.out.println("\nInsert a Song");
					System.out.print("Enter position: ");
					input = reader.readLine();
					if(!isValidNumber(input)) {
						System.out.println("\nInvalid input. Try again.");
						break;
					}
					position = Integer.parseInt(input);
					System.out.print("Enter the Title: ");
					title = reader.readLine();
					System.out.print("Enter the Artist: ");
					artist = reader.readLine();
					System.out.print("Enter the Duration: ");
					duration = reader.readLine();
					list.insertNode(new Node(title, artist, duration), position); // Call insertNode method to insert a song
					list.displayList();
					break;
				
				case 3: // Remove a song from a specific position
					System.out.println("\nRemove a Song");
					System.out.print("Enter the position: ");
					input = reader.readLine();
					if(!isValidNumber(input)) {
						System.out.println("\nInvalid input. Try again.");
						continue;
					}
					position = Integer.parseInt(input);
					list.removeNode(position); // Call removeNode method to remove a song from the list
					list.displayList();
					break;
				
				case 4: // Reorder a song from one position to another
					System.out.println("\nReorder a Song");
					System.out.print("Enter the current position: ");
					input = reader.readLine();
					if(!isValidNumber(input)) {
						System.out.println("\nInvalid input. Try again.");
						break;
					}
					int currentPosition = Integer.parseInt(input);
					System.out.print("Enter the new position: ");
					input = reader.readLine();
					if(!isValidNumber(input)) {
						System.out.println("\nInvalid input. Try again.");
						break;
					}
					int newPosition = Integer.parseInt(input);
					list.reorderNode(currentPosition, newPosition); // Call reorderNode method to reorder the song in the list
					list.displayList();
					break;
				
				case 5: // Clear the playlist
					list.clearList(); // Call clearList to clear the playlist
					list.displayList();
					break;
				
				case 0: // Exit the program
					System.out.println("Exiting program...");
					list.displayList(); // Call displayList to display the final playlist before exit
					break;
				default:
					System.out.println("Invalid input.");
			}

			// Exit if user inputs 0
			if(command != 0) {
				continue;
			} else {
				break;
			}
		}
	}
	
	// Check if the input is a number
	private static boolean isValidNumber(String input) {
	    if(input == null) {
	        return false;
	    }
	    int startIndex = 0;
	    // Check if the first character is a minus sign for negative numbers
	    if(input.charAt(0) == '-') {
	        if (input.length() == 1) {
	            return false;
	        }
	        startIndex = 1;
	    }
	    // Check that the rest of the characters are digits
	    for(int i = startIndex; i < input.length(); i++) {
	        char c = input.charAt(i);
	        if (c < '0' || c > '9') { // If any character is not a digit, return false
	            return false;
	        }
	    }
	    return true;
	}
	
}