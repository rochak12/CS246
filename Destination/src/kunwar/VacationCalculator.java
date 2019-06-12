package kunwar;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VacationCalculator {

    float calculateVacationCost(Destination destination, int days){
         List<Expense> expenses1 = new ArrayList<Expense>();
         expenses1.add(new Cruise(destination));
         expenses1.add(new Dining(destination,days));
         expenses1.add(new Lodging(destination, days));
         float result = tallyExpenses(expenses1);
        return  result;
    }


    private float tallyExpenses(List<Expense> expenses){
        float result = 0;
        for (Expense expense : expenses) {
            result += expense.getCost();
        }
            return result;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many days you want to stay?");
        int days = scanner.nextInt();

       VacationCalculator vc = new VacationCalculator();

        float japanCost = vc.calculateVacationCost(Destination.Japan, days);
         System.out.format("The cost for Japan is $%.2f. %n", japanCost);
        float europeCost = vc.calculateVacationCost(Destination.Europe, days);
        System.out.format("The cost for Europe is $%.2f. %n",europeCost);
        float mexicoCost = vc.calculateVacationCost(Destination.Mexico, days);
        System.out.format("The cost for Mexico is $%.2f. %n",mexicoCost);
    }

}
