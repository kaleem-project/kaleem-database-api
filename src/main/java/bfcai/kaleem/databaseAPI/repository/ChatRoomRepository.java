package bfcai.kaleem.databaseAPI.repository;

import bfcai.kaleem.databaseAPI.domain.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
}
