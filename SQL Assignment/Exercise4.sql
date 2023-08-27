/*
Create a function that takes as inputs a 
SalesOrderID, 
a Currency Code, 
and a date, 
and returns a table of all the SalesOrderDetail rows for that Sales Order including 
Quantity, ProductID, UnitPrice, and the unit price converted to the target currency based on the end of day rate for the date provided. 
Exchange rates can be found in the Sales.CurrencyRate table. 
( Use AdventureWorks)
*/

--CONNECT TO DATABASE;
USE AdventureWorks2008R2;

--FUNCTION
GO
CREATE FUNCTION Sales.uf_getProducts(@SalesOrderID int, @CurrencyCode nchar(3) ,@CurrencyRateDate datetime)
	RETURNS TABLE 
AS
	RETURN
	WITH Products
	AS (
		SELECT *
		FROM Sales.SalesOrderDetail AS sod 
		WHERE sod.SalesOrderID = @SalesOrderID
	)
	SELECT p.ProductID, p.OrderQty, p.UnitPrice, p.UnitPrice*scr.EndOfDayRate AS 'Converted Price'
	FROM Products AS p, Sales.CurrencyRate AS scr
	WHERE scr.ToCurrencyCode = @CurrencyCode
		AND scr.CurrencyRateDate = @CurrencyRateDate
GO


select * from Sales.uf_getProducts(43669,'ARS','2005-07-01 00:00:00:000')