import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
	
	public static final int WINDOW_WIDTH = 1280;
	public static final int WINDOW_HEIGHT = 720;
	public static final int GRID_COLS = 32;
	public static final int GRID_ROWS = 18;
	public static final int CELL_WIDTH = WINDOW_WIDTH / GRID_COLS;
	public static final int CELL_HEIGHT= WINDOW_HEIGHT / GRID_ROWS;
	
	private JPanel cardPanel;
	private GamePanel game;
	private StartScreen startScreen;
	private CharacterSelectionScreen characterSelectionScreen;
	
	/**
	 * Initializes GUI window
	 */
	public Main() {
		setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
		
		startScreen = new StartScreen(this);
		characterSelectionScreen = new CharacterSelectionScreen(this);
		game = new GamePanel();
		addMouseListener(startScreen);
		addMouseListener(characterSelectionScreen);
		addMouseListener(game);
		addKeyListener(game);
		add(game);
		
		cardPanel.add(startScreen, "1");
		cardPanel.add(characterSelectionScreen, "2");
		cardPanel.add(game, "3");
		
		add(cardPanel);
		setVisible(true);
	}
	
	/**
	 * Initializes main
	 * @param args
	 */
	public static void main(String[] args) {
		Main main = new Main();
	}
	
	/**
	 * Changes the panel
	 * @param name name of the other panel
	 */
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
		if (name.equals("3"))
			game.startThread();
	}
	
	/**
	 * Determines whether the game started or not
	 * @return true if the game started, false otherwise
	 */
	public boolean gameStarted() {
		return game.gameStarted();
	}
	
	/**
	 * Sets the players that is playing right now
	 * @param playerNumber the player that is being updated
	 * @param player character of the player
	 */
	public void setPlayers(Player p1, Player p2) {
		game.setPlayers(p1, p2);
	}
	
	/**
	 * 
	 * @return reference to GamePanel in the window 
	 */
	public GamePanel getGame() {
		return game;
	}
}
