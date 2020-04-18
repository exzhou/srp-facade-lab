package srpfacadelab;

import java.util.List;
import java.util.ArrayList;
import srpfacadelab.Health;
import srpfacadelab.Armour;
import srpfacadelab.CarryCap;
import srpfacadelab.Iventory;


public class RpgPlayer {
    public static final int MAX_CARRYING_CAPACITY = 1000;
    public static final int MAX_HEALTH = 1000;
    public static final int INITIAL_ARMOR = 1000;


    private final IGameEngine gameEngine;

    private Health health;

    private int maxHealth;

    private Armour armour;

    private List<Item> inventory;

    // How much the player can carry in pounds
    private CarryCap carryingCapacity;

    public RpgPlayer(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        inventory = new Inventory();
        health = new Health(MAX_HEALTH, MAX_HEALTH);
        armour = new Armour(INITIAL_ARMOR);
        maxHealth = health.getMaxHealth()
        carryingCapacity = new CarryCap(MAX_CARRYING_CAPACITY);
    }

    public void useItem(Item item) { //PLAYER
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = gameEngine.getEnemiesNear(this);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

    public boolean pickUpItem(Item item) { //PLAYER
        int weight = this.inventory.calculateInventoryWeight();
        if (weight + item.getWeight() > this.carryingCapacity.getCarryingCapacity())
            return false;

        if (item.isUnique() && this.inventory.checkIfItemExistsInInventory(item))
            return false;

        // Don't pick up items that give health, just consume them.
        if (this.item.getHeal() > 0) {
            this.health.setHealth(health.getHealth + item.getHeal());

            if (this.health.getHealth() > maxHealth)
                this.health.setHealth(maxHealth);

            if (item.getHeal() > 500) {
                gameEngine.playSpecialEffect("green_swirly");
            }

            return true;
        }

        if (item.isRare()){
            //IMPLEMENTATION 1
            if(item.isUnique()){
                gameEngine.playSpecialEffect("blue_swirly");
            }
            else{
                gameEngine.playSpecialEffect("cool_swirly_particles");
            }

        }
        this.inventory.add(item);

        this.inventory.calculateStats(this.Armour.getArmour);

        return true;
    }

    

    public void takeDamage(int damage) { //KEEP
        if (damage < armour) {
            gameEngine.playSpecialEffect("parry");
        }
        int damageToDeal = damage - armour;
        //IMPLEMENTATION 2
        if(carryingCapacity.getCarryingCapacity() <= MAX_CARRYING_CAPACITY){
            damageToDeal -= (damageToDeal* .25)
        }
        health.setHealth(health.getHealth() - damageToDeal);

        gameEngine.playSpecialEffect("lots_of_gore");
    }
}
