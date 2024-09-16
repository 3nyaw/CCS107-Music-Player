package PrelimLabExam;

public class LinkedList {
	
	private Node head; // Head of the linked list
	
	// Getter method for head node
	public Node getHead() {
		return head;
	}
	
	// Setter method for head node
	public void setHead(Node head) {
		this.head = head;
	}
	
	// Adds a new node to the end of the list
	public void addNode(Node node) {
		if(head == null) { // If the list is empty, make the new node the head
			head = node;
		} else {
			Node currentNode = head;
			// Traverse to the end of the list
			while(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			// Add the new node at the end
			currentNode.setNext(node);
		}
		System.out.println("\nSong successfully added.");
	}
	
	
	// Adds a node at a specific position in the list
	public void insertNode(Node node, int position) {
	    int currentPosition = 1;
	    Node currentNode = head;
	    
	    if(position < 1) { // Validate position
	        System.out.println("Invalid position.");
	        return;
	    } else if(head == null) { // Check if the list is empty or inserting at the head
			System.out.println("\nUnable to insert a song, list is empty.");
			return;
		} else if(position == 1) { // Special Case: If the node to be inserted is at the head
	        node.setNext(head); // Set new node's next to head
	        head = node; // Set new node as the new head
	        return;
	    }

	    // Traverse to the node before the desired position
	    while(currentNode != null && currentPosition < position - 1) {
	        currentNode = currentNode.getNext();
	        currentPosition++;
	    }

	    // Check if the desired position is valid
	    if(currentNode.getNext() == null) {
	    	System.out.println("\nPosition out of Bounds.");
	    	return;
	    }
	    
	    // Insert the new node at the desired position
	    node.setNext(currentNode.getNext());
	    currentNode.setNext(node);
	}
	
	// Removes a node from the specified position
	public void removeNode(int position) {
		if(head == null) { // Check if the list is empty
			System.out.println("\nUnable to add a song, list is empty.");
			return;
		} else if(position < 1) { // Validate position
	        System.out.println("\nInvalid position.");
	        return;
		} else if(position == 1) { // Special Case: If the node to be removed is at the head
			head = head.getNext(); // remove the head by setting it as its next node
			System.out.println("\nSong successfully removed.");
			return;
		}

		Node currentNode = head;
		Node previousNode = null;
		int currentPosition = 1;

		// Traverse to the node at the specified position
		while(currentNode != null && currentPosition < position) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
			currentPosition++;
		}

		// Check if the position is valid
		if(currentNode == null) {
	        System.out.println("\nPosition out of bounds.");
			return;
		}
		
		// Remove the node by updating the previous node's next pointer
		previousNode.setNext(currentNode.getNext());
		System.out.println("\nSong successfully removed.");
	}
	
	
	// Reorders a node from currentPosition to newPosition
	public void reorderNode(int currentPosition, int newPosition) {
		if(currentPosition < 1 || newPosition < 1) { // Validate positions
			System.out.println("\nInvalid positions.");
			return;
		} else if(head == null) { // Check if the list is empty
			System.out.println("\nUnable to reaorder song, playlist is empty.");
			return;
		} else if(head.getNext() == null) { // Check if the playlist has only 1 song
			System.out.println("\nUnable to reorder song, playlist has only one(1) song.");
			return;
		} 
		
		int size = getSize();
	    // Special Case: Check if the node to be moved is at the head
	    if (currentPosition == 1) {
	        Node temp = head; // Store the head node
	        head = head.getNext(); // Remove the head node

	        // Handle inserting the head node at the end of the list
	        if (newPosition == size) { // Move head to the last position
	            Node lastNode = head;
	            while (lastNode.getNext() != null) { // Traverse to the end of the list
	                lastNode = lastNode.getNext();
	            }
	            lastNode.setNext(temp); // Insert at the end
	            temp.setNext(null); // Mark the new end
	        } else {
	            // Insert the node at the specified position
	            insertNode(temp, newPosition);
	        }
			System.out.println("\nSong successfully reordered.");
	        return;
	    }
		
		// Traverse to the node at currentPosition
		Node currentNode = head;
		Node previousNode = null;
		int position = 1;
		while(currentNode != null && position < currentPosition) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
			position++;
		}

		// Check if the current position is valid
		if(currentNode == null) {
			System.out.println("\nCurrent position out of bounds.");
			return;
		}

		// Remove the node from its current position
		previousNode.setNext(currentNode.getNext());

	    // Handle inserting at the end of the list
	    if (newPosition == size + 1) { // Check if moving to the end
	        Node lastNode = head;
	        while (lastNode.getNext() != null) { // Traverse to the end of the list
	            lastNode = lastNode.getNext();
	        }
	        lastNode.setNext(currentNode); // Insert at the end
	        currentNode.setNext(null); // Mark the new end
			System.out.println("\nSong successfully reordered.");
	    }  else {
	        // Use insertNode method to insert at the new position
	        insertNode(currentNode, newPosition);
			System.out.println("\nSong successfully reordered.");
	    }
	}

	// Helper function to get the size of the list
	private int getSize() {
	    int size = 0;
	    Node current = head;
	    while (current != null) {
	        size++;
	        current = current.getNext();
	    }
	    return size;
	}
	
	// Clears the linked list content
	public void clearPlaylist() {
		if(head == null) {
			System.out.println("Unable to clear the playlist, there are no songs listed.");
		}
		head = null;
	}
	
	// Displays the linked list content
	public void displayList() {
		// Print the table headers
		System.out.println("\n+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
		System.out.printf("%s%20s%20s%20s%n", "| #", "Title", "Singer", "Duration |");
		System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
		Node currentNode = head;
		int counter = 1;

		// Traverse the list and print each node's details
		while(currentNode != null) {
			System.out.printf("%3s%19s%19s%19s%n", counter++, currentNode.getTitle(), currentNode.getArtist(), currentNode.getDuration());
			currentNode = currentNode.getNext();
		}
		System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
	}
}