package pu.fmi.web.hangman;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HangmanService {
	private AtomicInteger nextGameId = new AtomicInteger();
	
	@Value("${dictionary}")
	private List<String> dictionary;
	
	private Map<String, GameDetails> games = new ConcurrentHashMap<>();

	public GameDetails startNewGame() {
		Random random = new Random();
		int index = random.nextInt(dictionary.size());
		String word = dictionary.get(index);
		String gameId = String.valueOf(nextGameId.getAndIncrement());
		GameDetails game = new GameDetails();
		game.setId(gameId);
		game.setCharCount(word.length());
		game.setFirstChar(word.charAt(0));
		game.setLastChar(word.charAt(word.length() - 1));
		StringBuilder current = new StringBuilder(word);
		game.setCurrent(current.toString());
		games.put(gameId, game);
		return game;
	}
	
	public GameDetails getGameDetails(String gameId) {
		return games.get(gameId);
	}
	
	public void getGameDetails(String gameId, String character) {
		
	}
}
