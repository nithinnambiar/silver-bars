package com.silverbars.marketplace.util;

import com.silverbars.marketplace.model.Order;
import com.silverbars.marketplace.model.OrderSummary;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderSummaryHelperTest {

    OrderSummaryHelper orderSummaryHelper=new OrderSummaryHelper();

    @Test
    public void shouldCreateSummary(){

        Order buyOrder=new Order("abc",100l,10l, Order.Type.BUY);
        Order sellOrder=new Order("def",50l,15l, Order.Type.SELL);
        List<Order> orderList=new ArrayList<>();
        orderList.add(buyOrder);
        orderList.add(sellOrder);
        List<OrderSummary> orderSummaryList=orderSummaryHelper.createSummary(orderList);
        Assert.assertTrue(orderSummaryList.size()==2);
        OrderSummary orderSummary=orderSummaryList.get(0);
        Assert.assertEquals(buyOrder.getType(), orderSummary.getOrderType());
        Assert.assertEquals(buyOrder.getPricePerKg(), orderSummary.getPrice());

    }

    @Test
    public void shouldCreateSummaryForSellOrderWithLowestPriceFirst(){

        Order sellOrderOne=new Order("abc",100l,10l, Order.Type.SELL);
        Order sellOrderTwo=new Order("def",50l,15l, Order.Type.SELL);
        List<Order> orderList=new ArrayList<>();
        orderList.add(sellOrderOne);
        orderList.add(sellOrderTwo);
        List<OrderSummary> orderSummaryList=orderSummaryHelper.createSummary(orderList);
        Assert.assertTrue(orderSummaryList.size()==2);
        OrderSummary orderSummary=orderSummaryList.get(0);
        Assert.assertEquals(sellOrderTwo.getQuantity(), orderSummary.getQuantity());
        Assert.assertEquals(sellOrderTwo.getPricePerKg(), orderSummary.getPrice());

    }

    @Test
    public void shouldCreateSummaryForBuyOrderWithHighestPriceFirst(){

        Order buyOrderOne=new Order("abc",100l,10l, Order.Type.BUY);
        Order buyOrderTwo=new Order("def",50l,15l, Order.Type.BUY);
        List<Order> orderList=new ArrayList<>();
        orderList.add(buyOrderOne);
        orderList.add(buyOrderTwo);
        List<OrderSummary> orderSummaryList=orderSummaryHelper.createSummary(orderList);
        Assert.assertTrue(orderSummaryList.size()==2);
        OrderSummary orderSummary=orderSummaryList.get(0);
        Assert.assertEquals(buyOrderOne.getQuantity(), orderSummary.getQuantity());
        Assert.assertEquals(buyOrderOne.getPricePerKg(), orderSummary.getPrice());

    }

    @Test
    public void shouldMergeQuantity(){

        Order buyOrderOne=new Order("abc",100l,10l, Order.Type.BUY);
        Order buyOrderTwo=new Order("def",100l,15l, Order.Type.BUY);
        List<Order> orderList=new ArrayList<>();
        orderList.add(buyOrderOne);
        orderList.add(buyOrderTwo);
        List<OrderSummary> orderSummaryList=orderSummaryHelper.createSummary(orderList);
        Assert.assertTrue(orderSummaryList.size()==1);
        OrderSummary orderSummary=orderSummaryList.get(0);
        Assert.assertEquals(buyOrderOne.getType(), orderSummary.getOrderType());
        Assert.assertEquals(buyOrderOne.getPricePerKg(), orderSummary.getPrice());
        Assert.assertEquals(buyOrderOne.getQuantity() + buyOrderTwo.getQuantity(), orderSummary.getQuantity());
        System.out.println(orderSummaryList.toString());


    }




}
