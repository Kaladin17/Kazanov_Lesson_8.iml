package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class BloodRain extends Hero {
    private int bleeding;

    public BloodRain(int health, int damage, int bleeding, String name) {
        super(health, damage, SuperAbility.BLEEDING, name);
        this.bleeding = bleeding;
    }
    public int getBleeding() {
        return bleeding;
    }
    public void setBleeding(int bleeding) {
        this.bleeding = bleeding;
    }
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            int randomIndex = RPG_Game.random.nextInt(2) + 1;
            if (randomIndex == 1) {
                this.setBleeding(getBleeding() + 5);
                System.out.println("Black Panther bring about bleeding ");
            } else {
                this.setBleeding(getBleeding() + 10);
                System.out.println("Black Panther bring about critical bleeding ");
            }
        }
    }
    public String toString() {
        return super.toString() + " bleeding points: " + this.bleeding;
    }
}
