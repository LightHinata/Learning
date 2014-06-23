package by.lighthinata.newgame;

public class Monster extends Hero{

	private Size size = Size.MEDIUM;
	private ClassMonster classMonster = ClassMonster.ORDINARY;
	public enum Size {
		SMALL, MEDIUM, BIG
	}
	public enum ClassMonster{
		ORDINARY, HALF_BOSS
	}
	public Monster(Size size) {
		super();
		this.size = size;
	}
	public Monster(String name, int health, Size size, ClassMonster classMonster) {
		super(name, health);
		this.size = size;
		this.classMonster = classMonster;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}

	public String toString() {
		return super.toString() + " of size " + size.toString().toLowerCase() + " of class " + classMonster.toString().toLowerCase();
	}

	@Override
	public int attack(Hero target){
		if (classMonster == ClassMonster.HALF_BOSS){
			if(RNG.nextDouble() <= 0.2){
				int damage = target.getHealth() / 5;
				target.receiveDamage(damage);
				return  damage;
			}
		}
		return super.attack(target);
	}
}
