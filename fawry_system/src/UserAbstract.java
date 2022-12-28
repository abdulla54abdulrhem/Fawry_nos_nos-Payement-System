public abstract class UserAbstract {
    String email;
    String password;
    String username;

    UsersAuthSystem system=new UsersAuthSystem();
    public UserAbstract(){
    }
    abstract boolean login(String logingEmail, String logingPassword);
}
