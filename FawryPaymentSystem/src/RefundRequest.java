public class RefundRequest {
    RefundRequestDisplay refundDisplay=new RefundRequestDisplay();
    private String refundDescription=null;
    double whereIsMyMoney;
    public RefundRequest(){
        refundDescription= refundDisplay.getRefundDescription();
        whereIsMyMoney= refundDisplay.getRefundCost();
    }

}
