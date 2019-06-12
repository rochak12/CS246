package kunwar;

public class Dining implements Expense {
    Destination destination;
    int days;
    private float cost = 0;


    Dining(Destination destination, int days){
        if (destination == Destination.Mexico)
            cost = 10*days;
        if (destination == Destination.Japan)
            cost = 30*days;
        if (destination == Destination.Europe)
            cost = 20*days;
    }

    @Override
    public float getCost()
    {
        return cost;
    }
}
