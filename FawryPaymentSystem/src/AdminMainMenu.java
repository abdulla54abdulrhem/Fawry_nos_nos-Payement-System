public class AdminMainMenu extends Display{
    public AdminMainMenu(){}
    public int displayOption() {
        System.out.println("Admin Main Menu");
        System.out.println("1- Add service provider");
        System.out.println("2- Add Discounts to the system");
        System.out.println("3- List Refund requests");
        this.option=sc.nextInt();
        return this.option;
    }
}
