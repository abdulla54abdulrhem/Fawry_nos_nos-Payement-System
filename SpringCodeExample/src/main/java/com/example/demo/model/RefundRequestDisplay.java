
package com.example.demo.model;
public class RefundRequestDisplay extends Display{
    public RefundRequestDisplay(){}
    public int displayOption(){
        return 0;
    }
    public String getRefundDescription(){
        System.out.println("Please Enter your refund Description: ");
        String des=sc.nextLine();
        return des;
    }
    public double getRefundCost(){
        System.out.println("Please Enter your refund cost: ");
        double cost=sc.nextDouble();
        return cost;
    }
}
