package kunwar;

public class Cruise implements Expense{
    Destination destination;
     private float cost = 0;
    @Override
    public float getCost()
    {
        return cost;
    }

    Cruise(Destination destination1){
        destination = destination1;
        if (destination == Destination.Mexico)
            cost = 1000;
        if (destination == Destination.Europe)
            cost = 2000;
        if (destination == Destination.Japan)
            cost = 3000;
    }


}
