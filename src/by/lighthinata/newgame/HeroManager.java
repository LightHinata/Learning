package by.lighthinata.newgame;

import java.io.*;
import java.util.Scanner;

public class HeroManager{
    public static Hero createHero(){
        Hero hero = new Hero();
        System.out.println("Please, enter name of the hero: ");
        Scanner sc = new Scanner(System.in);
        hero.setName(sc.next());
        System.out.println("Please, enter gender of the hero: 0 for male, 1 for female ");
        while(true) {
            if (sc.hasNextInt()) {
                int input = sc.nextInt();
                if (input == 0) {hero.setGender(Hero.Gender.MALE);
                    break;
                } else if (input == 1) {
                    hero.setGender(Hero.Gender.FEMALE);
                    break;
                } else {
                    System.out.println("Incorrect input! Please, enter gender of the hero: 0 for male, 1 for female ");
                    sc.nextLine();
                }
            }
        }
        System.out.println("Please, enter race of the hero: 1 for HUMAN, 2 for ELF, 3 for DWARF, 4 for DRAGON: ");
        OUT: while (true){
            if(sc.hasNextInt()){
                int input = sc.nextInt();
                switch (input) {
                    case 1:
                        hero.setRace(Hero.Race.HUMAN);
                        break OUT;
                    case 2:
                        hero.setRace(Hero.Race.ELF);
                        break OUT;
                    case 3:
                        hero.setRace(Hero.Race.DWARF);
                        break OUT;
                    case 4:
                        hero.setRace(Hero.Race.DRAGON);
                        break OUT;
                    default:
                        System.out
                                .println("Incorrect input! Please, enter race of the hero: 1 for HUMAN, 2 for ELF, 3 for DWARF, 4 for DRAGON: ");
                        sc.nextLine();
                }
            }
        }
        hero.setMaxHealth(25);
        hero.setHealth(hero.getMaxHealth());
        saveHero(hero);
        return hero;
    }

        public static void saveHero(Hero hero){
        try {
            FileOutputStream fos = new FileOutputStream("hero.sav");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(hero);
        } catch (IOException ignored){}
    }
    public static Hero readHero(){
        File file = new File("hero.sav");
        if(file.exists()){
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                return (Hero) ois.readObject();
            } catch (FileNotFoundException | ClassNotFoundException ignored) {

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return createHero();
    }
}
