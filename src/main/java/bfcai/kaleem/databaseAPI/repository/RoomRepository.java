package bfcai.kaleem.databaseAPI.repository;

import bfcai.kaleem.databaseAPI.domain.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;


public interface RoomRepository extends MongoRepository<Room, String> {

	Room getRoomById(String id);
	List<Room> getRoomsByRoomAdmin(String adminId);

	Room deleteRoomsById(String id);
}
