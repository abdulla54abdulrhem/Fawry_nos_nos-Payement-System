package com.example.demo.model;
public interface SubjectUser {
    public void registerAdmin(ObserverAdmin a);
    public void removeObserver(ObserverAdmin a);
    public void notifyObserver(RefundRequest r);
    public void addRefundRequest(String Descripttion,double money);
}
