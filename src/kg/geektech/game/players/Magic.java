package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override

    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0 && this.getHealth() > 0) {
            int randomIndex = RPG_Game.random.nextInt(3) + 1;
            for (int i = 0; i < heroes.length; i++) {
                heroes[i].setDamage(heroes[i].getDamage() + randomIndex);
            }
            System.out.println("Scarlet witch increase damage heroes by " + randomIndex + " points");
        }
    }
}
