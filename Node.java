package PrelimLabExam;

public class Node {
	private String title, artist, duration; // Properties to store song details
	private Node next; // Pointer to the next node in the linked list
	
	// Default constructor initializes empty values
	public Node() {
		title = "";
		artist = "";
		duration = "";
		next = null; // Initially, next is set to null (no connection to another node)
	}
	
	// Constructor with parameters to initialize a node with specific song details
	public Node(String title, String artist, String duration) {
		this.title = title;
		this.artist = artist;
		this.duration = duration;
	}
	
	// Getter for the title of the song
	public String getTitle() {
		return title;
	}
	
	// Setter for the title of the song
	public void setTitle(String title) {
		this.title = title;
	}
	
	// Getter for the artist of the song
	public String getArtist() {
		return artist;
	}
	
	// Setter for the artist of the song
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	// Getter for the duration of the song
	public String getDuration() {
		return duration;
	}
	
	// Setter for the duration of the song
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	// Getter for the next node in the linked list
	public Node getNext() {
		return next;
	}
	
	// Setter for the next node in the linked list
	public void setNext(Node next) {
		this.next = next;
	}
}