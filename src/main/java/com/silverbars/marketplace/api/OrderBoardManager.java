package com.silverbars.marketplace.api;

import com.silverbars.marketplace.dao.OrderDaoImpl;

public class OrderBoardManager
{
    private static final LiveOrderBoard orderBoard=new LiverOrderBoardImpl(new OrderDaoImpl());

    public static LiveOrderBoard getLiveOrderBoard()
    {
        return orderBoard;
    }

}
