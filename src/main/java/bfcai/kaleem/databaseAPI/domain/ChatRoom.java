package bfcai.kaleem.databaseAPI.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ChatRoom {

	@Id
	private String id;
	private Room parentId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Room getParentId() {
		return parentId;
	}

	public void setParentId(Room parentId) {
		this.parentId = parentId;
	}
}
