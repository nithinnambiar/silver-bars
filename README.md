# Live Order Board
A java api to
1) Register an order
2) Cancel a registered order
3) Get a SUmmary of the Order Board

## Using the API

```
LiverOrderBoard orderBoard = OrderBoardManager.getLiverOrderBoard();
Order order= new Order("ABC",50, 10);
//register order
orderBoard.register(order);

//cancel order
orderBoard.cancel(order);

//summary of liver order board
List<OrderSummary> orderSummaryList=orderBoard.summary();
```

