SELECT AVG(AverageRate) as 'Average exchange rate for the day' FROM Sales.CurrencyRate WHERE FromCurrencyCode = 'USD' and ToCurrencyCode = 'GBP' and ModifiedDate like '%2005%'