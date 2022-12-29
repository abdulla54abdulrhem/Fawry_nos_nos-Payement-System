package com.example.demo.model;
public interface Observer {
    public void updateDiscount(double discount);
    public void updateSpecificDiscount(double discount);
    public String getDescription();
}