package me.qboard.dso.data;

import java.util.Date;

public class MessageData {

	private int id;
	private String title;
	private String body;
	private Date created_at;
	private String author;
	
	public MessageData(int id, String title, String body, Date created_at,
			String author) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.created_at = created_at;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	
}
