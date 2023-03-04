package bfcai.kaleem.databaseAPI.controller;

import bfcai.kaleem.databaseAPI.domain.Room;
import bfcai.kaleem.databaseAPI.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v3/database")
public class RoomController {

	@Autowired
	private RoomService service;

	@PostMapping("/rooms")
	public ResponseEntity<?> createRoom(@RequestBody Room room){
		var response = service.insertRoomRecord(room);
		return ResponseEntity.status(response.getCode()).body(response.toData());
	}

	@GetMapping("/rooms/{roomId}")
	public ResponseEntity<?> retrieveRoom(@PathVariable String roomId){
		var response = service.getRoomRecord(roomId);
		return ResponseEntity.status(response.getCode()).body(response.toData());
	}

	@GetMapping("/rooms/account/{accountId}")
	public ResponseEntity<?> retrieveRelatedRooms(@PathVariable String accountId){
		var response = service.getRelatedRoomsRecords(accountId);
		return ResponseEntity.status(response.getCode()).body(response.toData());
	}

	@PutMapping("/rooms")
	public ResponseEntity<?> updateRoomR(@RequestBody Room room){
		var response = service.updateRoomRecord(room);
		return ResponseEntity.status(response.getCode()).body(response.toData());
	}

	@DeleteMapping ("/rooms/{id}")
	public ResponseEntity<?> deleteRoom(@PathVariable String id){
		var response = service.deleteRoomRecord(id);
		return ResponseEntity.status(response.getCode()).body(response.toData());
	}

}
