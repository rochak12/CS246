package kunwar;
import java.util.Scanner;

public class Main {
    static final String SAVE_FILE = "/Users/Rochak/Desktop/Game.txt";

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scan.next();
        System.out.println("Enter health: ");
        int health = scan.nextInt();
        System.out.println("Enter mana: ");
        int mana = scan.nextInt();
        System.out.println("Enter gold: ");
        int gold = scan.nextInt();

        Player player = new Player(name, health, mana, gold);
        player.equipment.put("showel",25);
        player.equipment.put("hammer", 35);
        player.equipment.put("saw", 49);

        Game game1 = new Game(player);
        game1.saveGame(SAVE_FILE);
      //  Game game2 = new Game(player);
        //Gson gson = new Gson();

        //String jsonString1 = "{\"name\":\""  + name + "\" , \"health\": \"" + health + "\" , \"mana\": \"" + mana + "\" , \"gold\": \"" + gold + "\"}" ;


        Game game2 = Game.loadGame(SAVE_FILE);
        System.out.println(game2.player);

        System.out.print(game1.equals(game2));

    }
}