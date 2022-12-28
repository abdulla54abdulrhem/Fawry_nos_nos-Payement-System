public interface DiscountSubject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
    public void addDiscount(int dis);
}
