package srpfacadelab;

import java.util.List;
import java.util.ArrayList;


public class RpgPlayer {
    public static final int MAX_CARRYING_CAPACITY = 1000;

    private final IGameEngine gameEngine;

    private int health;

    private int maxHealth;

    private int armour;

    private List<Item> inventory;

    // How much the player can carry in pounds
    private int carryingCapacity;

    public RpgPlayer(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        inventory = new ArrayList<Item>();
        carryingCapacity = MAX_CARRYING_CAPACITY;

        //SRP Classes
        this.Inventory = new Inventory();
        this.Items = new Items();
        this.Damage = new Damage();

    }


    //Facade for the other class functions
    public void useItem(Item item) {
        return this.Items.useItem(item);
    }

    public boolean pickUpItem(Item item) {
        return this.Items.pickUpItem(item, this);
    }

    private void calculateStats() {
        return this.Inventory.calculateStats(this);
    }

    private boolean checkIfItemExistsInInventory(Item item) {
        return this.Inventory.checkIfItemExistsInInventory(this, item);
    }

    private int calculateInventoryWeight() {
        return this.Inventory.calculateInventoryWeight(this);
    }

    public void takeDamage(int damage) {
        this.Damage.takeDamage(damage, this);
    }
    
    
    
    //Added Getters and Setters after Refactor
    public List<Item> getInventory() {
        return this.inventory;
    }


    //Initial Getters and Setters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getArmour() {
        return armour;
    }

    private void setArmour(int armour) {
        this.armour = armour;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    private void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
}