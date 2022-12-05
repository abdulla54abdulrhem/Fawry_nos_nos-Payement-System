import java.util.Scanner;

public class UsersAuthSystem {
    User login(){
        while (true){
            System.out.println("enter email:");
            String tmp= new Scanner(System.in).next();
            System.out.println("enter password:");
            String tmp2=new Scanner(System.in).next();
            for (User u:Database.getInstance().users) {
                if(tmp.equals(u.email)&&tmp2.equals(u.password)){
                    System.out.println("welcome"+ u.username);
                    return u;
                }
            }
            System.out.println("error: no match found");
        }
    }
    void register(User user){
        while (true){
            System.out.println("enter user-name:");
            String tmp1=new Scanner(System.in).next();
            System.out.println("enter email:");
            String tmp2= new Scanner(System.in).next();
            System.out.println("enter password:");
            String tmp3=new Scanner(System.in).next();
            boolean ok=true;
            for (UserAbstract u:Database.getInstance().users) {
                if(tmp2.equals(u.email)||tmp3.equals(u.password)){
                    ok=false;
                    break;
                }
            }
            if(ok){
                user.email=tmp2;
                user.password=tmp3;
                user.username=tmp1;
                System.out.println("registerd as "+user.username);
                Database.getInstance().users.add((User) user);
                return;
            }else {
                System.out.println("error: email or password already exists");
            }

        }
    }
}
