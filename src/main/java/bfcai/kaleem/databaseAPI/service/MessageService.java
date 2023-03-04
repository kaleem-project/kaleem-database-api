package bfcai.kaleem.databaseAPI.service;

import bfcai.kaleem.databaseAPI.domain.Message;
import bfcai.kaleem.databaseAPI.repository.MessageRepository;
import bfcai.kaleem.databaseAPI.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

	@Autowired
	private MessageRepository repository;

	public Response insertMessageRecord(Message message){
		var result = new Response();
		var messageRecord = repository.save(message);
		result.make("Message added successfully", 201, messageRecord);
		return result;
	}

	public Response getRelatedMessagesRecords(String parentId){
		var result = new Response();
		var messages = repository.getAllByParentId(parentId);
		result.make("Related Messages", 200, messages);
		return result;
	}

}
