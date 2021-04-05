ALTER Function pranjal_saleorderdtl(
@SaleOrderID int,
@CurrencyCode varchar(60),
@ModiDate varchar(60)
)
returns table as 
return
select Sales.SalesOrderDetail.SalesOrderID, Sales.CurrencyRate.ToCurrencyCode as [Currency Code],Sales.SalesOrderDetail.ModifiedDate, Sales.SalesOrderDetail.OrderQty as OrderQuantity, Sales.SalesOrderDetail.ProductID, Sales.SalesOrderDetail.UnitPrice*Sales.CurrencyRate.EndOfDayRate as UnitPrice from Sales.SalesOrderDetail , Sales.CurrencyRate 
WHERE Sales.SalesOrderDetail.SalesOrderID = @SaleOrderID and Sales.CurrencyRate.ToCurrencyCode=@CurrencyCode and Sales.SalesOrderDetail.ModifiedDate=@ModiDate
