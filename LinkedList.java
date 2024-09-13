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
	  if (head == null) {
            head = node;
        } else {
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(node);
        }
	}
	
	// Adds a node at a specific position in the list
	public void insertNode(Node node, int position) {
	    int currentPosition = 1;
	    Node currentNode = head;
 	
	    // Validate position

	    
	    // Check if the list is empty or inserting at the head
  		

	    // Traverse to the node before the desired position


	    // Check if the desired position is valid


	    // Insert the new node at the desired position

	}

	
	// Reorders a node from currentPosition to newPosition
	public void reorderNode(int currentPosition, int newPosition) {
		// Check if the list is empty


		// Validate positions

		// Edge case: If the node to be moved is at the head


		// Traverse to the node at currentPosition
		Node currentNode = head;
		Node previousNode = null;
		int position = 1;



		// Check if the current position is valid


		// Remove the node from its current position
		previousNode.setNext(currentNode.getNext());

		// Insert the node at the new position

	}
	
	// Removes a node from the specified position
	public void removeNode(int position) {
		// Check if the list is empty


		// Traverse to the node at the specified position


		// Check if the position is valid

		
		// Remove the node by updating the previous node's next pointer

	}
	
	public void clearPlaylist() {

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
