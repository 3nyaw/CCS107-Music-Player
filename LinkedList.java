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
		if (head == null) { // If the list is empty, make the new node the head
			head = node;
		} else {
			Node currentNode = head;
			// Traverse to the end of the list
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			// Add the new node at the end
			currentNode.setNext(node);
		}
	}
	
	// Adds a node at a specific position in the list
	public void insertNode(Node node, int position) {
	    int currentPosition = 1;
	    Node currentNode = head;

	    // Validate position
	    if (position < 1) {
	        System.out.println("Invalid position.");
	        return;
	    } 
	    
	    // Check if the list is empty or inserting at the head
	    if (position == 1) {
	        node.setNext(head);
	        head = node;
	        return;
	    }

	    // Traverse to the node before the desired position
	    while (currentNode != null && currentPosition < position - 1) {
	        currentNode = currentNode.getNext();
	        currentPosition++;
	    }

	    // Check if the desired position is valid
	    if (currentNode == null) {
	        System.out.println("Position out of bounds.");
	        return;
	    }

	    // Insert the new node at the desired position
	    node.setNext(currentNode.getNext());
	    currentNode.setNext(node);
	}

	
	// Reorders a node from currentPosition to newPosition
	public void reorderNode(int currentPosition, int newPosition) {
		// Check if the list is empty
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}

		// Validate positions
		if (currentPosition < 1 || newPosition < 1) {
			System.out.println("Invalid positions.");
			return;
		}

		// Edge case: If the node to be moved is at the head
		if (currentPosition == 1) {
			Node temp = head;  // Store the head node
			head = head.getNext();  // Remove the head node
			insertNode(temp, newPosition);  // Add the node to the new position
			return;
		}

		// Traverse to the node at currentPosition
		Node currentNode = head;
		Node previousNode = null;
		int position = 1;

		while (currentNode != null && position < currentPosition) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
			position++;
		}

		// Check if the current position is valid
		if (currentNode == null) {
			System.out.println("Current position out of range.");
			return;
		}

		// Remove the node from its current position
		previousNode.setNext(currentNode.getNext());

		// Insert the node at the new position
		if (newPosition == 1) {
			// If moving to the head, update head
			currentNode.setNext(head);
			head = currentNode;
		} else {
			// Use addNode to insert at the new position
			insertNode(currentNode, newPosition);
		}
	}
	
	// Removes a node from the specified position
	public void removeNode(int position) {
		// Check if the list is empty
		if (head == null) {
			System.out.println("List is empty.");
			return;
		} else if (position == 0) { // Special case: remove the head node
			head = head.getNext();
			return;
		}

		Node currentNode = head;
		Node previousNode = null;
		int currentPosition = 1;

		// Traverse to the node at the specified position
		while (currentNode != null && currentPosition < position) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
			currentPosition++;
		}

		// Check if the position is valid
		if (currentNode == null) {
			System.out.println("Position out of range.");
			return;
		}
		
		// Remove the node by updating the previous node's next pointer
		previousNode.setNext(currentNode.getNext());
	}
	
	public void clearPlaylist() {
		head = null;
		System.out.println("The playlist has been cleared");
	}
	
	// Displays the linked list content
	public void displayList() {
		// Print the table headers
		System.out.printf("%n%s%10s%20s%20s%n", "#", "Title", "Singer", "Duration");
		Node currentNode = head;
		int counter = 1;

		// Traverse the list and print each node's details
		while (currentNode != null) {
			System.out.printf("%s%10s%20s%20s%n", counter++, currentNode.getTitle(), currentNode.getArtist(), currentNode.getDuration());
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
}