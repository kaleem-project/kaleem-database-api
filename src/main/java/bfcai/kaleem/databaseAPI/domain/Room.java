package bfcai.kaleem.databaseAPI.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@Document(collection="Rooms")
public class Room {

	@Id
	private String id;
	private String invitationLink;
	private String name;
	private ArrayList<String> members;
	private String type; 							// schedule, or now
	private String roomAdmin;
	private String status;							// Running, or Ended.
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Integer roomDurationInSeconds;
}
