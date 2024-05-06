SELECT T1.HOUR,
       NVL(T2.COUNT, 0) COUNT
FROM   (SELECT LEVEL - 1 AS HOUR
        FROM   DUAL
        CONNECT BY LEVEL <= 24) T1
       LEFT OUTER JOIN (SELECT TO_NUMBER(TO_CHAR(DATETIME, 'HH24')) HOUR,
                               COUNT(ANIMAL_ID)                     COUNT
                        FROM   ANIMAL_OUTS
                        GROUP  BY TO_NUMBER(TO_CHAR(DATETIME, 'HH24'))) T2
                    ON T2.HOUR = T1.HOUR
ORDER  BY 1 