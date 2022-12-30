package com.example.demo.model;

import java.math.*;

public abstract class service implements Observer{
	double cost = 0;
	boolean cashOnDelivery=false;
	String description="";
	double discountGeneral=0;
	double discountSpecific=0;
	public int id;

	public boolean pay(User user) {
		// TODO Auto-generated method stub
		double moneyTobePaid=getCostAfterDiscounts();
		if(user.wallet.getBalance()<moneyTobePaid){
			return false;
		}else {
			user.wallet.deductMoney(Math.max(0,moneyTobePaid));
			return true;
		}

	}
	public void updateDiscount(double discount){
		this.discountGeneral=discount;
	}
	public void updateSpecificDiscount(double discount){
		this.discountSpecific=discount;
	}
	public double getCost(){
		return this.cost;
	}
	public double getCostAfterDiscounts(){return this.cost-(this.cost*this.discountGeneral+this.cost*discountSpecific);}
	public String getDescription(){
		return this.description;
	}
}
