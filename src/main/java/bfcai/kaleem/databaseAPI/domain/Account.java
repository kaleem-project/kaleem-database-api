package bfcai.kaleem.databaseAPI.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection="Accounts")
public class Account implements AutoCloseable{

	@Id private String id;
	@Indexed(unique = true) private String username;
	@Indexed(unique = true) private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String headLine;
	private String gender;
	private boolean isActive;
	private boolean isConfirmed;
	private String profileImage;
	private String country;
	private LocalDateTime creationTime;
	private LocalDateTime lastLoginTime;
	private boolean firstLogin;

	@Override
	public void close() throws Exception {}
}
