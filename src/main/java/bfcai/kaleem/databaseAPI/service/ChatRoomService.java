package bfcai.kaleem.databaseAPI.service;


import bfcai.kaleem.databaseAPI.domain.ChatRoom;
import bfcai.kaleem.databaseAPI.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatRoomService {



	@Autowired
	private ChatRoomRepository repository;

	public ChatRoom createChatRoom(String parentRoomId){
		ChatRoom room = new ChatRoom();
		 room.setParentId(parentRoomId);
		var result = repository.save(room);
		return result;
	}

}
