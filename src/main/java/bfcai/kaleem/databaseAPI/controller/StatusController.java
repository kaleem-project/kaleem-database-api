package bfcai.kaleem.databaseAPI.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDateTime;
import java.util.HashMap;

@Controller
@RequestMapping("/api/v3/database")
public class StatusController {

	@GetMapping("/status")
	public ResponseEntity<?> checkStatus(HttpServletRequest request){
		int portNumber = request.getLocalPort();
		LocalDateTime timeNow = LocalDateTime.now();
		HashMap<String, String> responseMap = new HashMap<>();
		responseMap.put("Status", "Running");
		responseMap.put("Message", "Database application is running now on port " + portNumber);
		responseMap.put("Start_Time", "" + timeNow);
		return ResponseEntity.status(200).body(responseMap);
	}

}
