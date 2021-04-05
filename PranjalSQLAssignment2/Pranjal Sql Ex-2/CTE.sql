with PranjalCTE(CustomerID, OrderDate, AccountNumber, ModifiedDate)
as(SELECT Sales.Customer.CustomerID, Sales.SalesOrderHeader.OrderDate, Sales.Customer.AccountNumber, Sales.Customer.ModifiedDate FROM Sales.Customer, Sales.SalesOrderHeader Where Sales.SalesOrderHeader.OrderDate = 0)
SELECT CustomerID, OrderDate, AccountNumber, ModifiedDate from PranjalCTE