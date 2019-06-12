package prove02;

import java.awt.*;
import java.util.Random;

public class Wolves extends  Creature implements Aggressor, Movable, Aware, Spawner {
    //what is the difference without no new
    Random rand = new Random();
    String preferredDirection ;



    Wolves() {
        _health = 1;
        switch (rand.nextInt(4)) {
            case 0:
                preferredDirection = "left";
                break;
            case 1:
                preferredDirection = "right";
                break;
            case 2:
                preferredDirection = "up";
                break;
            case 3:
                preferredDirection = "down";
                break;
            default:
                break;
        }


    }


    @Override
    public boolean attack(Creature target) {
        if (target instanceof Animal) {
            target.takeDamage(5);
            return true;
        }
        return false;
    }

/*   @Override
   public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {
        // of default path returns false means there is no creature in default path
        boolean check = checkInDefaultPath(above, below, left, right);
        if (check == false) {
            // since wolf didn't find anything it has to look for ots prey
            lookAroundYou(above, below, left, right);
            System.out.println("I am sensing");
        }

    }*/

    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {

        if(preferredDirection == "up")
        {
            if(above instanceof Animal)
                return;
            else if(right instanceof Animal)
                preferredDirection = "right";
            else if(below instanceof Animal)
                preferredDirection = "down";
            else if (left instanceof Animal)
                preferredDirection = "left";
        }
        else if(preferredDirection == "right")
        {
            if(right instanceof Animal)
                return;
            else if(below instanceof Animal)
                preferredDirection = "down";
            else if(left instanceof Animal)
                preferredDirection = "left";
            else if(above instanceof Animal)
                preferredDirection = "up";
        }
        else if(preferredDirection == "down")
        {
            if(below instanceof Animal)
                return;
            else if(left instanceof Animal)
                preferredDirection = "left";
            else if(above instanceof Animal)
                preferredDirection = "up";
            else if(right instanceof Animal)
                preferredDirection = "right";
        }
        else if(preferredDirection == "left")
        {
            if(left instanceof Animal)
                return;
            else if(above instanceof Animal)
                preferredDirection = "up";
            else if(right instanceof Animal)
                preferredDirection = "right";
            else if(below instanceof Animal)
                preferredDirection = "down";

        }
    }




    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    Color getColor() {
        return new Color(220, 220, 0);
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }

    @Override
    public void move() {
        if (preferredDirection == "left") {
            _location.x--;
        }
        if (preferredDirection == "right") {
            _location.x++;
        }
        if (preferredDirection == "up") {
            _location.y--;
        }
        if (preferredDirection == "down") {
            _location.y++;
        }
    }


    private boolean checkInDefaultPath(Creature above, Creature below, Creature left, Creature right) {
        switch (preferredDirection) {
            case "right":
                if ((right instanceof Animal) )
                    return true;
            case "left":
                if ( (left instanceof Animal))
                    return true;
            case "up":
                if (  (above instanceof Animal))
                    return true;
            case "down":
                if ( (below instanceof Animal))
                    return true;
            default:
                return false;
        }
    }

    private void lookAroundYou(Creature above, Creature below, Creature left, Creature right) {
        if ( (above instanceof Animal)) {
            preferredDirection = "up";
            System.out.println("now changing up");
            return;
        }
        if ( (right instanceof Animal)){
            preferredDirection = "right";
            System.out.println("now changing right");
            return;
        }
        if ( (below instanceof Animal)) {
            preferredDirection = "down";
            System.out.println("now changing down");
            return;
        }
        if ((left instanceof Animal)) {
            preferredDirection = "left";
            System.out.println("now changing left");
            return;
        }
        }

    @Override
    public Creature spawnNewCreature() {
        Creature newCreature = new Wolves();
        newCreature.setLocation(new Point((int)(_location.getX()-1), (int)_location.getY()));

        return newCreature;
    }
}