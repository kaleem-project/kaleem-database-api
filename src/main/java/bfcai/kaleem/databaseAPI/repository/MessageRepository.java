package bfcai.kaleem.databaseAPI.repository;

import bfcai.kaleem.databaseAPI.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {

	List<Message> getAllByParentId(String parendId);
}
