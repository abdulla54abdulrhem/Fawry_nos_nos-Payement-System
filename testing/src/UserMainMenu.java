import java.util.Scanner;
public class UserMainMenu extends Display {
    int option;
    public UserMainMenu(){

    }
    public int displayOption(){
        System.out.println("User sign in / up menu");
        System.out.println("Please choose one of the options below");
        System.out.println("1- Sign in");
        System.out.println("2- Sign up");
        System.out.println("Enter your option: ");
        this.option=sc.nextInt();
        while(this.option<1||this.option>2){
            System.out.print("Error, Enter a valid number please (1 or 2): ");
            this.option=sc.nextInt();
        }
        return this.option;
    }
}
