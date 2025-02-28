-- 코드를 작성해주세요

# 비트 연산자
# distinct 대신 group by로 id로 묶어줘도 될 듯
SELECT distinct d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
FROM 
    DEVELOPERS AS d
    INNER JOIN SKILLCODES AS s
        on s.category='Front End' 
        and d.skill_code & s.code = s.code
order by 1
;