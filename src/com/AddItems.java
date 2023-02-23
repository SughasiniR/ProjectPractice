package com;

import java.util.Scanner;
public class AddItems {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		//double price=sc.nextDouble();
		int qn=sc.nextInt();
		Items item=new Items();
		item.set_name(name);
		//item.set_price(price);
		item.set_qn(qn);
		item.display();

	}

}

class Items{
	private String dish_name;
	//private double dish_price;
	private int quantity;
	
//	public Items(String dish_name,double dish_price,int quantity) {
//		this.dish_name=dish_name;
//		this.dish_price=dish_price;
//		this.quantity=quantity;
//	}
	public String get_name() {
		return dish_name;
	}
	public void set_name(String name) {
		this.dish_name=name;
	}
//	public double get_price() {
//		return dish_price;
//	}
//	public void set_price(double price) {
//		this.dish_price=price;
//	}
	public int get_qn() {
		return quantity;
	}
	public void set_qn(int quantity) {
		this.quantity=quantity;
	}
	public void display() {
		System.out.print("Dish name : "+get_name()+" Dish Quantity : "+get_qn());
	}
}