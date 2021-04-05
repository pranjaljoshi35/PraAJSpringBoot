CREATE TRIGGER pranjaltriggerlstprc
AFTER UPDATE
DECLARE @Inserted = Inserted
ON Production.ProductListPriceHistory FOR INSERT EACH COLOUMN AS 
(SELECT case when (Inserted.ListPrice*0.15<Production.ProductListPriceHistory.ListPrice)
then 'YES'
ELSE 'NO CHANGE'
END
