public class RefundRequest {
    RefundRequestDisplay refundDisplay=new RefundRequestDisplay();
    public String refundDescription=null;
    double whereIsMyMoney;
    public RefundRequest(){
        refundDescription= refundDisplay.getRefundDescription();
        whereIsMyMoney= refundDisplay.getRefundCost();
    }

}
