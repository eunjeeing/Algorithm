SELECT DISTINCT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM SKILLCODES SC
INNER JOIN DEVELOPERS D
ON SC.CODE & D.SKILL_CODE
WHERE SC.CATEGORY = 'Front End'
ORDER BY 1