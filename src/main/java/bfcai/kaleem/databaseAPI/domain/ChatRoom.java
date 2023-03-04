package bfcai.kaleem.databaseAPI.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ChatRooms")
@Data
public class ChatRoom {

	@Id
	private String id;
	private String parentId;
}
