package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss(1000, 50, "Глава всех ");
        Warrior warrior = new Warrior(280, 10, "Тот самый");
        Medic doc = new Medic(250, 5, 15, "Хирург");
        Magic magic = new Magic(270, 20, "Калдун");
        Berserk berserk = new Berserk(260, 15, "Не придума))))");
        Medic assistant = new Medic(290, 5, 5, "Терапевт");
        Hero[] heroes = {warrior, doc, magic, berserk, assistant};

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
            System.out.println("Heroes won!!!");
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
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.hits(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getDefence() != heroes[i].getAbility()) {
                heroes[i].hits(boss);
                if (heroes[i].getHealth() > 0) {
                    heroes[i].applySuperPower(boss, heroes);
                }
            }
        }
        printStatistics(boss, heroes);
    }
}
