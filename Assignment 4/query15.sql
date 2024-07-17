SELECT customerName, phone FROM customers WHERE customerNumber NOT IN (SELECT DISTINCT customerNumber FROM payments);
