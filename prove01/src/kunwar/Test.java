package kunwar;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Scanner;


public class Test {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a Password: ");
        String password = scan.nextLine();


        User user = new User(password);
        System.out.println(user.getPassword());
        System.out.println(user.getHashedPassword());
        System.out.println(user.getSalt());

        boolean loop = true;
        boolean exception = true;

        while (loop == true && exception == true)
        try {
            NSALoginController.hashUserPassword(user);
            exception = false;
            loop = false;
        } catch (WeakPasswordException e) {
            e.printStackTrace();
            System.out.println("Password too week");


            System.out.println("Input Password again");
            password = scan.nextLine();
            user.setPassword(password);

        }

        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(user.getPassword());
        System.out.println(user.getHashedPassword());
        System.out.println(user.getSalt());



        System.out.println("Now Your Password is set. Lets Verify");
        System.out.println("Enter your password for verification");
        String verifyPasswordd = scan.nextLine();
        user.setPassword(verifyPasswordd);
        try {
            if (NSALoginController.verifyPassword(user)) {
                System.out.println("Password Matched");
            }
            else
            {
                System.out.println("Password wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();


        }

    }
}
