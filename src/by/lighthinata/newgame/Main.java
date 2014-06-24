package by.lighthinata.newgame;

import java.util.ResourceBundle;
import java.util.Scanner;


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
		Hero hero = new Hero(rb.getString("HERO_NAME"), Integer.parseInt(rb.getString("HERO_HEALTH")), Hero.Gender.valueOf(rb.getString("HERO_GENDER")), Hero.Race.valueOf(rb.getString("HERO_RACE")));
		System.out.println("Greetings, " + hero.getName());
		Monster enemy = new Monster(rb.getString("ENEMY_NAME"),
				Integer.parseInt(rb.getString("ENEMY_HEALTH")),
				Monster.Size.valueOf(rb.getString("ENEMY_SIZE")),
				Monster.ClassMonster.valueOf(rb.getString("ENEMY_CLASSMONSTER")));
		battle(hero, enemy);

	}

}
