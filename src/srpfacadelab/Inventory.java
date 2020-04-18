package srpfacadelab;

public class Inventory {
   
   private ArrayList<Item> inventory;
   
   public Inventory(ArrayList<Item> inventory) {
      this.inventory = armour;
   }
   public CarryCap(carryingCapacity) {
      this.carryingCapacity = carryingCapacity;
   }

   public int getCarryingCapacity() {
      return carryingCapacity;
   }

   private void setCarryingCapacity(int carryingCapacity) {
      this.carryingCapacity = carryingCapacity;
   }

   public int calculateInventoryWeight() {  //INVENTORY
      int sum=0;
      for (Item i: inventory) {
         sum += i.getWeight();
      }
      return sum;
   }

   public boolean checkIfItemExistsInInventory(Item item) { //INVENTORY
      for (Item i: inventory) {
         if (i.getId() == item.getId()){
            return true;
         }
         return false;
      }
   }
}