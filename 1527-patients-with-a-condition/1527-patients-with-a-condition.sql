# Write your MySQL query statement below


select *
from patients p
where p.conditions like '% DIAB1%' or p.conditions like 'DIAB1%'