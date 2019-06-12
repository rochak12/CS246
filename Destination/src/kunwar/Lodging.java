package kunwar;

import javax.crypto.spec.DESedeKeySpec;

public class Lodging implements Expense{
    Destination destination;
    int days;
    private float cost = 0;

    Lodging(Destination destination, int days){
        if (destination == Destination.Mexico)
            cost = 100*days;
        if (destination == Destination.Japan)
            cost = 300*days + (30/100 * 300)*days;
        if (destination == Destination.Europe)
            cost = 200*days + (10/100 * 200)*days;
    }

    @Override
    public float getCost() {
        return cost;
    }
}
