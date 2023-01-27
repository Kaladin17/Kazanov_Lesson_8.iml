package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Stun extends Hero{
    public Stun(int health, int damage, String name) {
        super(health, damage, SuperAbility.STUN, name);
    }


    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0 && this.getHealth() > 0) {
            int randomIndex = RPG_Game.random.nextInt(3) + 1;
            if (randomIndex == 1){
                boss.setDamage(boss.getDamage() * 0);
                System.out.println("Thor stunned the boss ");

            }
            else {boss.setDamage(50);}

    }
    }
}
