import java.util.ArrayList;

public class Tank extends Player {

	public static final int HP = 5600;
	public static final int TANK_ULT_ATK_DELAY = GamePanel.FPS * 5;;
	
	private int skippedFrames;
	
	/**
	 * Creates new tank character of coordinates x,y
	 * @param x x coordinate of tank
	 * @param y y coordinate of tank
	 * @param angle angle of tank
	 */
	public Tank(int x, int y, double angle) {
		super(x, y, angle, HP);
		setMoveAnimation(new Animation("assets/player-tank/player-tank-moving(%d).png", 1, 4, 6));
		setStandAnimation(new Animation("assets/player-tank/player-tank-standing(%d).png", 1, 2, 16));
		super.setSpeed(3);
		skippedFrames = 0;
	}

	/**
	 * Returns shot projectile
	 * @return Projectile shot
	 */
	public Projectile shoot() {
		if(skippedFrames == 3){
			skippedFrames = 0;
			playShootingSound();
			return new TankBullet(
					(int) (getX() + 20 + Player.DISTANCE_TO_BARREL * Math.cos(super.getAngle() * Math.PI / 180)),
					(int) (getY() + 20 + Player.DISTANCE_TO_BARREL * -Math.sin(super.getAngle() * Math.PI / 180)),
					getAngle() * Math.PI / 180);
		}
		skippedFrames++;
		return null;
	}
	
	/**
	 * Creates massive tank bullet for special
	 * @return tank special bullet
	 */
	public Projectile initiateSpecial() {
		return new TankBulletSpecial(
				(int) (getX() + (Player.DISTANCE_TO_BARREL + 20) * Math.cos(super.getAngle() * Math.PI / 180)),
				(int) (getY() + (Player.DISTANCE_TO_BARREL + 20) * -Math.sin(super.getAngle() * Math.PI / 180)),
				getAngle() * Math.PI / 180);
	}
	
	public void initiateUltimate(ArrayList<Actor> actors, ArrayList<Barrier> barriers, ArrayList<Projectile> bullets) {
		super.initiateUltimate(actors, barriers, bullets);
		actors.add(new TankForcefield(this));
	}
	
	public TankForcefield createForcefield(){
		return new TankForcefield(this);
	} 
}
