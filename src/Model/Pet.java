package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * this class represent the pet object
 * @author Yu Liu
 */
public class Pet {

    private String name;
    private int strength;     
    private int agility;      
    private int stamina;      
    private int happiness;   
    private int money;        
    private Map<Item, Integer> goodsMap;

    /**
     *
     * @param name
     */
    public Pet(String name) {
        this.name = name;
        this.strength = 10;
        this.agility = 10;
        this.stamina = 100;
        this.happiness = 100;
        this.money = 10000;
        goodsMap = new HashMap<Item, Integer>();
    }

    /**
     * get the name of pet
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set the name of pet
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the strength of pet
     * @return
     */
    public int getStrength() {
        return strength;
    }

    /**
     *set the strength of pet
     * @param strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * get agility of pet
     * @return
     */
    public int getAgility() {
        return agility;
    }

    /**
     * set the agility of pet
     * @param agility
     */
    public void setAgility(int agility) {
        this.agility = agility;
    }

    /**
     * get the stamina of pet
     * @return
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * set the stamina of pet
     * @param stamina
     */
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    /**
     * get happiness of pet
     * @return
     */
    public int getHappiness() {
        return happiness;
    }

    /**
     * set the happiness of pet
     * @param happiness
     */
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    /**
     * get the money of pet
     * @return
     */
    public int getMoney() {
        return money;
    }

    /**
     * set th emoney of pet
     * @param money
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * add goods to the pet item list
     * @param goods
     * @param qty
     */
    public void addGoods(Item goods,int qty) {
        goodsMap.put(goods, qty);
    }

    /**
     * buy goods from shop
     * @param goods
     */
    public void buyGoods(Item goods) {
        int qty = 0;
        if (goodsMap.containsKey(goods)) {
            qty = goodsMap.get(goods);
        }
        qty++;
        goodsMap.put(goods, qty);
        this.money-=goods.getPrice();
    }

    /**
     * the list of goods
     * @return
     */
    public List<Item> listGoods() {
        return new ArrayList(goodsMap.keySet());
    }

    /**
     * the number of goods
     * @param goods
     * @return
     */
    public int getGoodsQty(Item goods) {
        return goodsMap.get(goods);
    }

    /**
     * pet eat goods
     * @param goods
     */
    public void eatGoods(Item goods) {
        int qty = goodsMap.get(goods);
        if (qty == 1) {
            goodsMap.remove(goods);
        } else {
            goodsMap.put(goods, qty - 1);
        }
        this.strength += goods.getStrength();
        this.agility += goods.getAgility();
        this.stamina += goods.getStamina();
        this.happiness += goods.getHappiness();
        if (this.happiness > 100) {
            this.happiness = 100;
        }
    }

    @Override
    public String toString() {
        String msg = "Pet Name: " + this.name + " money: " + this.money+"\n";
        msg += "\tstrength: " + this.strength;
        msg += " agility; " + this.agility;
        msg += " stamina: " + this.stamina;
        msg += " happiness: " + this.happiness + "\n";
        return msg;
    }

}
