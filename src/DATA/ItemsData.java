package DATA;

import Model.Item;
import java.util.ArrayList;
import java.util.List;

/**
 * this class represent the item data
 * @author Yu Liu
 */
public class ItemsData {

    private static ItemsData itemData = null;
    private List<Item> ItemsList = new ArrayList<Item>();

    /**
     * this method show the property of every items
     */
    public ItemsData() {
        // Item(String name, int price, int strength, int agility, int stamina, int happiness) {
        
        ItemsList.add(new Item("Water",20,2,0,2,15));
        
        ItemsList.add(new Item("Cookie",35,5,0,4,15));
        
        ItemsList.add(new Item("Milk",45,8,0,10,20));
        
        ItemsList.add(new Item("Salmon",55,15,0,15,10));
  
        ItemsList.add(new Item("Steak",75,25,0,20,30));
        
        ItemsList.add(new Item("Ham",90,35,0,25,30));
    
        ItemsList.add(new Item("Ball",120,0,30,5,20));
 
        ItemsList.add(new Item("Doll",150,0,15,10,40));
  
        ItemsList.add(new Item("Cat Toy",210,0,40,20,30));

        ItemsList.add(new Item("invincible",10000,9999,0,0,10));
    }

   
    public static ItemsData getInstance() {
        if (itemData == null) {
            itemData = new ItemsData();
        }
        return itemData;
    }
    
    /**
     * caculate the count of item list
     * @return size of the item lists
     */
    public int count(){
        return ItemsList.size();
    }
    
    /**
     * get the item property
     * @param index
     * @return get item
     */
    public Item get(int index){
        return ItemsList.get(index);
    }
    
    /**
     * get the name of item
     * @param name
     * @return 
     */
    public Item get(String name){
        for(Item goods:ItemsList){
            if(goods.getName().equalsIgnoreCase(name)){
                return goods;
            }
        }
        return null;
    }
}
