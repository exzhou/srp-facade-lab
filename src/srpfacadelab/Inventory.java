package srpfacadelab;

public class Inventory {
   

   public int calculateInventoryWeight(RpgPlayer player) {  //INVENTORY
      int sum=0;
      for (Item i: player.getInventory()) {
         sum += i.getWeight();
      }
      return sum;
   }

   public boolean checkIfItemExistsInInventory(RpgPlayer player, Item item) { //INVENTORY
      for (Item i: player.getInventory()) {
         if (i.getId() == item.getId()){
            return true;
         }
         return false;
      }
   }

   public void calculateStats(RpgPlayer player) { //PLAYER / INV
      for (Item i: player.getInventory()) {
         player.setArmour( player.getArmour() + i.getArmour());
      }
   }


   public void add(Item item, RpgPlayer player){
      player.inventory.add(item)
   }
}