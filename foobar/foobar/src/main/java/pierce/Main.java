package pierce;
import java.util.Scanner;
import com.google.gson.Gson;

public class Main {
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

        Player player = new Player(name, health, mana, gold); //

        Game game = new Game(player);

        String jsonString = gson.toJson(game);
        game.saveGame(jsonString);

        game = game.loadGame(jsonString);

        void check (){
            System.out.print(game.player.name.isEqual(this.name) );
        }

    }
}
