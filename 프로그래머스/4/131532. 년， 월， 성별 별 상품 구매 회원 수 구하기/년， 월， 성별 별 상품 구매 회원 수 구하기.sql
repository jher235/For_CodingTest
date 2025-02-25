-- 코드를 입력하세요

select YEAR(o.sales_date) as YEAR, 
    MONTH(o.sales_date) as MONTH, 
    u.GENDER, 
    count(distinct u.user_id) as USERS # 유저 수를 세는 거라서 중복된 유저 수를 제외해야 함
from 
    user_info as u
    inner join online_sale as o on u.user_id=o.user_id 
where u.gender IS NOT NULL
group by YEAR(o.sales_date), MONTH(o.sales_date), u.gender
order by 1,2,3;

