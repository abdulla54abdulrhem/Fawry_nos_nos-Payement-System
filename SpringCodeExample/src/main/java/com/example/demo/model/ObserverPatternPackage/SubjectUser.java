package com.example.demo.model.ObserverPatternPackage;

import com.example.demo.model.UserandAdmin.RefundRequest;

public interface SubjectUser {
    public void registerAdmin(ObserverAdmin a);
    public void removeObserver(ObserverAdmin a);
    public void notifyObserver(RefundRequest r);
    public void addRefundRequest(String Descripttion,double money);
}
