package com.silverbars.marketplace.dao;

import com.silverbars.marketplace.model.Order;
import org.junit.Assert;
import org.junit.Test;

public class OrderDaoTest {

    OrderDao orderDao=new OrderDaoImpl();

    @Test
    public void addBuyOrder()
    {
        Order order=new Order("abc",10l, 5l, Order.Type.BUY);
        Assert.assertTrue(orderDao.add(order));
        Assert.assertTrue(orderDao.getAll().size()==1);

    }
    @Test
    public void addSellOrder()
    {
        Order order=new Order("abc",10l, 5l, Order.Type.SELL);
        orderDao.add(order);
        Assert.assertTrue(orderDao.getAll().size()==1);

    }

    @Test
    public void removeOrder()
    {
        Order order=new Order("abc",10l, 5l, Order.Type.SELL);
        orderDao.add(order);

        boolean removed=orderDao.remove(order);
        Assert.assertTrue(removed);
    }




}
