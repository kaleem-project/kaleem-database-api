package bfcai.kaleem.databaseAPI.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.sql.Timestamp;

@Data
@Document(collection = "Messages")
public class Message implements AutoCloseable{

	@Id
	private String id;
	private String senderId;
	private String parentId;
	private String content;
	@Indexed(direction= IndexDirection.DESCENDING)
	private Timestamp timestamp;

	@Override
	public void close() throws Exception {

	}
}
