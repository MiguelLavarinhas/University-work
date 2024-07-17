SELECT orderdetails.productCode, SUM(orderdetails.quantityOrdered) AS "Total" FROM orderdetails GROUP BY orderdetails.productCode ORDER BY total DESC LIMIT 1;