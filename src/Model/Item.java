package Model;

/**
 * this class represent the item statement
 * @author Yu Liu
 */
public class Item {

    private String name;
    private int price;
    private int strength;
    private int agility;
    private int stamina;
    private int happiness;

    /**
     *
     * @param name of item name
     * @param price of item price
     * @param strength of item strength
     * @param agility of item aglity
     * @param stamina of item stamina
     * @param happiness of item happiness
     */
    public Item(String name, int price, int strength, int agility, int stamina, int happiness) {
        this.name = name;
        this.price = price;
        this.strength = strength;
        this.agility = agility;
        this.stamina = stamina;
        this.happiness = happiness;
    }

    /**
     * get the item name
     * @return item name
     */
    public String getName() {
        return name;
    }

    /**
     * set the name of item
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the price of item
     * @return the price of item
     */
    public int getPrice() {
        return price;
    }

    /**
     * set the price of item
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * get the strength of item
     * @return the strength of item
     */
    public int getStrength() {
        return strength;
    }

    /**
     * set the strength of item
     * @param strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * get the agility of item
     * @return
     */
    public int getAgility() {
        return agility;
    }

    /**
     * set the agility of item
     * @param agility
     */
    public void setAgility(int agility) {
        this.agility = agility;
    }

    /**
     * get the stamina of item
     * @return
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * set the stamina of item
     * @param stamina
     */
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    /**
     * get the happiness of item
     * @return 
     */
    public int getHappiness() {
        return happiness;
    }

    /**
     * set the happiness of item
     * @param happiness
     */
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }
  
    @Override
    public String toString() {
        return "name: " + name + ", price: " + price + "\n\tstrength: +" + strength + ", agility: +" + agility + ", stamina: +" + stamina + ", happiness: +" + happiness;
    }

}
