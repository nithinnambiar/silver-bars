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
## Notes
 The current implemenation of the Order model uses primitive long for quantity and price. This version only supports whole numbers for price and quantity. This could be improved either using BigDecimal or Joda Money.
 Other consideration was to use Spring library to manage dependency injection. Given the simplicity of the library i decided not to use Spring in this version. 

