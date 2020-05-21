package srpfacadelab;


public class Facade {

    public RpgPlayer player;
    
    //Facade for the other class functions
    public void useItem(Item item) {
        return player.Items.useItem(item);
    }

    public boolean pickUpItem(Item item) {
        return player.Items.pickUpItem(item, player);
    }

    public void calculateStats() {
        return player.Inventory.calculateStats(player);
    }

    public boolean checkIfItemExistsInInventory(Item item) {
        return player.Inventory.checkIfItemExistsInInventory(player, item);
    }

    public int calculateInventoryWeight() {
        return player.Inventory.calculateInventoryWeight(player);
    }

    public void takeDamage(int damage) {
        player.Damage.takeDamage(damage, player);
    }
}