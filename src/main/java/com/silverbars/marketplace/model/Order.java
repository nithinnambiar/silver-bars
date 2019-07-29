package com.silverbars.marketplace.model;

import java.util.UUID;

public final class Order
{
    public enum Type
    {
        BUY,SELL;
    }

    private final String userId;

    private final OrderKey key=new OrderKey();

    private final long pricePerKg;

    private final long quantity;

    private Type type;


    public Order(String userId, long pricePerKg, long quantity, Type type)
    {
        this.userId=userId;
        this.quantity=quantity;
          this.pricePerKg=pricePerKg;
          this.type=type;

    }

    public String getUserId() {
        return userId;
    }

    public long getPricePerKg() {
        return pricePerKg;
    }

    public long getQuantity() {
        return quantity;
    }


    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (pricePerKg != order.pricePerKg) return false;
        if (quantity != order.quantity) return false;
        if (!userId.equals(order.userId)) return false;
        if (!key.equals(order.key)) return false;
        return type == order.type;
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + key.hashCode();
        result = 31 * result + (int) (pricePerKg ^ (pricePerKg >>> 32));
        result = 31 * result + (int) (quantity ^ (quantity >>> 32));
        result = 31 * result + type.hashCode();
        return result;
    }

    public OrderKey getKey() {
        return key;
    }

    public class OrderKey
    {
        private final UUID uuid=UUID.randomUUID();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            OrderKey orderKey = (OrderKey) o;

            return uuid.equals(orderKey.uuid);
        }

        @Override
        public int hashCode() {
            return uuid.hashCode();
        }

        @Override
        public String toString() {
            return "OrderKey{" +
                    "uuid=" + uuid +
                    '}';
        }
    }
}
