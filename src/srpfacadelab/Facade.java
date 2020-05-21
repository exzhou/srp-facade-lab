package srpfacadelab;


public class Facade {

    public RpgPlayer player;
    
    //Facade for the other class functions
    public void useItem(Item item, RpgPlayer player) {
        return Items.useItem(item);
    }

    public boolean pickUpItem(Item item, RpgPlayer player) {
        return Items.pickUpItem(item, player);
    }

    public void calculateStats(RpgPlayer player) {
        return Inventory.calculateStats(player);
    }

    public boolean checkIfItemExistsInInventory(Item item, RpgPlayer player) {
        return Inventory.checkIfItemExistsInInventory(player, item);
    }

    public int calculateInventoryWeight(RpgPlayer player) {
        return Inventory.calculateInventoryWeight(player);
    }

    public void takeDamage(int damage, RpgPlayer player) {
        Damage.takeDamage(damage, player);
    }
}