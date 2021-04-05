SELECT ProductID, SafetyStockLevel as LargestStockLevel from Production.Product WHERE SafetyStockLevel = (SELECT MAX(SafetyStockLevel) from Production.Product)