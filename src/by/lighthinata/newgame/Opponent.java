package by.lighthinata.newgame;
import java.io.Serializable;
import java.util.Random;


public class Opponent implements Cloneable, Serializable {
	private int health;
    private int maxHealth;
	private String name;
	private boolean block;

	protected static final Random RNG = new Random();

	public void setHealth (int health){
        if(health < getMaxHealth()) {
            this.health = health;
        }
        else{
            this.health = getMaxHealth();
        }
	}
	public int getHealth(){
		return health;
	}
	public void setName(String name){
		this.name = name;
	}
	public boolean getBlock() {
		return block;
	}
	public void setBlock(boolean block){
		this.block = block;
	}
	public String getName(){
		return name;
	}
    public int getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void receiveDamage(int damage){
		if (block){
				this.setHealth(this.getHealth() - Math.min(1, damage));
		}
		else{
			this.setHealth(this.getHealth() - damage);
		}
	}
	public int attack(Opponent target){
		if (block) {
			return 0;
		}
		int damage = RNG.nextInt(4);
		target.receiveDamage(damage);
		return damage;
	}

	public Opponent(){
		health = 20;
		name = "Enemy";
	}
	
	public Opponent(String name, int health){
		this.name = name;
		
		if(health > 0){
			this.health = health;
		}
	}
	@Override
	public Opponent clone() {
		try {
			Opponent opponent = (Opponent) super.clone();
			return opponent;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(e);
		}
	}

	
	public String toString() {
		return this.getClass().getSimpleName() + " "+ name + " (" + health + " hp)";
	}
}
