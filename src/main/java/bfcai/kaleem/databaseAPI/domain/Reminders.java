package bfcai.kaleem.databaseAPI.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "Reminders")
public class Reminders {
	@Id
	private String id;
	private Room roomId;
	private String content;
	private String account;
	private LocalDateTime runTime;
	private LocalDateTime deleteTime;
}