# Write your MySQL query statement below

-- select d.name as Department, e.name as Employee, e.Salary 
-- from employee as e
--     join department as d on e.departmentId = d.id
-- where
--     3 >= (
--         select count(distinct salary)
--         from employee 
--         -- group by departmentId, salary
--         where departmentId = e.departmentId and e.salary <= salary
--     )

# 윈도우를 사용하면
with ranked as(
    select 
        e.name as Employee, e.salary as Salary, d.name as DepartMent,
        dense_rank() over (partition by departmentId order by salary desc) as rk
    from employee e
        join department d on e.departmentId = d.id
)

select r.Department, r.Employee, r.Salary
from ranked as r
where r.rk <=3
