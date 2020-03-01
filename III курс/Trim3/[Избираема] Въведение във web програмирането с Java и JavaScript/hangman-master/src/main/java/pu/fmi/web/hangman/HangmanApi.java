package pu.fmi.web.hangman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hangman")
public class HangmanApi {
	
	@Autowired
	private HangmanService hangmanService;

	@PostMapping("/games")
	public GameDetails startNewGame() {
		return hangmanService.startNewGame();
	}
	
	@GetMapping("/games/{gameId}")
	public GameDetails getGameDetails(@PathVariable String gameId) {
		return hangmanService.getGameDetails(gameId);
	}
	
	@PostMapping("/games/{gameId}/try")
	public void getGameDetails(@PathVariable String gameId, String character) {
		
	}
}
