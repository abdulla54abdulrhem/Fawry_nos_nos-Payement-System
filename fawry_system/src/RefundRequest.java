public class RefundRequest {
    RefundRequestDisplay refundDisplay=new RefundRequestDisplay();
    public String refundDescription=null;
    public User user;
    double whereIsMyMoney;
    public RefundRequest(User user){
        this.user=user;
        refundDescription= refundDisplay.getRefundDescription();
        whereIsMyMoney= refundDisplay.getRefundCost();
    }

}
