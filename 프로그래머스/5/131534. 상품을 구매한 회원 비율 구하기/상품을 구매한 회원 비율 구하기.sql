-- 코드를 입력하세요

with all_2021 as(
    # select count(u.user_id)
    select count(u.user_id) as count_all
    from USER_INFO as u
    where YEAR(joined)='2021'
)
,
purchased_2021 as(
    select 
        MONTH(o.sales_date) as MONTH,
        count(u.user_id) as count_all
    from USER_INFO as u
        inner join ONLINE_SALE as o on u.user_id = o.user_id
    where YEAR(joined)='2021'
    group by 
        MONTH
)

# select *
# from purchased_2021


SELECT  
    YEAR(o.sales_date) as YEAR, 
    MONTH(o.sales_date) as MONTH,
    COUNT(distinct o.user_id) as PURCHASED_USERS,
    ROUND(COUNT(distinct o.user_id) / a.count_all, 1) as PUCHASED_RATIO
from 
    USER_INFO as u
    inner join ONLINE_SALE as o on u.user_id = o.user_id 
        and YEAR(o.sales_date)='2022' and YEAR(u.joined)='2021'
    join all_2021 as a on 1=1
# where YEAR(u.joined)='2021'
group by YEAR, MONTH
order by 1, 2
;

# select *
# from 
#     USER_INFO as u
#     inner join ONLINE_SALE as o on u.user_id = o.user_id 
#         and YEAR(o.sales_date)='2022' and YEAR(u.joined)='2021'