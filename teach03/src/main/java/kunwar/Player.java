package kunwar;

import java.util.Map;
import java.util.TreeMap;

public class Player {
    public String name;
    public int health;
    public int mana;
    public int gold;
    Map<String, Integer> equipment = new TreeMap<>();

    public Player(String name, int health, int mana, int gold){
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.gold = gold;
    }


  /*  void addEquipment(String item, int price){
        equipment.put(item, price);
    }*/


    public String toString(){
        String a = name + " " + health + " " + mana + " " + gold;
        return a;
    }

    public void display(){
        System.out.println();
    }
}

