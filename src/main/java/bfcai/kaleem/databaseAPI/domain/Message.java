package bfcai.kaleem.databaseAPI.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.sql.Timestamp;

@Document(collection = "Messages")
public class Message implements  AutoCloseable{

	@Id private String id;
	private String senderId;
	private ChatRoom parentId;
	private String content;
	@Indexed(direction= IndexDirection.DESCENDING)
	private Timestamp timestamp;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public ChatRoom getParentId() {
		return parentId;
	}

	public void setParentId(ChatRoom parentId) {
		this.parentId = parentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public void close() throws Exception {

	}
}
