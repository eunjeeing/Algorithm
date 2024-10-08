SELECT EXTRACT (YEAR FROM OS.SALES_DATE) AS YEAR,
       EXTRACT (MONTH FROM OS.SALES_DATE) AS MONTH,
       GENDER,
       COUNT(DISTINCT UI.USER_ID) AS USERS
FROM USER_INFO UI
INNER JOIN ONLINE_SALE OS
ON UI.USER_ID = OS.USER_ID
WHERE GENDER IS NOT NULL
GROUP BY EXTRACT (YEAR FROM OS.SALES_DATE),
         EXTRACT (MONTH FROM OS.SALES_DATE),
         GENDER
ORDER BY 1, 2, 3