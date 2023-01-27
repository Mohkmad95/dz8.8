import kg.geektech.game.players.Boss;
import kg.geektech.game.players.Hero;
import kg.geektech.game.players.SuperAbility;

public class Orc extends Hero {
    public Orc(int health, int damage, String name){
        super(health,damage, SuperAbility.DEVOURER, name);

    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0 && this.getHealth() > 0){
            boss.setHealth(boss.getDamage() + 25);
            for (int i = 0; i <heroes.length; i++){
                heroes[i].setHealth(heroes[i].getHealth() * 2);
            }
            System.out.println("Орк использовал суперсилу");
            // все я больше не могу прошу понять и простить, не успею до конца ДЭДлайна  аэм сори бро
        }
    }
}
