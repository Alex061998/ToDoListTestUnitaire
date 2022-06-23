package org.example.Entity;

import java.util.Date;

public class Item {
	private final String name;
	private final String content;
	private final Date creationDate;

	public Item(String name, String content, Date creationDate) {
		this.name = name;
		this.content = content;
		this.creationDate = creationDate;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public Date getCreationDate() {
		return creationDate;
	}
}
