package prove02;

import java.awt.*;

public class Zombie extends Creature implements Movable, Aggressor{

    Zombie(){
        _health = 10000;
    }

    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    Color getColor() {
        return new Color(0, 0, 250);
    }

    @Override
    Boolean isAlive() {
        return true;
    }

    @Override
    public void move() {
        _location.x++;
    }

    @Override
    public boolean attack(Creature target) {
        if ( target != null && (!(target instanceof Plant))){
           target.takeDamage(10);
        }
        return  false;
    }
}
