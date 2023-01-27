package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {
    private int blockedDamage;

    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getDamage() != 0) {
            setBlockedDamage(RPG_Game.random.nextInt(boss.getDamage() + 1));
            if (boss.getHealth() > 0 && this.getHealth() > 0) {
                this.setHealth(boss.getHealth() - blockedDamage);
                boss.setHealth(boss.getHealth() - blockedDamage + this.getDamage());

            }
        }

    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }
}
