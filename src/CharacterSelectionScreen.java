import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CharacterSelectionScreen extends JPanel implements MouseListener {

	private Image characters;
	private Image player;
	private Main main;
	private int playerNumber;
	
	public CharacterSelectionScreen(Main main){
		this.main = main;
		addMouseListener(this);
		characters = (new ImageIcon("assets/character-selection-screen.png")).getImage();
		player = (new ImageIcon("assets/character-selection-p1.png")).getImage();
		playerNumber = 1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!main.gameStarted()){
			int x = e.getX();
			int y = e.getY();
			if(playerNumber == 1){
				if(x >= 100 && x <= 420 && y >= 45 && y <= 325){
					main.setPlayer(1, new Tank(1, 8, 0));
					player = (new ImageIcon("assets/character-selection-p2.png")).getImage();
					repaint();
					playerNumber++;
				}
				else if(x >= 480 && x <= 800 && y >= 45 && y <= 325){
					main.setPlayer(1, new Damager(1, 8, 0));
					player = (new ImageIcon("assets/character-selection-p2.png")).getImage();
					repaint();
					playerNumber++;
				}
				else if(x >= 880 && x <= 1160 && y >= 45 && y <= 325){
					main.setPlayer(1, new Builder(1, 8, 0));
					player = (new ImageIcon("assets/character-selection-p2.png")).getImage();
					repaint();
					playerNumber++;
				}
			}
			else if(playerNumber == 2){
				if(x >= 100 && x <= 420 && y >= 45 && y <= 325){
					main.setPlayer(2, new Tank(30, 8, 180));
					player = (new ImageIcon("assets/character-selection-start.png")).getImage();
					repaint();
					playerNumber++;
				}
				else if(x >= 480 && x <= 800 && y >= 45 && y <= 325){
					main.setPlayer(2, new Damager(30, 8, 180));
					player = (new ImageIcon("assets/character-selection-start.png")).getImage();
					repaint();
					playerNumber++;
				}
				else if(x >= 880 && x <= 1160 && y >= 45 && y <= 325){
					main.setPlayer(2, new Builder(30, 8, 180));
					player = (new ImageIcon("assets/character-selection-start.png")).getImage();
					repaint();
					playerNumber++;
				}
			}
			else if(playerNumber == 3){
					main.changePanel("2");
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	public void paintComponent(Graphics g){
		g.drawImage(characters, 0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT, null);
		
		g.drawImage(player, 620, 350, 530, 293, null);
	}
}
