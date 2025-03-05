# Write your MySQL query statement below

select e.name
from employee as e 
    join (select managerId
            from employee
            group by managerId
            having count(managerId) >= 5
            ) as n 
            on n.managerId = e.id

