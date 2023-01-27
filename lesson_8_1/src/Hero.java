import kg.geektech.game.players.Boss;
import kg.geektech.game.players.GameEntity;
import kg.geektech.game.players.HavingSuperAbility;
import kg.geektech.game.players.SuperAbility;

public abstract class Hero extends GameEntity implements HavingSuperAbility {
    public SuperAbility ability;
    public Hero(int health, int damage, SuperAbility devourer, String name) {
        super(health,damage, name);
        this.ability = ability;
    }
    public SuperAbility getAbility(){
        return  ability;
    }
    public void hits(Boss boss){
        if (this.getHealth() > 0 && boss.getHealth() > 0){
            boss.setHealth(boss.getHealth() - this.getDamage());
        }
    }
}
