import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class FlowerTurret extends Actor implements Turret {
	
	private Image img;
	private double angle;
	
	public FlowerTurret(int x, int y, int width, int height){
		super(x, y, width, height);
		img = (new ImageIcon("assets/turret-flower/turret-flower.png")).getImage();
	}
	
	@Override
	public Projectile shoot() {
		return new FlowerBullet(super.getX(), super.getY(), super.getWidth(), super.getHeight(), angle);
	}

	@Override
	public void updateCoordinates(int newX, int newY) {
		super.move(newX, newY);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, super.getX(), super.getY(), super.getWidth(), super.getHeight(), null);
	}

	@Override
	public void act() {
		angle += Math.PI/30;
	}
}
