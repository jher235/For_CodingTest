# Write your MySQL query statement below

-- select 
--     case 
--         when mod(id, 2)=0 then id-1
--         when mod(id, 2)=1 and id+1 not in (select id from seat) then id
--         else id+1 end as id,
--     student
-- from seat
-- order by id


-- select id,
--     case when id%2=0 then lag(student) over (order by id)   
--         when id%2=1 and lead(student) over (order by id) is null then student
--         else lead(student) over (order by id)
--         end as student
-- from seat


select id,
    case when id%2=0 then lag(student) over (order by id)   
        else ifnull(lead(student) over (order by id), student)
        end as student
from seat
    