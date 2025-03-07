# Write your MySQL query statement below

# 이것도 통과는 함
-- with cte as(
--     select distinct tiv_2015
--     from insurance
--     group by tiv_2015
--     having count(tiv_2015) > 1
-- ),
-- uiq_loc as(
--     select lat, lon
--     from insurance
--     group by lat, lon
--     having count(*) = 1
-- )

-- select round(sum(tiv_2016), 2) as tiv_2016
-- from insurance as i
-- where 
--     (i.lat, i.lon) in (
--         select lat, lon
--         from uiq_loc
--     ) and
--     i.tiv_2015 in (
--         select tiv_2015
--         from cte
--     )



# 논리적 과정을 따라가는게 위 쿼리가 편했지만, 이렇게 서브 쿼리로 한번에 작성하면 더 깔끔
select round(sum(tiv_2016), 2) as tiv_2016
from insurance as i
where 
    (i.lat, i.lon) in (
        select lat, lon
        from insurance
        group by lat, lon
        having count(*) = 1
    ) and
    i.tiv_2015 in (
        select distinct tiv_2015
        from insurance
        group by tiv_2015
        having count(tiv_2015) > 1
    )