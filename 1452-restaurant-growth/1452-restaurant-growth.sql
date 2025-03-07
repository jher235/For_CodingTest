# Write your MySQL query statement below

with total_amount as(
    select sum(amount) as amount, visited_on
    from customer 
    group by visited_on
)

-- select *
-- from total_amount

select 
    visited_on, 
    sum(t.amount) over (order by t.visited_on rows between 6 preceding  and current row) as amount ,
    round(avg(t.amount) over (order by t.visited_on rows between 6 preceding  and current row), 2) as average_amount
from total_amount as t
-- where date_sub(visited_on, interval 7 day) in ( // where 절이 가장 먼저 처리되므로 불가
--     select visited_on
--     from customer
-- )
-- group by visited_on 
-- having EXISTS(date_sub(visited_on, interval 7 day))
order by visited_on
limit 9999 offset 6 