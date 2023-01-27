package kg.geektech.game.players;

public abstract class Hero extends GameEntity implements HavingSuperAbility {
    public void setAbility(SuperAbility ability) {
        this.ability = ability;
    }

    private SuperAbility ability;

    public Hero(int health, int damage, SuperAbility ability, String name) {
        super(health, damage, name);
        this.ability = ability;
    }

    public SuperAbility getAbility() {
        return ability;
    }

    public void hits(Boss boss) {
        if (this.getHealth() > 0 && boss.getHealth() > 0) {
            boss.setHealth(boss.getHealth() - this.getDamage());
        }
    }
    public void maxHealth(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0 && this.getHealth() > 300) { //сделать возврат к начальнму значению
            this.setHealth(300);
        }
    }public void minPoints(Boss boss, Hero[] heroes) {
        if (this.getHealth() == 0) { //сделать возврат к начальнму значению
            this.setDamage(0);
        }
    }

}
