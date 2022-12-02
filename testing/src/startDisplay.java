import java.util.*;
public class startDisplay extends Display{
    public startDisplay(){

    }
    public int displayOption(){
        System.out.println("Welcome to fawry, please choose whether you are admin or user");
        System.out.println("1- Admin");
        System.out.println("2- User");
        System.out.println("Enter your option here: ");
        this.option=sc.nextInt();
        while(this.option<1||this.option>2){
            System.out.print("Error, Enter a valid number please (1 or 2): ");
            this.option=sc.nextInt();
        }
        return this.option;
    }
}
