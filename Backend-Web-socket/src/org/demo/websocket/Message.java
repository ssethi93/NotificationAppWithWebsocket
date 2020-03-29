package org.demo.websocket;

public class Message {

	private String title;
	
	private String message;
	
	private String id;

	public Message(String title, String message, String id) {
		this.id = id;
		this.message = message;
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
