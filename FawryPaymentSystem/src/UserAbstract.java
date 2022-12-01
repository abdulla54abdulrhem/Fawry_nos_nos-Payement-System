public class UserAbstract {
    String email;
    String password;
    SignUpDisplay signupDisplay= new SignUpDisplay();
    public UserAbstract(){
    }
    public void setEmail(){
        signupDisplay.displayOption();
        email= signupDisplay.getEmail();
    }
    public void setPassword(){
        password=signupDisplay.getPassword();
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
}
