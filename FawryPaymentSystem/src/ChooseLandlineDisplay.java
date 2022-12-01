public class ChooseLandlineDisplay extends Display{
    public ChooseLandlineDisplay(){}
    public int displayOption(){
        System.out.println("Landline services: ");
        System.out.println("1- Monthly receipt");
        System.out.println("2- Quarter receipt");

        this.option=sc.nextInt();
        while(option>2||option<1){
            System.out.println("Error, invalid value, try again: ");
            this.option=sc.nextInt();
        }
        return this.option;
    }
}
