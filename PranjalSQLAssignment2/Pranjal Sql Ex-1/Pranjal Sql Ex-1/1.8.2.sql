

update Sales.SalesPerson set CommissionBand='Band 0' where CommissionPct=0.0;
update Sales.SalesPerson set CommissionBand='Band 1' where CommissionPct>0.00 and CommissionPct<=0.01;
update Sales.SalesPerson set CommissionBand='Band 2' where CommissionPct>0.01 and CommissionPct<=0.015;
update Sales.SalesPerson set CommissionBand='Band 3' where CommissionPct>0.015;

SELECT * FROM Sales.SalesPerson