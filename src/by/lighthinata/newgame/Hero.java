package by.lighthinata.newgame;

public class Hero extends Opponent {
	private Gender gender = Gender.MALE;
	private Race race = Race.HUMAN;
	public enum Gender {
		MALE, FEMALE
	}
	public enum Race {
		HUMAN, ELF, DWARF, DRAGON
	}
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public String toString(){
		return super.toString()
				+ "\nGender: " + gender.toString().toLowerCase()
				+ "\nRace: " + race.toString().toLowerCase();
	}
	public Hero() {
		
	}

	public Hero(String name, int health) {
		super(name, health);
		
	}
	
	public Hero(String name, int health, Gender gender, Race race){
		super(name, health);
		this.gender = gender;
		this.race = race;
	}
	
	@Override
	public Hero clone() throws CloneNotSupportedException{
		Hero hero = (Hero) super.clone();
		hero.gender = gender;
		hero.race = race;
		return hero;
	}
}
