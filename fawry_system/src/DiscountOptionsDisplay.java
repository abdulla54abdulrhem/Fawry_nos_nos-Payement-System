public class DiscountOptionsDisplay extends Display{
    public DiscountOptionsDisplay(){}
    public int displayOption() {
        System.out.println("Discount Options");
        System.out.println("1- Add General Discount");
        System.out.println("2- Add Specific Discount");
        this.option = sc.nextInt();
        while (this.option < 1 || this.option > 2) {
            System.out.print("Error, Enter a valid number please: ");
            this.option = sc.nextInt();
        }
        return this.option;
    }
}
