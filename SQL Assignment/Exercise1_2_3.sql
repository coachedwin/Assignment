--CONECT TO DATABASE
USE AdventureWorks2008R2;

--1.1
/*
Display the number of records in the [SalesPerson] table. 
(Schema(s) involved: Sales)
*/
SELECT COUNT(1) AS 'No. of Records'
FROM Sales.SalesPerson;

--1.2
/*
Select both the FirstName and LastName of records from the Person table where the FirstName begins with the letter ‘B’. 
(Schema(s) involved: Person)
*/
SELECT FirstName + ' ' + LastName AS 'Full Name'
FROM Person.Person
WHERE FirstName LIKE 'B%';

--1.3
/*
Select a list of FirstName and LastName for employees where 
Title is one of Design Engineer, Tool Designer or Marketing Assistant. 
(Schema(s) involved: HumanResources, Person)
*/
SELECT p.FirstName + ' ' + p.LastName AS 'Full Name'
FROM Person.Person AS p, HumanResources.Employee AS e
WHERE e.BusinessEntityID = p.BusinessEntityID 
    AND e.JobTitle IN ('Design Engineer','Tool Designer','Marketing Assistant');

--1.4
/*
Display the Name and Color of the Product with the maximum weight. 
(Schema(s) involved: Production)
*/
SELECT Name, Color 
FROM Production.Product
WHERE [Weight] = (SELECT MAX([Weight]) FROM Production.Product);

--select Top (1) Name, Color from Production.Product order by Weight desc;

--1.5
/*
Display Description and MaxQty fields from the SpecialOffer table. 
Some of the MaxQty values are NULL, in this case display the value 0.00 instead. 
(Schema(s) involved: Sales)
*/

SELECT [Description], COALESCE(MaxQty, 0.00)   
FROM Sales.SpecialOffer;

--1.6
/*
Display the overall Average of the [CurrencyRate].[AverageRate] values for the exchange rate ‘USD’ to ‘GBP’ for the year 2005 i.e. FromCurrencyCode = ‘USD’ and ToCurrencyCode = ‘GBP’. 
Note: The field [CurrencyRate].[AverageRate] is defined as 'Average exchange rate for the day.' 
(Schema(s) involved: Sales)
*/
SELECT AVG(AverageRate) AS 'Average Exchange Rate'
FROM Sales.CurrencyRate
WHERE FromCurrencyCode = 'USD' 
	AND ToCurrencyCode = 'GBP' 
	AND YEAR(CurrencyRateDate) = 2005;

--1.7
/*
Display the FirstName and LastName of records from the Person table 
where FirstName contains the letters ‘ss’. 
Display an additional column with sequential numbers for each row returned beginning at integer 1. 
(Schema(s) involved: Person)
*/
SELECT ROW_NUMBER() OVER(ORDER BY FirstName, LastName ) AS 'Sr. No.', FirstName, LastName
FROM Person.Person
WHERE FirstName LIKE '%ss%';


--1.8
/*
Sales people receive various commission rates that belong to 1 of 4 bands. 
(Schema(s) involved: Sales)
Display the [SalesPersonID] with an additional column entitled ‘Commission Band’ indicating the appropriate band as above.
*/
SELECT BusinessEntityID AS 'SalesPersonID',
	CASE
		WHEN CommissionPct = 0.0 then 'BAND 0'
		WHEN CommissionPct > 0.0 AND CommissionPct <=0.01 then 'BAND 1'
		WHEN CommissionPct > 0.01 AND CommissionPct <=0.015 then 'BAND 2'
		WHEN CommissionPct > 0.015 then 'BAND 3'
		END AS 'Commission Band'
FROM Sales.SalesPerson;

--1.9
/*
Display the managerial hierarchy from Ruth Ellerbrock (person type – EM) up to CEO Ken Sanchez. 
Hint: use [uspGetEmployeeManagers] 
(Schema(s) involved: [Person], [HumanResources])
*/
DECLARE @ID int;
SELECT @ID = BusinessEntityID 
FROM Person.Person 
WHERE FirstName = 'Ruth' 
	AND LastName = 'Ellerbrock'
	AND PersonType = 'EM';
EXEC dbo.uspGetEmployeeManagers @BusinessEntityID = @ID;


--1.10
/*
Display the ProductId of the product with the largest stock level. 
Hint: Use the Scalar-valued function [dbo]. [UfnGetStock]. 
(Schema(s) involved: Production)
*/

SELECT MAX(dbo.ufnGetStock(ProductID)) as 'Stock' FROM Production.Product;

/*
Write separate queries using 
a join, 
a subquery, 
a CTE, and 
then an EXISTS to list all AdventureWorks customers who have not placed an order.
*/

--CONNECT TO DATABASE
USE AdventureWorks2008R2;

--JOINS
SELECT c.CustomerID
FROM Sales.SalesOrderHeader soh
	RIGHT JOIN Sales.Customer c ON soh.CustomerID = c.CustomerID
WHERE SalesOrderID IS NULL;


--SUB QUERY
SELECT c.CustomerID
FROM Sales.Customer c
WHERE c.CustomerID NOT IN (SELECT CustomerID FROM Sales.SalesOrderHeader);


--CTE
WITH CustomersWithoutOrder (CustmerID) 
AS 
(
	SELECT c.CustomerID
	FROM Sales.SalesOrderHeader soh
	RIGHT JOIN Sales.Customer c ON soh.CustomerID = c.CustomerID
	WHERE SalesOrderID IS NULL
)
SELECT * FROM CustomersWithoutOrder;
	
--EXIST
SELECT c.CustomerID
FROM Sales.Customer c
WHERE NOT EXISTS (SELECT s.CustomerID 
				FROM Sales.SalesOrderHeader AS s
				WHERE s.CustomerID = c.CustomerID);

select * from Sales.SalesOrderHeader where SalesOrderID  is null;

/*
Show the most recent five orders that were purchased from account numbers that have spent more than $70,000 with AdventureWorks.
*/

--CONNECT TO DATABASE
USE AdventureWorks2008R2;

SELECT TOP 5 SalesOrderID, AccountNumber, OrderDate
FROM Sales.SalesOrderHeader
WHERE AccountNumber 
IN (SELECT AccountNumber
    FROM Sales.SalesOrderHeader
    GROUP BY AccountNumber
    HAVING SUM(SubTotal) > 70000)
ORDER BY OrderDate DESC;

-select * from Sales.SalesOrderHeader;