package kunwar;
import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Game {
    Player player;




    public Game(Player player){
        this.player = player;
    }
    // to string from what we get back from Gson

    public void saveGame(String fileName){
        Gson gson = new Gson();
        String userJson = gson.toJson(player);

        try(Writer w = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(fileName), "UTF-8"))) {
            w.write(userJson);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    static Game loadGame(String fileName){
        String userJson = null;
        Gson gson = new Gson();

        try{
            byte[] encoded = Files.readAllBytes(Paths.get(fileName));
            userJson = new String(encoded, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }


         Player savedPlayer = gson.fromJson(userJson, Player.class);

         Game newGame = new Game(savedPlayer);
         //String jsonString = "{\"name\":\""  + gamee.player.name + "\" , \"health\": \"" + gamee.player.health + "\" , \"mana\": \"" +
           //     gamee.player.mana + "\" , \"gold\": \"" + gamee.player.gold + "\"}" ;

       // String jsonString2 = (String) gson.toString(gamee);
        return  newGame;
    }


}
