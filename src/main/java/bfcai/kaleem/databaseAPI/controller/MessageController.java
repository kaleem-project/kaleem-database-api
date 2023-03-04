package bfcai.kaleem.databaseAPI.controller;

import bfcai.kaleem.databaseAPI.domain.Message;
import bfcai.kaleem.databaseAPI.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/database")
public class MessageController {

	@Autowired
	private MessageService service;

	@PostMapping("/messages")
	public ResponseEntity<?> createMessage(@RequestBody Message message){
		var response = service.insertMessageRecord(message);
		return ResponseEntity.status(response.getCode()).body(response.toData());
	}

	@GetMapping("/messages/chatroom/{parentId}")
	public ResponseEntity<?> getRelatedMessages(@PathVariable String parentId){
		var response = service.getRelatedMessagesRecords(parentId);
		return ResponseEntity.status(response.getCode()).body(response.toData());
	}
}
