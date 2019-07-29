package com.silverbars.marketplace.model;

public class OrderSummary
{
    private final Order.Type orderType;

    private final long quantity;

    private final long price;

    public OrderSummary(Order.Type orderType, long price, long quantity) {
        this.orderType = orderType;
        this.quantity = quantity;
        this.price = price;
    }

    public Order.Type getOrderType() {
        return orderType;
    }

    public long getQuantity() {
        return quantity;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{" +
                "type=" + orderType +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

}
