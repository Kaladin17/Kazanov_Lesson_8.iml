package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss(2000, 50, "Thanos");
        Warrior warrior = new Warrior(280, 10, "Iron man");
        Medic doc = new Medic(250, 5, 10, "doctor Strange");
        Berserk berserk = new Berserk(260, 15, "Hulk");
        Medic assistant = new Medic(290, 5, 5, "Wong");
        Leader leader = new Leader(250, 10, "Captain America");
        Magic magic = new Magic(270, 20, "Scarlet witch");
        Stun stun = new Stun(250, 15, "Thor");
        BloodRain bloodRain = new BloodRain(230, 10, 0, "Black Panther");
        Hero[] heroes = {warrior, doc, leader, bloodRain, berserk, assistant, stun, magic};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -----------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Avengers won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Thanos won!!!");
        }
        return allHeroesDead;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.hits(heroes);
        heroes[2].passiveApplySuperPower(heroes);
        heroes[3].damageOverTime(boss);
        // пассивная способность leader, ее босс не блокирует
        //Hero.maxHealth(heroes); не работает ссылка на метод

        for (int i = 0; i < heroes.length; i++) {
            if (boss.getDefence() != heroes[i].getAbility()) {
                    heroes[i].hits(boss);
                    heroes[i].applySuperPower(boss, heroes);
                    heroes[i].minPoints(boss, heroes);
                }
            }
         printStatistics(boss, heroes);
    }
}

