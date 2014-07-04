package by.lighthinata.newgame;

import by.lighthinata.newgame.Monster.ClassMonster;
import by.lighthinata.newgame.Monster.Size;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	
	public static void main(String[] args) throws CloneNotSupportedException {
        Hero hero = HeroManager.readHero();
		ArrayList<Monster> list = new ArrayList<>();
		list.add(new Monster("Cyclops", 25, Size.BIG, ClassMonster.HALF_BOSS));
		list.add(new Monster("Polynomial", 15, Size.MEDIUM, ClassMonster.ORDINARY));
		list.add(new Monster("Злобака-Кобелина", 25, Size.SMALL, ClassMonster.ORDINARY));
		list.add(new Monster("Taurus", 22, Size.MEDIUM, ClassMonster.ORDINARY));
		list.add(new Monster("Orc", 28, Size.BIG, ClassMonster.HALF_BOSS));
		list.add(new Monster("Ogre", 23, Size.BIG, ClassMonster.HALF_BOSS));
		System.out.println("Greetings, " + hero.toString());
		while(true){
			Hero hero_clone = hero.clone();
			System.out.println("Select your enemy: ");
			for(int i = 0; i < list.size(); i++){
				System.out.println(i + ": " + list.get(i).toString());
			}
			System.out.println("Enter number of the monster or -1 to exit: ");
			Scanner sc = new Scanner(System.in);
			while (!sc.hasNextInt()){
				System.out.println("Please, enter a number: ");
				sc.nextLine();
			}
			int input = sc.nextInt();
			if (input == -1){
				System.out.println("We are waiting for you, our savior!");
				break;
			}
			Opponent enemy = list.get(input).clone();
			boolean isVictory = BattleManager.battle(hero_clone, enemy);
            if (isVictory){
                hero.setVictories(hero.getVictories() + 1);
                HeroManager.saveHero(hero);
            }
		}
		
	}

}
