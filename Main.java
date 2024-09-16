package PrelimLabExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		// BufferedReader for reading user input
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
			String input = reader.readLine(); // Read user input for menu selection
			if(!isValidNumber(input)) { // Checks if the input is not a number
				System.out.println("\nInvalid input. Try again.");
				continue;
			}
			int command = Integer.parseInt(input);
			
			String title, artist, duration; // Variables to store song details
			
			// Switch statement to handle different menu options
			switch(command) {
				case 1:
					// Case 1: Add a new song to the list
					System.out.println("\nAdd a Song");
					System.out.print("Enter the Title: ");
					title = reader.readLine(); // Read song title
					System.out.print("Enter the Artist: ");
					artist = reader.readLine(); // Read artist name
					System.out.print("Enter the Duration: ");
					duration = reader.readLine(); // Read song duration
					list.addNode(new Node(title, artist, duration)); // Add the new song to the list
					list.displayList(); // Display the updated playlist
					break;
				
				case 2:
					// Case 2: Insert a song at a specific position
					int position; // Variable for song position
					System.out.println("\nInsert a Song");
					System.out.print("Enter position: ");
					input = reader.readLine(); // Read the desired position
					if(!isValidNumber(input)) { // Checks if the input is not a number
						System.out.println("\nInvalid input. Try again.");
						break;
					}
					position = Integer.parseInt(input);
					System.out.print("Enter the Title: ");
					title = reader.readLine(); // Read song title
					System.out.print("Enter the Artist: ");
					artist = reader.readLine(); // Read artist name
					System.out.print("Enter the Duration: ");
					duration = reader.readLine(); // Read song duration
					list.insertNode(new Node(title, artist, duration), position); // Insert the song at the specified position
					System.out.println("\nSong successfully inserted.");
					list.displayList(); // Display the updated playlist
					break;
				
				case 3:
					// Case 3: Remove a song from a specific position
					System.out.println("\nRemove a Song");
					System.out.print("Enter the position: ");
					input = reader.readLine();
					if(!isValidNumber(input)) { // Checks if the input is not a number
						System.out.println("\nInvalid input. Try again.");
						continue;
					}
					position = Integer.parseInt(input);
					list.removeNode(position); // Read the position and remove the song
					list.displayList(); // Display the updated playlist
					break;
				
				case 4:
					// Case 4: Reorder a song from one position to another
					System.out.println("\nReorder a Song");
					System.out.print("Enter the current position: ");
					input = reader.readLine();
					if(!isValidNumber(input)) { // Checks if the input is not a number
						System.out.println("\nInvalid input. Try again.");
						break;
					}
					int currentPosition = Integer.parseInt(input); // Read the current position
					System.out.print("Enter the new position: ");
					input = reader.readLine();
					if(!isValidNumber(input)) { // Checks if the input is not a number
						System.out.println("\nInvalid input. Try again.");
						break;
					}
					int newPosition = Integer.parseInt(input); // Read the new position
					list.reorderNode(currentPosition, newPosition); // Reorder the song in the list
					list.displayList(); // Display the updated playlist
					break;
				
				case 5:
					// Case 5: Clear the playlist
					list.clearPlaylist();
					list.displayList(); // Display the now-empty playlist
					System.out.println("\nPlaylist successfully cleared.");
					break;
				
				case 0:
					// Case 0: Exit the program
					System.out.println("Exiting program...");
					list.displayList(); // Display the final playlist before exit
					break;
			}

			// Exit condition: if user inputs 0, break the loop and exit the program
			if(command != 0) {
				continue;
			} else {
				break;
			}
		}
	}
	
	private static boolean isValidNumber(String input) {
	    if(input == null) {
	        return false;
	    }
	    int startIndex = 0;
	    // Check if the first character is a minus sign for negative numbers
	    if(input.charAt(0) == '-') {
	        if (input.length() == 1) { // If the string is just "-", it's not a valid number
	            return false;
	        }
	        startIndex = 1; // Start checking the rest of the string after the minus sign
	    }
	    // Check that the rest of the characters are digits
	    for(int i = startIndex; i < input.length(); i++) {
	        char c = input.charAt(i);
	        if (c < '0' || c > '9') { // If any character is not a digit, return false
	            return false;
	        }
	    }
	    return true; // If all checks pass, the input is a valid integer
	}
}
