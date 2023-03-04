package bfcai.kaleem.databaseAPI.service;


import bfcai.kaleem.databaseAPI.domain.ChatRoom;
import bfcai.kaleem.databaseAPI.domain.Room;
import bfcai.kaleem.databaseAPI.repository.ChatRoomRepository;
import bfcai.kaleem.databaseAPI.repository.RoomRepository;
import bfcai.kaleem.databaseAPI.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomService {


	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private ChatRoomService chatRepository;

	public Response insertRoomRecord(Room room){
		var result = new Response();
		Room newRoom = roomRepository.save(room);
		ChatRoom newChatRoom = chatRepository.createChatRoom(newRoom.getId());
		result.make("Room created Successfully", 201, newRoom);
		return result;
	}

	public Response getRoomRecord(String roomId){
		var result = new Response();
		Room roomResult = roomRepository.getRoomById(roomId);
		result.make("", 200, roomResult);
		return result;
	}

	public Response getRelatedRoomsRecords(String adminId){
		var result = new Response();
		var roomResult = roomRepository.getRoomsByRoomAdmin(adminId);
		result.make("All available rooms for account", 200, roomResult);
		return result;
	}

	public Response updateRoomRecord(Room room){
		var result = new Response();
		var updatedRooms = roomRepository.save(room);
		result.make("Room updated successfully", 200, updatedRooms);
		return result;
	}

	public Response deleteRoomRecord(String id){
		var result = new Response();
		var roomResult = roomRepository.deleteRoomsById(id);
		result.make("Room deleted successfully", 200, roomResult);
		return result;
	}


}
