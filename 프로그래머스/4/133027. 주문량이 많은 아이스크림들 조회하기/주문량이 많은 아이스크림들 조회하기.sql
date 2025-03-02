-- 코드를 입력하세요
# SELECT * 
# from FIRST_HALF

with cte_july as (
    select j.FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
    from july as j
    group by j.FLAVOR
)

SELECT f.FLAVOR
from FIRST_HALF as f
    inner join cte_july as j on f.FLAVOR = j.FLAVOR
order by (f.TOTAL_ORDER + j.TOTAL_ORDER) desc
limit 3