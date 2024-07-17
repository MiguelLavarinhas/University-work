SELECT customers.customerName AS "CustomerName", ROUND(SUM(amount),2) AS "total" FROM customers JOIN payments ON customers.customerNumber= payments.customerNumber WHERE city="Paris" GROUP BY customers.customerNumber HAVING COUNT(customers.customerNumber)>4  ;