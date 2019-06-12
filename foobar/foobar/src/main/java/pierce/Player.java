package pierce;

public class Player {
    public String name;
    public int health;
    public int mana;
    public int gold;

    public Player(String name, int health, int mana, int gold){
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.gold = gold;
    }

    @overide
    String toString(){

        String a = name + " " + health + " " + mana + " " + gold;
        return a;
    }

    public void display(){
        System.out.println();
    }
}
