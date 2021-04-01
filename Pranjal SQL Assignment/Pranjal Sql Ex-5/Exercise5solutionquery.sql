Use AdventureWorks2008R2
Go
ALTER PROCEDURE pranjalprocedure @FirstName varchar(60) = NULL
AS 
Begin
  IF @FirstName is null
       Select * FROM Person.Person
  ELSE  
       SELECT * FROM Person.Person WHERE FirstName = @FirstName
END
GO