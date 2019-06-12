package kunwar;
import java.util.Scanner;

public class CircleCalculator {
    static Scanner scanner = new Scanner(System.in);
    protected static float radius = 0;

    public static float getRadius(){
        String input = scanner.nextLine();
        radius = Integer.parseInt( input );
        return  radius;
    }

    static void  displayArea(float calc){
       System.out.println(22/7 * calc * calc);
    }
}
