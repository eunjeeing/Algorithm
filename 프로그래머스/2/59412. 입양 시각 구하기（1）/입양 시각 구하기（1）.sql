SELECT LTRIM(TO_CHAR(DATETIME, 'HH24'),'0') HOUR, COUNT(*) COUNT
FROM ANIMAL_OUTS
WHERE TO_CHAR(DATETIME, 'HH24') BETWEEN 09 AND 19
GROUP BY TO_CHAR(DATETIME, 'HH24')
ORDER BY TO_CHAR(DATETIME, 'HH24')