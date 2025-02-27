-- 코드를 입력하세요
SELECT 
    p.product_id as PRODUCT_ID, 
    p.product_name as PRODUCT_NAME, 
    SUM(o.amount * p.price) as TOTAL_SALES
from 
    FOOD_PRODUCT as p
    join FOOD_ORDER as o on p.product_id = o.product_id
where YEAR(o.produce_date)=2022 and MONTH(o.produce_date)=5
group by p.product_id
order by 3 desc, 1
