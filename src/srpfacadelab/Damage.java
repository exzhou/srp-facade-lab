package srpfacadelab;

public class Damage {
   
   public void takeDamage(int damage, RpgPlayer player) {
        if (player.getDamage() < player.getArmour()) {
            gameEngine.playSpecialEffect("parry");
        }

        int damageToDeal = damage - player.getArmour();
        player.setHealth( player.getHealth() - damageToDeal);

        gameEngine.playSpecialEffect("lots_of_gore");
    }

}