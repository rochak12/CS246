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

        try
        {
            // Use NSALoginController to hash the user's password.
            NSALoginController.hashUserPassword(user);

            // The user's password should now be empty, but we should have a
            // hashed version as well as the salt value. Print all three of those
            // to verify our assumptions.
            System.out.format("\tPassword After Hash: %s\n", user.getPassword());
            System.out.format("\tHashed Password: %s\n", user.getHashedPassword());
            System.out.format("\tSalt: %s\n", user.getSalt());
        }
        catch(WeakPasswordException ex) {
            System.out.println("Password rejected: " + ex.getMessage());
            return;
        }
        catch(Exception ex) {
            System.out.println("Something went wrong.");
            return;
        }

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
