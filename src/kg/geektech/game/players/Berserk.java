package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {
    private int blockedDamage;

    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0 && this.getHealth() > 0) {
            int randomIndex = RPG_Game.random.nextInt(3)+1;

            boss.setHealth(boss.getHealth() - boss.getDamage()/5);
            System.out.println("Hulk return 20% hit Thanos ");


        }
    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }
}
