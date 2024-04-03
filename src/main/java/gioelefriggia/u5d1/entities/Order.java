package gioelefriggia.u5d1.entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextOrderNumber = 1;

    private int orderNumber;
    private String status;
    private int numberOfGuests;
    private double totalAmount;
    private List<MenuItem> items;
    private int tableNumber;
    private String tableStatus;

    public Order(int numberOfGuests, int tableNumber) {
        this.orderNumber = nextOrderNumber++;
        this.status = "in corso";
        this.numberOfGuests = numberOfGuests;
        this.items = new ArrayList<>();
        this.tableNumber = tableNumber;
        this.tableStatus = "occupato";
    }

    public void addItem(MenuItem item) {
        items.add(item);
        totalAmount += item.getPrice();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTableStatus(String tableStatus) {
        this.tableStatus = tableStatus;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getStatus() {
        return status;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getTableStatus() {
        return tableStatus;
    }
}
