package com.silverbars.marketplace.api;

import com.silverbars.marketplace.model.Order;
import com.silverbars.marketplace.model.OrderSummary;

import java.util.List;

public interface LiveOrderBoard
{
    boolean register(Order order);

    boolean cancel(Order order);

    List<OrderSummary> summary();

}
