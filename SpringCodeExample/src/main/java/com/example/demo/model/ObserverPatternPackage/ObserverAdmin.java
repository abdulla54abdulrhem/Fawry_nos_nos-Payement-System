package com.example.demo.model.ObserverPatternPackage;

import com.example.demo.model.UserandAdmin.RefundRequest;

public interface ObserverAdmin {
    public void notifyAdmin(RefundRequest r);
}
