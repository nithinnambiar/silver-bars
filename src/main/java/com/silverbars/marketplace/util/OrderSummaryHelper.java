package com.silverbars.marketplace.util;

import com.silverbars.marketplace.model.Order;
import com.silverbars.marketplace.model.OrderSummary;

import java.util.*;

import static com.silverbars.marketplace.model.Order.Type.BUY;
import static com.silverbars.marketplace.model.Order.Type.SELL;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingLong;
import static java.util.stream.Collectors.toList;

public final class OrderSummaryHelper {


    public List<OrderSummary> createSummary(Collection<Order> orderCollection)
    {
        List<OrderSummary> summaryList=new ArrayList<>();
        createSummaryForType(BUY, orderCollection, reverseOrder(),summaryList);
        createSummaryForType(SELL, orderCollection, naturalOrder(),summaryList);

        return summaryList;
    }



    private void createSummaryForType(Order.Type type,
                               Collection<Order> orderCollection,
                               Comparator<Long> comparator,
                               List<OrderSummary> orderSummaryList)
    {
        orderSummaryList.addAll(
                orderCollection.stream().filter(o-> o.getType()==type).
                        collect(
                                groupingBy(Order::getPrice,
                                        () -> new TreeMap<>(comparator),
                                        summingLong(Order::getQuantity))
                        )
                        .entrySet().stream()
                        .map(e -> new OrderSummary(type, e.getKey(), e.getValue()))
                        .collect(toList())
        );

    }
}
