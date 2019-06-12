package kunwar;
import java.util.*;

public class Cruise implements Expense {
    private Destination dest;

    public Cruise(Destination D1) {
        dest = D1;
    }


    @Override
    public float getCost() {
        if (dest == Destination.Mexico)
            return (1000);
        if (dest == Destination.Europe)
            return 2000;
        if (dest == Destination.Japan)
            return 3000;

        return 0;
    }
}
