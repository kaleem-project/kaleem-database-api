package bfcai.kaleem.databaseAPI.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Document
@Data
public class Room {

	private String id;
	private String url;
	private String invitationLink;
	private String name;
	private ArrayList<String> members;
	private String type; 							// schedule, or now
	private Account roomAdmin;
	private String status;							// Running, or Ended.
	private ChatRoom chatRoomChannel;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Integer roomDurationInSeconds;
	private ChatRoom chatRoom;

}
