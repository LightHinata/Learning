package by.lighthinata.newgame;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import by.lighthinata.newgame.Monster.ClassMonster;
import by.lighthinata.newgame.Monster.Size;


public class Main {

	public static void battle(Opponent hero, Opponent enemy) {
		System.out.println(hero.toString() + "\nversus\n" + enemy.toString());
		System.out.println("Rules of the game:");
		System.out.println("Hero can attack or block hits.");
		System.out.println("Battle is starting!");
		while (hero.getHealth() > 0 && enemy.getHealth() > 0){
			try {
				Thread.sleep(1000) ;
			} catch (InterruptedException e) {}
			System.out.println("Enter 0 to attack or 1 to block hit: ");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			if(input == 1 || input == 0){
				hero.setBlock(input == 1);
				if (hero.getHealth() > 0){
					System.out.printf("%s (%s hp) attacks by %s hp\n", hero.getName(), hero.getHealth(), hero.attack(enemy));

				}
				if (enemy.getHealth() > 0){
					System.out.printf("%s (%s hp) attacks by %s hp\n", enemy.getName(), enemy.getHealth(), enemy.attack(hero));

				}
			}
			else {
				System.out.println("Incorrect input. Plese, enter 0 to attack or 1 to block hit: ");
			}
		}
		if (hero.getHealth() > 0){
			System.out.println("Congratulations! You saved our kingdom!");
		} else {
			System.out.println("It's a pity! Please, try again :-(");
		}
	}

	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("by.lighthinata.newgame.game_options");
		Hero hero = new Hero(rb.getString("HERO_NAME"), 
							Integer.parseInt(rb.getString("HERO_HEALTH")), 
							Hero.Gender.valueOf(rb.getString("HERO_GENDER")), 
							Hero.Race.valueOf(rb.getString("HERO_RACE")));
		ArrayList<Monster> list = new ArrayList<>();
		list.add(new Monster("Cyclops", 25, Size.BIG, ClassMonster.HALF_BOSS));
		list.add(new Monster("Polynomial", 15, Size.MEDIUM, ClassMonster.ORDINARY));
		list.add(new Monster("Злобака-кобелина", 25, Size.SMALL, ClassMonster.ORDINARY));
		list.add(new Monster("Taurus", 22, Size.MEDIUM, ClassMonster.ORDINARY));
		list.add(new Monster("Orc", 28, Size.BIG, ClassMonster.HALF_BOSS));
		list.add(new Monster("Ogre", 23, Size.BIG, ClassMonster.HALF_BOSS));
		System.out.println("Greetings, " + hero.getName() + "\nSelect your enemy: ");
		for(int i = 0; i < list.size(); i++){
			System.out.println(i + ": " + list.get(i).toString());
		}
		System.out.println("Enter number of the monster: ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		Opponent enemy = list.get(input);
//		Monster enemy = new Monster(rb.getString("ENEMY_NAME"),
//									Integer.parseInt(rb.getString("ENEMY_HEALTH")),
//									Monster.Size.valueOf(rb.getString("ENEMY_SIZE")),
//									Monster.ClassMonster.valueOf(rb.getString("ENEMY_CLASSMONSTER")));
		battle(hero, enemy);

	}

}
