package kunwar;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class VacationCalculator {

    private float add;
    private float exp;

    public static void main(String[] args) {

        VacationCalculator vc = new VacationCalculator();

        float japanCost = vc.calculateVacationCost(Destination.Japan);
        
        VacationCalculator vacCalc = null;
        vacCalc.calculateVacationCost(Destination.Japan);
    }


    List<Float> differentCost = new ArrayList<Float>();

    public float calculateVacationCost(Destination dest) {
        while (exp != 0) {
            System.out.print("\nEnter Expenses.");
            Scanner in = new Scanner(System.in);
            exp = in.nextFloat();
            differentCost.add(exp);
        }
        float finalCost = (float) tallyExpenses(differentCost);
        return finalCost;
    }


    float tallyExpenses(List<Float> expenses){
        for(int i = 0; i < expenses.size(); i++ ) {
            add += expenses.get(i);
        }
        return add;
    }



}
