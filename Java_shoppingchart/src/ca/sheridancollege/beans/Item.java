package ca.sheridancollege.beans;

public class Item {
int itemId;
double itemPrice;
String itemName;
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public double getItemPrice() {
	return itemPrice;
}
public void setItemPrice(double itemPrice) {
	this.itemPrice = itemPrice;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public Item(){
	};


public Item(int itemId, double itemPrice, String itemName) {
	super();
	this.itemId = itemId;
	this.itemPrice = itemPrice;
	this.itemName = itemName;
}}
