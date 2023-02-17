package bfcai.kaleem.databaseAPI.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Document
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getInvitationLink() {
		return invitationLink;
	}

	public void setInvitationLink(String invitationLink) {
		this.invitationLink = invitationLink;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<String> members) {
		this.members = members;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Account getRoomAdmin() {
		return roomAdmin;
	}

	public void setRoomAdmin(Account roomAdmin) {
		this.roomAdmin = roomAdmin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ChatRoom getChatRoomChannel() {
		return chatRoomChannel;
	}

	public void setChatRoomChannel(ChatRoom chatRoomChannel) {
		this.chatRoomChannel = chatRoomChannel;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Integer getRoomDurationInSeconds() {
		return roomDurationInSeconds;
	}

	public void setRoomDurationInSeconds(Integer roomDurationInSeconds) {
		this.roomDurationInSeconds = roomDurationInSeconds;
	}

	public ChatRoom getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}
}
