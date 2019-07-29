package com.silverbars.marketplace.api;

import com.silverbars.marketplace.dao.OrderDao;
import com.silverbars.marketplace.model.Order;
import com.silverbars.marketplace.model.OrderSummary;
import com.silverbars.marketplace.util.OrderSummaryHelper;

import java.util.*;

class LiverOrderBoardImpl implements LiveOrderBoard
{
    private final OrderDao orderDao;

    private final OrderSummaryHelper orderSummaryHelper=new OrderSummaryHelper();

    public LiverOrderBoardImpl(OrderDao orderDao)
    {
        this.orderDao = orderDao;
    }

    @Override
    public boolean register(Order order)
    {
        if(order==null || order.getUserId() ==null || order.getType()==null)
            throw new RuntimeException("order is not valid");

        return orderDao.add(order);

    }

    @Override
    public boolean cancel(Order order)
    {
        if(order==null)
            throw new RuntimeException("order is not valid");
        return orderDao.remove(order);

    }

    @Override
    public List<OrderSummary> summary() {

        Collection<Order> orderCollection=orderDao.getAll();

        return orderSummaryHelper.createSummary(orderCollection);


    }


}
