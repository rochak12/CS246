package pierce;
import com.google.gson.Gson;

public class Game {
    Player player = new Player();
    Gson gson = new Gson();

    public Game(Player player){
        this.player = player;
    }
    // to string from what we get back from Gson

    public void saveGame(String jsonString){
      //  String userJson = gson.toJson(jsonString);

    }

    static Game loadGame(){
      //  Player = gson.fromJson(userJson, Player.class);
    }


}
