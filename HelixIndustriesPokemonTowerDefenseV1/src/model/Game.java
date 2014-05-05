package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import maps.Map;

import ObserverModel.PanelObservable;

public class Game extends PanelObservable {

	private final static int MAX_PLAYERS = 2; // The most we can have is 2 for
												// multiplayer. But will usually
												// be 1.

	// move this somewhere else
	private final static int spriteWidth = 10;
	private final static int spriteHeight = 10;
	private final static int spriteRows = 5;
	private final static int spriteColumns = 5;

	public static Timer gameTimer;
	private int spawnerOffset;
	private int moveOffset;

	private List<Map> mapList;

	private Map currentMap; // dont know if we want this for sure.
	// Do we want the game class handling everything (main screen, map choice,
	// menus) or just the actual
	// game at hand?

	private List<Player> players = new ArrayList<Player>(MAX_PLAYERS); // A list
																		// of
																		// players.
																		// yup.

	// private ArrayList<Mob> mobs;
	// private ArrayList<Tower> towers;

	public Game() { // added constructor.
		// add observers and other things.
		mapList = new ArrayList<Map>();
		gameTimer = new Timer(1, new GameTimerListener());
	}

	public void startTimer() {
		gameTimer.start();
	}

	public void addMap(Map input) {
		mapList.add(input);
	}

	public static void main(String[] args) {
		/*
		 * BufferedImage pokemonSpriteSheet = ImageIO.read(new
		 * File("Images/CondensedPokemonSprites.png")); BufferedImage[] sprites
		 * = new BufferedImage[spriteRows*spriteColumns];
		 * 
		 * for(int i = 0; i<spriteColumns;i++) { for(int j = 0;
		 * i<spriteRows;j++) { sprites[(i*spriteColumns)+j] =
		 * pokemonSpriteSheet.getSubimage( i*spriteWidth, j*spriteHeight,
		 * spriteWidth, spriteHeight); }
		 * 
		 * ArrayList<Tower> towers = null; ArrayList<Mob> mobs = null; for(Tower
		 * t:towers) { //attack for every mob in range once timer goes
		 * off(probably call function) }
		 * 
		 * for(Mob m:mobs) { //move to next tile every time the timer goes
		 * off(probably call function) } } //Set up listeners for placing
		 * towers, //Set up Timer and listeners for tower attacks.
		 */
	}

	public Map getCurrentMap() { // added this
		return this.currentMap;
	}

	public void setMap(Map map) { // added this
		this.currentMap = map;
	}

	public void addPlayer(Player player) { // added this
		players.add(player);
	}

	public List<Player> getPlayers() { // added this
		return players;
	}

	public Player getPlayer(int i) {
		return players.get(i);
	}

	private class GameTimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			// moving mobs is synced with timer
			moveOffset++;
			if (moveOffset > 600) {
				currentMap.moveMobs();
				moveOffset = 0;
			}

			// spawning is synced~~~~~~~~~~
			spawnerOffset++;
			if (spawnerOffset > 3000) {
				currentMap.sendWave();
				spawnerOffset = 0;
			}
			// spawning ~~~~~~~~~~~~~~~~~~~

			// sync towers in here

			notifyObservers();

		}

	}

}
