package com.silverbars.marketplace.api;

import com.silverbars.marketplace.dao.OrderDaoImpl;
import com.silverbars.marketplace.model.Order;
import org.junit.Assert;
import org.junit.Test;

public class LiveOrderBoardTest
{
    private final LiveOrderBoard liveOrderBoard=new LiverOrderBoardImpl(new OrderDaoImpl());

    @Test
    public void shouldRegisterValidOrder()
    {
        Order order=new Order("abc",10l, 5l, Order.Type.BUY);
        Assert.assertTrue(liveOrderBoard.register(order));
    }

    @Test(expected=RuntimeException.class)
    public void shouldNotRegisterInValidOrder()
    {
        Order order=new Order(null,10l, 5l, Order.Type.BUY);
        liveOrderBoard.register(order);
    }

    @Test
    public void shouldCancelValidOrder()
    {
        Order order=new Order("abc",10l, 5l, Order.Type.BUY);
        liveOrderBoard.register(order);
        Assert.assertTrue(liveOrderBoard.cancel(order));
    }

    @Test(expected=RuntimeException.class)
    public void shouldNotCancelInValidOrder()
    {
        Order order=null;
        liveOrderBoard.cancel(order);
    }

    @Test
    public void shouldNotCancelANotExistingOrder()
    {
        Order order=new Order("abc",10l, 5l, Order.Type.BUY);;
        Assert.assertFalse(liveOrderBoard.cancel(order));
    }
}
