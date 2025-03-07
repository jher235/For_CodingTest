# Write your MySQL query statement below

# 이렇게하면 null이 될 수 없네
-- with cte as(
--     select e.id, e.salary, dense_rank() over(order by e.salary) as rk
--     from employee e
-- )

-- select salary as SecondHighestSalary
-- from cte
-- where rk=2

select max(e.salary) as SecondHighestSalary
from employee e
where e.salary <> (
    select max(salary)
    from employee
)