package com.silverbars.marketplace.dao;

import com.silverbars.marketplace.model.Order;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class OrderDaoImpl implements OrderDao
{

    private final ConcurrentMap<Order.OrderKey, Order> orderStore=new ConcurrentHashMap<>();

    @Override
    public boolean add(Order order)
    {
         orderStore.putIfAbsent(order.getKey(), order);
         return true;
    }

    @Override
    public boolean remove(Order order)
    {
        return orderStore.remove(order.getKey(), order);
    }

    @Override
    public Collection<Order> getAll()
    {
        return orderStore.values();

    }

}
