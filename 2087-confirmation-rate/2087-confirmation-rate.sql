# Write your MySQL query statement below

select s.user_id ,
    (case when round(sum(c.action='confirmed')/ count(c.user_id), 2) is null then 0.00
        else  round(sum(c.action='confirmed')/ count(c.user_id), 2) 
        end )as confirmation_rate
from Signups as s 
    left join Confirmations as c on c.user_id = s.user_id
group by user_id
;


