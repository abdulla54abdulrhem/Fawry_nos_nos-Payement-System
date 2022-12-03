import java.util.Scanner;

public class abstractUsersAuthSystem {
    void login(UserAbstract userAbstract){
        while (true){
            System.out.println("enter email:");
            String tmp= new Scanner(System.in).next();
            System.out.println("enter password:");
            String tmp2=new Scanner(System.in).next();
            for (UserAbstract u:Database.getInstance().users) {
                if(tmp==u.email&&tmp2==u.password){
                    userAbstract=u;
                    System.out.println("welcome"+userAbstract.username);
                    return;
                }
            }
            System.out.println("error: no match found");
        }
    }
    void register(UserAbstract userAbstract){
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
                userAbstract.email=tmp2;
                userAbstract.password=tmp3;
                userAbstract.username=tmp1;
                System.out.println("registerd as "+userAbstract.username);
                Database.getInstance().users.add(userAbstract);
                return;
            }else {
                System.out.println("error: email or password already exists");
            }

        }
    }
}
