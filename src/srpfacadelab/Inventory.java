package srpfacadelab;

public class Inventory {
   
   private ArrayList<Item> inventory;
   
   public Inventory() {
      this.inventory = new ArrayList<item>;
   }

   public int calculateInventoryWeight() {  //INVENTORY
      int sum=0;
      for (Item i: inventory) {
         sum += i.getWeight();
      }
      return sum;
   }

   public void calculateStats(Armour armour) { //PLAYER / INV
        for (Item i: inventory) {
            armour.setArmour( armour.getArmour() + i.getArmour());
        }
    }

   public boolean checkIfItemExistsInInventory(Item item) { //INVENTORY
      for (Item i: inventory) {
         if (i.getId() == item.getId()){
            return true;
         }
         return false;
      }
   }

   public void add(Item item){
      inventory.add(item)
   }
}