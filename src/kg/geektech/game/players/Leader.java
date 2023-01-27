package kg.geektech.game.players;

public class Leader extends Hero{
    public Leader(int health, int damage, String name) {
        super(health, damage, SuperAbility.SHIELD, name);
    }

    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth()>0){
            this.setHealth(getHealth() + boss.getDamage()*2/5);
        }

    }public void passiveApplySuperPower(Hero[] heroes) {
        if (this.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                heroes[i].setHealth((int) (heroes[i].getHealth() * 1.05));
                this.setHealth((int) (this.getHealth() / 1.05));

            }System.out.println("Captain America is still alive! Morale of allies increased!");
        }
        else {
            for (int i = 0; i < heroes.length; i++) {
                heroes[i].setHealth((int) (heroes[i].getHealth() / 1.05));
            }
            System.out.println("Captain America is dead! Morale of allies decreased!");
        }

    }
}
