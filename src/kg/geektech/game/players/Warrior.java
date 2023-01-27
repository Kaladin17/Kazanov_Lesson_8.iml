package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Warrior extends Hero {

    public Warrior(int health, int damage, String name) {

        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }




    public void applySuperPower(Boss boss, Hero[] heroes) {
            if (boss.getHealth() > 0 && this.getHealth() > 0) {
                int randomIndex = RPG_Game.random.nextInt(3)+1;

                    boss.setHealth(boss.getHealth() - this.getDamage()*randomIndex);
                    System.out.println("Drax hit critical damage by " + this.getDamage()*randomIndex + " points!");


            }
    }

}
