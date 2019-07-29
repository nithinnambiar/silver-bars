package com.silverbars.marketplace.dao;

import com.silverbars.marketplace.model.Order;

import java.util.Collection;

public interface OrderDao {

    boolean add(Order order);

    boolean remove(Order order);

    Collection<Order> getAll();
}
